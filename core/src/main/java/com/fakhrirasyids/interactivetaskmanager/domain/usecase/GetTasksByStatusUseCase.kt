package com.fakhrirasyids.interactivetaskmanager.domain.usecase

import com.fakhrirasyids.interactivetaskmanager.domain.model.Task
import com.fakhrirasyids.interactivetaskmanager.domain.repo.TaskRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTasksByStatusUseCase @Inject constructor(
    private val repository: TaskRepository
) {
    operator fun invoke(completed: Boolean): Flow<List<Task>> = repository.getTasksByStatus(completed)
}
