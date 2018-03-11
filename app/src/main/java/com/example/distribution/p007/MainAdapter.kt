package com.example.distribution.p007

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.company_list_item.view.*

/**
 * Created by Z50 on 2018-02-18.
 */

class MainAdapter(context: Context, resource: Int, objects: List<CompanyDetail>) : ArrayAdapter<CompanyDetail>(context, 0, objects) {

    //------------------------make list view------------------------
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItemView = convertView

        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.company_list_item, parent, false)
        }

        val currentCompany = getItem(position)
        //-----------------------set item views------------------------

        listItemView!!.company_item.text = currentCompany.companyName

        return listItemView!!
    }
}
