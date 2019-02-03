package id.app.alzeimar.weathernow.TanamanVP

import id.app.alzeimar.weathernow.Model.Tanaman
import id.app.alzeimar.weathernow.Response.Data

public interface TanamanView {
    public interface View{
        fun setdata()
        fun setView(data:Data)
    }
    public interface Presenter{
        fun addGridview()
        fun getDataView(data:Data)
    }
}