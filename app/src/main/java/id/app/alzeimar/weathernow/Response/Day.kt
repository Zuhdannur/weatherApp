package id.app.alzeimar.weathernow.Response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Day {
    @SerializedName("morning")
    @Expose
    val morning: Morning? = null
    @SerializedName("daylight")
    @Expose
    val daylight: Daylight? = null
    @SerializedName("night")
    @Expose
    val night: Night? = null
    @SerializedName("dawn")
    @Expose
    val dawn: Dawn? = null
}