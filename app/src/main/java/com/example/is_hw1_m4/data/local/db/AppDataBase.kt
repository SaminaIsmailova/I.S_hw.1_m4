package com.example.is_hw1_m4.data.local.db

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import com.example.is_hw1_m4.model.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDataBase:RoomDatabase() {
    abstract fun taskDao():TaskDAO
}