package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.io.Serializable

class LauncherActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                        startActivity(Intent(this@LauncherActivity,
                            RecyclerViewActivity::class.java))
                    }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(text = "Normal RecyclerView", fontSize = 32.sp)
                }
                Button(
                    onClick = {
                        startActivity(Intent(this@LauncherActivity,
                            HybridActivity::class.java))
                    }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(text = "Hybrid RecyclerView", fontSize = 32.sp)
                }
                Button(
                    onClick = {
                        startActivity(Intent(this@LauncherActivity,
                            LazyColumnActivity::class.java))
                    }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(text = "Compose LazyColumn", fontSize = 32.sp)
                }

                Button(
                    onClick = {
                        startActivity(Intent(this@LauncherActivity,
                            HybridComposableActivity::class.java))
                    }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(text = "Rv Item + Composable", fontSize = 32.sp)
                }
            }
        }
    }
}

data class Item(val number: String, val country: String): Serializable
