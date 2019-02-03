package id.app.alzeimar.weathernow.Response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Daylight {

    @SerializedName("time")
    @Expose
    val time: String? = null
    @SerializedName("weather")
    @Expose
    val weather: String? = null
    @SerializedName("image")
    @Expose
    val image: String? = null

    @SerializedName("background_image")
    @Expose
    var background: String? = null
}
