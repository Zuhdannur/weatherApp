package id.app.alzeimar.weathernow.MainVP

import android.content.Context
import id.app.alzeimar.weathernow.FragmentVP.BaseFragment


public interface MainActivityVP {
    public interface View{
        fun setFragment(fragment: BaseFragment)
        fun setColor(statusColor: Int)
    }
    public interface Presenter{
        fun addColor(statusColor: Int)
        fun getRandomFragment()
    }
}