package com.duongtung.alerttool

import android.content.Context
import com.duongtung.alerttool.databinding.ActivityMainBinding
import duongtung.com.alerttool.MainView
import duongtung.com.alerttool.MainViewModel
import duongtung.com.mymvvm.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding, MainView, MainViewModel>(), MainView {
    override fun getContext(): Context = this

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initPresenter(): MainViewModel = MainViewModel()


}
