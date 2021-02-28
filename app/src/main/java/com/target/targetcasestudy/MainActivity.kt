package com.target.targetcasestudy

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.target.targetcasestudy.ui.deal.DealListFragment
import com.target.targetcasestudy.ui.deal.detail.DealDetailFragment
import com.target.targetcasestudy.ui.payment.PaymentDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, DealListFragment())
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
          R.id.credit_card -> {
            PaymentDialogFragment().show(supportFragmentManager, "CreditCardValidation")
            true
          }
            else -> false
        }
    }

    fun toDealDetail(dealId: Int) {
        val detailFragment = DealDetailFragment(dealId)
        supportFragmentManager.beginTransaction()
            .add(R.id.container, detailFragment)
            .addToBackStack(detailFragment.tag)
            .commit()
    }
}
