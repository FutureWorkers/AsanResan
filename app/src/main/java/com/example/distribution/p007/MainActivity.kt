package com.example.distribution.p007

import android.content.Intent
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val companies = ArrayList<CompanyDetail>()


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
        //--------------------add companies for test---------------------

        for (i in 0..15) {
            var company= CompanyDetail()
            company.companyName = "شرکت" + i
            company.companyAddress = "آدرس شرکت" + i
            company.companyId = i
            companies.add(company)

            Log.v("companies", companies[i].companyName)
        }

        val adapter = MainAdapter(this, 0, companies)
        list_view.adapter = adapter
        //----------------------- company item selection --------------
        list_view.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(this@MainActivity, CompanyActivity::class.java)
            intent.putExtra("company", companies[position])
            startActivity(intent)
        }

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
