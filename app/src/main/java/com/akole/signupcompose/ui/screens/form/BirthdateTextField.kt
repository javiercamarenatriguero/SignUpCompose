package com.akole.signupcompose.ui.screens.form

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.akole.signupcompose.R
import com.akole.signupcompose.ui.CustomOutlinedTextField
import com.akole.signupcompose.utils.DateTransformation

@Composable
fun BirthDateTextField(
    birthdate: String,
    onBirthdateChange: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(SignUpScreenDefaults.ArrangementSpacedBy)
    ) {
        CustomOutlinedTextField(
            value = birthdate,
            keyboardType = KeyboardType.Number,
            visualTransformation = DateTransformation(),
            onValueChange = onBirthdateChange,
            label = stringResource(id = R.string.sign_up_birthdate_label_text),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.DateRange,
                    contentDescription = "",
                    modifier = Modifier.padding(start = 10.dp, end = 5.dp)
                )
            }
        )
    }
}