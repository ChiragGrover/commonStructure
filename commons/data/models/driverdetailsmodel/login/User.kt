package skycap.com.driver.go4er.data.models.driverdetailsmodel.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import skycap.com.driver.go4er.AppConstants
import skycap.com.driver.go4er.data.models.driverdetailsmodel.driverdetails.AccountDetail
import skycap.com.driver.go4er.data.models.driverdetailsmodel.driverdetails.DriverAttachment
import skycap.com.driver.go4er.data.models.driverdetailsmodel.driverdetails.DriverDetail

import skycap.com.driver.go4er.utils.prefs.Utils

class User {

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
    @SerializedName("account_type")
    @Expose
    var accounttype: String? = null
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
        get() {
            return Utils.getParsedDate(AppConstants.webDateTimeFormat, field!!)
        }
    @SerializedName("phone_no")
    @Expose
    var phoneNo: String? = null
    @SerializedName("stripe_customer_token")
    @Expose
    var stripeCustomerToken: Any? = null
    @SerializedName("client_id")
    @Expose
    var clientId: Int? = null
    @SerializedName("profile_pic_url")
    @Expose
    var profilePicUrl: String? = null
    @SerializedName("full_name")
    @Expose
    var fullName: String? = null
    @SerializedName("show_unread_badge")
    @Expose
    var showUnreadBadge: Boolean? = null
    @SerializedName("status_label")
    @Expose
    var statusLabel: String? = null
    @SerializedName("driver_detail")
    @Expose
    var driverDetail: DriverDetail? = null
    @SerializedName("account_detail")
    @Expose
    var accountDetail: AccountDetail? = null
    @SerializedName("driver_attachment")
    @Expose
    var driverAttachment: List<DriverAttachment>? = null
}
