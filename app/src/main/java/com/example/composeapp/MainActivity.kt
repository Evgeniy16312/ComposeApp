package com.example.composeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContent {
            MessageCard(Message("android","jetpack compose"))
        }
    }

    data class Message(
        val author : String,
        val body : String
    )

    @Composable
    fun MessageCard(msg : Message) {
        Column {
            Text(text = msg.author)
            Text(text = msg.body)
        }
    }

    @Preview
    @Composable
    fun PreviewMessageCard() {
        MessageCard(msg =
      Message("Android","jetpack compose"))
    }
}