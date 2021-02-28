package com.target.targetcasestudy.ui.deal.detail

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

import com.target.targetcasestudy.R
import com.target.targetcasestudy.data.Deal
import com.target.targetcasestudy.databinding.FragmentDealDetailBinding
import com.target.targetcasestudy.utils.setVisible
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class DealDetailFragment(private val dealId: Int) : Fragment(), IDealDetailView {

  @Inject lateinit var presenter: DealDetailPresenter
  private var _binding: FragmentDealDetailBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    _binding = FragmentDealDetailBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onStart() {
    super.onStart()
    presenter.start(this, dealId)
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

  override fun toggleProgressVisibility(visible: Boolean) {
    binding.scrollView.setVisible(!visible)
    binding.pbLoading.setVisible(visible)
  }

  override fun bindDealData(deal: Deal) {
    Glide.with(this).load(deal.imageUrl).into(binding.ivProduct)
    binding.tvSalePrice.text = deal.salePrice?.displayString ?: deal.regularPrice.displayString
    binding.tvRegularPrice.setVisible(deal.salePrice != null)
    binding.tvRegularPrice.text = deal.regularPrice.displayString
    binding.tvProductName.text = deal.title
    binding.tvProductDescription.text = deal.description
  }
}
