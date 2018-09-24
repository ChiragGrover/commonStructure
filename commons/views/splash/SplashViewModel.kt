package skycap.com.driver.go4er.views.splash

import android.arch.lifecycle.ViewModel
import skycap.com.driver.go4er.di.SingleLiveEvent
import skycap.com.driver.go4er.utils.prefs.SharedPrefsHelperImpl
import javax.inject.Inject

/**
 * Created by Chirag.
 * Created on 03/09/18.
 */
class SplashViewModel @Inject constructor(private val sharedPrefsHelperImpl: SharedPrefsHelperImpl) : ViewModel() {

    val userLoggedInCommand = SingleLiveEvent<Boolean>()

    val userLogInRequestCommand = SingleLiveEvent<Boolean>()

    fun processNextTask() {

        val user = sharedPrefsHelperImpl.getUser()
        if (user != null) {
            if (user.id != null) {
                userLoggedInCommand.postValue(true)
            } else {
                userLogInRequestCommand.postValue(true)
            }
        } else {
            userLogInRequestCommand.postValue(true)
        }
    }
}