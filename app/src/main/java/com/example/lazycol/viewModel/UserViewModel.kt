package com.example.lazycol.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lazycol.data.UserRepo
import com.example.lazycol.model.User
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    private val repo = UserRepo()

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    fun fetchUser() {
        viewModelScope.launch {
            try {
                val user = repo.getUsers()
                _users.value = user
                Log.e("Fetch User", _users.value.toString())
            } catch (e:Exception) {
                Log.e("Fetch User", e.message.toString())
            }
        }
    }
}