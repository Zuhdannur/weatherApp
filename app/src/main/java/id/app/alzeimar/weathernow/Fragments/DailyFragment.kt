package id.app.alzeimar.weathernow.Fragments


import android.graphics.Point
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso
import id.app.alzeimar.weathernow.API.ApiInterface
import id.app.alzeimar.weathernow.Adapter.TanamanGA
import id.app.alzeimar.weathernow.FragmentVP.BaseFragment
import id.app.alzeimar.weathernow.HomeVP.HomePresenter
import id.app.alzeimar.weathernow.HomeVP.HomeVIew
import id.app.alzeimar.weathernow.MainActivity
import id.app.alzeimar.weathernow.Model.Tanaman

import id.app.alzeimar.weathernow.R
import id.app.alzeimar.weathernow.Response.Data
import id.app.alzeimar.weathernow.TanamanVP.TanamanPresenter
import id.app.alzeimar.weathernow.TanamanVP.TanamanView
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.custom_toolbar.view.*
import kotlinx.android.synthetic.main.fragment_daily.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class DailyFragment : BaseFragment(),HomeVIew.View,TanamanView.View {

    override fun setView(data: Data) {
        var i = 0

            data.rows!!.forEach {
                tanamanList.add(Tanaman("${it.kota}","${it.tanaman}"))
            }
                view!!.gvTanaman.adapter = TanamanGA(context!!,tanamanList)

    }

    override fun setdata() {
        api.getTanaman("Bearer "+"eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjA2NWZlN2FkZTk5NWFjYmE5NDFmMGM0YjkzYzE1MTA4ZTdkMTliYjU5ODQzY2E4YmEyYmYwYzc1ODJjMDg2NjIzYTg2MDU2NGUyMTc4YmE3In0.eyJhdWQiOiI4IiwianRpIjoiMDY1ZmU3YWRlOTk1YWNiYTk0MWYwYzRiOTNjMTUxMDhlN2QxOWJiNTk4NDNjYThiYTJiZjBjNzU4MmMwODY2MjNhODYwNTY0ZTIxNzhiYTciLCJpYXQiOjE1NDgyNDI3OTYsIm5iZiI6MTU0ODI0Mjc5NiwiZXhwIjoxNTc5Nzc4Nzk2LCJzdWIiOiIxIiwic2NvcGVzIjpbXX0.WT0IholfO1mzhBSeIPDbPGSkwChh2hSg8kit38opMwkm2mz4cZWN0qq6GPhxQMbEuSJ07OhMWgyM_NmozczIXsNaIqXdRWP1_DP-hRd1S7s_Pl3tely7rOP4su25-5Mu2AhlPK2HT72ZSDElWKs5AawMcDgxpND19Ec1mV78N7ia7MZOQaQeo-7i37gLJPLQ2uoTHqA6NqNPgEDaV_85keD0E1agw7mhyXrUoWIYa7hjBjMbCh6SuqHLL1CMRzUEFwDacVHCJSOWfzAKcKg9VZQxN2Qt57dA1uKcocH9B5x2rIKyJSKN2M-SRNyEYoVhPnspuvagbASAVY_oM_wPKmIvvUjWQKHHmQyF_Sgd1M30c2MnlvOZPU-_3JLENb9OC-cy9TocYvZD314wQoZM5BZ4j3iz6jBnHb0rXxKqTk6wGz_9jRH_IWyrEDkycyLtq8tYsnDL0cgW2snZ31ELSle2WbxsAOv2ba7FlNwe0j-uP03MDumgTjQ9C0raYEqlc6OTEMXmJvggtqIXGBtHdeuHhOcIe0rCqC7qI-wE5Ooj0KwrlkZmXjFuKOXX5pJhr_i1KKJ5Pr9SsQLzF0gxocEgvug0_MuzGOKPJMmkcLZULxcKvo0GpHO3L1K2q9JuQm4HSh4Jx4Suy1Bi657WW3ILuS8Boe86bxF3hG2N1Hg")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    result->
                    presenterTanaman.getDataView(result.data!!)
                })

    }

    var tanamanList = ArrayList<Tanaman>()

    override fun setImage(resourece: Int, image: ImageView) {
        val display: Display =  activity!!.windowManager.defaultDisplay
        val point: Point = Point()
        display.getSize(point)
        Picasso.get().load(resourece).resize(point.x,point.y).centerCrop().into(image)
    }

    val api: ApiInterface by lazy {
       ApiInterface.create()
    }

    override fun getLayout(): Int {
        return R.layout.fragment_daily
    }

    private lateinit var presenter:HomePresenter
    private lateinit var presenterTanaman:TanamanPresenter
    var adapter:TanamanGA? =null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_daily, container, false)
        val textView:TextView = view.findViewById(R.id.toolbar_title)
        textView.setText("TANAMAN")
        (activity as MainActivity).toolbar = view.toolbar_custom
        presenter = HomePresenter(this)
        presenterTanaman = TanamanPresenter(this)
        presenter.addImage(R.drawable.background_seed,view.imageBG)
        presenterTanaman.addGridview()

        return view
    }


}
