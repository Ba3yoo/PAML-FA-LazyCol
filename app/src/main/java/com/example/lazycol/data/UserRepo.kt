package com.example.lazycol.data

import com.example.lazycol.model.User
import com.example.lazycol.service.RetrofitInstance

class UserRepo {
    private val userService = RetrofitInstance.userService

    suspend fun getUsers(): List<User> {
        return userService.getUsers()
    }
}