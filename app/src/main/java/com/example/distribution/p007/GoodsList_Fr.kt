package com.example.distribution.p007

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.goods_list.*

/**
* Created by T2Aq on 2018-03-10.
*/
class GoodsList_Fr : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
//        Toast.makeText(this.context,"onCreateView",Toast.LENGTH_SHORT).show()
//        Log.v("lifeCycle","onCreateView")

        return inflater!!.inflate(R.layout.goods_list,container,false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        //--------------------add image resource goods for test---------------------

        var good:Goods_obj
        val list = ArrayList<Goods_obj>()
        for(i in 0..40){
            good = Goods_obj()
            good.name = "کالا "+i.toString()
            good.price = i+1000
            good.description = "توضیح کالا "+i.toString()
            list.add(good)
        }
        gridViewGoods.adapter = GoodsAdapter(activity,0, list)
        //-----------------------on itemClick listener------------------------------
        gridViewGoods.setOnItemClickListener { parent, view, position, id ->
        val goodsProfile = GoodsProfile_Fr()
            fragmentManager.beginTransaction().replace(R.id.fragment_container,goodsProfile).addToBackStack("GoodsList").commit()
        }
    }




}
