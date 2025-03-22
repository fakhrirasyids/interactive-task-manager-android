package com.fakhrirasyids.interactivetaskmanager.di

import com.fakhrirasyids.interactivetaskmanager.domain.repo.TaskRepository
import com.fakhrirasyids.interactivetaskmanager.domain.usecase.DeleteTaskUseCase
import com.fakhrirasyids.interactivetaskmanager.domain.usecase.GetTasksByStatusUseCase
import com.fakhrirasyids.interactivetaskmanager.domain.usecase.GetTasksSortedAlphabeticallyUseCase
import com.fakhrirasyids.interactivetaskmanager.domain.usecase.GetTasksSortedByDueDateUseCase
import com.fakhrirasyids.interactivetaskmanager.domain.usecase.GetTasksSortedByPriorityUseCase
import com.fakhrirasyids.interactivetaskmanager.domain.usecase.InsertTaskUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetTasksSortedByPriorityUseCase(repository: TaskRepository): GetTasksSortedByPriorityUseCase {
        return GetTasksSortedByPriorityUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetTasksSortedByDueDateUseCase(repository: TaskRepository): GetTasksSortedByDueDateUseCase {
        return GetTasksSortedByDueDateUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetTasksSortedAlphabeticallyUseCase(repository: TaskRepository): GetTasksSortedAlphabeticallyUseCase {
        return GetTasksSortedAlphabeticallyUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetTasksByStatusUseCase(repository: TaskRepository): GetTasksByStatusUseCase {
        return GetTasksByStatusUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideInsertTaskUseCase(repository: TaskRepository): InsertTaskUseCase {
        return InsertTaskUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideDeleteTaskUseCase(repository: TaskRepository): DeleteTaskUseCase {
        return DeleteTaskUseCase(repository)
    }
}
