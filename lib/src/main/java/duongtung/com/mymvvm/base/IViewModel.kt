package duongtung.com.mymvvm.base


/**
 * Created by duong.thanh.tung on 08/12/2017.
 */
interface IViewModel<V : IView> {
    fun getView(): V?

    fun attachView(view: V)

    fun detachView()
}