package composables

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.FlowColumnScopeInstance.weight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
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
import java.util.Objects

@Composable
fun Greeting(greetingModel: GreetingModel) {
    var expanded by rememberSaveable {
        mutableStateOf(false)
    }

    val extraPadding by animateDpAsState(
        if (expanded) 30.dp
        else 5.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy,
        stiffness = Spring.StiffnessLow)
    )

    Surface(
        modifier = Modifier.fillMaxWidth()
            .padding(5.dp),
        color = MaterialTheme.colors
            .primary
    ) {
        GreetingFormat(GreetingFormatModel(
            greetingModel.name,
            expanded,
            extraPadding
        ) {
            expanded = !expanded
        })
    }
}

@Composable
fun GreetingFormat(greetingFormatModel: GreetingFormatModel) {
    val greetingFormatTextStyle = MaterialTheme.typography
        .h4
        .copy(fontWeight = FontWeight.Bold)

    val greetingFormatColumnChildren: @Composable ColumnScope.(String) -> Unit = {
        name: String ->
        Text("Hello")
        Text(
            text = name,
            style = greetingFormatTextStyle
        )
    }

    //fun ColumnScope.something() = {num: Float -> Modifier.weight(num)}

    val myFunc = {num: Float -> Modifier.weight(num)}

    val something =  object: ColumnScope {

    }
    val test = myFunc(ColumnScope(), 1f)

    val test = weight(1f).padding(start = 5.dp, top = 5.dp, end = 5.dp, bottom = greetingFormatModel.extraPadding.coerceAtLeast(0.dp))

    val greetingFormatColumnModifier: Modifier = weight(1f)

    Row {
        Column(
            modifier = greetingFormatColumnModifier,
            content = {greetingFormatColumnChildren(greetingFormatModel.name)}
        )
        IconButton({

        }) {Icon(
            imageVector = Icons.Filled
                .ArrowForward,
            contentDescription = null
        )}
    }
}


