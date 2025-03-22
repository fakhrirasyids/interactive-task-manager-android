package com.fakhrirasyids.interactivetaskmanager.utils.mapper

import com.fakhrirasyids.interactivetaskmanager.data.local.entity.TaskEntity
import com.fakhrirasyids.interactivetaskmanager.utils.enums.Priority
import com.fakhrirasyids.interactivetaskmanager.domain.model.Task

object TaskMapper {

    fun TaskEntity.toDomain(): Task {
        return Task(
            id = this.id,
            title = this.title,
            description = this.description,
            priority = when (this.priority) {
                1 -> Priority.HIGH
                2 -> Priority.MEDIUM
                else -> Priority.LOW
            },
            dueDate = this.dueDate,
            isCompleted = this.isCompleted
        )
    }

    fun Task.toEntity(): TaskEntity {
        return TaskEntity(
            id = this.id,
            title = this.title,
            description = this.description,
            priority = when (this.priority) {
                Priority.HIGH -> 1
                Priority.MEDIUM -> 2
                Priority.LOW -> 3
            },
            dueDate = this.dueDate,
            isCompleted = this.isCompleted
        )
    }
}
