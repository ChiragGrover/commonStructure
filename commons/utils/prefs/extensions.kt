package skycap.com.driver.go4er.utils.prefs

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.TextView
import skycap.com.driver.go4er.R

fun AppCompatActivity.setToolbar(toolbar: Toolbar, screenTitle: String, showBackButton: Boolean) {
    setSupportActionBar(toolbar)

    supportActionBar?.apply {

        toolbar.findViewById<TextView>(R.id.toolbar_title).text = screenTitle

        setDisplayHomeAsUpEnabled(showBackButton)
        setHomeButtonEnabled(showBackButton)
        setHomeAsUpIndicator(R.drawable.ic_backarrow)
        setDisplayShowTitleEnabled(false)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }
}

fun Context.getScreenHeightInDp(): Float {
    val displayMetrics = resources.displayMetrics
    return displayMetrics.heightPixels / displayMetrics.density
}

fun Context.getScreenWidthInDp(): Float {
    val displayMetrics = resources.displayMetrics
    return displayMetrics.widthPixels / displayMetrics.density
}