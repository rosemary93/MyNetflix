package com.example.mynetflix.database

import androidx.room.*

@Dao
interface FilmDao {
    @Query("SELECT * FROM Film")
    fun getAllFilms():List<Film>

    @Query("SELECT * FROM Film WHERE id IN (:filmID)")
    fun getFilmByID(filmID:Int):Film

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFilm(film: Film)

    @Update
    fun updateFilm(film: Film)



}