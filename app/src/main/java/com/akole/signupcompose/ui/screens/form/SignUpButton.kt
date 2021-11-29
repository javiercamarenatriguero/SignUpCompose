package com.akole.signupcompose.ui.screens.form

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.akole.signupcompose.R

@Composable
fun SignUpButton(
    onClick: () -> Unit,
    enabled: Boolean
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Button(
            onClick = onClick,
            enabled = enabled
        ) {
            Text(
                text = stringResource(id = R.string.sign_up_button_text),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}