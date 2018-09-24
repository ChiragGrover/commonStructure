package skycap.com.driver.go4er.utils.prefs

import android.content.Intent
import android.content.SharedPreferences
import com.google.gson.Gson
import skycap.com.driver.go4er.App
import skycap.com.driver.go4er.data.models.driverdetailsmodel.login.Token
import skycap.com.driver.go4er.data.models.driverdetailsmodel.login.User
import skycap.com.driver.go4er.views.login.LoginActivity
import javax.inject.Inject

class SharedPrefsHelperImpl @Inject constructor(private val sharedPreferences : SharedPreferences,
                                                private val app: App,
                                                private val gson: Gson):SharedPrefsHelper {

    override fun getString(key: String, value: String?): String = sharedPreferences.getString(key, value)
    override fun getBoolean(key: String, default: Boolean): Boolean = sharedPreferences.getBoolean(key, default)

    override fun save(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    override fun save(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    override fun clearPrefs(showUnAuthenticationError: Boolean) {
       sharedPreferences.edit().clear().apply()

        try {
            //val currentActivity = app.currentActivity

            saveUser(User())
            saveToken(Token())

            save("refreshToken", "")
            save("accessToken", "")
            save("USER_STRIPE_CUSTOMER_ID", "")
/*
            val intent = LoginActivity.newIntent(currentActivity, true, showUnAuthenticationError)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            currentActivity.startActivity(intent)*/
        }catch (e : UninitializedPropertyAccessException){}
    }

    fun getUser(): User? {

        val json = getString("user", "")

        var user: User? = null

        if (json != "") {
            user = gson.fromJson<Any>(json, User::class.java) as User
        }

        return user
    }

    private fun saveUser(userData: User) {
        val user = gson.toJson(userData)

        save("user", user)
    }

    fun getToken(): Token? {

        val json = getString("token", "")

        var token: Token? = null

        if (json != "") {
            token = gson.fromJson<Any>(json, Token::class.java) as Token
        }

        return token
    }

    fun saveToken(tokenData: Token) {
        val token = gson.toJson(tokenData)

        save("token", token)
    }

}