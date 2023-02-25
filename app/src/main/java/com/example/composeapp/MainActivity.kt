package com.example.composeapp

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContent {
            MessageCard(Message("arnold", "schwartz"))
        }
    }

    data class Message(
        val author: String,
        val body: String
    )

    @Composable
    fun MessageCard(msg: Message) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(R.drawable.arni),
                contentDescription = null,
                modifier = Modifier
                    // Set image size to 40 dp
                    .size(40.dp)
                    // Clip image to be shaped as a circle
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colors.primary, CircleShape)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = msg.author,
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(modifier = Modifier.height(4.dp))

                Surface(shape = MaterialTheme.shapes.small, elevation = 1.dp) {
                    Text(
                        text = msg.body,
                        Modifier.padding(4.dp),
                        color = MaterialTheme.colors.secondaryVariant,
                        style = MaterialTheme.typography.subtitle2
                    )
                }
            }
        }
    }

    @Preview(name = "Light Mode")
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark Mode"
    )
    @Composable
    fun PreviewMessageCard() {
        MaterialTheme {
            Surface {
                MessageCard(
                    msg =
                    Message("Arnold", "schwartz")
                )
            }
        }
    }
}