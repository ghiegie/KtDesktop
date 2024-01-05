package classes

import androidx.compose.ui.unit.Dp

class GreetingFormatModel(val name: String, var expanded: Boolean, var extraPadding: Dp, val eventHandler: () -> Unit)