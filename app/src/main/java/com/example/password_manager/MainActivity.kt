package com.example.password_manager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.password_manager.Screen.MainScreen
import com.example.password_manager.ui.theme.Password_ManagerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            val passwordViewModel:PasswordViewModel = viewModel()
            Password_ManagerTheme {
                App(passwordViewModel = passwordViewModel)
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier,passwordViewModel: PasswordViewModel) {

    val users = passwordViewModel.readAllData.collectAsState().value
    MainScreen(users = users,
        onAddUser = { user->
            passwordViewModel.addUser(user)
        } ,
        onRemoveUser = { user->
            passwordViewModel.removeUser(user)
        })

}