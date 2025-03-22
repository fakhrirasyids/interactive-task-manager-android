package com.fakhrirasyids.interactivetaskmanager.domain.repo

import com.fakhrirasyids.interactivetaskmanager.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getAllTasks(): Flow<List<Task>>
    suspend fun insertTask(task: Task)
    suspend fun deleteTask(task: Task)
}
