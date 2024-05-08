package com.example.password_manager.components

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import com.example.password_manager.R

@Composable
fun OutLineTextFieldExample(text :String,level:String,isOpenField:(String) -> Unit)
{
    OutlinedTextField(
        value = text,
        label = { Text(text = level) },
        onValueChange = {
            isOpenField.invoke(it)
        }
    )
}

@Composable
fun UserInputTextField(
    userId: MutableState<String>,
    password: MutableState<String>
) {
    OutlinedTextField(
        value = userId.value,
        onValueChange = {
            if (it.all { char ->
                    char.isLetter() || char.isWhitespace()
                }) {
                userId.value = it
            }
        },
        maxLines = 1,
        label = { Text(stringResource(id = R.string.User_ID)) },
    )
    OutlinedTextField(
        value = password.value,
        onValueChange = {
            if (it.all { char ->
                    char.isLetter() || char.isWhitespace()
                }) {
                password.value = it
            }
        },
        maxLines = 1,
        label = {
            Text(
                stringResource(id = R.string.Password)
            )
        },
    )
}