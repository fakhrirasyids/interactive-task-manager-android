package com.fakhrirasyids.interactivetaskmanager.data.local.dao

import androidx.room.*
import com.fakhrirasyids.interactivetaskmanager.data.local.entity.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks ORDER BY priority ASC")
    fun getTasksSortedByPriority(): Flow<List<TaskEntity>>

    @Query("SELECT * FROM tasks ORDER BY dueDate ASC")
    fun getTasksSortedByDueDate(): Flow<List<TaskEntity>>

    @Query("SELECT * FROM tasks ORDER BY title ASC")
    fun getTasksSortedAlphabetically(): Flow<List<TaskEntity>>

    @Query("SELECT * FROM tasks WHERE isCompleted = :completed")
    fun getTasksByStatus(completed: Boolean): Flow<List<TaskEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(taskEntity: TaskEntity)

    @Delete
    suspend fun deleteTask(taskEntity: TaskEntity)
}
