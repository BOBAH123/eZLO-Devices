package com.easyservice.ezlodevices.homescreen.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.window.Dialog
import com.easyservice.ezlodevices.R
import com.easyservice.ezlodevices.shared.presentation.ui.theme.Typography
import com.easyservice.ezlodevices.shared.presentation.ui.theme.spacingNormal

@Composable
fun EditDeleteDialog(
    onDismissDialog: () -> Unit,
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit,
) {
    Dialog(onDismissRequest = onDismissDialog) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10))
                .background(Color.White)
                .padding(spacingNormal),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.dialog_title),
                style = Typography.titleLarge,
                textAlign = TextAlign.Center
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(spacingNormal),
                onClick = onEditClick
            ) {
                Text(
                    text = stringResource(id = R.string.edit_btn_text),
                    style = Typography.bodyLarge
                )
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = spacingNormal),
                onClick = onDeleteClick
            ) {
                Text(
                    text = stringResource(id = R.string.delete_btn_text),
                    style = Typography.bodyLarge
                )
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(spacingNormal),
                onClick = onDismissDialog
            ) {
                Text(
                    text = stringResource(id = R.string.close_btn_text),
                    style = Typography.bodyLarge
                )
            }
        }
    }
}