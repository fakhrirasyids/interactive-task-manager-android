package com.fakhrirasyids.interactivetaskmanager.ui.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fakhrirasyids.interactivetaskmanager.feature.tasklist.screen.TaskListScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    
    NavHost(navController, startDestination = "task_list") {
        composable("task_list") { TaskListScreen() }
    }
}