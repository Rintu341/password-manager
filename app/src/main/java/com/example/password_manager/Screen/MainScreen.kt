package com.example.password_manager.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.password_manager.R
import com.example.password_manager.components.ElevatedButtonExample
import com.example.password_manager.components.ShowUserData
import com.example.password_manager.components.UserInputTextField
import com.example.password_manager.components.UserSaveCancelButton
import com.example.password_manager.components.UserTopAppBar
import com.example.password_manager.data.User


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    users: List<User>,
    onAddUser:(User) -> Unit,
    onRemoveUser:(User) -> Unit
) {

    val userId = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }

    val isOpen  = remember{
        mutableStateOf(false)
    }
    Scaffold(
            topBar = {
                UserTopAppBar(modifier)
            },
    ) {
        Column(
            modifier
                .fillMaxSize()
                .padding(it),
            ) {
                if(isOpen.value) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp, start = 8.dp, end = 8.dp, bottom = 12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    )
                    {
                        UserInputTextField(userId, password)
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween
                        )
                        {
                            UserSaveCancelButton(
                                userId,
                                password,
                                isOpen = { isOpen.value = false },
                                onAddUser
                            )
                        }
                    }
                    Divider(modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp))
                }
                //show list of User
                LazyColumn {
                    items(users){user->
                        ShowUserData(user = user) {
                            onRemoveUser(user)
                        }
                    }
                }
            } // user input field end here





            //Add button start
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                ElevatedButtonExample(onClick = {
                                                isOpen.value = true
                }, text = stringResource(id = R.string.Add) )
            }
        }
    }

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    MainScreen( users = mutableListOf(User(userId = "facebook", password = "saveEarth@Rintu")),
        onAddUser = {} , onRemoveUser = {})

}