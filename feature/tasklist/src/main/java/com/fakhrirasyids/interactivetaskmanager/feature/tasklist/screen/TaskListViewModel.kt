package com.fakhrirasyids.interactivetaskmanager.feature.tasklist.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fakhrirasyids.interactivetaskmanager.domain.model.Task
import com.fakhrirasyids.interactivetaskmanager.domain.usecase.DeleteTaskUseCase
import com.fakhrirasyids.interactivetaskmanager.domain.usecase.GetFilteredAndSortedTasksUseCase
import com.fakhrirasyids.interactivetaskmanager.utils.enums.TaskFilterOption
import com.fakhrirasyids.interactivetaskmanager.utils.enums.TaskSortOption
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flattenMerge
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskListViewModel @Inject constructor(
    private val getFilteredAndSortedTasksUseCase: GetFilteredAndSortedTasksUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase
) : ViewModel() {

    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks.asStateFlow()

    var currentFilterOption = MutableStateFlow(TaskFilterOption.ALL)
    var currentSortOption = MutableStateFlow(TaskSortOption.PRIORITY)

    init {
        loadTasks()
    }

    fun loadTasks() {
        viewModelScope.launch {
            combine(currentFilterOption, currentSortOption) { filter, sort ->
                getFilteredAndSortedTasksUseCase(filter, sort)
            }.flattenMerge().collect {
                _tasks.value = it
            }
        }
    }

    fun updateFilterOption(filter: TaskFilterOption) {
        currentFilterOption.value = filter
    }

    fun updateSortOption(sort: TaskSortOption) {
        currentSortOption.value = sort
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            deleteTaskUseCase(task)
        }
    }
}
