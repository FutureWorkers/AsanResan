package com.example.distribution.p007

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.company_list_item.view.*

/**
 * Created by T2Aq on 2018-06-02.
 */
class CompanyListAdapter(val companies: ArrayList<CompanyDetail_Obj>) : RecyclerView.Adapter<CompanyListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int)
            = ViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.company_list_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(companies[position])

    override fun getItemCount() = companies.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: CompanyDetail_Obj) = with(itemView) {
            companyName.text = item.companyName
            setOnClickListener {
                val companyFragment = CompanyProfile_Fr()
                val bundle = Bundle()
                bundle.putSerializable("company", item)
                val manager = (context as Activity).fragmentManager
                companyFragment.arguments = bundle
                manager.beginTransaction()
                        .replace(R.id.fragment_container, companyFragment).commit()
            }

        }


    }
}