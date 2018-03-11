package com.example.distribution.p007

import android.content.Intent
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_company.*

class CompanyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company)
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
            drawer_layout!!.closeDrawers()
            true
        }
        //--------------------------------views---------------------------------
        val currentCompany = intent.getSerializableExtra("company") as CompanyDetail
        val companyName = findViewById<View>(R.id.companyName) as TextView
        companyName.text = currentCompany.companyName
        basketButton.setOnClickListener {
            val goodsActivityIntent = Intent(this@CompanyActivity,GoodsActivity::class.java)
            startActivity(goodsActivityIntent)
        }
    }

    //--------------------------on ic_menu click listener for navDrawer----------------------

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
