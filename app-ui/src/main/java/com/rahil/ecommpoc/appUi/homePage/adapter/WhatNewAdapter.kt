package com.rahil.ecommpoc.appUi.homePage.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rahil.ecommpoc.appUi.utils.getResourceIdFrom
import com.rahil.ecommpoc.appUi.base.RecyclerAdapter
import com.rahil.ecommpoc.appUi.base.RecyclerHolder
import com.rahil.ecommpoc.domain.model.homepage.NewServiceModel
import com.rahil.ecommpocUi.R
import kotlinx.android.synthetic.main.item_what_is_new.view.*
import kotlin.math.roundToInt

class WhatNewAdapter(view: RecyclerView) : RecyclerAdapter<NewServiceModel>(view) {
    var onItemClickListener: ((NewServiceModel) -> Unit)? = null
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) = object :
        RecyclerHolder<NewServiceModel>(p0, R.layout.item_what_is_new) {

        init {
            itemView.setOnClickListener {
                onItemClickListener?.invoke(item!!)
            }
        }

        override fun bind(item: NewServiceModel) {
            super.bind(item)
            itemView.run {
                val imgWidth = context.resources.displayMetrics.widthPixels
                tv_item_title.text = item.title
                tv_item_description.text = item.description
                iv_item.setImageResource(context.getResourceIdFrom(item.image))
                cv_item_what_new.layoutParams.width = ((0.7*imgWidth).roundToInt())
            }
        }
    }

}