package skycap.com.driver.go4er.utils

import android.util.Log
import com.google.gson.Gson
import okhttp3.FormBody
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import skycap.com.driver.go4er.AppConstants
import skycap.com.driver.go4er.data.models.driverdetailsmodel.login.ApiResponse
import skycap.com.driver.go4er.data.models.driverdetailsmodel.login.User
import skycap.com.driver.go4er.utils.prefs.SharedPrefsHelperImpl
import java.util.concurrent.TimeUnit

class AuthInterceptor(private val sharedPrefsHelperImpl: SharedPrefsHelperImpl,
                      private val gson: Gson) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val token = sharedPrefsHelperImpl.getToken()
        val deviceId = sharedPrefsHelperImpl.getString("device_id", "")
        val user = sharedPrefsHelperImpl.getUser()

        var mainResponse = chain.proceed(buildRequest(chain, token?.accessToken, deviceId, user))

        if (mainResponse.code() == 401) {
            Log.d("token", token?.refreshToken + user?.clientId)

            if (token != null && user?.clientId != null) {

                val refreshTokenBody = FormBody.Builder()
                        .add("refresh_token", token.refreshToken)
                        .add("client_id", user.clientId.toString())
                        .build()
                val refreshTokenRequest = Request.Builder()
                        .url(AppConstants.BASE_URL + "users/refresh_token")
                        .post(refreshTokenBody)
                        .build()
                val refreshTokenResponse = chain.proceed(refreshTokenRequest)

                if (refreshTokenResponse.code() == 200) {

                    val apiResponse: ApiResponse = gson.fromJson<ApiResponse>(refreshTokenResponse.body()?.string(), ApiResponse::class.java)
                    val tokenData = apiResponse.data.token
                    tokenData?.let {
                        sharedPrefsHelperImpl.saveToken(it)
                        sharedPrefsHelperImpl.save("USER_TOKEN_EXPIRATION_TIME", (getCurrentTimeInSeconds() + tokenData.expiresIn).toString())

                    }

                    mainResponse = chain.proceed(buildRequest(chain, tokenData?.accessToken, deviceId, user))

                } else {
                    if (isTokenExpired()) {
                        Log.d("authInterceptor", "failure" + isTokenExpired())
                        sharedPrefsHelperImpl.clearPrefs(true)
                    }
                }
            } else {
                // Do Nothing
            }
        }
        return mainResponse
    }

    private fun buildRequest(chain: Interceptor.Chain, token: String?, deviceId: String, user: User?): Request {

        var original = chain.request()

        original = if (user?.id == null) {
            original.newBuilder()
                    .method(original.method(), original.body())
                    .addHeader("Accept", "application/json")
                    .addHeader("device-token", deviceId)
                    .build()
        } else {
            original.newBuilder()
                    .method(original.method(), original.body())
                    .addHeader("Accept", "application/json")
                    .header("Authorization", "Bearer $token")
                    .addHeader("device-token", "asdfsdfsdfsdf")
                    .build()
        }
        return original
    }

    private fun isTokenExpired(): Boolean {

        var tokenValid = false
        val expirationTime = sharedPrefsHelperImpl.getString("USER_TOKEN_EXPIRATION_TIME", "")
        Log.d("CurrentTimeInSeconds:", getCurrentTimeInSeconds().toString() + " SystemTime : " + expirationTime)
        if (expirationTime.isNotEmpty()) {
            tokenValid = getCurrentTimeInSeconds() > expirationTime.toLong()
        }
        return tokenValid
    }

    private fun getCurrentTimeInSeconds(): Long {
        return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())
    }
}
