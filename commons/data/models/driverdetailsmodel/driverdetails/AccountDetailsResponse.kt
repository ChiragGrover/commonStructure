package skycap.com.driver.go4er.data.models.driverdetailsmodel.driverdetails

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class AccountDetailsResponse : Serializable {

    @SerializedName("valid")
    @Expose
    var valid: Boolean? = null
    @SerializedName("message")
    @Expose
    var message: String? = null
    @SerializedName("data")
    @Expose
    var data: DriverData? = null
    @SerializedName("code")
    @Expose
    var code: Int? = null
}
