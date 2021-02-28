package com.target.targetcasestudy.ui.deal

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.target.targetcasestudy.data.Deal
import com.target.targetcasestudy.ui.custom.DealListItemView

class DealItemAdapter : RecyclerView.Adapter<DealItemViewHolder>() {

  private var dataItems = ArrayList<Deal>()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealItemViewHolder {
    return DealItemViewHolder(DealListItemView(parent.context))
  }

  override fun getItemCount(): Int = dataItems.size

  override fun onBindViewHolder(viewHolder: DealItemViewHolder, position: Int) {
    (viewHolder.itemView as DealListItemView).setup(dataItems[position])
  }

  fun setItems(data: List<Deal>) {
    dataItems.clear()
    dataItems.addAll(data)
    notifyDataSetChanged()
  }
}

class DealItemViewHolder(itemView: DealListItemView) : RecyclerView.ViewHolder(itemView)