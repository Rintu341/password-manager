package com.example.password_manager.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.password_manager.data.User

@Composable
fun ShowUserData(modifier: Modifier = Modifier, user : User, onRemove:()->Unit) {
    Card(onClick = { onRemove.invoke() },
            modifier = modifier
                .padding(8.dp)
                .fillMaxWidth()
                .height(100.dp),
            colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.elevatedCardElevation(8.dp),
        ) {

        Column (
            modifier = Modifier.padding(8.dp).fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ){
                Text(text = user.userId ,
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.headlineLarge.fontSize
                    )

                Text(text = user.password,
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize
                    )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowUserDataPreview() {
    ShowUserData(user = User(userId = "facebook", password = "saveEarth@Rintu")) {

    }
}