package me.baleen.delegateadapter.sample.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import me.baleen.delegateadapter.sample.adapter.delegate.ImageDelegate
import me.baleen.delegateadapter.sample.adapter.delegate.TextDelegate
import me.baleen.delegateadapter.sample.model.DisplayItem
import me.baleen.delegateadpater.DelegateAdapterManager

/**
 * Created by baleen37@gmail.com on 03/08/2017.
 */

class SimpleListAdapter2(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items = arrayListOf<DisplayItem>()
    val delegatesManager = DelegateAdapterManager<List<DisplayItem>>()

    val imageDelegate = ImageDelegate(context)
    val textDelegate = TextDelegate(context)

    init {
        delegatesManager.addDelegate(imageDelegate)
        delegatesManager.addDelegate(textDelegate)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder?, position: Int) {
        delegatesManager.onBindViewHolder(viewHolder, items, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return delegatesManager.onCreateViewHolder(parent, viewType)
    }

    override fun getItemViewType(position: Int): Int {
        return delegatesManager.getItemViewType(items, position)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}