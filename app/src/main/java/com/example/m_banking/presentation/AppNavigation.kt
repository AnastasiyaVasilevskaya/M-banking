package com.example.m_banking.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.m_banking.presentation.homeScreen.HomeScreen

@Composable
fun AppNavigation(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController = navController)
        }
    }
}