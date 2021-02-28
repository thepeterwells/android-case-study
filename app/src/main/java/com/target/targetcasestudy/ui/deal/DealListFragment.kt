package com.target.targetcasestudy.ui.deal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.target.targetcasestudy.R
import com.target.targetcasestudy.databinding.FragmentDealListBinding
import com.target.targetcasestudy.ui.deal.DealItemAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class DealListFragment : Fragment(), IDealListView {

  @Inject lateinit var presenter: DealListPresenter
  private var _binding: FragmentDealListBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    _binding = FragmentDealListBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onStart() {
    super.onStart()
    presenter.start(this)
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  override fun bindDealsData() {
    binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    binding.recyclerView.adapter = DealItemAdapter()
    binding.recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
  }
}
