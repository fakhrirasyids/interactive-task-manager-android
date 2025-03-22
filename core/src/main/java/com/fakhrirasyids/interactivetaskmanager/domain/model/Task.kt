package com.fakhrirasyids.interactivetaskmanager.domain.model

import com.fakhrirasyids.interactivetaskmanager.utils.enums.Priority

data class Task(
    val id: Int,
    val title: String,
    val description: String?,
    val priority: Priority,
    val dueDate: Long,
    val isCompleted: Boolean
)
