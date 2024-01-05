package composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import classes.GreetingModel
import classes.MyAppModel

@Composable
fun MyApp(myAppModel: MyAppModel) {
    LazyColumn(modifier = myAppModel.modifier.padding(vertical = 4.dp)) {
        items(items = myAppModel.names) {name -> Greeting(GreetingModel(name))}
    }
}