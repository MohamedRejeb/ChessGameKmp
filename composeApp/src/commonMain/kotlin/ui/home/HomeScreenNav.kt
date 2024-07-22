package ui.home

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

data object HomeScreenNav: Screen {

    @Composable
    override fun Content() {
        HomeScreen()
    }

}