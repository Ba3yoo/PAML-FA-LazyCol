package com.example.lazycol.navigation

import android.annotation.SuppressLint
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lazycol.view.detailScreen
import com.example.lazycol.view.userList
import com.example.lazycol.viewModel.UserViewModel
import kotlinx.serialization.Serializable

@Composable
fun AppNavHost()
{

val navController = rememberNavController()
NavHost(navController = navController, startDestination = "user_list"){
    composable("user_list") {
        userList(
            onClickDetail = { user_id ->
                navController.navigate(route = "user_detail/$user_id")
            }
        )
    }
    composable(
        route = "user_detail/{user_id}",
        arguments = listOf(navArgument("user_id") {type = NavType.IntType})
    ) { navBackStackEntry ->
        val user_id = navBackStackEntry.arguments?.getInt("user_id") ?: 0
        detailScreen(user_id)
    }
}

}