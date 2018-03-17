package com.example.distribution.p007

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.goods_list.*

/**
 * Created by Z50 on 2018-03-10.
 */
class GoodsList_Fr : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
//        Toast.makeText(this.context,"onCreateView",Toast.LENGTH_SHORT).show()
//        Log.v("lifeCycle","onCreateView")

        return inflater!!.inflate(R.layout.goods_list,container,false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        //--------------------add image resource goods for test---------------------

        val list = ArrayList<String>()
        for(i in 0..40)
            list.add("")
        gridViewGoods.adapter = GoodsAdapter(activity,0, list)
    }

//        @RequiresApi(Build.VERSION_CODES.M)
//    override fun onStop() {
//        super.onStop()
//        Toast.makeText(context,"stop",Toast.LENGTH_SHORT).show()
//        Log.v("lifeCycle","stop")
//    }

//    @RequiresApi(Build.VERSION_CODES.M)
//    override fun onPause() {
//        super.onPause()
//        Toast.makeText(context,"onPause",Toast.LENGTH_SHORT).show()
//        Log.v("lifeCycle","onPause")
//    }
//
//    @RequiresApi(Build.VERSION_CODES.M)
//    override fun onDestroyView() {
//        super.onDestroyView()
//
//        Toast.makeText(this.context,"onDestroyView",Toast.LENGTH_SHORT).show()
//        Log.v("lifeCycle","onDestroyView")
//    }
//    @RequiresApi(Build.VERSION_CODES.M)
//    override fun onDestroy() {
//        super.onDestroy()
//        Toast.makeText(this.context,"onDestroy",Toast.LENGTH_SHORT).show()
//        Log.v("lifeCycle","onDestroy")
//    }
}
