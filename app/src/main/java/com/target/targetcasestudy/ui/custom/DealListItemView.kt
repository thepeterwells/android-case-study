package com.target.targetcasestudy.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import com.target.targetcasestudy.data.Deal
import com.target.targetcasestudy.databinding.DealListItemViewBinding

class DealListItemView constructor(context: Context,
                                   attrs: AttributeSet? = null,
                                   defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr) {

    private var binding: DealListItemViewBinding

    init {
        if (attrs == null) {
            layoutParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }
        binding = DealListItemViewBinding.inflate(LayoutInflater.from(context), this, true)
    }

    fun setup(data: Deal) {
        binding.tvProductName.text = data.title
        binding.tvPrice.text = data.regularPrice?.displayString ?: "Unknown"
    }

}