package com.target.targetcasestudy.ui.deal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.target.targetcasestudy.MainActivity

import com.target.targetcasestudy.R
import com.target.targetcasestudy.data.Deal
import com.target.targetcasestudy.databinding.FragmentDealListBinding
import com.target.targetcasestudy.ui.deal.DealItemAdapter
import com.target.targetcasestudy.utils.setVisible
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class DealListFragment : Fragment(), IDealListView {

    @Inject
    lateinit var presenter: DealListPresenter
    private lateinit var adapter: DealItemAdapter
    private var _binding: FragmentDealListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDealListBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.addItemDecoration(
          DividerItemDecoration(
            requireContext(),
            RecyclerView.VERTICAL
          )
        )
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        adapter = DealItemAdapter(presenter)
        binding.recyclerView.adapter = adapter
        presenter.start(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun bindDealsData(deals: List<Deal>) {
        adapter.setItems(deals)
    }

    override fun toDealDetail(dealId: Int) {
        (activity as MainActivity).toDealDetail(dealId)
    }

    override fun toggleProgressVisibility(visible: Boolean) {
        binding.recyclerView.setVisible(!visible)
        binding.pbLoading.setVisible(visible)
    }
}
