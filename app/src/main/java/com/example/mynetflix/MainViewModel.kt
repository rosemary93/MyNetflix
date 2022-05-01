package com.example.mynetflix

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.example.mynetflix.database.Film
import com.google.gson.Gson

class MainViewModel(app: Application) : AndroidViewModel(app) {
    val comingSoonList=ArrayList<Film>()
    init {
        FilmRepository.initDB(app)
        comingSoonList.add(Film(0,"coming soon 1",R.drawable.coming_soon_0,false))
        comingSoonList.add(Film(0,"coming soon 2",R.drawable.coming_soon_1,false))
        comingSoonList.add(Film(0,"coming soon 3",R.drawable.coming_soon_2,false))
    }

    fun getAllFilms(): List<Film> {
        return FilmRepository.getAllFilms()
    }

    fun addFilm(film: Film) {
        FilmRepository.addFilm(film)
    }

    fun updateFilm(film: Film) {
        FilmRepository.updateFilm(film)
    }

    fun getFilmByID(id: Int): Film {
        return FilmRepository.findFilmByID(id)
    }

    fun saveDataInSharedPref(activity:Activity,userInfo: UserInfo){
        val sharedPref=activity.getSharedPreferences("user",Context.MODE_PRIVATE)
        val editor=sharedPref.edit()
        val gson= Gson()
        val jsonStr=gson.toJson(userInfo)
        editor.putString("user",jsonStr)
        editor.apply()
    }

    fun getDataFromSharedPref(activity: Activity):UserInfo?{
        val sharedPref=activity.getSharedPreferences("user",Context.MODE_PRIVATE)
        val gson=Gson()
        val jsonStr=sharedPref.getString("user","")
        return gson.fromJson(jsonStr,UserInfo::class.java)
    }

    fun addTestData() {
        addFilm(Film(0, "film1", R.drawable.icon_0, false))
        addFilm(Film(0, "film2", R.drawable.icon_1, false))
        addFilm(Film(0, "film3", R.drawable.icon_2, false))
        addFilm(Film(0, "film4", R.drawable.icon_3, false))
        addFilm(Film(0, "film5", R.drawable.icon_4, false))
        addFilm(Film(0, "film6", R.drawable.icon_5, false))
        addFilm(Film(0, "film7", R.drawable.icon_6, false))
        addFilm(Film(0, "film8", R.drawable.icon_7, false))
        addFilm(Film(0, "film9", R.drawable.icon_8, false))
        addFilm(Film(0, "film10", R.drawable.icon_9, false))
        addFilm(Film(0, "film11", R.drawable.icon_10, false))
        addFilm(Film(0, "film12", R.drawable.icon_0, false))
        addFilm(Film(0, "film13", R.drawable.icon_1, false))
        addFilm(Film(0, "film14", R.drawable.icon_2, false))
        addFilm(Film(0, "film15", R.drawable.icon_3, false))
        addFilm(Film(0, "film16", R.drawable.icon_4, false))
        addFilm(Film(0, "film17", R.drawable.icon_5, false))
        addFilm(Film(0, "film18", R.drawable.icon_6, false))
        addFilm(Film(0, "film19", R.drawable.icon_7, false))
        addFilm(Film(0, "film20", R.drawable.icon_8, false))
        addFilm(Film(0, "film21", R.drawable.icon_9, false))
        addFilm(Film(0, "film22", R.drawable.icon_10, false))
        addFilm(Film(0, "film23", R.drawable.icon_0, false))
        addFilm(Film(0, "film24", R.drawable.icon_1, false))
        addFilm(Film(0, "film25", R.drawable.icon_2, false))
        addFilm(Film(0, "film26", R.drawable.icon_3, false))
        addFilm(Film(0, "film27", R.drawable.icon_4, false))
        addFilm(Film(0, "film28", R.drawable.icon_5, false))
        addFilm(Film(0, "film29", R.drawable.icon_6, false))
        addFilm(Film(0, "film30", R.drawable.icon_7, false))

    }

}
class UserInfo(
    var name: String ="",
    var familyName: String ="",
    var emailAddress: String =""
) {
    var phoneNumber: String=""
    var username: String=""
}