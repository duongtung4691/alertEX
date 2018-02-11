package duongtung.com.mymvvm.base.fragment

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import duongtung.com.mymvvm.base.fragment.callback.ActivityCallBackFragment

/**
 * Created by FRAMGIA\tong.xuan.an on 13/12/2017.
 */
abstract class BaseFragment<V : ViewDataBinding,CB : ActivityCallBackFragment> : Fragment() {
    protected lateinit var binding: V

    protected abstract fun initCallBack(): CB

    val callBack : CB by lazy { initCallBack() }

    abstract fun getLayoutId(): Int

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return binding.root
    }

}