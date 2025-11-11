package com.example.allnewtechnologies.photList.view

sealed class Screen(val rout: String) {
    data object PhotosListFragment: Screen("photoList")
    data object PhotoDetails: Screen("photoDetails")
}