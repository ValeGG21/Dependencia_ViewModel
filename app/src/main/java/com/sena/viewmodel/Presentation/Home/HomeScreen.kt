package com.sena.viewmodel.Presentation.Home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.sena.viewmodel.R
import com.sena.viewmodel.Domain.Model.TimerTypeEnum
import com.sena.viewmodel.Presentation.Components.AutoResizedText
import com.sena.viewmodel.Presentation.Components.BorderedIcon
import com.sena.viewmodel.Presentation.Components.CircleDot
import com.sena.viewmodel.Presentation.Components.CustomButtonAlternative
import com.sena.viewmodel.Presentation.Components.CustomButton
import com.sena.viewmodel.Presentation.Components.InformationItem
import com.sena.viewmodel.Presentation.Components.TimerTypeItem
import com.sena.viewmodel.Presentation.theme.ViewModelTheme

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel = HomeScreenViewModel()) {
    val timeState by remember { mutableStateOf(viewModel.timerValueState) }
    val timerTypeState by remember { mutableStateOf(viewModel.timerTypeState) }
    val roundsState by remember { mutableStateOf(viewModel.roundsState) }
    val todayTimeState by remember { mutableStateOf(viewModel.todayTimeState) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(ViewModelTheme.dimens.paddingMedium)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopEnd
        ) {
            Icon(
                modifier = Modifier.size(ViewModelTheme.dimens.iconSizeNormal),
                painter = painterResource(id = R.drawable.ic_menu),
                contentDescription = "Menu",
                tint = MaterialTheme.colorScheme.primary
            )
        }
        AutoResizedText(
            text = "Focus Timer",
            textStyle = MaterialTheme.typography.displayMedium.copy(
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )
        )
        Spacer(modifier = Modifier.height(ViewModelTheme.dimens.spacerMedium))
        Row {
            CircleDot()
            Spacer(modifier = Modifier.width(ViewModelTheme.dimens.spacerNormal))
            CircleDot()
            Spacer(modifier = Modifier.width(ViewModelTheme.dimens.spacerNormal))
            CircleDot(color = MaterialTheme.colorScheme.tertiary)
            Spacer(modifier = Modifier.width(ViewModelTheme.dimens.spacerNormal))
            CircleDot(color = MaterialTheme.colorScheme.tertiary)
        }
        Spacer(modifier = Modifier.height(ViewModelTheme.dimens.spacerMedium))
        TimerSession(
            timer = viewModel.millisToMinutes(timeState.value),
            onIncreaseTap = {
                viewModel.onIncreaseTime()
            },
            onDecreaseTap = {
                viewModel.onDecreaseTime()
            }
        )
        Spacer(modifier = Modifier.height(ViewModelTheme.dimens.spacerMedium))
        TimerTypeSession(
            type = timerTypeState.value,
            onTap = { type ->
                viewModel.onUpdateType(type)
            }
        )
        Spacer(modifier = Modifier.height(ViewModelTheme.dimens.spacerMedium))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CustomButton(
                text = "Start",
                textColor = MaterialTheme.colorScheme.surface,
                buttonColor = MaterialTheme.colorScheme.primary,
                onClick = {
                    viewModel.onStartTimer()
                }
            )
            CustomButtonAlternative(
                text = "Reset",
                textColor = MaterialTheme.colorScheme.primary,
                buttonColor = MaterialTheme.colorScheme.surface,
                onTap = {
                    viewModel.onCancelTimer(true)
                }
            )
        }
        Spacer(modifier = Modifier.height(ViewModelTheme.dimens.spacerMedium))
        InformationSession(
            modifier = Modifier.weight(1f),
            round = roundsState.value.toString(),
            time = viewModel.millisToHours(todayTimeState.value)
        )
    }
}

@Composable
fun TimerSession(
    modifier: Modifier = Modifier,
    timer: String,
    onIncreaseTap: () -> Unit = {},
    onDecreaseTap: () -> Unit = {},
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BorderedIcon(icon = R.drawable.ic_minus, onTap = onDecreaseTap)
            Spacer(modifier = Modifier.height(ViewModelTheme.dimens.spacerMedium))
        }
        AutoResizedText(
            text = timer,
            modifier = Modifier
                .fillMaxWidth()
                .weight(6f)
                .align(Alignment.CenterVertically),
            textStyle = MaterialTheme.typography.displayLarge.copy(
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BorderedIcon(icon = R.drawable.ic_plus, onTap = onIncreaseTap)
            Spacer(modifier = Modifier.height(ViewModelTheme.dimens.spacerMedium))
        }
    }
}

@Composable
fun TimerTypeSession(
    modifier: Modifier = Modifier,
    type: TimerTypeEnum,
    onTap: (TimerTypeEnum) -> Unit = {}
) {
    val gridCount = 3
    val itemsSpacing = Arrangement.spacedBy(ViewModelTheme.dimens.paddingNormal)
    LazyVerticalGrid(
        modifier = modifier
            .fillMaxWidth()
            .height(ViewModelTheme.dimens.spacerLarge),
        columns = GridCells.Fixed(gridCount),
        horizontalArrangement = itemsSpacing,
        verticalArrangement = itemsSpacing,
    ) {
        items(
            TimerTypeEnum.values(),
            key = { it.title }
        ) {
            TimerTypeItem(
                text = it.title,
                textColor = if (type == it)
                    MaterialTheme.colorScheme.primary
                else
                    MaterialTheme.colorScheme.secondary,
                onTap = { onTap(it) }
            )
        }
    }
}

@Composable
fun InformationSession(
    modifier: Modifier = Modifier,
    round: String,
    time: String
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            InformationItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                text = round,
                label = "rounds"
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            InformationItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                text = time,
                label = "time"
            )
        }
    }
}

@Preview(
    name = "HomeScreenPreview",
    showBackground = true
)
@Composable
fun HomeScreenPreview() {
    ViewModelTheme {
        HomeScreen()
    }
}
