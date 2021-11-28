package com.akole.signupcompose.ui.screens.form

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.akole.signupcompose.countryToPhonePrefix

@Composable
fun CountryListModalSheetContent(
    onItemClick: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .defaultMinSize(minHeight = 1.dp)
            .fillMaxWidth()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    text = "Select a country",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(5.dp)
                )
            }
            items(countryToPhonePrefix.keys.toList()) { country ->
                Text(
                    text = country,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .clickable { onItemClick (country)}
                )
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
private fun previewModalSheet() {
    CountryListModalSheetContent({})
}