package id.app.alzeimar.weathernow.Fragments


import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Point
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.ahmadrosid.svgloader.SvgLoader
import com.squareup.picasso.Picasso
import id.app.alzeimar.weathernow.API.ApiInterface
import id.app.alzeimar.weathernow.CuacaVP.CuacaPresenter
import id.app.alzeimar.weathernow.CuacaVP.CuacaView
import id.app.alzeimar.weathernow.FragmentVP.BaseFragment
import id.app.alzeimar.weathernow.HomeVP.HomePresenter
import id.app.alzeimar.weathernow.HomeVP.HomeVIew

import id.app.alzeimar.weathernow.R
import kotlinx.android.synthetic.main.fragment_home.view.*
import id.app.alzeimar.weathernow.MainActivity
import id.app.alzeimar.weathernow.Response.Data
import id.app.alzeimar.weathernow.TanamanVP.TanamanView
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.custom_toolbar.view.*
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*
import java.util.jar.Manifest


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : BaseFragment(),HomeVIew.View,CuacaView.View {
    override fun setRequest(position: Int) {
        api.getCuaca("Bearer "+"eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjA2NWZlN2FkZTk5NWFjYmE5NDFmMGM0YjkzYzE1MTA4ZTdkMTliYjU5ODQzY2E4YmEyYmYwYzc1ODJjMDg2NjIzYTg2MDU2NGUyMTc4YmE3In0.eyJhdWQiOiI4IiwianRpIjoiMDY1ZmU3YWRlOTk1YWNiYTk0MWYwYzRiOTNjMTUxMDhlN2QxOWJiNTk4NDNjYThiYTJiZjBjNzU4MmMwODY2MjNhODYwNTY0ZTIxNzhiYTciLCJpYXQiOjE1NDgyNDI3OTYsIm5iZiI6MTU0ODI0Mjc5NiwiZXhwIjoxNTc5Nzc4Nzk2LCJzdWIiOiIxIiwic2NvcGVzIjpbXX0.WT0IholfO1mzhBSeIPDbPGSkwChh2hSg8kit38opMwkm2mz4cZWN0qq6GPhxQMbEuSJ07OhMWgyM_NmozczIXsNaIqXdRWP1_DP-hRd1S7s_Pl3tely7rOP4su25-5Mu2AhlPK2HT72ZSDElWKs5AawMcDgxpND19Ec1mV78N7ia7MZOQaQeo-7i37gLJPLQ2uoTHqA6NqNPgEDaV_85keD0E1agw7mhyXrUoWIYa7hjBjMbCh6SuqHLL1CMRzUEFwDacVHCJSOWfzAKcKg9VZQxN2Qt57dA1uKcocH9B5x2rIKyJSKN2M-SRNyEYoVhPnspuvagbASAVY_oM_wPKmIvvUjWQKHHmQyF_Sgd1M30c2MnlvOZPU-_3JLENb9OC-cy9TocYvZD314wQoZM5BZ4j3iz6jBnHb0rXxKqTk6wGz_9jRH_IWyrEDkycyLtq8tYsnDL0cgW2snZ31ELSle2WbxsAOv2ba7FlNwe0j-uP03MDumgTjQ9C0raYEqlc6OTEMXmJvggtqIXGBtHdeuHhOcIe0rCqC7qI-wE5Ooj0KwrlkZmXjFuKOXX5pJhr_i1KKJ5Pr9SsQLzF0gxocEgvug0_MuzGOKPJMmkcLZULxcKvo0GpHO3L1K2q9JuQm4HSh4Jx4Suy1Bi657WW3ILuS8Boe86bxF3hG2N1Hg")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({ result ->
                    cuacaPresenter.getData(result.data!!, position)
                    //Toast.makeText(context,""+result.data.rows!![0].day!!.morning!!.time,Toast.LENGTH_LONG).show()
                },
                        {
                        }
                )
    }




    @SuppressLint("MissingPermission")
    override fun setLocation(txview: TextView) {
        if(ContextCompat.checkSelfPermission(activity!!,android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            var lm:LocationManager = activity!!.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            var loc:Location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            var log:Double = loc.longitude
            var lati:Double = loc.latitude

            var geocoder:Geocoder = Geocoder(activity!!, Locale.getDefault())
            var addres:List<Address> = geocoder.getFromLocation(lati,log,1)
            var cityName = addres.get(0).getAddressLine(0)
            txview.text = cityName
        }


    }



    override fun setData(data: Data, position: Int) {
        var imageBG:String = ""
        var imageAwan:String = ""
        var min:String = ""
        var max:String = ""
        var kecepatan:String = ""
        var kelembapan:String =""
        var suhu:Int =0
        var kondisi:String = ""

        var url:String = "http://128.199.155.45/Assets/cerah-berawan.svg"
        var right:Calendar = Calendar.getInstance()
        var time:Int = right.get(Calendar.HOUR_OF_DAY)
        //Toast.makeText(context,""+time,Toast.LENGTH_LONG).show()
        when(time){
            in 0..6 ->{
                imageBG = data.rows!![position].day!!.dawn!!.background!!
                imageAwan= data.rows!![position].day!!.dawn!!.image!!
                min= data.rows!![position].temperatureMin!!
                max= data.rows!![position].temperatureMax!!
                kelembapan= data.rows!![position].humidityMin + "% - "+data.rows!![position].humidityMax+"%"
                kondisi = data.rows!![position].day!!.dawn!!.weather!!
                val minInt = min.toIntOrNull()
                val maxInt = max.toIntOrNull()
                suhu = (maxInt!! + minInt!!) / 2

            }
            in 7..11 ->{
                imageBG = data.rows!![position].day!!.morning!!.background!!
                imageAwan= data.rows!![position].day!!.morning!!.image!!
                min= data.rows!![position].temperatureMin!!
                max= data.rows!![position].temperatureMax!!
                kelembapan= data.rows!![position].humidityMin + "% - "+data.rows!![position].humidityMax+"%"
                kondisi = data.rows!![position].day!!.morning!!.weather!!
                val minInt = min.toIntOrNull()
                val maxInt = max.toIntOrNull()
                suhu = (maxInt!! + minInt!!) / 2
            }
            in 12..18->{
                imageBG = data.rows!![position].day!!.daylight!!.background!!
                imageAwan= data.rows!![position].day!!.daylight!!.image!!
                min= data.rows!![position].temperatureMin!!
                max= data.rows!![position].temperatureMax!!
                kelembapan= data.rows!![position].humidityMin + "% - "+data.rows!![position].humidityMax+"%"
                kondisi = data.rows!![position].day!!.daylight!!.weather!!
                val minInt = min.toIntOrNull()
                val maxInt = max.toIntOrNull()
                suhu = (maxInt!! + minInt!!) /2
            }
            else->{
                imageBG = data.rows!![position].day!!.night!!.background!!
                imageAwan= data.rows!![position].day!!.night!!.image!!
                min= data.rows!![position].temperatureMin!!
                max= data.rows!![position].temperatureMax!!
                kelembapan= data.rows!![position].humidityMin + "% - "+data.rows!![position].humidityMax+"%"
                kondisi = data.rows!![position].day!!.night!!.weather!!
                val minInt = min.toIntOrNull()
                val maxInt = max.toIntOrNull()
                suhu = (maxInt!! + minInt!!) /2
            }
        }
        if(time >= 0 && time < 6){

        }
        if(time >= 6 && time < 11 ){

        }
        if(time >= 11 && time < 18){

        }
        if(time >= 18 && time <0){

        }
        val display: Display =  activity!!.windowManager.defaultDisplay
        val point: Point = Point()
        display.getSize(point)
        Picasso.get().load(imageBG).resize(point.x,point.y).centerCrop().into(view!!.imageBG)
        SvgLoader.pluck()
                .with(activity)
                .load(imageAwan,view!!.imageAwan)

        view!!.weather.text = kondisi
        view!!.weatherMin.text = min+"\u2103"
        view!!.weatherMax.text = max+"\u2103"
        view!!.kelembapan.text = kelembapan
        view!!.suhu.text = ""+suhu
        //Toast.makeText(context,kelembapan,Toast.LENGTH_LONG).show()

    }

    override fun setImage(resourece: Int, image: ImageView) {
        val display: Display =  activity!!.windowManager.defaultDisplay
        val point: Point = Point()
        display.getSize(point)
        Picasso.get().load(resourece).resize(point.x,point.y).centerCrop().into(image)
//        var bmp: Bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources,R.drawable.bg_home),point.x,point.y,true)
//        image.setImageBitmap(bmp)
    }

    override fun getLayout(): Int {
        return R.layout.fragment_home
    }

    val api:ApiInterface by lazy {
        ApiInterface.create()
    }

    private lateinit var presenter: HomePresenter
    private lateinit var cuacaPresenter: CuacaPresenter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        (activity as MainActivity).toolbar = view.toolbar_custom
        presenter = HomePresenter(this)
        cuacaPresenter = CuacaPresenter(this)
        cuacaPresenter.getRequest(0)
//        presenter.addImage(R.drawable.bg_berawan,view.imageBG)
        cuacaPresenter.getLocation(view.location)
        view.now.setOnClickListener {
            view.now.setBackgroundColor(ContextCompat.getColor(context!!,R.color.click))
            view.bsk.setBackgroundColor(Color.TRANSPARENT)
            view.lusa.setBackgroundColor(Color.TRANSPARENT)
            cuacaPresenter.getRequest(0)
        }
        view.bsk.setOnClickListener {
            view.bsk.setBackgroundColor(ContextCompat.getColor(context!!,R.color.click))
            view.now.setBackgroundColor(Color.TRANSPARENT)
            view.lusa.setBackgroundColor(Color.TRANSPARENT)
            cuacaPresenter.getRequest(1)
        }
        view.lusa.setOnClickListener {
            view.bsk.setBackgroundColor(Color.TRANSPARENT)
            view.now.setBackgroundColor(Color.TRANSPARENT)
            view.lusa.setBackgroundColor(ContextCompat.getColor(context!!,R.color.click))
            cuacaPresenter.getRequest(2)
        }

        return view
    }


}
