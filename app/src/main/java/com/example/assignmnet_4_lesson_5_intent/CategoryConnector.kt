package com.example.assignmnet_4_lesson_5_intent

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CategoryConnector (context: Context, productCategories: ArrayList<ProductCategory>): BaseAdapter() {

    var context = context
    var productCategory = productCategories

    override fun getCount(): Int {
        return productCategory.size
    }

    override fun getItem(p0: Int): Any {
        TODO("Not")
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(postion: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        var viewHolder: ViewHolder

        if(view == null){
            val categoryInflator = (context as Activity).layoutInflater

            view = categoryInflator.inflate(R.layout.activity_grid_view_items, parent, false)

            viewHolder = ViewHolder()

            viewHolder.categoryImage = view!!.findViewById<ImageView>(R.id.category_image) as ImageView
            viewHolder.categoryText = view!!.findViewById<TextView>(R.id.category_name) as TextView

            view.setTag(viewHolder)
        }else {
            viewHolder = view.getTag() as ViewHolder
        }

        viewHolder.categoryImage!!.setImageResource(productCategory.get(postion).image)

        viewHolder.categoryText!!.setText(productCategory.get(postion).category)

        return view
    }

    class ViewHolder {
        var categoryImage: ImageView? = null
        var categoryText: TextView? = null
    }

}