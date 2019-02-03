package id.app.alzeimar.weathernow.FragmentVP

import id.app.alzeimar.weathernow.MainVP.MainActivityVP

class FragmentNavigation {
    interface View{
        fun atachPresenter(presenter:Presenter)
    }
    interface Presenter{
        fun addFragment(fragment: BaseFragment)
    }
}