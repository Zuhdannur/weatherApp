package id.app.alzeimar.weathernow.Response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class DataResponses {
    @SerializedName("code")
    @Expose
    val code: Int? = null
    @SerializedName("status")
    @Expose
    val status: String? = null
    @SerializedName("data")
    @Expose
    val data: Data? = null
}