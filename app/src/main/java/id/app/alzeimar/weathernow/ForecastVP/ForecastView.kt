package id.app.alzeimar.weathernow.ForecastVP

import android.widget.SeekBar
import com.john.waveview.WaveView

public interface ForecastView {
    public interface View {
        fun setWave(wave: WaveView,seekBar: SeekBar)
    }
    public interface Presenter{
        fun addWave(wave:WaveView,seekBar: SeekBar)
    }
}