package com.akole.signupcompose.ui.screens.form

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.akole.signupcompose.R
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
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            item {
                Text(
                    text = stringResource(id = R.string.select_country_text),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(10.dp)
                )
            }
            items(countryToPhonePrefix.keys.toList()) { country ->
                Text(
                    text = "$country (${countryToPhonePrefix[country]})",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clickable { onItemClick(country) }
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