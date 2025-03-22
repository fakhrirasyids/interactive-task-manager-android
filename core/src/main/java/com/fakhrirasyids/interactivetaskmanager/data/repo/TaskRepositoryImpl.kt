package com.fakhrirasyids.interactivetaskmanager.data.repo

import com.fakhrirasyids.interactivetaskmanager.data.local.dao.TaskDao
import com.fakhrirasyids.interactivetaskmanager.utils.mapper.TaskMapper.toDomain
import com.fakhrirasyids.interactivetaskmanager.utils.mapper.TaskMapper.toEntity
import com.fakhrirasyids.interactivetaskmanager.domain.model.Task
import com.fakhrirasyids.interactivetaskmanager.domain.repo.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    private val taskDao: TaskDao
) : TaskRepository {

    override fun getAllTasks(): Flow<List<Task>> =
        taskDao.getAllTasks().map { list -> list.map { it.toDomain() } }

    override suspend fun insertTask(task: Task) = taskDao.insertTask(task.toEntity())
    override suspend fun deleteTask(task: Task) = taskDao.deleteTask(task.toEntity())
}
