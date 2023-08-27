package com.easyservice.ezlodevices.shared.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.easyservice.ezlodevices.R
import com.easyservice.ezlodevices.shared.presentation.ui.theme.EZLODevicesTheme

@Composable
fun AppHeader() {
    Column(
        Modifier.fillMaxWidth().background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Spacer(modifier = Modifier.height(12.dp))

        Image(
            modifier = Modifier
                .size(300.dp)
                .clip(CircleShape),
            painter = painterResource(id = R.drawable.my_photo),
            contentDescription = "",
            contentScale = ContentScale.Crop,
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Volodymyr Lesko",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EZLODevicesTheme {
        AppHeader()
    }
}