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
 * Created by Z50 on 2018-03-10.
 */
class GoodsAdapter(context: Context?, resource: Int, objects: List<String>?) : ArrayAdapter<String>(context, resource, objects) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var gridListView = convertView
        if(gridListView == null){
            gridListView = LayoutInflater.from(context).inflate(R.layout.goods_list_item,parent,false)
        }
        var currentImageAddress = getItem(position)

        //-----------------------set item views------------------------
        //gridListView!!.goodsImage.setImageDrawable(currentImage)
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
        return gridListView!!
    }

}