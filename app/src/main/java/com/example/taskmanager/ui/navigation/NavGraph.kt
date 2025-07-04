package com.example.taskmanager.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taskmanager.ui.screens.AddEditTaskScreen
import com.example.taskmanager.ui.screens.TaskListScreen
import com.example.taskmanager.viewmodel.TaskViewModel

sealed class Screen(val route: String) {
    object TaskList : Screen("task_list")
    object AddEditTask : Screen("add_edit_task")
}

@Composable
fun AppNavGraph(viewModel: TaskViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.TaskList.route
    ) {
        composable(Screen.TaskList.route) {
            TaskListScreen(
                viewModel = viewModel,
                onAddClick = {
                    navController.navigate(Screen.AddEditTask.route)
                }
            )
        }

        composable(Screen.AddEditTask.route) {
            AddEditTaskScreen(
                onSaveClick = { task ->
                    viewModel.addTask(task)
                    navController.popBackStack()
                }
            )
        }
    }
}

