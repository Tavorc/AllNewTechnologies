package com.example.allnewtechnologies

sealed class Screen(val rout: String) {
    data object PhotosListFragment: Screen("photoList")
    data object PhotoDetails: Screen("photoDetails")
}