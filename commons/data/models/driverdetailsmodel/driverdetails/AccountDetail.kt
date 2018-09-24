package skycap.com.driver.go4er.data.models.driverdetailsmodel.driverdetails

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class AccountDetail : Serializable {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("provider_id")
    @Expose
    var providerId: Int? = null
    @SerializedName("company_name")
    @Expose
    var companyName: Any? = null
    @SerializedName("address")
    @Expose
    var address: Any? = null
    @SerializedName("about_us")
    @Expose
    var aboutUs: Any? = null
    @SerializedName("state_id")
    @Expose
    var stateId: Any? = null
    @SerializedName("city_id")
    @Expose
    var cityId: Any? = null
    @SerializedName("state")
    @Expose
    var state: Any? = null
    @SerializedName("city")
    @Expose
    var city: Any? = null
    @SerializedName("zipcode")
    @Expose
    var zipcode: Any? = null
    @SerializedName("website_url")
    @Expose
    var websiteUrl: Any? = null
    @SerializedName("virtual_mobile_no")
    @Expose
    var virtualMobileNo: Any? = null
    @SerializedName("lat")
    @Expose
    var lat: Any? = null
    @SerializedName("lng")
    @Expose
    var lng: Any? = null
    @SerializedName("min_working_radius")
    @Expose
    var minWorkingRadius: Int? = null
    @SerializedName("working_radius")
    @Expose
    var workingRadius: Int? = null
    @SerializedName("total_orders")
    @Expose
    var totalOrders: Int? = null
    @SerializedName("total_quotations")
    @Expose
    var totalQuotations: Int? = null
    @SerializedName("total_earning")
    @Expose
    var totalEarning: String? = null
    @SerializedName("total_commission")
    @Expose
    var totalCommission: String? = null
    @SerializedName("rating")
    @Expose
    var rating: String? = null
    @SerializedName("provider_photos")
    @Expose
    var providerPhotos: Any? = null
    @SerializedName("time_duration")
    @Expose
    var timeDuration: String? = null
    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("stripe_accid")
    @Expose
    var stripeAccid: String? = null
    @SerializedName("stripe_response")
    @Expose
    var stripeResponse: Any? = null
    @SerializedName("payout_interval")
    @Expose
    var payoutInterval: Any? = null
    @SerializedName("weekly_anchor")
    @Expose
    var weeklyAnchor: Any? = null
    @SerializedName("monthly_anchor")
    @Expose
    var monthlyAnchor: Any? = null
    @SerializedName("delay_days")
    @Expose
    var delayDays: Any? = null
    @SerializedName("is_archived")
    @Expose
    var isArchived: Int? = null
    @SerializedName("is_activated")
    @Expose
    var isActivated: Int? = null
    @SerializedName("provider_photos_list")
    @Expose
    var providerPhotosList: List<Any>? = null
    @SerializedName("provider_total_reviews")
    @Expose
    var providerTotalReviews: Int? = null
}
