package id.app.alzeimar.weathernow.ForecastVP

import android.widget.SeekBar
import com.john.waveview.WaveView

class ForecastPresenter : ForecastView.Presenter {
    override fun addWave(wave: WaveView, seekBar: SeekBar) {
        view.setWave(wave,seekBar)
    }

    private lateinit var view:ForecastView.View

    constructor(view:ForecastView.View){
        this.view = view
    }


}