package skycap.com.driver.go4er.data.models.driverdetailsmodel.driverdetails

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class DriverDetail : Serializable {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("account_id")
    @Expose
    var accountId: Int? = null
    @SerializedName("registration_no")
    @Expose
    var registrationNo: String? = null
    @SerializedName("vehicle_modal")
    @Expose
    var vehicleModal: String? = null
    @SerializedName("vehicle_details")
    @Expose
    var vehicleDetails: String? = null
    @SerializedName("lat")
    @Expose
    var lat: Any? = null
    @SerializedName("lng")
    @Expose
    var lng: Any? = null
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null
    @SerializedName("is_available")
    @Expose
    var isAvailable: Int? = null
}
