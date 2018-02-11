package duongtung.com.mymvvm.base

import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import duongtung.com.mymvvm.base.Utils.Constanse.Companion.EXTRA_ARGS


/**
 * Created by duong.thanh.tung on 08/12/2017.
 */

abstract class BaseActivity<VB : ViewDataBinding, V : IView, out P : BaseViewModel<V>> : AppCompatActivity() {

    /**
     *
     * @return layout id : R.layout.<id>
     *
     **/
    abstract fun getLayoutId(): Int

    /**
     *
     *@init Presenter
     *
     **/
    protected abstract fun initPresenter(): P

    /**
     * set variable data
     * **/
    open fun binding() {
    }

    protected val presenter: P by lazy { initPresenter() }

    protected lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        presenter.attachView(this as V)
        binding()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    /**
     * add fragment in backstack
     * **/
    fun addFragment(id: Int, fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction().add(id, fragment, tag).commit()
    }

    fun replaceFragment(id: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(id, fragment).commit()
    }

    fun replaceFragment(id: Int, fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction().replace(id, fragment, tag).commit()
    }

    /**
     * replace fragment and add to backstack
     * */
    fun replaceAndAdd(id: Int, fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction().replace(id, fragment, tag).addToBackStack(tag).commit()
    }

    fun replaceAndAdd(id: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(id, fragment).addToBackStack(null)
                .commit()
    }

    fun goTo(cls: Activity, bundle: Bundle?, parcel: Parcelable?) {
        intent = Intent(this, cls::class.java)
        if (bundle != null) intent.putExtra(EXTRA_ARGS, bundle)
        if (parcel != null) intent.putExtra(EXTRA_ARGS, parcel)
        startActivity(intent)

    }

    override fun onBackPressed() {
        if (supportFragmentManager.fragments.size > 1) {
            back()
        } else {
            finish()
        }
    }


    /**
     * pop fragment by tag
     * **/
    fun back(tag: String) {
        supportFragmentManager.popBackStack(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    private fun back() {
        supportFragmentManager.popBackStackImmediate()
        //  supportFragmentManager.fragments.removeAt(supportFragmentManager.fragments.size - 1)
    }
}
