package id.app.alzeimar.weathernow.FragmentVP

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.app.alzeimar.weathernow.MainVP.MainActivityVP

public abstract class BaseFragment : Fragment(),FragmentNavigation.View{

    protected open var navigation:FragmentNavigation.Presenter? = null
    protected open var rootView:View? = null
    override fun atachPresenter(presenter: FragmentNavigation.Presenter) {
            navigation = presenter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(getLayout(),container,false)
        return rootView
    }

    protected abstract fun getLayout(): Int

}