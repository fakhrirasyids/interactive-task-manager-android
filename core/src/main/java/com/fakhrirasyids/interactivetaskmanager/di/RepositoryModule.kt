package com.fakhrirasyids.interactivetaskmanager.di

import com.fakhrirasyids.interactivetaskmanager.data.repo.TaskRepositoryImpl
import com.fakhrirasyids.interactivetaskmanager.domain.repo.TaskRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindTaskRepository(repository: TaskRepositoryImpl): TaskRepository
}
