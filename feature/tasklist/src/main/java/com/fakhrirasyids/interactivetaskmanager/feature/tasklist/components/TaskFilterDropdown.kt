package com.fakhrirasyids.interactivetaskmanager.feature.tasklist.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.fakhrirasyids.interactivetaskmanager.utils.enums.TaskFilterOption

@Composable
fun TaskFilterDropdown(
    selectedFilter: TaskFilterOption,
    onFilterSelected: (TaskFilterOption) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    
    Box {
        Button(onClick = { expanded = true }) {
            Text(text = "Filter: ${selectedFilter.name}")
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            TaskFilterOption.entries.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option.name) },
                    onClick = {
                        onFilterSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}
