package com.example.mynetflix

object NetflixEnvironment {
    var userInfo: UserInfo? = null
    val filmList = ArrayList<Film>()
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