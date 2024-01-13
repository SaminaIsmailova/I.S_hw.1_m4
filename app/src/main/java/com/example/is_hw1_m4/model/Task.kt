package com.example.is_hw1_m4.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String? = "no title",
    val desc: String? = "no description"
) : Serializable
