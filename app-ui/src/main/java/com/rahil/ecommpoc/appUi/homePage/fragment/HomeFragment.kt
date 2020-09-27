package com.rahil.ecommpoc.appUi.homePage.fragment

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import com.rahil.ecommpoc.appUi.homePage.adapter.FeatureAdapter
import com.rahil.ecommpoc.appUi.homePage.adapter.WhatNewAdapter
import com.rahil.ecommpoc.appUi.pickLocation.DialogPickLocation
import com.rahil.ecommpoc.appUi.utils.hide
import com.rahil.ecommpoc.appUi.utils.show
import com.rahil.ecommpoc.appUi.widget.dialog.LoadingDialog
import com.rahil.ecommpoc.appUi.widget.empty.EmptyListener
import com.rahil.ecommpoc.appUi.widget.error.ErrorListener
import com.rahil.ecommpoc.domain.model.homepage.CategoryModel
import com.rahil.ecommpoc.domain.model.homepage.HomePageModel
import com.rahil.ecommpoc.presentation.homePage.HomePageContract
import com.rahil.ecommpocUi.R
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : Fragment(), HomePageContract.HomePageView {
    private val limitedFeatureCount = 6
    private val listFeature = mutableListOf<CategoryModel>()
    private var featureCategoryAdapter: FeatureAdapter? = null
    private var featuredAdapter: FeatureAdapter? = null
    private var whatNewAdapter: WhatNewAdapter? = null
    private var loading : LoadingDialog? = null

    @Inject
    lateinit var homePagePresenter: HomePageContract.HomePagePresenter

    override fun onAttach(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            AndroidSupportInjection.inject(this)
        }
        super.onAttach(context)
    }

    override fun onAttach(activity: Activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            AndroidSupportInjection.inject(this)
        }
        super.onAttach(activity)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        tv_hello.text = HtmlCompat.fromHtml(
            getString(R.string.lbl_good_afternoon),
            HtmlCompat.FROM_HTML_MODE_LEGACY
        )
        setUpFeaturedList()
        setUpFeaturesList()
        setUpWhatNewList()
        setupViewListeners()
        homePagePresenter.start()

        iv_close_expanded_feature.setOnClickListener {
            if (iv_close_expanded_feature.rotation == 180f) {
                featureCategoryAdapter?.items = getFeatureList(limitedFeatureCount)
                iv_close_expanded_feature.rotation = 0f
                featureCategoryAdapter?.notifyDataSetChanged()
            } else {
                featureCategoryAdapter?.items = listFeature
                iv_close_expanded_feature.rotation = 180f
                featureCategoryAdapter?.notifyDataSetChanged()
            }
        }

        tv_my_location.setOnClickListener {
            DialogPickLocation(requireContext()) {
                tv_my_location.text = it
            }.show()
        }
    }

    private fun setupViewListeners() {
        view_empty.emptyListener = emptyListener
        view_error.errorListener = errorListener
    }


    private fun setUpFeaturesList() {
        featureCategoryAdapter = FeatureAdapter(rv_features)
        featureCategoryAdapter?.onItemClickListener = {
            toast("click on ${it.name}")
        }
    }

    private fun getFeatureList(count: Int): MutableList<CategoryModel> {
        val list = ArrayList(listFeature)
        return if (list.size > count) {
            list.subList(0, count)
        } else {
            list
        }
    }

    private fun setUpFeaturedList() {
        featuredAdapter = FeatureAdapter(rv_featured)
        featuredAdapter?.onItemClickListener = {
            toast("click on ${it.name}")
        }
    }

    private fun toast(text: String) {
        Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
    }

    private fun setUpWhatNewList() {
        whatNewAdapter = WhatNewAdapter(rv_what_new)
        whatNewAdapter?.onItemClickListener = {
            toast("click on ${it.title}")
        }
    }

    override fun showProgress() {
        loading = LoadingDialog()
        loading?.show(childFragmentManager, null)
    }

    override fun hideProgress() {
        if(loading != null){
            loading?.dismiss()
            loading = null
        }
    }

    override fun showHomeData(homePageData: HomePageModel) {
        listFeature.clear()
        listFeature.addAll(homePageData.categories)
        featureCategoryAdapter?.items = getFeatureList(limitedFeatureCount)
        featuredAdapter?.items = homePageData.featured.toMutableList()
        whatNewAdapter?.items = homePageData.what_new.toMutableList()
    }

    override fun showErrorState() {
        view_error.show()
    }

    override fun hideErrorState() {
        view_error.hide()
    }

    override fun showEmptyState() {
        view_empty.show()
    }

    override fun hideEmptyState() {
        view_empty.hide()
    }

    override fun setPresenter(presenter: HomePageContract.HomePagePresenter) {
        homePagePresenter = presenter
    }

    private val emptyListener = object : EmptyListener {
        override fun onCheckAgainClicked() {
            homePagePresenter.start()
        }
    }

    private val errorListener = object : ErrorListener {
        override fun onTryAgainClicked() {
            homePagePresenter.start()
        }
    }
}