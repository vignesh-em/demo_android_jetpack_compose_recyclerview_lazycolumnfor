package com.example.recyclerview

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class LazyColumnActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLazyColumn(
                listItems = listItems
            )
        }
    }
}

@Composable
fun MyLazyColumn(
    modifier: Modifier = Modifier,
    listItems: List<Item>,
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(Int.MAX_VALUE) {
            ViewItem(itemText = listItems[it % listItems.size])
        }
    }
}

@Composable
fun ViewItem(
    itemText: Item
) {
    Box(modifier = Modifier.padding(16.dp)) {
        Card(
            shape = RoundedCornerShape(4.dp),
            backgroundColor = Color(0xFFCCCCCC),
        ) {
            Row {
                Text(
                    text = itemText.number,
                    modifier = Modifier.padding(8.dp),
                    style = TextStyle(fontSize = 24.sp, color = Color.Red),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = itemText.country,
                    modifier = Modifier.padding(8.dp),
                    style = TextStyle(fontSize = 24.sp, color = Color.Black),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
