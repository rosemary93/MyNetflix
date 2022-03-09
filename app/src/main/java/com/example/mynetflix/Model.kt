package com.example.mynetflix

object NetflixEnvironment {
    var userInfo: UserInfo? = null
    val filmList = ArrayList<Film>()

    fun testData(){
        filmList.add(Film("film1",R.drawable.icon_0))
        filmList.add(Film("film2",R.drawable.icon_1))
        filmList.add(Film("film3",R.drawable.icon_2))
        filmList.add(Film("film4",R.drawable.icon_3))
        filmList.add(Film("film5",R.drawable.icon_4))
        filmList.add(Film("film6",R.drawable.icon_5))
        filmList.add(Film("film7",R.drawable.icon_6))
        filmList.add(Film("film8",R.drawable.icon_7))
        filmList.add(Film("film9",R.drawable.icon_8))
        filmList.add(Film("film10",R.drawable.icon_9))
        filmList.add(Film("film11",R.drawable.icon_10))
        filmList.add(Film("film12",R.drawable.icon_11))
    }
}

data class Film(var title: String, var imageID: Int) {
    var isFavorite = false

}

class UserInfo(
    var name: String ="",
    var familyName: String ="",
    var emailAddress: String =""
) {
    var phoneNumber: String=""
    var username: String=""
}