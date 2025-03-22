package com.fakhrirasyids.interactivetaskmanager.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fakhrirasyids.interactivetaskmanager.data.local.dao.TaskDao
import com.fakhrirasyids.interactivetaskmanager.data.local.entity.TaskEntity

@Database(entities = [TaskEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}
