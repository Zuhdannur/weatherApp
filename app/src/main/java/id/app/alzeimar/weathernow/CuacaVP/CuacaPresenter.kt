package id.app.alzeimar.weathernow.CuacaVP

import android.widget.ImageView
import android.widget.TextView
import id.app.alzeimar.weathernow.Response.Data

class CuacaPresenter : CuacaView.Presenter {
    override fun getRequest(position: Int) {
        view.setRequest(position)
    }

    override fun getLocation(txview: TextView) {
        view.setLocation(txview)
    }

    private lateinit var view:CuacaView.View

    constructor(view:CuacaView.View){
        this.view = view
    }

    override fun getData(data: Data, position: Int) {
        view.setData(data,position)
    }
}