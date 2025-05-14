package com.example.lazycol.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lazycol.data.UserRepo
import com.example.lazycol.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    private val repo = UserRepo()

    private val _users = MutableStateFlow<List<User>?>(null)
    val users: StateFlow<List<User>?> = _users

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

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

    fun getUser(id: Int) {
        viewModelScope.launch {
            try {
                val user = repo.getUser(id)
                _user.value = user
                Log.i("USER", _user.value.toString())
            } catch (e: Exception) {
                Log.e("USER", e.message.toString())
            }
        }
    }
}