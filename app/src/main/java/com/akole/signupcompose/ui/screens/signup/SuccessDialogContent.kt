package com.akole.signupcompose.ui.screens.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.akole.signupcompose.R
import com.akole.signupcompose.utils.countryToPhonePrefix

@Composable
fun SuccessDialogContent(
    firstName: String,
    lastName: String,
    country: String,
    phoneNumber: String,
    email: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(30.dp)

    ) {
        Text(
            text = stringResource(
                id = R.string.sign_up_success_dialog_message,
                firstName,
                lastName,
            ),
            textAlign = TextAlign.Justify
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = ""
            )
            Text(
                text = "(${countryToPhonePrefix[country]}) $phoneNumber",
                fontWeight = FontWeight.Bold
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = ""
            )
            Text(
                text = "$email",
                fontWeight = FontWeight.Bold
            )
        }
    }
}