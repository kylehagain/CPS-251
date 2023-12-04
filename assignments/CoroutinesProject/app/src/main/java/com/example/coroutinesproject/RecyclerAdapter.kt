package com.example.coroutinesproject

import android.view.LayoutInflater
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    private val lines = mutableListOf("John Smith", "David Jones", "Michael Taylor", "James Brown", "Daniel Wilson")

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        coroutineScope.launch(Dispatchers.Main){
            viewHolder.itemTitle.text = performTaskAsync(i).await()
        }

    }

    override fun getItemCount(): Int {
        return lines.size
    }

    suspend fun performTaskAsync(tasknumber: Int): Deferred<String> =
        coroutineScope.async(Dispatchers.Main) {
            val randomDelay = Random.nextLong(0, 10000)
            delay(randomDelay)
            return@async "The name is ${lines[tasknumber]} and the delay was ${randomDelay / 1000}s"
        }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemTitle: TextView

        init {
            itemTitle = itemView.findViewById(R.id.itemTitle)
        }
    }



}