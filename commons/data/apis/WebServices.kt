package skycap.com.driver.go4er.data.apis

import kotlinx.coroutines.experimental.Deferred
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*
import skycap.com.driver.go4er.data.models.AddReviewResponse
import skycap.com.driver.go4er.data.models.CompanyOrderListResponse
import skycap.com.driver.go4er.data.models.GeneralApiResponse
import skycap.com.driver.go4er.data.models.driverdetailsmodel.CommonApiResponse
import skycap.com.driver.go4er.data.models.driverdetailsmodel.driverdetails.DriverDetailData
import skycap.com.driver.go4er.data.models.driverdetailsmodel.driverdetails.AccountDetailsResponse
import skycap.com.driver.go4er.data.models.driverdetailsmodel.login.ApiResponse
import skycap.com.driver.go4er.data.models.packageDetails.PackageData
import skycap.com.driver.go4er.data.models.packageList.PackageListResponse
import skycap.com.driver.go4er.data.models.stripeAccountDetails.Data
import java.net.URI

interface WebServices {
    @GET("api/drivers/access_code")
    fun getDriverDetails(@Query("code") code: String): Deferred<Response<AccountDetailsResponse>>

    @FormUrlEncoded
    @POST("api/drivers/update_password")
    fun driverSetPassword(@Field("code") code: String,
                          @Field("email") email: String,
                          @Field("password") password: String,
                          @Field("password_confirmation") password_confirmation: String): Deferred<Response<CommonApiResponse>>

    /*@FormUrlEncoded
    @POST("login")
    fun login(@Field("email") name: String,
              @Field("password") userName: String,
              @Field("device_type") deviceType: Int,
              @Field("notification_token") notificationToken: String): Deferred<Response<AccountDetailsResponse>>*/
    // Login
    @FormUrlEncoded
    @POST("api/driver/login")
    fun login(@Field("email") email: String,
              @Field("password") password: String): Deferred<Response<ApiResponse>>

    // Forgot Password
    @FormUrlEncoded
    @POST("api/users/forget_password")
    fun forgotPassword(@Field("email") email: String): Deferred<Response<CommonApiResponse>>

    // Incoming Packages
    @GET("api/incoming_packages")
    fun getIncomingPackages(): Deferred<Response<PackageListResponse>>

    // Package Details
    @GET("api/packagedetail")
    fun getPackageDetails(@Query("id") id: Int): Deferred<Response<GeneralApiResponse<PackageData>>> // Response type needs to be changed

    @FormUrlEncoded
    @POST("api/driver/availablity")
    fun activeInactive(@Field("start_time") start_time: String,
                       @Field("end_time") end_time: String, @Field("is_available") is_available: String):
            Deferred<Response<CommonApiResponse>>

    // Send Bid
    @FormUrlEncoded
    @POST("api/quotations/send")
    fun sendBid(@Field("package_id") packageId: Int,
                @Field("amount") amount: String,
                @Field("proposla") proposla: String):
            Deferred<Response<CommonApiResponse>>

    // Decline Bid
    @FormUrlEncoded
    @POST("api/incoming_request/decline")
    fun declineBid(@Field("package_id") packageId: Int): Deferred<Response<CommonApiResponse>>

    // Cancel Bid
    @FormUrlEncoded
    @POST("api/quotations/cancel")
    fun cancelBid(@Field("package_id") packageId: Int): Deferred<Response<CommonApiResponse>>

    // Driver Details
    @GET("api/driver/details")
    fun getDriverDetails(): Deferred<Response<GeneralApiResponse<DriverDetailData>>>

    // Company Driver Apis
    @GET("api/driver/orders")
    fun getOrderList(): Deferred<Response<CompanyOrderListResponse>>

    @FormUrlEncoded
    @POST("api/driver/picking")
    fun orderPicking(@Field("order_id") orderId: Int): Deferred<Response<CommonApiResponse>>

    @FormUrlEncoded
    @POST("api/driver/delivering")
    fun orderDelivering(@Field("order_id") orderId: Int): Deferred<Response<CommonApiResponse>>

    // Stripe Account config
    @GET("api/driver/stripe_setup_link")
    fun getStripeAccountSetup(): Deferred<Response<GeneralApiResponse<Data>>>

    @FormUrlEncoded
    @POST("stripe_response")
    fun fetchStripeCode(@Field("code") code: String): Deferred<Response<ApiResponse>>

    // Upload Image
    @Multipart
    @POST("upload-files")
    fun uploadPackageImage(@Part filePart: MultipartBody.Part,
                           @Part("tbl") pathDirectory: RequestBody): Deferred<Response<ApiResponse>>

    // Delete Package Image
    @DELETE
    fun deletePackageImage(@Url deleteFileUrl: URI): Deferred<Response<ApiResponse>>

    @FormUrlEncoded
    @POST("api/order/pickedup")
    fun orderPickedUpComplete(@Field("order_id") orderId: Int,
                            @Field("sender_sign") senderSign: String,
                            @Field("sender_id_proof") senderIdProof: String,
                            @Field("sender_name") senderName: String): Deferred<Response<ApiResponse>>

    // Mark Order As Complete
    @FormUrlEncoded
    @POST("api/order_status")
    fun markOrderDeliveryAsComplete(@Field("order_id") orderId: Int,
                            @Field("receiver_sign") receiverSign: String,
                            @Field("id_proof") idProof: String,
                            @Field("receiver_name") receiverName: String): Deferred<Response<ApiResponse>>
    @FormUrlEncoded
    @POST("api/reviews")
    fun addReview( @Field("order_id") orderId: Int,
                   @Field("review") review: String,
                  @Field("rating") rating: Float ,
                   @Field("type") type: Int): Deferred<Response<AddReviewResponse>>
    // Edit Review
    @FormUrlEncoded
    @PUT("api/reviews/{order_id}")
    fun editReview(@Field("review") review: String,
                   @Field("rating") rating: Float,
                   @Path("order_id") orderId: Int,
                   @Field("type") type: Int): Deferred<Response<AddReviewResponse>>
}
