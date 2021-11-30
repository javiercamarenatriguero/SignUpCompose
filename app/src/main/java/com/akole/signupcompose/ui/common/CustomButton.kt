package com.akole.signupcompose.ui.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.akole.signupcompose.R

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            modifier = modifier
                .padding(dimensionResource(id = R.dimen.sign_up_button_padding))
        )
    }
}