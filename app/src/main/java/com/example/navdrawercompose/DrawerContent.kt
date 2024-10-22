package com.example.navdrawercompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DrawerContent(
    drawerState: DrawerState,
    scope: CoroutineScope,
    navController: NavHostController
) {
    val configuration = LocalConfiguration.current
    val width = remember { (configuration.screenWidthDp * 0.60).dp }
    val statusBarHeight = with(LocalDensity.current) { WindowInsets.systemBars.getTop(this).toDp() }
    Column(modifier = Modifier
        .width(width)
        .fillMaxHeight()
        .padding(top = statusBarHeight)
        .background(color = Color.Gray)) {
        Text("Home", modifier = Modifier
            .padding(16.dp)
            .clickable {
                navController.navigate(Screens.Home.route)
                scope.launch { drawerState.close() }
            })
        Text("About", modifier = Modifier
            .padding(16.dp)
            .clickable {
                navController.navigate(Screens.About.route)
                scope.launch { drawerState.close() }
            })
        Text("Settings", modifier = Modifier
            .padding(16.dp)
            .clickable {
                navController.navigate(Screens.Settings.route)
                scope.launch { drawerState.close() }
            })
    }
}