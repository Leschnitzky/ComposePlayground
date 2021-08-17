import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeplayground.ui.slots.TestCompose


@Preview
@Composable
fun Greeting2(){

    TestCompose {
        Text(
            text = "Hello World2!"
        )
    }
}