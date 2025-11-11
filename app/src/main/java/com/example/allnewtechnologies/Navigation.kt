package com.example.allnewtechnologies

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.allnewtechnologies.photList.view.PhotoFeedScreen
import com.example.allnewtechnologies.photList.view.PhotoScreen
import com.example.allnewtechnologies.photList.view.Screen
import com.example.allnewtechnologies.photList.viewModel.PhotosListViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val viewModel = hiltViewModel<PhotosListViewModel>()
    NavHost(navController = navController, startDestination = Screen.PhotosListFragment.rout) {
        composable(Screen.PhotosListFragment.rout) {
            PhotoFeedScreen(viewModel) { hit ->
                navController.navigate("${Screen.PhotoDetails.rout}/${hit.id}")
            }
        }

        composable(
            Screen.PhotoDetails.rout + "/{id}",
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
            })
        ) { navBackStackEntry ->
            PhotoScreen(navBackStackEntry.arguments!!.getInt("id"), viewModel, navController)
        }
    }
}