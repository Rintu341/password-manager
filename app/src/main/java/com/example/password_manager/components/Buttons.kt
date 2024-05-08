package com.example.password_manager.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.password_manager.data.User

@Composable
fun OutlinedButtonExample(text:String,modifier:Modifier = Modifier,onClick: () -> Unit) {
    OutlinedButton(onClick = { onClick.invoke() },
    modifier.padding(8.dp)
    ) {
        Text(text)
    }
}

@Composable
fun ElevatedButtonExample(text:String,onClick: () -> Unit) {
    ElevatedButton(
        onClick = { onClick() },
        modifier = Modifier.padding(8.dp),
        enabled = true,
        colors = ButtonDefaults.buttonColors(Color(0xFF43A860)),
        shape = RoundedCornerShape(10),


        ) {
        Text(text,color = Color.Black)
    }
}

@Composable
fun UserSaveCancelButton(
    userId: MutableState<String>,
    password: MutableState<String>,
    isOpen:()->Unit,
    onAddUser: (User) -> Unit
) {
    OutlinedButtonExample(text = "cancel") {
        userId.value = ""
        password.value = ""
        isOpen.invoke()
    }
    ElevatedButtonExample(text = "save")
    {
        if (userId.value.isNotEmpty() && password.value.isNotEmpty()) {
            onAddUser(User(userId = userId.value, password = password.value))
            userId.value = ""
            password.value = ""
        }
    }
}