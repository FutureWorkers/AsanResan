package com.example.distribution.p007

import android.app.Fragment
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.daimajia.slider.library.Animations.DescriptionAnimation
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView
import kotlinx.android.synthetic.main.action_bar.*
import kotlinx.android.synthetic.main.company_list_main.*
import java.util.*


/**
* Created by T2Aq on 2018-03-13.
*/
class CompanyListMain_Fr : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.company_list_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        val companies = ArrayList<CompanyDetail_Obj>()
//init action bar------------------------------------
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        val actionbar =  (activity as AppCompatActivity).supportActionBar
        actionbar!!.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        actionbar.setCustomView(R.layout.action_bar)
//On item click for actionBar-------------------------------------------
        icMenuButton.setOnClickListener {  drawer_layout!!.openDrawer(GravityCompat.START) }
//Add click event for navDrawer------------------------------------------
        nav_view.setNavigationItemSelectedListener { menuItem ->
            // set item as selected to persist highlight
            menuItem.isChecked = true
            // close drawer when item is tapped
            drawer_layout.closeDrawers()
            true
        }
//slider-------------------------------------------------------

        val url_maps = HashMap<String, String>()
        url_maps.put("ketchup", "https://static.independent.co.uk/s3fs-public/styles/story_large/public/thumbnails/image/2012/05/27/21/Pg-27-ketchup.jpg")
        url_maps.put("milk", "https://static.standard.co.uk/s3fs-public/thumbnails/image/2017/07/19/15/shutterstock-568076731.jpg")
        url_maps.put("sandwiches", "https://static.standard.co.uk/s3fs-public/thumbnails/image/2017/07/19/15/shutterstock-506857147.jpg")
        url_maps.put("chocolate", "https://uploads-3scb1afwjgwax1popi.stackpathdns.com/products/2015/244441/images/121903_Chocolate-Spreads1.jpg")

        for (name in url_maps.keys){
            var textSliderView = TextSliderView(activity)
            textSliderView
                    .description(name)
                    .image(url_maps[name]).scaleType = BaseSliderView.ScaleType.Fit
                    //.setOnSliderClickListener(this)

            slider.addSlider(textSliderView)
        }
        slider.setPresetTransformer(SliderLayout.Transformer.Fade)
        slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)
        slider.setCustomAnimation(DescriptionAnimation())
        slider.setDuration(4000)

//fab button----------------------------------------------------
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
//add companies for test-----------------------------------------

        var companyName:String
        var companyAddress:String
        var companyId:Int
        for (i in 0..15) {
             companyName = "شرکت" + i
             companyAddress = "آدرس شرکت" + i
             companyId = i
            var company = CompanyDetail_Obj(companyName, companyAddress,companyId)
            companies.add(company)

            Log.v("companies", companies[i].companyName)
        }
//set adapter-------------------------------------------
        recyclerViewMain.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        val adapter = CompanyListAdapter(companies)
        recyclerViewMain.adapter = adapter

    }
}