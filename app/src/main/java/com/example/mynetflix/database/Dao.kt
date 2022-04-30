package com.example.mynetflix.database

import androidx.room.*

@Dao
interface FilmDao {
    @Query("SELECT * FROM Film")
    fun getAllFilms():List<Film>

    @Query("SELECT * FROM Film WHERE id IN (:filmID)")
    fun getFilmByID(filmID:Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWord(film: Film)

    @Update
    fun updateFilm(film: Film)



}