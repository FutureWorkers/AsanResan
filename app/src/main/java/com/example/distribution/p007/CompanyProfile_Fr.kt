package com.example.distribution.p007

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.company_profile.*

class CompanyProfile_Fr : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.company_profile,container,false)

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        //--------------------------------views---------------------------------
        val currentCompany =  arguments.getSerializable("company") as CompanyDetail_Obj
        companyName.text = currentCompany.companyName
        basketButton.setOnClickListener {
            val goodsList = GoodsList_Fr()
            fragmentManager.beginTransaction().replace(R.id.fragment_container,goodsList).commit()
        }
    }
}
