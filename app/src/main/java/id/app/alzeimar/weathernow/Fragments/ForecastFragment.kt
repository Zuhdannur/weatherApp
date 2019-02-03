package id.app.alzeimar.weathernow.Fragments


import android.graphics.Point
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SeekBar
import com.john.waveview.WaveView
import com.squareup.picasso.Picasso
import id.app.alzeimar.weathernow.ForecastVP.ForecastPresenter
import id.app.alzeimar.weathernow.ForecastVP.ForecastView
import id.app.alzeimar.weathernow.FragmentVP.BaseFragment
import id.app.alzeimar.weathernow.HomeVP.HomePresenter
import id.app.alzeimar.weathernow.HomeVP.HomeVIew
import id.app.alzeimar.weathernow.MainActivity
import id.app.alzeimar.weathernow.MainVP.MainActivityVP

import id.app.alzeimar.weathernow.R
import kotlinx.android.synthetic.main.custom_toolbar.view.*
import kotlinx.android.synthetic.main.fragment_forecast.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ForecastFragment : BaseFragment(),HomeVIew.View,ForecastView.View {

    override fun setWave(wave: WaveView, seekBar: SeekBar) {
//        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
//            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
//                wave.setProgress(progress)
//            }
//
//            override fun onStartTrackingTouch(seekBar: SeekBar?) {
//
//            }
//
//            override fun onStopTrackingTouch(seekBar: SeekBar?) {
//                seekBar.setProgress()
//            }
//
//        })
        wave.setProgress(50)
    }

    override fun setImage(resourece: Int, image: ImageView) {
        val display: Display =  activity!!.windowManager.defaultDisplay
        val point: Point = Point()
        display.getSize(point)
        Picasso.get().load(resourece).resize(point.x,point.y).centerCrop().into(image)
    }

    override fun getLayout(): Int {
        return R.layout.fragment_forecast
    }




    private lateinit var prenster:HomePresenter
    private lateinit var presenterForecat:ForecastPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_forecast, container, false)
        view.toolbar_title.text = "CURAH HUJAN"
        (activity as MainActivity).toolbar = view.toolbar_custom
        prenster = HomePresenter(this)
        presenterForecat = ForecastPresenter(this)
        prenster.addImage(R.drawable.bg_curah,view.imageBG)
        view.wave_view.setProgress(view.seekbar_try.progress)
        view.seekbar_try.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                seekBar!!.progress = 45
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                seekBar!!.progress
            }

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                view.wave_view.setProgress(progress)
            }

        })
        return view
    }


}
