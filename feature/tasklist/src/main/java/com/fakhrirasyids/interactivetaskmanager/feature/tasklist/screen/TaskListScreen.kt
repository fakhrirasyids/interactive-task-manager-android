package com.fakhrirasyids.interactivetaskmanager.feature.tasklist.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.fakhrirasyids.interactivetaskmanager.feature.tasklist.components.TaskFilterDropdown
import com.fakhrirasyids.interactivetaskmanager.feature.tasklist.components.TaskItem
import com.fakhrirasyids.interactivetaskmanager.feature.tasklist.components.TaskSortDropdown

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskListScreen(viewModel: TaskListViewModel = hiltViewModel()) {
    val tasks by viewModel.tasks.collectAsState()
    val selectedFilter by viewModel.currentFilterOption.collectAsState()
    val selectedSort by viewModel.currentSortOption.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Task List") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Icon(Icons.Default.Add, contentDescription = "Add Task")
            }
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TaskFilterDropdown(
                    selectedFilter = selectedFilter,
                    onFilterSelected = { viewModel.updateFilterOption(it) }
                )

                TaskSortDropdown(
                    selectedSort = selectedSort,
                    onSortSelected = { viewModel.updateSortOption(it) }
                )
            }

            LazyColumn {
                items(tasks) { task ->
                    TaskItem(
                        task = task,
                        onDelete = { viewModel.deleteTask(task) }
                    )
                }
            }
        }
    }
}
