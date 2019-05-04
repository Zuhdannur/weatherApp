package id.app.alzeimar.weathernow.API

import com.google.gson.Gson
import id.app.alzeimar.weathernow.Response.DataResponses
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ApiInterface {

    @GET("api/listCuacaBasedOnCity/501212")
    fun getCuaca(@Header("Authorization") token:String) : Observable<DataResponses>

    @GET("api/recommendTanaman")
    fun getTanaman(@Header("Authorization") token:String) : Observable<DataResponses>

    companion object {

            fun create():ApiInterface{
                var logging:HttpLoggingInterceptor = HttpLoggingInterceptor()
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                val client:OkHttpClient = OkHttpClient.Builder().addInterceptor(logging).build()

                var retrofit = Retrofit.Builder()
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(client)
                        .baseUrl("http://bdgweather.derazu.tech/")
                        .build()
                return retrofit.create(ApiInterface::class.java)
            }
    }
}