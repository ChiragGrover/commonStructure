package skycap.com.driver.go4er.data.apis

import kotlinx.coroutines.experimental.Deferred
import retrofit2.Response
import retrofit2.http.*
import skycap.com.driver.go4er.data.models.GeneralApiResponse
import skycap.com.driver.go4er.data.models.driverdetailsmodel.CommonApiResponse
import skycap.com.driver.go4er.data.models.driverdetailsmodel.driverdetails.AccountDetailsResponse
import skycap.com.driver.go4er.data.models.driverdetailsmodel.login.ApiResponse
import skycap.com.driver.go4er.data.models.googleDistanceTime.GoogleDistanceTimeResponse
import skycap.com.driver.go4er.data.models.packageDetails.PackageData
import skycap.com.driver.go4er.data.models.packageList.PackageListResponse

interface GoogleApiServices {

    @GET("directions/json?origin=0.0,0.0&destination=0.0,0.0&key=AIzaSyC21-RFwN_GQSS7izw3u9tRlpGZf0g44q4")
    fun getDirections(@Query("code") code: String): Deferred<Response<AccountDetailsResponse>>

    // Get Distance Time
    @GET("distancematrix/json?units=imperial")
    fun getDistanceTime(@Query("origins") origins: String,
                        @Query("destinations") destinations: String,
                        @Query("key") key: String): Deferred<Response<GoogleDistanceTimeResponse>>
}