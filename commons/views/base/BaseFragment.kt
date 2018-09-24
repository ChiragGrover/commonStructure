package skycap.com.driver.go4er.views.base

import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.annotation.DrawableRes
import android.support.annotation.LayoutRes
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.yokeyword.fragmentation.SupportFragment

open class BaseFragment : SupportFragment() {


    protected open fun inject() {}

    @LayoutRes
    protected open fun layoutRes(): Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return if (layoutRes() == 0) {
            super.onCreateView(inflater, container, savedInstanceState)
        } else {
            inflater.inflate(layoutRes(), container, false)
        }
    }

    @Suppress("OverridingDeprecatedMember", "DEPRECATION")
    override fun onAttach(activity: Activity) {
        /*
        * Perform injection here before M, L (API 22) and below because onAttach(Context)
        * is not yet available at L.
        * */
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            inject()
        }
        super.onAttach(activity)
    }

    override fun onAttach(context: Context) {
        /*
        * Perform injection here for M (API 23) due to deprecation of onAttach(Activity).
        * */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            inject()
        }
        super.onAttach(context)
    }

    protected fun initToolbarNav(toolbar: Toolbar) {
//        toolbar.setNavigationIcon(R.drawable.ic_back_button)
        toolbar.setNavigationOnClickListener { _mActivity.onBackPressed() }
    }

    protected fun setNavigationBar(toolbar: Toolbar, title: String, showBackButton: Boolean = false, @DrawableRes backIconRes: Int? = null) {

        title.let {
//            toolbar.findViewById<TextView>(R.id.toolbar_title).text = title
        }

        toolbar.showOverflowMenu()

        if (showBackButton) {
//            toolbar.setNavigationIcon(backIconRes ?: R.drawable.ic_back_button)
            toolbar.setNavigationOnClickListener { _mActivity.onBackPressed() }
        }
    }
}
