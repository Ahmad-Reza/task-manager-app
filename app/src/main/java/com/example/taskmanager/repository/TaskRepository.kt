package com.example.taskmanager.repository

import com.example.taskmanager.data.local.Task
import com.example.taskmanager.data.local.TaskDao
import javax.inject.Inject

class TaskRepository @Inject constructor(
    private val dao: TaskDao
) {
    val tasks = dao.getAllTasks()

    suspend fun insert(task: Task) = dao.insertTask(task)
    suspend fun update(task: Task) = dao.updateTask(task)
    suspend fun delete(task: Task) = dao.deleteTask(task)
    suspend fun getTask(id: Int) = dao.getTaskById(id)
}