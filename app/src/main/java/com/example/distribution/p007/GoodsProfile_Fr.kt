package com.example.distribution.p007

import android.annotation.SuppressLint
import android.app.Fragment
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.action_bar.*
import kotlinx.android.synthetic.main.goods_profile.*

/**
* Created by T2Aq on 2018-03-19.
*/
class GoodsProfile_Fr : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.goods_profile,container,false)
    }

    @SuppressLint("WrongConstant")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        //--------------------init action bar----------------
        (activity as AppCompatActivity).setSupportActionBar(toolbar_goods_profile)
        val actionbar = (activity as AppCompatActivity).supportActionBar
        actionbar!!.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        actionbar.setCustomView(R.layout.action_bar)

        //--------------------init views----------------------
        var counter = 0
        plus_button.setOnClickListener{counter++
            show_count.text = counter.toString() +" بسته میخوام"
        }
        minus_button.setOnClickListener{if(counter>0){
            counter--
            show_count.text = counter.toString() +" بسته میخوام"
        }}

       // var text:String = countall_view.text.toString()
       // show_count.setOnClickListener{countall_view.text= (text.trim().toInt()+counter).toString()}
//         MainActivity().actionbar!!.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
//         var text:String = countall_view.text.toString()
//         show_count.setOnClickListener{countall_view.text= (text.trim().toInt()+counter).toString()}
        show_count.setOnClickListener {
            Log.v("why null?",countall_view.text.toString())
            var text = countall_view.text.toString()
            countall_view.text= (text.trim().toInt()+counter).toString()

        }
    }
}

