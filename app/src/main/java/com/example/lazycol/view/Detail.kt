package com.example.lazycol.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lazycol.model.User
import com.example.lazycol.viewModel.UserViewModel

@Composable
fun detailScreen(id: Int, viewModel: UserViewModel = viewModel()){
    val user = viewModel.user.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.getUser(id)
    }
    
    Column(Modifier.padding(40.dp)) {
        Text("ID = ${user.value?.id.toString()}\n")
        user.value?.let { Text("Name = ${it.name}\n") }
        user.value?.let { Text("Email = ${it.email}\n") }
        user.value?.company?.let { Text("Company Name = ${it.name}\n") }
        user.value?.company?.let { Text("Company Phrase = ${it.catchPhrase}\n") }
        user.value?.company?.let { Text("Company Business = ${it.bs}\n") }
    }
}