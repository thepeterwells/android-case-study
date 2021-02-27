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
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class DealListFragment : Fragment(), IDealListView {

  @Inject lateinit var presenter: DealListPresenter

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_deal_list, container, false)
  }

  override fun onStart() {
    super.onStart()
    presenter.start(this)
  }

  override fun bindDealsData() {
    view?.findViewById<RecyclerView>(R.id.recycler_view)?.layoutManager = LinearLayoutManager(requireContext())
    view?.findViewById<RecyclerView>(R.id.recycler_view)?.adapter = DealItemAdapter()
  }
}
