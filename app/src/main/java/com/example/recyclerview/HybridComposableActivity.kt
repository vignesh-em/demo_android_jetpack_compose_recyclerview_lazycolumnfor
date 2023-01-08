package com.example.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.ComposeView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.databinding.ViewItemBinding
import kotlin.random.Random

class HybridComposableActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@HybridComposableActivity)
            adapter = HybridComposableAdapter(listItems)
        }
    }
}

class HybridComposableAdapter(private val listItems: List<Item>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_VIEW = 0
        private const val TYPE_COMPOSABLE = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_VIEW -> {
                val binding = ViewItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                ItemViewHolder(binding)
            }
            else -> {
                ComposeItemViewHolder(ComposeView(parent.context))
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as Bindable).bindView(listItems[position % listItems.size])
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    private val positionTypeMap = mutableMapOf<Int, Int>()

    override fun getItemViewType(position: Int): Int {
        if (positionTypeMap[position] == null) {
            positionTypeMap[position] = if (Random.nextBoolean()) TYPE_VIEW else TYPE_COMPOSABLE
        }
        return positionTypeMap[position]!!
    }
}
