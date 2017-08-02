package me.baleen.delegateadpater

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.ViewGroup

/**
 * Created by baleen37 on 2/08/2017.
 */
abstract class AbsDelegateAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val delegatesManager = DelegateAdapterManager<T>()
    abstract var items: T


    override fun onBindViewHolder(viewHolder: ViewHolder?, position: Int) {
        delegatesManager.onBindViewHolder(viewHolder, items, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return delegatesManager.onCreateViewHolder(parent, viewType)
    }

    override fun getItemViewType(position: Int): Int {
        return delegatesManager.getItemViewType(items, position)
    }
}
