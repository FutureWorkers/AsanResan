package com.example.distribution.p007

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.action_bar.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    val TAG = "MainFragment"
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.layoutDirection = View.LAYOUT_DIRECTION_RTL

        //--------------------init action bar----------------
        setSupportActionBar(toolbar)
        val actionbar = supportActionBar
        actionbar!!.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        actionbar.setCustomView(R.layout.action_bar)
        //--------------------On item click for actionBar-----------------------
        icMenuButton.setOnClickListener {  drawer_layout!!.openDrawer(GravityCompat.START) }
        //-------------------Add click event for navDrawer-----------------------
        nav_view.setNavigationItemSelectedListener { menuItem ->
            // set item as selected to persist highlight
            menuItem.isChecked = true
            // close drawer when item is tapped
            drawer_layout.closeDrawers()
            true
        }
        //---------------------main fragment----------------------------
        val companyListMain = CompanyListMain_Fr()
        fragmentManager.beginTransaction().add(R.id.fragment_container,companyListMain,TAG).commit()
        //----------------------------------------------------------------
          fun setCountall(text:String){

        }

    }
    //--------------------------on ic_menu click listener  for navDrawer----------------------
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//           R.id.icMenuButton -> {
//                drawer_layout!!.openDrawer(GravityCompat.START)
//                return true
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }

    override fun onBackPressed() {
        var myFragment = fragmentManager.findFragmentById(R.id.fragment_container)
        if (myFragment != null && (myFragment is CompanyListMain_Fr || myFragment is GoodsProfile_Fr) && myFragment.isVisible) {
            super.onBackPressed()
        }else{
            val companyListMain = CompanyListMain_Fr()
            fragmentManager.beginTransaction().add(R.id.fragment_toolbar_container,companyListMain).commit()
        }

    }


}
