package skycap.com.driver.go4er.utils.prefs

interface SharedPrefsHelper {

    fun save(key: String, value: Boolean)
    fun getBoolean(key: String, default: Boolean): Boolean

    fun save(key: String, value: String)
    fun getString(key: String, value: String?): String

    fun clearPrefs(showExpirationAlert: Boolean)
}