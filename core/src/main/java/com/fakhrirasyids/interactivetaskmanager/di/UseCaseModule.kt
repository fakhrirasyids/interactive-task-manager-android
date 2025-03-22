package com.fakhrirasyids.interactivetaskmanager.di

import com.fakhrirasyids.interactivetaskmanager.domain.repo.TaskRepository
import com.fakhrirasyids.interactivetaskmanager.domain.usecase.DeleteTaskUseCase
import com.fakhrirasyids.interactivetaskmanager.domain.usecase.GetFilteredAndSortedTasksUseCase
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
    fun provideGetFilteredAndSortedTasksUseCase(repository: TaskRepository)=
        GetFilteredAndSortedTasksUseCase(repository)

    @Provides
    fun provideInsertTaskUseCase(repository: TaskRepository)=
        InsertTaskUseCase(repository)


    @Provides
    fun provideDeleteTaskUseCase(repository: TaskRepository)=
        DeleteTaskUseCase(repository)
}
