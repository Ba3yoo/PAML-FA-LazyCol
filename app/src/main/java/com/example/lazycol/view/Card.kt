package com.example.lazycol.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.unit.dp
import com.example.lazycol.model.User

@Composable
fun cards(user : User){
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Row{
            Column (Modifier.padding(10.dp))
            {
                Text(
                    text = "${user.id.toString()}. ${user.name}"
                )
                Text(
                    text = "Username = ${user.username}"
                )
                Text(
                    text = "Email = ${user.email}"
                )
                Text(
                    text = "Addr = ${user.address.street}, ${user.address.suite}, ${user.address.city}"
                )
                Text(
                    text = "Zipcode = ${user.address.zipcode}"
                )
                Text(
                    text = "Lat = ${user.address.geo.lat}, Lng = ${user.address.geo.lng}"
                )
                Text(
                    text = "Phone = ${user.phone}"
                )
                Text(
                    text = "Web = ${user.website}"
                )
                Text(
                    text = "Company = ${user.company.name}"
                )
                Text(
                    text = "\"${user.company.catchPhrase}\""
                )
                Text(
                    text = user.company.bs
                )
            }
        }
    }
}