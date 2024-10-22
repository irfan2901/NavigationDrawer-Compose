package com.example.navdrawercompose

sealed class Screens(val route: String) {

    object Home: Screens("home")
    object About: Screens("about")
    object Settings: Screens("settings")

}