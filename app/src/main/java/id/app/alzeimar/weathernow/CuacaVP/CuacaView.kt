package id.app.alzeimar.weathernow.CuacaVP

import android.widget.ImageView
import android.widget.TextView
import id.app.alzeimar.weathernow.Response.Data

interface CuacaView {
    public interface View{
        fun setData(data: Data,position:Int)
        fun setLocation(txview: TextView)
        fun setRequest(position: Int)
    }

    public interface Presenter{
        fun getData(data: Data,position:Int)
        fun getRequest(position: Int)
        fun getLocation(txview:TextView)
    }
}