package com.example.distribution.p007

import android.app.Fragment
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import com.daimajia.slider.library.Animations.DescriptionAnimation
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView
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
        //----------------------toolbar-------------------------------
//        activity.setActionBar(toolbar_collapsed)
//        val actionbar = activity.actionBar
//        actionbar!!.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
//        actionbar.setCustomView(R.layout.action_bar)
        //---------------------slider----------------------------------

        val url_maps = HashMap<String, String>()
        url_maps.put("ketchup", "https://static.independent.co.uk/s3fs-public/styles/story_large/public/thumbnails/image/2012/05/27/21/Pg-27-ketchup.jpg")
        url_maps.put("milk", "https://static.standard.co.uk/s3fs-public/thumbnails/image/2017/07/19/15/shutterstock-568076731.jpg")
        url_maps.put("sandwiches", "https://static.standard.co.uk/s3fs-public/thumbnails/image/2017/07/19/15/shutterstock-506857147.jpg")
        url_maps.put("chocolate", "https://uploads-3scb1afwjgwax1popi.stackpathdns.com/products/2015/244441/images/121903_Chocolate-Spreads1.jpg")

        for (name in url_maps.keys){
            var textSliderView = TextSliderView(activity)
            textSliderView
                    .description(name)
                    .image(url_maps[name])
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    //.setOnSliderClickListener(this)

            slider.addSlider(textSliderView)
        }
        slider.setPresetTransformer(SliderLayout.Transformer.Fade)
        slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)
        slider.setCustomAnimation(DescriptionAnimation())
        slider.setDuration(4000)

        //--------------------fab button--------------------------------
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        //--------------------add companies for test---------------------

        for (i in 0..15) {
            var company = CompanyDetail_Obj()
            company.companyName = "شرکت" + i
            company.companyAddress = "آدرس شرکت" + i
            company.companyId = i
            companies.add(company)

            Log.v("companies", companies[i].companyName)
        }

        val adapter = MainAdapter(activity, 0, companies)
        list_view.adapter = adapter
        list_view.setNestedScrollingEnabled(true)
        //----------------------- company item selection --------------
        list_view.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val companyFragment = CompanyProfile_Fr()
            val bundle = Bundle()
            bundle.putSerializable("company", companies[position])
            companyFragment.arguments = bundle
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, companyFragment).commit()
        }


    }
}