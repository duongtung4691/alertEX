package duongtung.com.mymvvm

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by FRAMGIA\tong.xuan.an on 25/12/2017.
 */
interface ApiService {
    @GET("android/jsonarray/")
    fun androidVersion(): Observable<List<Android>>
}