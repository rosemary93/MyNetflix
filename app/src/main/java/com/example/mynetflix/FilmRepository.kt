package com.example.mynetflix

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.mynetflix.database.AppDatabase
import com.example.mynetflix.database.Film
import com.example.mynetflix.database.FilmDao

object FilmRepository {

    lateinit var filmDao: FilmDao

    fun initDB(context: Context) {
        val db = AppDatabase.getAppDataBase(context)
        filmDao = db!!.filmDao()
    }

    fun getAllFilms(): List<Film> {
        return filmDao.getAllFilms()
    }

    fun addFilm(film: Film) {
        filmDao.insertFilm(film)
    }

    fun updateFilm(film: Film) {
        filmDao.updateFilm(film)
    }

    fun findFilmByID(id: Int): Film {
        return filmDao.getFilmByID(id)
    }

    fun testData(){

    }

}