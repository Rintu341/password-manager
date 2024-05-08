package com.example.password_manager.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.password_manager.R

@Composable
fun UserIcon(modifier : Modifier = Modifier,image:Int) {
    /*
    Surface(
        modifier
            .size(50.dp)
            .padding(2.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, color = Color.Gray),
        tonalElevation = 5.dp,
    )
    {
        Image(
            painter = painterResource(id = image),
            contentDescription = "profile image",
            contentScale = ContentScale.Crop
        )
    }
     */
    Surface(
        modifier
            .fillMaxSize()
            .padding(2.dp)
            .clickable { },
        shape = CircleShape,
        border = BorderStroke(width = 1.dp, color = Color.Black)
    )
    {
        Image(painter = painterResource(id = image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}

/*
//@Composable
//fun column(modifier: Modifier = Modifier) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(4.dp),
//
//        ) {
//
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Bottom,
//            horizontalAlignment = Alignment.CenterHorizontally
//        )
//        {
//            Button(
//                modifier = Modifier.clip(RoundedCornerShape(percent = 1)),
//                onClick = { /*TODO*/ }) {
//                Text(text = "Add userId and password")
//            }
//        }
//
//    }
//}
 */
@Preview(showBackground = true)
@Composable
private fun UserIconPreview() {
        UserIcon(image = R.drawable.user_photo)
//    column()
}