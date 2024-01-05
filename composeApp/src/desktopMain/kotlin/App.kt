import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import classes.MyAppModel
import classes.OnboardingScreenModel
import composables.MyApp
import composables.OnboardingScreen

@Composable
fun App(modifier: Modifier = Modifier) {
    var shouldShowOnboarding by remember { mutableStateOf(true) }

    Surface(modifier) {
        if (shouldShowOnboarding) {
            OnboardingScreen(OnboardingScreenModel{shouldShowOnboarding = false})
        } else {
            MyApp(MyAppModel(modifier = Modifier.fillMaxSize()))
        }
    }
}