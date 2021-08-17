import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.theme.ComposeTheme
import com.example.composeplayground.ui.slots.TestCompose


@Preview
@Composable
fun Greeting(
    navController : NavHostController
){

    TestCompose {
        Column {
            Text(
                text = "Hello World!"
            )
            Button(onClick = { navController.navigate("greetings2") }) {
                Text(text = "Click me!")
            }
        }

    }
}

