package com.akole.signupcompose.ui.screens.form

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.akole.signupcompose.R
import com.akole.signupcompose.countryToPhonePrefix
import com.akole.signupcompose.ui.CustomOutlinedTextField

@Composable
fun PhoneTextField(
    phoneNumber: String,
    country: String,
    onPhoneNumberChange: (String) -> Unit,
    onPhonePrefixClick: () -> Unit
) {
    CustomOutlinedTextField(
        value = phoneNumber,
        onValueChange = onPhoneNumberChange,
        label = stringResource(id = R.string.sign_up_phone_number_label_text),
        keyboardType = KeyboardType.Phone,
        leadingIcon = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = "",
                    modifier = Modifier.padding(start = 10.dp, end = 5.dp)
                )
                Row(
                    modifier = Modifier
                        .padding(start = 5.dp, end = 5.dp)
                        .clickable { onPhonePrefixClick() }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = ""
                    )
                    Text(
                        // Set Spain as default prefix
                        text = countryToPhonePrefix[country] ?: "+34",
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    )
}