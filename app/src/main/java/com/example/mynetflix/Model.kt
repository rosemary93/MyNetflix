package com.example.mynetflix
object NetflixEnvironment{
    lateinit var userInfo: UserInfo
    val filmList=ArrayList<Film>()
}
data class Film(var title:String,var imageID:Int)
{
    var isFavorite=false
}

data class UserInfo(var name:String, var familyName:String,var emailAddress:String)
{
    var phoneNumber:String?=null
    var username:String?=null
}