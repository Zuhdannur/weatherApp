package id.app.alzeimar.weathernow.HomeVP

import android.graphics.Bitmap
import android.widget.ImageView

public interface HomeVIew {
    public interface View{
        fun setImage(resourece:Int,image:ImageView)
    }
    public interface Presenter{
        fun addImage(resourece: Int,image:ImageView)
    }
}