package com.akole.signupcompose.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.akole.signupcompose.ui.theme.SignUpColor

@Composable
fun CustomDialog(
    content: @Composable () -> Unit,
    onDismissRequest: () -> Unit,
    title: String? = null,
    isCancellable: Boolean = false,
    doneButtonText: String? = null,
    onDoneButtonClick: () -> Unit = onDismissRequest,
    editButtonText: String? = null,
    onEditButtonClick: () -> Unit = onDismissRequest
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            dismissOnBackPress = isCancellable,
            dismissOnClickOutside = isCancellable,
        ),
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(SignUpColor.whiteAlpha90)
                .padding(20.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                title?.let { text ->
                    AlertDialogTitle(title = text)
                }
                content()
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    doneButtonText?.let { text ->
                        AlertDialogButton(
                            text = text,
                            onClick = onDoneButtonClick
                        )
                    }
                    editButtonText?.let { text ->
                        AlertDialogButton(
                            text = text,
                            onClick = onEditButtonClick
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun AlertDialogTitle(
    title: String
) {
    Text(
        text = title,
        style = MaterialTheme.typography.h6.copy(
            textAlign = TextAlign.Center,
            color = SignUpColor.grey6
        ),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    )
}

@Composable
private fun AlertDialogButton(
    text: String,
    onClick: () -> Unit = {},
) {
    Button(
        onClick = onClick
    ) {
        Text(text = text)
    }
}
