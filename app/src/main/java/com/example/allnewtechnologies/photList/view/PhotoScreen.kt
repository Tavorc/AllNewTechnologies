package com.example.allnewtechnologies.photList.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.allnewtechnologies.R
import com.example.allnewtechnologies.photList.viewModel.PhotosListViewModel
import com.example.allnewtechnologies.photList.viewModel.PhotosListViewState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhotoScreen(id: Int, viewModel: PhotosListViewModel, navController: NavHostController) {
    val res = viewModel.uiState.collectAsState().value
    if (res is PhotosListViewState.Success) {
        val hit = res.response.firstOrNull { it.id == id }
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(stringResource(R.string.app_name)) },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                        }
                    }
                )
            },
            content = { padding ->
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxWidth()
                        .padding(padding)
                ) {
                    Column {
                        Image(
                            painter = rememberAsyncImagePainter(hit?.largeImageURL),
                            contentDescription = null,
                            modifier = Modifier.size(300.dp)
                        )
                    }
                }
            }
        )
    }

}