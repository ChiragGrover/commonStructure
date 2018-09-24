package skycap.com.driver.go4er.data.models.packageList

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import skycap.com.driver.go4er.AppConstants
import skycap.com.driver.go4er.data.models.OrderDetails.Order

import skycap.com.driver.go4er.data.models.driverdetailsmodel.login.User
import skycap.com.driver.go4er.utils.prefs.Utils
import java.io.Serializable

class IncomingPackage : Serializable {

    @SerializedName("id")
    @Expose
    var id: Int = 0
    @SerializedName("account_id")
    @Expose
    var accountId: Int? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("weight")
    @Expose
    var weight: String? = null
    @SerializedName("delivery_type")
    @Expose
    var deliveryType: String? = null
    @SerializedName("pickup_location")
    @Expose
    var pickupLocation: String? = null
    @SerializedName("pickup_landmark")
    @Expose
    var pickupLandmark: Any? = null
    @SerializedName("pickup_city")
    @Expose
    var pickupCity: String? = null
    @SerializedName("pickup_date")
    @Expose
    var pickupDate: String? = null
    @SerializedName("pickup_time")
    @Expose
    var pickupTime: String? = null
    @SerializedName("pickup_lat")
    @Expose
    var pickupLat: Double? = null
    @SerializedName("pickup_lng")
    @Expose
    var pickupLng: Double? = null
    @SerializedName("delivery_location")
    @Expose
    var deliveryLocation: String? = null
    @SerializedName("delivery_landmark")
    @Expose
    var deliveryLandmark: Any? = null
    @SerializedName("delivery_city")
    @Expose
    var deliveryCity: String? = null
    @SerializedName("delivery_date")
    @Expose
    var deliveryDate: String? = null
    @SerializedName("delivery_time")
    @Expose
    var deliveryTime: String? = null
    @SerializedName("delivery_lat")
    @Expose
    var deliveryLat: Double? = null
    @SerializedName("delivery_lng")
    @Expose
    var deliveryLng: Double? = null
    @SerializedName("user_type")
    @Expose
    var userType: String? = null
    @SerializedName("package_name")
    @Expose
    var packageName: String? = null
    @SerializedName("instructions")
    @Expose
    var instructions: Any? = null
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null
    @SerializedName("bid_price")
    @Expose
    var bidPrice: Float? = null
    @SerializedName("user_package_status")
    @Expose
    var userPackageStatus: String? = null
    @SerializedName("weight_string")
    @Expose
    var weightString: String? = null
    @SerializedName("order_id")
    @Expose
    var orderId: Any? = null
    @SerializedName("order_stage")
    @Expose
    var orderStage: Any? = null
    @SerializedName("created_at_date_time")
    @Expose
    var createdAtDateTime: String? = null
        get() {
            return Utils.getParsedDate(AppConstants.webDateTimeFormat, field!!)
        }

    @SerializedName("pickup_date_time")
    @Expose
    var pickupDateTime: String? = null
    @SerializedName("delivery_date_time")
    @Expose
    var deliveryDateTime: String? = null
    @SerializedName("user")
    @Expose
    var user: User? = null
    @SerializedName("provider_message")
    @Expose
    var providerMessage: List<Any>? = null
    @SerializedName("order")
    @Expose
    var order: Order? = null
}
