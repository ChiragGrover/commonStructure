package skycap.com.driver.go4er

import android.content.Context
import android.support.multidex.MultiDex
import com.facebook.drawee.backends.pipeline.Fresco
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import skycap.com.driver.go4er.AppConstants
import skycap.com.driver.go4er.di.DaggerAppComponent
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

class App : DaggerApplication() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)

        if (BuildConfig.BUILD_TYPE != AppConstants.BUILD_TYPE_DEV) {
            Fabric.with(this, Crashlytics())
        }

    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerAppComponent.builder().create(this)
}