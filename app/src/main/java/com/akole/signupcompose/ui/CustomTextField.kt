package com.akole.signupcompose.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.akole.signupcompose.R
import com.akole.signupcompose.ui.theme.SignUpColor

@Composable
fun CustomOutlinedTextField(
    text: String = "",
    onValueChange: (String) -> Unit,
    enabled: Boolean = true,
    isError: Boolean = false,
    errorText: String = "",
    modifier: Modifier = Modifier
) {
    Column {
        OutlinedTextField(
            value = text,
            onValueChange = { onValueChange(it)},
            enabled = enabled,
            isError = isError,
            modifier = modifier,
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.textfield_corner_radius)),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = SignUpColor.greyAlpha50
            ),
            trailingIcon = {
                if (isError) {
                    Icon(
                        imageVector = Icons.Filled.Warning,
                        tint = MaterialTheme.colors.error,
                        contentDescription = "Text validation error"
                    )
                }
            }
        )
        if (isError) {
            val errorTextPadding = dimensionResource(id = R.dimen.textfield_error_start_padding)
            Text(
                text = errorText,
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(start = errorTextPadding)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun Preview() {
    var text by rememberSaveable {mutableStateOf("testing") }
    val onValueChange: (String) -> Unit = {
        text = it
    }
    CustomOutlinedTextField(
        text,
        onValueChange = onValueChange,
        isError = false,
        errorText = "Fail data"
    )
}