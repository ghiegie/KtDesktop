package composables

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import classes.GreetingFormatModel
import classes.GreetingModel

@Composable
fun Greeting(greetingModel: GreetingModel) {
    var expanded by rememberSaveable {mutableStateOf(false)}
    val extraPadding by animateDpAsState(if (expanded) 30.dp else 5.dp, animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow))

    Surface(modifier = Modifier.fillMaxWidth().padding(5.dp), color = MaterialTheme.colors.primary) {
        GreetingFormat(GreetingFormatModel(greetingModel.name, expanded, extraPadding) { expanded = !expanded })
    }
}

@Composable
fun GreetingFormat(greetingFormatModel: GreetingFormatModel) {
    Row {
        Column(modifier = Modifier.padding(bottom = greetingFormatModel.extraPadding.coerceAtLeast(0.dp)).weight(1f)) {
            Text("Hello")
            Text(text = greetingFormatModel.name, style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.Bold))
        }
        Button(onClick = greetingFormatModel.eventHandler) {Text(if (greetingFormatModel.expanded) "Show less" else "Show more")}
    }
}
