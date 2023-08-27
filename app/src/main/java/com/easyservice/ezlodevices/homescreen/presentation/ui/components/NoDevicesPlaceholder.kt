package com.easyservice.ezlodevices.homescreen.presentation.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.easyservice.ezlodevices.shared.presentation.ui.theme.Typography
import com.easyservice.ezlodevices.shared.presentation.ui.theme.spacingExtraLarge

@Composable
fun NoDevicesPlaceholder() {
    Text(
        modifier = Modifier.padding(top = spacingExtraLarge),
        text = "You have deleted all your devices. Press refresh button to reload them from remote.",
        style = Typography.headlineSmall,
        textAlign = TextAlign.Center
    )
}