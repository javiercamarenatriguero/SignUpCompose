package com.akole.signupcompose.ui.screens.form

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.akole.signupcompose.R

@Composable
fun TitleText() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 25.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            // Set Spain as default prefix
            text = stringResource(id = R.string.sign_up_title_text),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h4
        )
    }
}