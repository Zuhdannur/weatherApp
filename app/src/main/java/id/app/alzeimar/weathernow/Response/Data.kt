package id.app.alzeimar.weathernow.Response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Data {
    @SerializedName("rows")
    @Expose
    val rows: List<Row>? = null
}