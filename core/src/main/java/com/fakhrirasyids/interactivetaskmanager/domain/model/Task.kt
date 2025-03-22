package com.fakhrirasyids.interactivetaskmanager.domain.model

data class Task(
    val id: Int,
    val title: String,
    val description: String?,
    val priority: Priority,
    val dueDate: Long,
    val isCompleted: Boolean
)
