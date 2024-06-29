package com.example.m_banking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.m_banking.presentation.AppNavigation
import com.example.m_banking.presentation.theme.MBankingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MBankingTheme {
                val navController = rememberNavController()
                AppNavigation(navController = navController)
            }
        }
    }
}