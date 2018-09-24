package skycap.com.driver.go4er.data.models.signatureModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Image {

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("size")
    @Expose
    var size: Int? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("delete_url")
    @Expose
    var deleteUrl: String? = null
    @SerializedName("delete_type")
    @Expose
    var deleteType: String? = null

}
