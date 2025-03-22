package com.fakhrirasyids.interactivetaskmanager.domain.usecase

import com.fakhrirasyids.interactivetaskmanager.domain.model.Task
import com.fakhrirasyids.interactivetaskmanager.domain.repo.TaskRepository
import com.fakhrirasyids.interactivetaskmanager.utils.enums.TaskFilterOption
import com.fakhrirasyids.interactivetaskmanager.utils.enums.TaskSortOption
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class GetFilteredAndSortedTasksUseCase @Inject constructor(
    private val repository: TaskRepository
) {
    operator fun invoke(
        filterOption: TaskFilterOption,
        sortOption: TaskSortOption
    ): Flow<List<Task>> {
        return repository.getAllTasks().map { tasks ->
            val filteredTasks = when (filterOption) {
                TaskFilterOption.ALL -> tasks
                TaskFilterOption.COMPLETED -> tasks.filter { it.isCompleted }
                TaskFilterOption.PENDING -> tasks.filter { !it.isCompleted }
            }

            when (sortOption) {
                TaskSortOption.PRIORITY -> filteredTasks.sortedBy { it.priority }
                TaskSortOption.DUE_DATE -> filteredTasks.sortedBy { it.dueDate }
                TaskSortOption.ALPHABETICAL -> filteredTasks.sortedBy { it.title }
            }
        }
    }
}
