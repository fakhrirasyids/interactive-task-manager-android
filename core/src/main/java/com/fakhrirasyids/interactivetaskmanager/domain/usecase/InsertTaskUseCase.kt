package com.fakhrirasyids.interactivetaskmanager.domain.usecase

import com.fakhrirasyids.interactivetaskmanager.domain.model.Task
import com.fakhrirasyids.interactivetaskmanager.domain.repo.TaskRepository
import javax.inject.Inject

class InsertTaskUseCase @Inject constructor(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(task: Task) = repository.insertTask(task)
}
