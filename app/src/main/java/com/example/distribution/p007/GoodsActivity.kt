package com.example.distribution.p007

import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_goods.*

/**
 * Created by Z50 on 2018-03-10.
 */
class GoodsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goods)

        //--------------------toolbar as action bar for navDrawer----------------
        setSupportActionBar(toolbar)
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu)
        //-------------------Add click event for navDrawer-----------------------

        nav_view.setNavigationItemSelectedListener { menuItem ->
            // set item as selected to persist highlight
            menuItem.isChecked = true
            // close drawer when item is tapped
            drawer_layout.closeDrawers()
            true
        }
        //--------------------add image resource goods for test---------------------

        val list = ArrayList<String>()
        for(i in 0..40)
            list.add("")
        gridViewGoods.adapter = GoodsAdapter(this,0, list)
    }

    //--------------------------on ic_menu click listener  for navDrawer----------------------
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                drawer_layout!!.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
