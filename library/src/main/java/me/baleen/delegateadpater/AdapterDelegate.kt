package me.baleen.delegateadpater

import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.ViewGroup

/**
 * Created by baleen37 on 2/08/2017.
 */

interface AdapterDelegate<T> {
    fun isViewType(items: T, position: Int): Boolean

    fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder

    fun onBindViewHolder(holder: ViewHolder, items: T, position: Int)
}
