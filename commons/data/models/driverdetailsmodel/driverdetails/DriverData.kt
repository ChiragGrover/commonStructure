package skycap.com.driver.go4er.data.models.driverdetailsmodel.driverdetails

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class DriverData : Serializable {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("last_name")
    @Expose
    var lastName: String? = null
    @SerializedName("email")
    @Expose
    var email: String? = null
    @SerializedName("phone_no")
    @Expose
    var phoneNo: String? = null
    @SerializedName("account_type")
    @Expose
    var accountType: String? = null
    @SerializedName("username")
    @Expose
    var username: Any? = null
    @SerializedName("profile_pic")
    @Expose
    var profilePic: Any? = null
    @SerializedName("e_code")
    @Expose
    var eCode: Any? = null
    @SerializedName("is_facebook")
    @Expose
    var isFacebook: Int? = null
    @SerializedName("is_verified")
    @Expose
    var isVerified: Int? = null
    @SerializedName("is_active")
    @Expose
    var isActive: Int? = null
    @SerializedName("reason_text")
    @Expose
    var reasonText: Any? = null
    @SerializedName("stripe_customer_token")
    @Expose
    var stripeCustomerToken: Any? = null
    @SerializedName("timezone")
    @Expose
    var timezone: String? = null
    @SerializedName("provider_id")
    @Expose
    var providerId: Any? = null
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null
    @SerializedName("deleted_at")
    @Expose
    var deletedAt: Any? = null
    @SerializedName("profile_pic_url")
    @Expose
    var profilePicUrl: String = ""
    @SerializedName("full_name")
    @Expose
    var fullName: String? = null
    @SerializedName("show_unread_badge")
    @Expose
    var showUnreadBadge: Boolean? = null
    @SerializedName("status_label")
    @Expose
    var statusLabel: String? = null
    @SerializedName("account_detail")
    @Expose
    var accountDetail: AccountDetail? = null
    @SerializedName("driver_detail")
    @Expose
    var driverDetail: DriverDetail? = null
    @SerializedName("driver_attachment")
    @Expose
    var driverAttachment: List<DriverAttachment>? = null
}
