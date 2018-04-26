package com.example.distribution.p007

import android.app.Fragment
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
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

//    @RequiresApi(Build.VERSION_CODES.M)
//    override fun onStop() {
//        super.onStop()
//        Toast.makeText(context,"stop",Toast.LENGTH_LONG).show()
//        Log.v("lifeCycle","stop")
//    }
//
//    @RequiresApi(Build.VERSION_CODES.M)
//    override fun onPause() {
//        super.onPause()
//        Toast.makeText(context,"onPause",Toast.LENGTH_LONG).show()
//        Log.v("lifeCycle","onPause")
//    }
//
//    @RequiresApi(Build.VERSION_CODES.M)
//    override fun onDestroyView() {
//        super.onDestroyView()
//
//        Toast.makeText(this.context,"onDestroyView",Toast.LENGTH_LONG).show()
//        Log.v("lifeCycle","onDestroyView")
//    }
//    @RequiresApi(Build.VERSION_CODES.M)
//    override fun onDestroy() {
//        super.onDestroy()
//        Toast.makeText(this.context,"onDestroy",Toast.LENGTH_LONG).show()
//        Log.v("lifeCycle","onDestroy")
//    }
}