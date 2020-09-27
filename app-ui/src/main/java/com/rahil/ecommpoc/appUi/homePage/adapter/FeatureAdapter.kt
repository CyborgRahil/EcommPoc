package com.rahil.ecommpoc.appUi.homePage.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rahil.ecommpoc.appUi.utils.getResourceIdFrom
import com.rahil.ecommpoc.appUi.base.RecyclerAdapter
import com.rahil.ecommpoc.appUi.base.RecyclerHolder
import com.rahil.ecommpoc.domain.model.homepage.CategoryModel
import com.rahil.ecommpocUi.R
import kotlinx.android.synthetic.main.item_category.view.*

class FeatureAdapter(view: RecyclerView) : RecyclerAdapter<CategoryModel>(view) {
    var onItemClickListener: ((CategoryModel) -> Unit)? = null
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) = object :
        RecyclerHolder<CategoryModel>(p0, R.layout.item_category) {

        init {
            itemView.setOnClickListener {
                onItemClickListener?.invoke(item!!)
            }
        }

        override fun bind(item: CategoryModel) {
            super.bind(item)
            itemView.run {
                cv_item.text = item.name
                cv_item.background = context.getResourceIdFrom(item.image)
            }
        }
    }

}