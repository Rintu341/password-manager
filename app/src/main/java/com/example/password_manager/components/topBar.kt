package com.example.password_manager.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.password_manager.R

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun UserTopAppBar(modifier: Modifier) {
    TopAppBar(title = {
        Text(
            text = stringResource(id = R.string.user_name),
            modifier.padding(start = 20.dp),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 30.sp
        )
    },
        navigationIcon = {
            IconButton(
                modifier = Modifier.size(60.dp),
                onClick = { /*TODO*/ }) {
                UserIcon(image = R.drawable.user_photo)
            }
        },
        actions = {
            IconButton(modifier = Modifier.size(60.dp),
                onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Notifications, contentDescription = null)
            }
        }
    )
}