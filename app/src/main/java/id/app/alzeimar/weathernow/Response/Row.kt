package id.app.alzeimar.weathernow.Response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Row {
    @SerializedName("area_id")
    @Expose
    val areaId: Int? = null
    @SerializedName("day")
    @Expose
    val day: Day? = null
    @SerializedName("temperature_min")
    @Expose
    val temperatureMin: String? = null
    @SerializedName("temperature_max")
    @Expose
    val temperatureMax: String? = null
    @SerializedName("humidity_min")
    @Expose
    val humidityMin: String? = null
    @SerializedName("humidity_max")
    @Expose
    val humidityMax: String? = null
    @SerializedName("weather_date")
    @Expose
    val weatherDate: String? = null

    @SerializedName("kota")
    @Expose
    val kota: String? = null
    @SerializedName("tanaman")
    @Expose
    val tanaman: String? = null
}