package com.example.mynetflix.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Film(
    @PrimaryKey(autoGenerate = true) val id: Int,
    var title: String, var imageID: Int, var isFavorite: Boolean
)