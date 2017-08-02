package me.baleen.delegateadpater

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.ViewGroup
import java.lang.NullPointerException


/**
 * Created by baleen37 on 2/08/2017.
 */
class DelegateAdapterManager<T> {

    var delegates = SparseArrayCompat<AdapterDelegate<T>>()

    fun addDelegate(adapterDelegate: AdapterDelegate<T>) {
        val viewType = delegates.size()

        delegates.append(viewType, adapterDelegate)
    }

    fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val delegate = getDelegateForViewType(viewType) ?:
                throw NullPointerException("getDelegateForViewType($viewType) is null")

        return delegate.onCreateViewHolder(parent, viewType)
    }

    fun onBindViewHolder(viewHolder: ViewHolder?, items: T, position: Int) {
        viewHolder?.let {
            val delegate = getDelegateForViewType(viewHolder.itemViewType) ?:
                    throw NullPointerException("getDelegateForViewType(${viewHolder.itemViewType}) is null")

            delegate.onBindViewHolder(viewHolder, items, position)
        }
    }

    private fun getDelegateForViewType(viewType: Int): AdapterDelegate<T>? {
        return delegates.get(viewType)
    }

    fun getItemViewType(items: T, position: Int): Int {
        if (items == null) {
            throw NullPointerException("Items data source is null!")
        }

        val delegatesCount = delegates.size()
        for (i in 0..delegatesCount - 1) {
            val delegate = delegates.valueAt(i)
            if (delegate.isForViewType(items, position)) {
                return delegates.keyAt(i)
            }
        }

        throw NullPointerException(
                "No AdapterDelegate added that matches position=$position in data source")
    }
}
