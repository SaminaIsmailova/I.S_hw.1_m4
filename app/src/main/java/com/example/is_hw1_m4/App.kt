package com.example.is_hw1_m4

import android.app.Application
import androidx.room.Room
import com.example.is_hw1_m4.data.local.db.AppDataBase

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java,
            "database-name"
        ).allowMainThreadQueries().build()
    }

    companion object {
        lateinit var db: AppDataBase
    }
}