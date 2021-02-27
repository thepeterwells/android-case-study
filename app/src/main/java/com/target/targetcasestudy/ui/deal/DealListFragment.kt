package com.target.targetcasestudy.ui.deal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.target.targetcasestudy.R
import com.target.targetcasestudy.ui.deal.DealItemAdapter


class DealListFragment : Fragment(), IDealListView {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view =  inflater.inflate(R.layout.fragment_deal_list, container, false)

    view.findViewById<RecyclerView>(R.id.recycler_view).layoutManager = LinearLayoutManager(requireContext())
    view.findViewById<RecyclerView>(R.id.recycler_view).adapter = DealItemAdapter()

    return view
  }
}
