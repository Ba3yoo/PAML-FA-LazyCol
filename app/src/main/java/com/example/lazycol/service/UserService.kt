package com.example.lazycol.service

import com.example.lazycol.model.User
import retrofit2.http.GET

interface UserService {
    @GET("users")
    suspend fun getUsers():List<User>
}