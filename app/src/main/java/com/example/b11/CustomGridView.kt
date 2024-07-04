package com.example.b11

import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomGridView(
    val activity: MainActivity,
    val list: List<OurData>
):ArrayAdapter<OurData>(activity, R.layout.layout_item){
    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val context = activity.layoutInflater
        //trung gian
        val rowView= context.inflate(R.layout.layout_item, parent, false)

        //tạo biến kết nối giữa csgr và activity_mail.xml
        val csimg = rowView.findViewById<ImageView>(R.id.imgFilm)
        val csTitle = rowView.findViewById<TextView>(R.id.txtTitle)

        //tạo biến kết nối giữa csgr và OurData
        csimg.setImageResource(list[position].img)
        csTitle.text= list[position].title




        return rowView
    }
}