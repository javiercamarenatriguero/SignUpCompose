package com.akole.signupcompose.ui.screens.signup

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.akole.signupcompose.AppState
import com.akole.signupcompose.R
import com.akole.signupcompose.ui.screens.signup.SignUpViewModel.OneShotEvent
import com.akole.signupcompose.ui.screens.signup.SignUpViewModel.ViewEvent
import kotlinx.coroutines.flow.collect

@OptIn(ExperimentalMaterialApi::class)
@ExperimentalComposeUiApi
@Composable
fun SignUpScreen(
    appState: AppState,
    viewModel: SignUpViewModel
) {
    ModalBottomSheetLayout(
        sheetState = appState.modalBottomSheetState,
        sheetContent = {
            CountryListModalSheetContent(
                onItemClick = {
                    viewModel.on(ViewEvent.CountryChange(it))
                }
            )
        },
        sheetShape = RoundedCornerShape(20.dp)
    ) {
        Scaffold(
            scaffoldState = appState.scaffoldState,
            topBar ={
                TopAppBar(
                    title ={
                        Text(text =stringResource(id = R.string.app_name))
                    },
                    elevation = 5.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                )
            }
        ) { paddings ->
            SignUpContent(
                viewModel = viewModel,
                modifier = Modifier.padding(paddings)
            )
        }
    }

    LaunchedEffect(viewModel.oneShotEvents) {
        viewModel.oneShotEvents.collect { event ->
            when (event) {
                OneShotEvent.OpenCountryModalSheet -> appState.showModalSheet()
                OneShotEvent.HideKeyboard -> appState.hideKeyboard()
                OneShotEvent.HideCountryModalSheet -> appState.hideModalSheet()
                OneShotEvent.FocusRight -> appState.moveFocus(FocusDirection.Right)
                OneShotEvent.FocusDown -> appState.moveFocus(FocusDirection.Down)
                OneShotEvent.FocusClear -> appState.clearFocus()
                else -> {}
            }
        }
    }
}
