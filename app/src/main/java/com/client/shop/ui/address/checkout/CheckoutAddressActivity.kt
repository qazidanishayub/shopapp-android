package com.client.shop.ui.address.checkout

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.client.shop.ShopApplication
import com.client.shop.ui.address.base.BaseAddressActivity
import com.client.shop.ui.address.base.contract.AddressPresenter
import com.client.shop.ui.address.base.contract.AddressView
import com.client.shop.ui.address.checkout.di.CheckoutAddressModule
import com.client.shop.getaway.entity.Address
import com.shopify.constant.Extra

class CheckoutAddressActivity : BaseAddressActivity<AddressView, AddressPresenter<AddressView>>() {

    companion object {

        private const val ADDRESS = "address"
        private const val IS_SELECTED_ADDRESS = "is_selected_address"

        fun getStartIntent(
            context: Context,
            address: Address? = null,
            isSelectedAddress: Boolean = false
        ): Intent {
            val intent = Intent(context, CheckoutAddressActivity::class.java)
            intent.putExtra(ADDRESS, address)
            intent.putExtra(IS_SELECTED_ADDRESS, isSelectedAddress)
            return intent
        }
    }

    //INIT

    override fun inject() {
        ShopApplication.appComponent.attachCheckoutAddressComponent().inject(this)
    }

    //LCE

    override fun addressChanged(address: Address) {
        val result = Intent()
        result.putExtra(Extra.ADDRESS, address)
        result.putExtra(Extra.IS_SELECTED_ADDRESS,
            intent.getBooleanExtra(IS_SELECTED_ADDRESS, false))
        setResult(Activity.RESULT_OK, result)
        finish()
    }
}