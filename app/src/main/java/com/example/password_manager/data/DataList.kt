package com.example.password_manager.data

class DataList {

    fun getUsers():List<User>
    {
        return listOf(
            User(userId = "facebook", password = "saveearth@Rintu"),
            User(userId = "instagram", password = "saveearth@Rintu"),
        )
    }
}