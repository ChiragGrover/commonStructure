import java.text.SimpleDateFormat
import java.util.*

object AppConstants {

    // SPLASH VISIBILITY TIME
    const val SPLASH_TIME_MILLIS: Long = 2500

    const val BUILD_TYPE_DEV = "dev"
    const val SUCCESS = 200
    const val AUTH_FAIL = 401
    const val NETWORK_NOT_AVAILABLE = 1001
    const val UNKNOWN_ERROR = 1000
    const val UNKNOWN_STATUS = 290
    const val SERVER_CONNECTION_ERROR = 5000

    // DATE TIME FORMAT
    val appDateTimeFormat = SimpleDateFormat("MMMM dd, yyyy, hh:mm a", Locale.getDefault())
    val webDateTimeFormat = SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.getDefault())
    val webPickDeliveryTimeFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    val utcTimeZone = TimeZone.getTimeZone("UTC")

    // ERROR VIEW KEYS
    const val NO_DATA_VIEW: String = "empty"
    const val NO_NETWORK_VIEW: String = "network_unavailable"
    const val OH_SNAP_VIEW: String = "unexpected_error"

}