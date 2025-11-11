package com.example.allnewtechnologies.photList.viewModel

import com.example.allnewtechnologies.photList.model.responses.Hit


sealed class PhotosListViewState {

    data object Init : PhotosListViewState()

    data class Error(var message: String?) : PhotosListViewState()

    data class Success(var response: MutableList<Hit>) : PhotosListViewState()

    data object Loading : PhotosListViewState()
}