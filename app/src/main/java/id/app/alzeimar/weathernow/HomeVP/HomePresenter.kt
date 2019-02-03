package id.app.alzeimar.weathernow.HomeVP

import android.widget.ImageView

class HomePresenter : HomeVIew.Presenter {

    private lateinit var view:HomeVIew.View

    constructor(view:HomeVIew.View){
        this.view = view
    }

    override fun addImage(resourece: Int, image: ImageView) {
        view.setImage(resourece,image)
    }
}