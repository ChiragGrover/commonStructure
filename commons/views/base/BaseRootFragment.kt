package skycap.com.driver.go4er.views.base

import android.content.Context
import skycap.com.driver.go4er.views.home.map.MapRootFragment

abstract class BaseRootFragment : BaseFragment() {
    protected var backToFirstListener: OnBackToFirstListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnBackToFirstListener) {
            backToFirstListener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnBackToFirstListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        backToFirstListener = null
    }

    override fun onBackPressedSupport(): Boolean {
        if (childFragmentManager.backStackEntryCount > 1) {
            popChild()
        } else {
            if (this is MapRootFragment) {
                _mActivity.finish()
            } else {
                backToFirstListener?.onBackToFirstFragment()
            }
        }
        return true
    }

    interface OnBackToFirstListener {
        fun onBackToFirstFragment()
    }
}
