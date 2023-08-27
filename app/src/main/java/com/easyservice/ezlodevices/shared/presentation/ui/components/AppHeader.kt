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
import androidx.compose.ui.tooling.preview.Preview
import com.easyservice.ezlodevices.R
import com.easyservice.ezlodevices.shared.presentation.ui.theme.EZLODevicesTheme
import com.easyservice.ezlodevices.shared.presentation.ui.theme.Typography
import com.easyservice.ezlodevices.shared.presentation.ui.theme.profileImageHeight
import com.easyservice.ezlodevices.shared.presentation.ui.theme.spacingNormal

@Composable
fun AppHeader() {
    Column(
        Modifier.fillMaxWidth().background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Spacer(modifier = Modifier.height(spacingNormal))

        Image(
            modifier = Modifier
                .size(profileImageHeight)
                .clip(CircleShape),
            painter = painterResource(id = R.drawable.my_photo),
            contentDescription = "",
            contentScale = ContentScale.Crop,
        )

        Spacer(modifier = Modifier.height(spacingNormal))

        Text(
            text = "Volodymyr Lesko",
            style = Typography.titleLarge,
        )

        Spacer(modifier = Modifier.height(spacingNormal))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EZLODevicesTheme {
        AppHeader()
    }
}