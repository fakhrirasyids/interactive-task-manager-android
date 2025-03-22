package com.fakhrirasyids.interactivetaskmanager.domain.usecase

import com.fakhrirasyids.interactivetaskmanager.domain.model.Task
import com.fakhrirasyids.interactivetaskmanager.domain.repo.TaskRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTasksSortedAlphabeticallyUseCase @Inject constructor(
    private val repository: TaskRepository
) {
    operator fun invoke(): Flow<List<Task>> = repository.getTasksSortedAlphabetically()
}
