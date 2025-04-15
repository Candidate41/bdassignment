package com.example.nanitassignmentclient

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nanitassignmentclient.babybirthday.ui.BabyBirthdayScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "baby_birthday") {
        composable("baby_birthday") {
            BabyBirthdayScreen()
        }
    }
}