package skycap.com.driver.go4er.data.models.packageList

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PackageListResponse {

    @SerializedName("valid")
    @Expose
    var valid: Boolean? = null
    @SerializedName("message")
    @Expose
    var message: String? = null
    @SerializedName("data")
    @Expose
    var data: PackageListData? = null
    @SerializedName("code")
    @Expose
    var code: Int? = null
}
