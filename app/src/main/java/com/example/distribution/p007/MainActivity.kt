package com.example.distribution.p007

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity() {


    val TAG = "MainFragment"
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.layoutDirection = View.LAYOUT_DIRECTION_RTL
        //---------------------main fragment----------------------------
        val companyListMain = CompanyListMain_Fr()
        fragmentManager.beginTransaction().add(R.id.fragment_container,companyListMain,TAG).commit()

    }

    override fun onBackPressed() {
        var myFragment = fragmentManager.findFragmentById(R.id.fragment_container)
        if (myFragment != null && (myFragment is CompanyListMain_Fr || myFragment is GoodsProfile_Fr) && myFragment.isVisible) {
            super.onBackPressed()
        }else{
            val companyListMain = CompanyListMain_Fr()
            fragmentManager.beginTransaction().add(R.id.fragment_container,companyListMain).commit()
        }

    }


}
