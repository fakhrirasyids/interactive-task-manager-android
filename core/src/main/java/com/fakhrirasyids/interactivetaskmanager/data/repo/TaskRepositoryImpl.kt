package com.fakhrirasyids.interactivetaskmanager.data.repo

import com.fakhrirasyids.interactivetaskmanager.data.local.dao.TaskDao
import com.fakhrirasyids.interactivetaskmanager.data.mapper.TaskMapper.toDomain
import com.fakhrirasyids.interactivetaskmanager.data.mapper.TaskMapper.toEntity
import com.fakhrirasyids.interactivetaskmanager.domain.model.Task
import com.fakhrirasyids.interactivetaskmanager.domain.repo.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    private val taskDao: TaskDao
) : TaskRepository {

    override fun getTasksSortedByPriority(): Flow<List<Task>> =
        taskDao.getTasksSortedByPriority().map { list -> list.map { it.toDomain() } }

    override fun getTasksSortedByDueDate(): Flow<List<Task>> =
        taskDao.getTasksSortedByDueDate().map { list -> list.map { it.toDomain() } }

    override fun getTasksSortedAlphabetically(): Flow<List<Task>> =
        taskDao.getTasksSortedAlphabetically().map { list -> list.map { it.toDomain() } }

    override fun getTasksByStatus(completed: Boolean): Flow<List<Task>> =
        taskDao.getTasksByStatus(completed).map { list -> list.map { it.toDomain() } }

    override suspend fun insertTask(task: Task) = taskDao.insertTask(task.toEntity())
    override suspend fun deleteTask(task: Task) = taskDao.deleteTask(task.toEntity())
}
