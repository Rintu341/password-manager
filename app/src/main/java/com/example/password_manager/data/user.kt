package com.example.password_manager.data

import java.util.UUID

data class User(
    val id: UUID = UUID.randomUUID(),
    var userId :String,
    var password:String
)