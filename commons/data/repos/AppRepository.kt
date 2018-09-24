package skycap.com.driver.go4er.data.repos
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.google.gson.Gson
import kotlinx.coroutines.experimental.launch
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Retrofit
import skycap.com.driver.go4er.ApiStatus
import skycap.com.driver.go4er.AppConstants
import skycap.com.driver.go4er.data.Response
import skycap.com.driver.go4er.data.apis.GoogleApiServices
import skycap.com.driver.go4er.data.apis.WebServices
import skycap.com.driver.go4er.data.models.AddReviewResponse
import skycap.com.driver.go4er.data.models.CompanyOrderListResponse
import skycap.com.driver.go4er.data.models.GeneralApiResponse
import skycap.com.driver.go4er.data.models.driverdetailsmodel.CommonApiResponse
import skycap.com.driver.go4er.data.models.driverdetailsmodel.driverdetails.AccountDetailsResponse
import skycap.com.driver.go4er.data.models.driverdetailsmodel.driverdetails.DriverDetailData
import skycap.com.driver.go4er.data.models.driverdetailsmodel.login.ApiResponse
import skycap.com.driver.go4er.data.models.driverdetailsmodel.login.Token
import skycap.com.driver.go4er.data.models.driverdetailsmodel.login.User
import skycap.com.driver.go4er.data.models.googleDistanceTime.GoogleDistanceTimeResponse
import skycap.com.driver.go4er.data.models.packageDetails.PackageData
import skycap.com.driver.go4er.data.models.packageList.PackageListResponse
import skycap.com.driver.go4er.data.models.stripeAccountDetails.Data
import skycap.com.driver.go4er.di.ResourceProvider
import skycap.com.driver.go4er.utils.prefs.SharedPrefsHelperImpl
import java.net.ConnectException
import java.net.URI
import java.net.UnknownHostException
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton
@Singleton
class AppRepository @Inject constructor(private val webServices: WebServices,
                                        private val googleApiServices: GoogleApiServices,
                                        private val retrofit: Retrofit,
                                        private val sharedPrefsHelperImpl: SharedPrefsHelperImpl,
                                        private val resourceProvider: ResourceProvider) {
    private val go4erUser = MutableLiveData<User>()
    val isUserLoggedIn = MutableLiveData<Boolean>()
    private val USER = "user"
    private val USER_TOKEN = "token"
    private val USER_PIC = "USER_PIC"
    private val USER_STRIPE_CUSTOMER_ID = "USER_STRIPE_CUSTOMER_ID"
    private val USER_TOKEN_EXPIRATION_TIME = "USER_TOKEN_EXPIRATION_TIME"
    val companyOrderListData = MutableLiveData<Response<CompanyOrderListResponse>>()
    val packageListData = MutableLiveData<Response<PackageListResponse>>()
    val driverDetail = MutableLiveData<Response<GeneralApiResponse<DriverDetailData>>>()
    val stripeAccountUrl = MutableLiveData<Response<GeneralApiResponse<Data>>>()
    init {
        fetchData()
    }
    fun fetchData() {
        getDriverDetails()
        getCompanyOrderList()
        if (isCompanyDriver()) {
            getCompanyOrderList()
        } else {
            updatePackagesList()
        }
    }
    /*
     AccountDtailApi
 */
    fun driverAccountDetails(code: String): LiveData<Response<AccountDetailsResponse>> {
        var apiStatus: ApiStatus
        var response: Response<AccountDetailsResponse>
        val liveData = MutableLiveData<Response<AccountDetailsResponse>>()
        launch {
            try {
                val apiresponse = webServices.getDriverDetails(code).await()
                apiStatus = ApiStatus(apiresponse.code())
                response = Response(apiStatus, apiresponse.body())
            } catch (e: Exception) {
                val code: Int = getStatusCode(e)
                response = Response(ApiStatus(code), null)
            }
            liveData.postValue(response)
        }
        return liveData
    }
    /*
        SetPasswordApi
    */
    fun driverSetPasswordDetails(code: String, email: String, password: String, passwordConfirmation: String): LiveData<Response<CommonApiResponse>> {
        var apiStatus: ApiStatus
        var response: Response<CommonApiResponse>
        val liveData = MutableLiveData<Response<CommonApiResponse>>()
        launch {
            try {
                val setPasswordApiResponse = webServices.driverSetPassword(code, email, password, passwordConfirmation).await()
                apiStatus = ApiStatus(setPasswordApiResponse.code())
                response = Response(apiStatus, setPasswordApiResponse.body())
            } catch (e: Exception) {
                val code: Int = getStatusCode(e)
                response = Response(ApiStatus(code), null)
            }
            liveData.postValue(response)
        }
        return liveData
    }
    /*
        Login Api
    */
    fun saveUser(userData: User) {
        val gson = Gson()
        val user = gson.toJson(userData)
        go4erUser.postValue(userData)
        isUserLoggedIn.postValue(true)
        sharedPrefsHelperImpl.save(USER, user)
    }
    fun getUserType(): String {
        val user = sharedPrefsHelperImpl.getUser()
        var accountType = AppConstants.companyDriverAccountType
        user?.let {
            it.accounttype?.let {
                accountType = it
            }
        }
        return accountType
    }
    fun isCompanyDriver(): Boolean {
        var isCompanyDriver = false
        if (getUserType() == AppConstants.companyDriverAccountType) {
            isCompanyDriver = true
        }
        return isCompanyDriver
    }
    fun saveToken(tokenData: Token) {
        val gson = Gson()
        val token = gson.toJson(tokenData)
        sharedPrefsHelperImpl.save(USER_TOKEN, token)
    }
    private fun getCurrentTimeInSeconds(): Long {
        return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())
    }
    private fun getTokenExpirationTime(): String {
        return sharedPrefsHelperImpl.getString(USER_TOKEN_EXPIRATION_TIME, "")
    }
    fun login(email: String, password: String): LiveData<Response<ApiResponse>> {
        var loginapiStatus: ApiStatus
        var loginresponse: Response<ApiResponse>
        val liveData = MutableLiveData<Response<ApiResponse>>()
        launch {
            try {
                val loginApiResponse = webServices.login(email, password).await()
                loginapiStatus = ApiStatus(loginApiResponse.code())
                loginresponse = Response(loginapiStatus, loginApiResponse.body())
            } catch (e: Exception) {
                val code: Int = getStatusCode(e)
                loginresponse = Response(ApiStatus(code), null)
            }
            liveData.postValue(loginresponse)
        }
        return liveData
    }
    /*
    * ForgotPasswordApi
    **/
    fun driverForgotPassword(email: String): LiveData<Response<CommonApiResponse>> {
        var forgotPasswordapiStatus: ApiStatus
        var forgotPasswordresponse: Response<CommonApiResponse>
        val liveData = MutableLiveData<Response<CommonApiResponse>>()
        launch {
            try {
                val forgotPasswordApiResponse = webServices.forgotPassword(email).await()
                forgotPasswordapiStatus = ApiStatus(forgotPasswordApiResponse.code())
                forgotPasswordresponse = Response(forgotPasswordapiStatus, forgotPasswordApiResponse.body())
            } catch (e: Exception) {
                val code: Int = getStatusCode(e)
                forgotPasswordresponse = Response(ApiStatus(code), null)
            }
            liveData.postValue(forgotPasswordresponse)
        }
        return liveData
    }
    fun getPackagesList(): LiveData<Response<PackageListResponse>> = packageListData
    fun fetchDriverDetails(): LiveData<Response<GeneralApiResponse<DriverDetailData>>> = driverDetail
    fun updatePackagesList() {
        var response: Response<PackageListResponse>
        launch {
            response = try {
                val apiResponse = webServices.getIncomingPackages().await()
                val apiStatus = ApiStatus(apiResponse.code())
                Response(apiStatus, apiResponse.body())
            } catch (e: Exception) {
                val code: Int = getStatusCode(e)
                Response(ApiStatus(code), null)
            }
            packageListData.postValue(response)
        }
    }
    fun getPackageDetails(packageId: Int): LiveData<Response<GeneralApiResponse<PackageData>>> {
        var apiStatus: ApiStatus
        var response: Response<GeneralApiResponse<PackageData>>
        val liveData = MutableLiveData<Response<GeneralApiResponse<PackageData>>>()
        launch {
            try {
                val apiResponse = webServices.getPackageDetails(packageId).await()
                apiStatus = ApiStatus(apiResponse.code())
                response = Response(apiStatus, apiResponse.body())
            } catch (e: Exception) {
                val code: Int = getStatusCode(e)
                response = Response(ApiStatus(code), null)
            }
            liveData.postValue(response)
        }
        return liveData
    }
    private fun getDriverDetails() {
        var apiStatus: ApiStatus
        var response: Response<GeneralApiResponse<DriverDetailData>>
        launch {
            try {
                val apiResponse = webServices.getDriverDetails().await()
                apiStatus = ApiStatus(apiResponse.code())
                response = Response(apiStatus, apiResponse.body())
            } catch (e: Exception) {
                val code: Int = getStatusCode(e)
                response = Response(ApiStatus(code), null)
            }
            driverDetail.postValue(response)
        }
    }
    fun getCompanyOrderList() {
        var apiStatus: ApiStatus
        var response: Response<CompanyOrderListResponse>
        launch {
            try {
                val apiResponse = webServices.getOrderList().await()
                apiStatus = ApiStatus(apiResponse.code())
                response = Response(apiStatus, apiResponse.body())
            } catch (e: Exception) {
                val code: Int = getStatusCode(e)
                response = Response(ApiStatus(code), null)
            }
            companyOrderListData.postValue(response)
        }
    }
   fun getStripeConfigUrl(): LiveData<Response<GeneralApiResponse<Data>>> {
        var apiStatus: ApiStatus
        var response: Response<GeneralApiResponse<Data>>
        launch {
            try {
                val apiResponse = webServices.getStripeAccountSetup().await()
                apiStatus = ApiStatus(apiResponse.code())
                response = Response(apiStatus, apiResponse.body())
            } catch (e: Exception) {
                val code: Int = getStatusCode(e)
                response = Response(ApiStatus(code), null)
            }
            stripeAccountUrl.postValue(response)
        }
        return stripeAccountUrl
    }
    fun fetchStripeCode(code: String): LiveData<Response<ApiResponse>> {
        var apiStatus: ApiStatus
        var response: Response<ApiResponse>
        val liveData = MutableLiveData<Response<ApiResponse>>()
        launch {
            try {
                val ApiResponse = webServices.fetchStripeCode(code).await()
                apiStatus = ApiStatus(ApiResponse.code())
                response = Response(apiStatus, ApiResponse.body())
            } catch (e: Exception) {
                val code: Int = getStatusCode(e)
                response = Response(ApiStatus(code), null)
            }
            liveData.postValue(response)
        }
        return liveData
    }
    fun declinePackageRequest(packageId: Int): LiveData<Response<CommonApiResponse>> {
        var apiStatus: ApiStatus
        var response: Response<CommonApiResponse>
        val liveData = MutableLiveData<Response<CommonApiResponse>>()
        launch {
            try {
                val apiResponse = webServices.declineBid(packageId).await()
                apiStatus = ApiStatus(apiResponse.code())
                // Update Packages List
                if (apiResponse.isSuccessful) {
                    updatePackagesList()
                }
                response = Response(apiStatus, apiResponse.body())
            } catch (e: Exception) {
                val code: Int = getStatusCode(e)
                response = Response(ApiStatus(code), null)
            }
            liveData.postValue(response)
        }
        return liveData
    }
    fun activeInactive(startTime: String, endTime: String, isAvailable: String): LiveData<Response<CommonApiResponse>> {
        var apiStatus: ApiStatus
        var response: Response<CommonApiResponse>
        val liveData = MutableLiveData<Response<CommonApiResponse>>()
        launch {
            try {
                val apiResponse = webServices.activeInactive(startTime, endTime, isAvailable).await()
                apiStatus = ApiStatus(apiResponse.code())
                response = Response(apiStatus, apiResponse.body())
            } catch (e: Exception) {
                val code = getStatusCode(e)
                response = Response(ApiStatus(code), null)
            }
            liveData.postValue(response)
        }
        return liveData
    }
    fun sendBid(packageId: Int, amount: String,proposla : String): LiveData<Response<CommonApiResponse>> {
        var apiStatus: ApiStatus
        var response: Response<CommonApiResponse>
        val liveData = MutableLiveData<Response<CommonApiResponse>>()
        launch {
            try {
                val apiResponse = webServices.sendBid(packageId, amount,proposla).await()
                apiStatus = ApiStatus(apiResponse.code())
                response = Response(apiStatus, apiResponse.body())
                if (apiResponse.isSuccessful) {
                    updatePackagesList()
                }
            } catch (e: Exception) {
                val code = getStatusCode(e)
                response = Response(ApiStatus(code), null)
            }
            liveData.postValue(response)
        }
        return liveData
    }
    fun cancelBid(packageId: Int): LiveData<Response<CommonApiResponse>> {
        var apiStatus: ApiStatus
        var response: Response<CommonApiResponse>
        val liveData = MutableLiveData<Response<CommonApiResponse>>()
        launch {
            try {
                val apiResponse = webServices.cancelBid(packageId).await()
                apiStatus = ApiStatus(apiResponse.code())
                // Update Packages List
                if (apiResponse.isSuccessful) {
                    updatePackagesList()
                }
                response = Response(apiStatus, apiResponse.body())
            } catch (e: Exception) {
                val code: Int = getStatusCode(e)
                response = Response(ApiStatus(code), null)
            }
            liveData.postValue(response)
        }
        return liveData
    }
    fun getDistanceTimeTraveled(origins: String, destinations: String): LiveData<Response<GoogleDistanceTimeResponse>> {
        var apiStatus: ApiStatus
        var response: Response<GoogleDistanceTimeResponse>
        val liveData = MutableLiveData<Response<GoogleDistanceTimeResponse>>()
        launch {
            try {
                val apiResponse = googleApiServices.getDistanceTime(origins, destinations, AppConstants.GOOGLE_MAPS_API_KEY).await()
                apiStatus = ApiStatus(apiResponse.code())
                response = Response(apiStatus, apiResponse.body())
            } catch (e: Exception) {
                val code: Int = getStatusCode(e)
                response = Response(ApiStatus(code), null)
            }
            liveData.postValue(response)
        }
        return liveData
    }
    private fun getStatusCode(e: Exception): Int {
        return when (e) {
            is UnknownHostException -> AppConstants.NETWORK_NOT_AVAILABLE
            is ConnectException -> AppConstants.SERVER_CONNECTION_ERROR
            else -> AppConstants.UNKNOWN_ERROR
        }
    }
    fun orderPicking(orderId: Int): LiveData<Response<CommonApiResponse>> {
        var apiStatus: ApiStatus
        var response: Response<CommonApiResponse>
        val liveData = MutableLiveData<Response<CommonApiResponse>>()
        launch {
            try {
                val apiResponse = webServices.orderPicking(orderId).await()
                apiStatus = ApiStatus(apiResponse.code())
                response = Response(apiStatus, apiResponse.body())
                if (apiResponse.isSuccessful) {
                    updatePackagesList()
                }
            } catch (e: Exception) {
                val code = getStatusCode(e)
                response = Response(ApiStatus(code), null)
            }
            liveData.postValue(response)
        }
        return liveData
    }
    fun orderDelivering(orderId: Int): LiveData<Response<CommonApiResponse>> {
        var apiStatus: ApiStatus
        var response: Response<CommonApiResponse>
        val liveData = MutableLiveData<Response<CommonApiResponse>>()
        launch {
            try {
                val apiResponse = webServices.orderDelivering(orderId).await()
                apiStatus = ApiStatus(apiResponse.code())
                response = Response(apiStatus, apiResponse.body())
                if (apiResponse.isSuccessful) {
                    updatePackagesList()
                }
            } catch (e: Exception) {
                val code = getStatusCode(e)
                response = Response(ApiStatus(code), null)
            }
            liveData.postValue(response)
        }
        return liveData
    }

    fun uploadPackageImage(filePart: MultipartBody.Part, directoryRequestBody: RequestBody): LiveData<Response<ApiResponse>> {

        val liveData = MutableLiveData<Response<ApiResponse>>()

        launch {

            var apiStatus = ApiStatus(0)

            var response = Response<ApiResponse>(apiStatus, null)

            try {
                val apiResponse = webServices.uploadPackageImage(filePart, directoryRequestBody).await()

                if (apiResponse.isSuccessful) {
                    apiStatus = ApiStatus(apiResponse.code())
                    response = Response(apiStatus, apiResponse.body())
                } else {

                    val converter = retrofit.responseBodyConverter<ApiResponse>(ApiResponse::class.java, arrayOfNulls<Annotation>(0))

                    val apiErrorObject: ApiResponse = converter.convert(apiResponse.errorBody()!!)

                    val errorApiResponse = ApiResponse()

                    errorApiResponse.valid = apiErrorObject.valid
                    errorApiResponse.message = apiErrorObject.message

                    apiStatus = ApiStatus(apiResponse.code())
                    response = Response(apiStatus, errorApiResponse)
                }
            } catch (e: Exception) {

                e.let {

                    val code: Int = if (e is UnknownHostException) {
                        AppConstants.NETWORK_NOT_AVAILABLE
                    } else {
                        AppConstants.UNKNOWN_ERROR
                    }

                    response = Response(ApiStatus(code), null)

                    Log.d("status", e.toString())
                }
            }

            liveData.postValue(response)
        }
        return liveData
    }
    fun deletePackageImage(deleteFileUrl: URI): LiveData<Response<ApiResponse>> {

        val liveData = MutableLiveData<Response<ApiResponse>>()

        launch {

            var apiStatus = ApiStatus(0)

            retrofit.newBuilder().baseUrl(AppConstants.BASE_URL)


            var response = Response<ApiResponse>(apiStatus, null)

            try {
                val apiResponse = webServices.deletePackageImage(deleteFileUrl).await()

                if (apiResponse.isSuccessful) {
                    apiStatus = ApiStatus(apiResponse.code())
                    response = Response(apiStatus, apiResponse.body())
                } else {

                    val converter = retrofit.responseBodyConverter<ApiResponse>(ApiResponse::class.java, arrayOfNulls<Annotation>(0))

                    val apiErrorObject: ApiResponse = converter.convert(apiResponse.errorBody()!!)

                    val errorApiResponse = ApiResponse()

                    errorApiResponse.valid = apiErrorObject.valid
                    errorApiResponse.message = apiErrorObject.message

                    apiStatus = ApiStatus(apiResponse.code())
                    response = Response(apiStatus, errorApiResponse)
                }
            } catch (e: Exception) {

                e.let {

                    val code: Int = if (e is UnknownHostException) {
                        AppConstants.NETWORK_NOT_AVAILABLE
                    } else {
                        AppConstants.UNKNOWN_ERROR
                    }

                    response = Response(ApiStatus(code), null)

                    Log.d("status", e.toString())
                }
            }

            liveData.postValue(response)
        }
        return liveData
    }
    fun markOrderComplete(orderId: Int, receiverSignName: String, idProofName: String, receiverName: String): LiveData<Response<ApiResponse>> {

        val liveData = MutableLiveData<Response<ApiResponse>>()

        launch {
            var apiStatus = ApiStatus(0)
            var response = Response<ApiResponse>(apiStatus, null)
            try {
                val apiResponse = webServices.markOrderDeliveryAsComplete(orderId, receiverSignName, idProofName, receiverName).await()
                if (apiResponse.isSuccessful) {
                    apiStatus = ApiStatus(apiResponse.code())
                    response = Response(apiStatus, apiResponse.body())
                } else {
                    val converter = retrofit.responseBodyConverter<ApiResponse>(ApiResponse::class.java, arrayOfNulls<Annotation>(0))
                    val apiErrorObject: ApiResponse = converter.convert(apiResponse.errorBody()!!)
                    val errorApiResponse = ApiResponse()
                    errorApiResponse.valid = apiErrorObject.valid
                    errorApiResponse.message = apiErrorObject.message
                    apiStatus = ApiStatus(apiResponse.code())
                    response = Response(apiStatus, errorApiResponse)
                }
            } catch (e: Exception) {
                e.let {
                    val code: Int = if (e is UnknownHostException) {
                        AppConstants.NETWORK_NOT_AVAILABLE
                    } else {
                        AppConstants.UNKNOWN_ERROR
                    }
                    response = Response(ApiStatus(code), null)
                    Log.d("status", e.toString())
                }
            }

            liveData.postValue(response)
        }
        return liveData
    }
    /*fun markpickupComplete(orderId: Int, senderSignName: String, idProofName: String, senderName: String): LiveData<Response<ApiResponse>> {

        val liveData = MutableLiveData<Response<ApiResponse>>()

        launch {
            var apiStatus = ApiStatus(0)
            var response = Response<ApiResponse>(apiStatus, null)
            try {
                val apiResponse = webServices.orderPickedUpComplete(orderId, senderSignName, idProofName, senderName).await()
                if (apiResponse.isSuccessful) {
                    apiStatus = ApiStatus(apiResponse.code())
                    response = Response(apiStatus, apiResponse.body())
                } else {
                    val converter = retrofit.responseBodyConverter<ApiResponse>(ApiResponse::class.java, arrayOfNulls<Annotation>(0))
                    val apiErrorObject: ApiResponse = converter.convert(apiResponse.errorBody()!!)
                    val errorApiResponse = ApiResponse()
                    errorApiResponse.valid = apiErrorObject.valid
                    errorApiResponse.message = apiErrorObject.message
                    apiStatus = ApiStatus(apiResponse.code())
                    response = Response(apiStatus, errorApiResponse)
                }
            } catch (e: Exception) {
                e.let {
                    val code: Int = if (e is UnknownHostException) {
                        AppConstants.NETWORK_NOT_AVAILABLE
                    } else {
                        AppConstants.UNKNOWN_ERROR
                    }
                    response = Response(ApiStatus(code), null)
                    Log.d("status", e.toString())
                }
            }

            liveData.postValue(response)
        }
        return liveData
    }*/
    fun markpickupComplete(orderId: Int, senderSignName: String, idProofName: String, senderName: String): LiveData<Response<ApiResponse>> {
        var apiStatus: ApiStatus
        var response: Response<ApiResponse>
        val liveData = MutableLiveData<Response<ApiResponse>>()

        launch {
            try {
                val apiResponse = webServices.orderPickedUpComplete(orderId, senderSignName, idProofName, senderName).await()
                apiStatus = ApiStatus(apiResponse.code())
                response = Response(apiStatus, apiResponse.body())
            } catch (e: Exception) {
                val code = getStatusCode(e)
                response = Response(ApiStatus(code), null)
            }
            liveData.postValue(response)
        }
        return liveData
    }
   /* fun addReview(review: String, rating: Float, orderId: Int, action: String): LiveData<Response<AddReviewResponse>> {

        val liveData = MutableLiveData<Response<AddReviewResponse>>()

        launch {

            var apiStatus = ApiStatus(0)

            var response = Response<AddReviewResponse>(apiStatus, null)

            try {

                val apiResponse = when (action) {
                    "save" -> webServices.addReview( orderId,review, rating).await()
                    "edit" -> webServices.editReview(review, rating, orderId).await()
                    else -> return@launch
                }
                if (apiResponse.isSuccessful) {
                    apiStatus = ApiStatus(apiResponse.code())
                    response = Response(apiStatus, apiResponse.body())
                } else {

                    val converter = retrofit.responseBodyConverter<ApiResponse>(ApiResponse::class.java, arrayOfNulls<Annotation>(0))

                    val apiErrorObject: ApiResponse = converter.convert(apiResponse.errorBody()!!)

                    val errorApiResponse = AddReviewResponse()

                    errorApiResponse.valid = apiErrorObject.valid
                    errorApiResponse.message = apiErrorObject.message

                    apiStatus = ApiStatus(apiResponse.code())
                    response = Response(apiStatus, errorApiResponse)
                }
            } catch (e: Exception) {

                e.let {

                    val code: Int = if (e is UnknownHostException) {
                        AppConstants.NETWORK_NOT_AVAILABLE
                    } else {
                        AppConstants.UNKNOWN_ERROR
                    }

                    response = Response(ApiStatus(code), null)

                    Log.d("status", e.toString())
                }
            }

            liveData.postValue(response)
        }
        return liveData
    }*/
   fun addReview(review: String, rating: Float, orderId: Int, action: String, type: Int): LiveData<Response<AddReviewResponse>> {
       var apiStatus: ApiStatus
       var response: Response<AddReviewResponse>
       val liveData = MutableLiveData<Response<AddReviewResponse>>()
       launch {
           try {
               val apiResponse = when (action) {
                   "save" -> webServices.addReview(orderId, review, rating,type).await()
                   "edit" -> webServices.editReview(review, rating, orderId,type).await()
                   else -> return@launch
               }
               apiStatus = ApiStatus(apiResponse.code())
               response = Response(apiStatus, apiResponse.body())

           } catch (e: Exception) {
               val code = getStatusCode(e)
               response = Response(ApiStatus(code), null)
           }
           liveData.postValue(response)
       }
       return liveData
   }

}
