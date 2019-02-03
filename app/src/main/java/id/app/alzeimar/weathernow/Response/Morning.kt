package id.app.alzeimar.weathernow.Response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Morning {
    @SerializedName("time")
    @Expose
    var time: String? = null
    @SerializedName("weather")
    @Expose
    var weather: String? = null
    @SerializedName("image")
    @Expose
    var image: String? = null
    @SerializedName("background_image")
    @Expose
    var background: String? = null

}
