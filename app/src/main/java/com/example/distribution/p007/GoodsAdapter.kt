package com.example.distribution.p007

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.goods_list_item.view.*
import java.io.File


/**
* Created by T2Aq on 2018-03-10.
*/
class GoodsAdapter(context: Context?, resource: Int, objects: List<Goods_obj>?) : ArrayAdapter<Goods_obj>(context, resource, objects) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var gridListView = convertView
        if(gridListView == null){
            gridListView = LayoutInflater.from(context).inflate(R.layout.goods_list_item,parent,false)
        }
        var currentGoods = getItem(position)

        //-----------------------init views------------------------

        gridListView!!.goodsName.text = currentGoods.name
        gridListView.goods_price.text = currentGoods.price.toString()
        var imageAddress = ""
        if (imageAddress != null) {
            val file = File(imageAddress)
            if (file.exists()) {
                val myBitmap = BitmapFactory.decodeFile(imageAddress)
               // gridListView!!.goodsImage.setPadding(16, 16, 16, 16)
                gridListView!!.goodsImage.setImageBitmap(myBitmap)
            }
        } else {
            gridListView!!.goodsImage.setImageResource(R.mipmap.ic_launcher)
        }
        //ToDo gridListView!!.goodsImage.setOnClickListener {  }
        return gridListView!!
    }

}