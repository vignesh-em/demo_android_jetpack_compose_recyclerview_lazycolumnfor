package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ActivityMainBinding

class HybridActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@HybridActivity)
            adapter = HybridRecyclerViewAdapter(listItems)
        }
    }
}


class HybridRecyclerViewAdapter(private val listItems: List<Item>)
    : RecyclerView.Adapter<ComposeItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComposeItemViewHolder {
        return ComposeItemViewHolder(ComposeView(parent.context))
    }

    override fun onBindViewHolder(holder: ComposeItemViewHolder, position: Int) {
        holder.bindView(listItems[position % listItems.size])
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }
}


class ComposeItemViewHolder(
    private val composeView: ComposeView
) : RecyclerView.ViewHolder(composeView), Bindable {

    override fun bindView(content: Item) {
        composeView.setContent {
            ViewItem(content)
        }
    }
}