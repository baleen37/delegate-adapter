package me.baleen.delegateadapter.sample.adapter.delegate

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import me.baleen.delegateadapter.sample.R
import me.baleen.delegateadapter.sample.model.DisplayItem
import me.baleen.delegateadapter.sample.model.ImageModel
import me.baleen.delegateadpater.AdapterDelegate

/**
 * Created by baleen37@gmail.com on 07/08/2017.
 */
class ImageDelegate(val context: Context) : AdapterDelegate<List<DisplayItem>> {

    override fun isViewType(items: List<DisplayItem>, position: Int): Boolean {
        return items[position] is ImageModel
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, items: List<DisplayItem>, position: Int) {
        holder as ViewHolder
        var item = items[position] as ImageModel

        holder.apply {
            imageView.setBackgroundResource(item.resourceId)
        }
    }

    private class ViewHolder(parent: ViewGroup?) : RecyclerView.ViewHolder(
            LayoutInflater.from(parent?.context).inflate(R.layout.vh_image, parent, false)) {
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
    }
}