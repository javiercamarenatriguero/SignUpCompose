package com.akole.signupcompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.akole.signupcompose.R
import com.akole.signupcompose.ui.theme.Shapes
import com.akole.signupcompose.ui.theme.SignUpColor

@Composable
fun CustomOutlinedTextField(
    value: String = "",
    onValueChange: (String) -> Unit = {},
    onKeyboardNext: () -> Unit = {},
    onKeyboardDone: () -> Unit = {},
    label: String = "",
    enabled: Boolean = true,
    isError: Boolean = false,
    errorText: String = "",
    singleLine: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    leadingIcon: @Composable (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Column {
        OutlinedTextField(
            value = value,
            onValueChange = { onValueChange(it)},
            label = {
                Text( text = label)
            },
            enabled = enabled,
            isError = isError,
            singleLine = singleLine,
            modifier = modifier
                .background(SignUpColor.grey0Alpha50, Shapes.small),
            shape = Shapes.small,
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = MaterialTheme.colors.primary,
                focusedLabelColor = MaterialTheme.colors.primary
            ),
            keyboardOptions = KeyboardOptions(
                autoCorrect = false,
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            keyboardActions = KeyboardActions(
                onNext = { onKeyboardNext() },
                onDone = { onKeyboardDone() },
            ),
            visualTransformation = visualTransformation,
            trailingIcon = {
                if (value.isNotEmpty() && enabled) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Clear text icon",
                        tint = SignUpColor.greyDarkAlpha50,
                        modifier = Modifier
                            .clickable { onValueChange("") }
                    )
                }
            },
            leadingIcon = leadingIcon
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
    var text by rememberSaveable { mutableStateOf("") }
    val onValueChange: (String) -> Unit = {
        text = it
    }
    CustomOutlinedTextField(
        text,
        onValueChange = onValueChange,
        label = "Phone number",
        enabled = true,
        isError = true,
        errorText = "Fail data"
    )
}