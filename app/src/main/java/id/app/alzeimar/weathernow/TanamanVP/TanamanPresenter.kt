package id.app.alzeimar.weathernow.TanamanVP

import id.app.alzeimar.weathernow.Model.Tanaman
import id.app.alzeimar.weathernow.Response.Data

class TanamanPresenter : TanamanView.Presenter {
    override fun getDataView(data: Data) {
        view.setView(data)
    }

    private lateinit var view:TanamanView.View



    constructor(view: TanamanView.View){
        this.view = view
    }

    override fun addGridview() {
        view.setdata()
    }
}