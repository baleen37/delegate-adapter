package me.baleen.delegateadapter.sample.adapter.delegate

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import me.baleen.delegateadapter.sample.R
import me.baleen.delegateadapter.sample.model.DisplayItem
import me.baleen.delegateadapter.sample.model.TextModel
import me.baleen.delegateadpater.AdapterDelegate

/**
 * Created by baleen37@gmail.com on 07/08/2017.
 */
class TextDelegate(val context: Context) : AdapterDelegate<List<DisplayItem>> {

    override fun isViewType(items: List<DisplayItem>, position: Int): Boolean {
        return items[position] is TextModel
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, items: List<DisplayItem>, position: Int) {
        holder as ViewHolder
        val item = items[position] as TextModel

        holder.apply {
            textView.text = item.text
        }
    }

    private class ViewHolder(parent: ViewGroup?) : RecyclerView.ViewHolder(
            LayoutInflater.from(parent?.context).inflate(R.layout.vh_text, parent, false)) {
        val textView = itemView.findViewById<TextView>(R.id.textView)
    }
}