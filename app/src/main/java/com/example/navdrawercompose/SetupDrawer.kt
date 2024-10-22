package com.example.navdrawercompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.navdrawercompose.screens.AboutScreen
import com.example.navdrawercompose.screens.HomeScreen
import com.example.navdrawercompose.screens.SettingsScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetupDrawer(navController: NavHostController, innerPadding: PaddingValues) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { DrawerContent(drawerState, scope, navController) }) {
        Column {
            TopAppBar(
                title = { Text("Navigation drawer") },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch { drawerState.open() }
                    }) {
                        Icon(Icons.Filled.Menu, contentDescription = "")
                    }
                }
            )
            NavHost(navController, startDestination = Screens.Home.route, modifier = Modifier.padding(innerPadding)) {
                composable(Screens.Home.route) { HomeScreen(modifier = Modifier) }
                composable(Screens.About.route) { AboutScreen(modifier = Modifier) }
                composable(Screens.Settings.route) { SettingsScreen(modifier = Modifier) }
            }
        }
    }
}