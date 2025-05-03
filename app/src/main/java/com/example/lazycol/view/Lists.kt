package com.example.lazycol.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lazycol.ui.theme.LazycolTheme
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.lazycol.viewModel.UserViewModel
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.example.lazycol.model.User

@Composable
fun userList(viewModel: UserViewModel) {
    val users by viewModel.users.observeAsState(null)
    LaunchedEffect(Unit) {
        viewModel.fetchUser()
    }
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(10.dp)
    ){
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(vertical = 20.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Text("225150701111005 - Bayusatya Mufti Muhammad", style = MaterialTheme.typography.headlineMedium)
            }
        }
        if(users == null) {
            item{
                Text(text="Waiting")
            }
        } else{
            val listUser = users ?: emptyList<User>()
            items(listUser){
                user -> cards(user)
            }
        }
    }
}