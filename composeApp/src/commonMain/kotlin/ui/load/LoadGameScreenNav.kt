package ui.load

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

data object LoadGameScreenNav: Screen {

    @Composable
    override fun Content() {
        LoadGameScreen()
    }

}