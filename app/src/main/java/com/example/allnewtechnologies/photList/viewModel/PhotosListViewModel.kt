package com.example.allnewtechnologies.photList.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.allnewtechnologies.photList.model.responses.Hit
import com.example.allnewtechnologies.photList.model.PhotosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class PhotosListViewModel @Inject constructor(private val photosListApiController: PhotosRepository) :
    ViewModel() {

    var page: Int = 0
    var isLoading: Boolean = false
    var hasMore: Boolean = true
    private var job: Job? = null

    companion object {
        const val PER_PAGE = 10
    }

    private val _uiState = MutableStateFlow<PhotosListViewState>(PhotosListViewState.Init)
    val uiState: StateFlow<PhotosListViewState> = _uiState.asStateFlow()
    var photoList = mutableListOf<Hit>()

    init {
        getPhotosList(false)
    }

    fun getPhotosList(isPagination: Boolean) {
        if (isLoading || !hasMore) return
        isLoading = true
        if(isPagination || page == 0) page++
        if (page == 1) {
            _uiState.value = PhotosListViewState.Loading
        }
        job = viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = photosListApiController.getPhotosList(page, PER_PAGE, isPagination)
                if (response.isSuccessful) {
                    val newHits = response.body()?.hits ?: emptyList()
                    if (page == 1) {
                        _uiState.value = PhotosListViewState.Success(newHits.toMutableList())
                    } else {
                        val currentHits = (_uiState.value as? PhotosListViewState.Success)?.response ?: emptyList()
                        _uiState.value = PhotosListViewState.Success((currentHits + newHits).toMutableList())
                    }
                    photoList.addAll(newHits)
                } else {
                    _uiState.value = PhotosListViewState.Error(response.message())
                    hasMore = false
                }
            } catch (e: Exception) {
                _uiState.value = PhotosListViewState.Error("Network request failed")
                hasMore = false
            } finally {
                isLoading = false
            }
        }
    }

    private fun getTwoPages() {
        val page1 = viewModelScope.async(Dispatchers.IO) {
            photosListApiController.getPhotosList(1, PER_PAGE, false)
        }

        val page2 = viewModelScope.async(Dispatchers.IO) {
            photosListApiController.getPhotosList(2, PER_PAGE, false)
        }

        viewModelScope.launch {
            try {
                val resultAll = awaitAll(page1, page2)
                val res = resultAll.map { it.body() }
                _uiState.value = PhotosListViewState.Success(res[0]?.hits ?: mutableListOf())
                photoList.addAll(res.flatMap { it?.hits ?: emptyList() })

            } catch (e: Exception) {
                _uiState.value = PhotosListViewState.Error("Network request failed")
            }
        }
    }
}