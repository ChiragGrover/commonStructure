package skycap.com.driver.go4er.data.models.driverdetailsmodel.driverdetails

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class DriverAttachment : Serializable {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("account_id")
    @Expose
    var accountId: Int? = null
    @SerializedName("path")
    @Expose
    var path: String? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null
    @SerializedName("path_url")
    @Expose
    var pathUrl: String? = null

}
