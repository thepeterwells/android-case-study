package com.target.targetcasestudy.ui.deal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.target.targetcasestudy.R
import com.target.targetcasestudy.data.StaticData
import com.target.targetcasestudy.ui.custom.DealListItemView

class DealItemAdapter : RecyclerView.Adapter<DealItemViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealItemViewHolder {
    return DealItemViewHolder(DealListItemView(parent.context))
  }

  override fun getItemCount(): Int {
    return StaticData.deals.size
  }

  override fun onBindViewHolder(viewHolder: DealItemViewHolder, position: Int) {
    (viewHolder.itemView as DealListItemView).setup(StaticData.deals[position])
  }
}

class DealItemViewHolder(itemView: DealListItemView) : RecyclerView.ViewHolder(itemView) {

}