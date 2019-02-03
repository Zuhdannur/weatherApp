package id.app.alzeimar.weathernow.MainVP

import android.content.Context
import android.view.Window
import id.app.alzeimar.weathernow.FragmentVP.BaseFragment
import id.app.alzeimar.weathernow.FragmentVP.FragmentNavigation
import id.app.alzeimar.weathernow.MainActivity
import android.app.Activity
import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.view.WindowManager
import id.app.alzeimar.weathernow.R
import kotlinx.android.synthetic.main.activity_main.view.*


public class MainActvityPresenter : MainActivityVP.Presenter,FragmentNavigation.Presenter {
    override fun addColor(statusColor: Int) {
        view.setColor(statusColor)
    }


    private lateinit var view:MainActivityVP.View

    constructor(view:MainActivityVP.View){
        this.view = view
    }


    override fun getRandomFragment() {

    }


    override fun addFragment(fragment: BaseFragment) {
            view.setFragment(fragment)
    }
}