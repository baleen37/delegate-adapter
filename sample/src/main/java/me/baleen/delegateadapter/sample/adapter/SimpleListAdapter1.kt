package me.baleen.delegateadapter.sample.adapter

import android.content.Context
import me.baleen.delegateadapter.sample.adapter.delegate.ImageDelegate
import me.baleen.delegateadapter.sample.adapter.delegate.TextDelegate
import me.baleen.delegateadapter.sample.model.DisplayItem
import me.baleen.delegateadpater.AbsDelegateAdapter

/**
 * Created by baleen37@gmail.com on 03/08/2017.
 */

class SimpleListAdapter1(val context: Context, override var items: List<DisplayItem> = arrayListOf())
    : AbsDelegateAdapter<List<DisplayItem>>() {

    val imageDelegate = ImageDelegate(context)
    val textDelegate = TextDelegate(context)

    init {
        delegatesManager.addDelegate(imageDelegate)
        delegatesManager.addDelegate(textDelegate)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}