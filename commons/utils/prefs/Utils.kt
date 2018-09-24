package skycap.com.driver.go4er.utils.prefs

import android.content.Context
import android.graphics.*
import android.net.ConnectivityManager
import android.support.v4.content.ContextCompat
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.AppCompatTextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import com.androidadvance.topsnackbar.TSnackbar
import skycap.com.driver.go4er.AppConstants
import skycap.com.driver.go4er.R
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


object Utils {

    fun showCustomSnackBar(view: View, message: String, value: Boolean) {

        val snackBar = TSnackbar.make(view, message, TSnackbar.LENGTH_LONG)

        val status: String

        val snackBarView: TSnackbar.SnackbarLayout = snackBar.view as TSnackbar.SnackbarLayout

        val customSnackBarView = LayoutInflater.from(view.context).inflate(R.layout.layout_custom_snakebar, null)

        val snackBarIcon = customSnackBarView.findViewById<AppCompatImageView>(R.id.snackBar_icon)

        val snackBarAlert = customSnackBarView.findViewById<AppCompatTextView>(R.id.alert_message)
        val snackBarSuccessAlert = customSnackBarView.findViewById<AppCompatTextView>(R.id.status)


        if (value) {
            status = view.context.getString(R.string.success)
            snackBarView.setBackgroundColor(ContextCompat.getColor(view.context, R.color.light_greenColor))
            snackBarIcon.setImageResource(R.drawable.ic_check)
            snackBarIcon.setColorFilter(ContextCompat.getColor(view.context, R.color.whiteColor))
        } else {
            status = view.context.getString(R.string.error_sorry)
            snackBarView.setBackgroundColor(ContextCompat.getColor(view.context, R.color.redColor))
            snackBarIcon.setImageResource(R.drawable.ic_warning)
            snackBarIcon.setColorFilter(ContextCompat.getColor(view.context, R.color.whiteColor))
        }

        val textView = snackBarView.findViewById<TextView>(com.androidadvance.topsnackbar.R.id.snackbar_text)
        textView.visibility = View.INVISIBLE

        snackBarAlert.text = message
        snackBarSuccessAlert.text = status

        val layoutParams = snackBarView.layoutParams
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
        layoutParams.height = 180

        snackBarView.layoutParams = layoutParams

        snackBarView.setPadding(0, 10, 10, 10)

        snackBarView.addView(customSnackBarView)

        snackBar.show()
    }

    fun hideKeyboard(view: View) {
        val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }

    fun getCircularBitmap(bitmap: Bitmap): Bitmap {
        val output: Bitmap = if (bitmap.width > bitmap.height) {
            Bitmap.createBitmap(bitmap.height, bitmap.height, Bitmap.Config.ARGB_8888)
        } else {
            Bitmap.createBitmap(bitmap.width, bitmap.width, Bitmap.Config.ARGB_8888)
        }

        val canvas = Canvas(output)

        val color = -0xbdbdbe
        val paint = Paint()
        val rect = Rect(0, 0, bitmap.width, bitmap.height)

        val rec: Float = if (bitmap.width > bitmap.height) {
            (bitmap.height / 2).toFloat()
        } else {
            (bitmap.width / 2).toFloat()
        }

        paint.isAntiAlias = true
        canvas.drawARGB(0, 0, 0, 0)
        paint.color = color
        canvas.drawCircle(rec, rec, rec, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas.drawBitmap(bitmap, rect, rect, paint)

        return output
    }

    fun getParsedDate(dateFormat: SimpleDateFormat, date: String): String {
        var parsedDate = ""
        try {
            dateFormat.timeZone = AppConstants.utcTimeZone
            val serverDate = dateFormat.parse(date)
            val appDateFormatter = AppConstants.appDateTimeFormat
            appDateFormatter.timeZone = TimeZone.getDefault()
            parsedDate = appDateFormatter.format(serverDate)
        } catch (e: Exception) {
            // Exception in parsing date
        }
        return parsedDate
    }

    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null
    }

    fun getTimeDifference(startDate: String): String {

        //HH converts hour in 24 hours format (0-23), day calculation

        try {
            val d1 = AppConstants.webPickDeliveryTimeFormat.parse(startDate)
            val d2 = Date(System.currentTimeMillis())
            //in milliseconds
            val diff = d1.time - d2.time

            val diffSeconds: Int = (diff / 1000 % 60).toInt()
            val diffMinutes: Int = (diff / (60 * 1000) % 60).toInt()
            val diffHours: Int = (diff / (60 * 60 * 1000)).toInt()
            val diffDays: Int = (diff / (24 * 60 * 60 * 1000)).toInt()

            if (diffDays > 30) {
                return AppConstants.webPickDeliveryTimeFormat.format(d1)
            }
            if (diffDays == 1) {
                return "1 day left"
            }
            if (diffDays < 1 && diffHours > 1) {
                return diffHours.toString() + " hours left"
            }
            if (diffDays > 1) {
                return diffDays.toString() + " days left"
            }
            if (diffHours == 1) {
                return "1 hour left"
            }
            if (diffHours < 1 && diffMinutes > 1) {
                return diffMinutes.toString() + " minutes left"
            }
            if (diffHours > 1) {
                return diffHours.toString() + " hours left"
            }
            if (diffMinutes == 1) {
                return "1 minute left"
            }
            if (diffMinutes < 1 && diffSeconds > 1) {
                return diffSeconds.toString() + " minutes left"
            }
            if (diffMinutes > 1) {
                return diffMinutes.toString() + " minutes left"
            }
            if (diffSeconds == 1) {
                return "1 second left"
            }
            if (diffSeconds > 1) {
                return diffSeconds.toString() + "seconds left"
            }

        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return ""
    }

    fun getCurrentDate(): String {

        val c = Calendar.getInstance()
        val webDateFormatter = AppConstants.webPickDeliveryTimeFormat
        return webDateFormatter.format(c.time)
    }

    fun compareTwoDates(d1: String, d2: String): Boolean {
        var value = false
        try {
            val date1 = AppConstants.webPickDeliveryTimeFormat.parse(d1)

            val date2 = AppConstants.webPickDeliveryTimeFormat.parse(d2)

            if (date1.compareTo(date2) < 0) {
                value = true
            }
        } catch (e1: ParseException) {
            e1.printStackTrace()
            return false
        }
        return value
    }
}
