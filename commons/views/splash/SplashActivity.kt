package skycap.com.driver.go4er.views.splash

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import dagger.android.support.DaggerAppCompatActivity
import skycap.com.driver.go4er.AppConstants
import skycap.com.driver.go4er.R
import skycap.com.driver.go4er.views.LocationActivity
import skycap.com.driver.go4er.views.home.HomeActivity
import skycap.com.driver.go4er.views.login.LoginActivity
import javax.inject.Inject


class SplashActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(SplashViewModel::class.java)
        bindObservers(viewModel)
        Handler().postDelayed({ viewModel.processNextTask() }, AppConstants.SPLASH_TIME_MILLIS)

    }

    private fun bindObservers(viewModel: SplashViewModel) {

        viewModel.userLoggedInCommand.observe(this, Observer {
            startActivity(Intent(this, LocationActivity::class.java))
            finish()
        })

        viewModel.userLogInRequestCommand.observe(this, Observer {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        })
    }
}
