package skycap.com.driver.go4er.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import skycap.com.driver.go4er.views.LocationActivity
import skycap.com.driver.go4er.views.home.HomeActivity
import skycap.com.driver.go4er.views.home.delivery.DeliveryFragment
import skycap.com.driver.go4er.views.home.deliveryDetail.DeliveryDetailActivity
import skycap.com.driver.go4er.views.home.deliveryMapScreen.DeliveryMapScreen
import skycap.com.driver.go4er.views.home.map.MapFragment
import skycap.com.driver.go4er.views.home.messaging.MessagingFragment
import skycap.com.driver.go4er.views.home.packageDetail.PackageDetailsActivity
import skycap.com.driver.go4er.views.home.request.QuotesTab.QuotesTabFragment
import skycap.com.driver.go4er.views.home.request.RequestFragment
import skycap.com.driver.go4er.views.home.request.requestTab.RequestsTabFragment
import skycap.com.driver.go4er.views.home.settings.SettingsFragment
import skycap.com.driver.go4er.views.home.signature.SignatureActivity
import skycap.com.driver.go4er.views.login.*
import skycap.com.driver.go4er.views.login.driverActivationAccount.DriverAccountActivationActivity
import skycap.com.driver.go4er.views.login.driverActivationAccount.driverSetPassword.SetPasswordActivity
import skycap.com.driver.go4er.views.login.driverDetails.DriverDetailActivity
import skycap.com.driver.go4er.views.login.forgotPassword.ForgotpasswordActivity
import skycap.com.driver.go4er.views.login.forgotPassword.otp.OTPActivity
import skycap.com.driver.go4er.views.splash.SplashActivity
import skycap.com.driver.go4er.views.stripeAccountConfig.StripeAccountWebViewActivity


@Module
abstract class BindingsModule {

    @ContributesAndroidInjector
    abstract fun splashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun LoginActivity(): LoginActivity

 @ContributesAndroidInjector
    abstract fun LocationActivity(): LocationActivity

    @ContributesAndroidInjector
    abstract fun DriverPinActivity(): DriverAccountActivationActivity

    @ContributesAndroidInjector
    abstract fun ForgotpasswordActivity(): ForgotpasswordActivity

    @ContributesAndroidInjector
    abstract fun OTPActivity(): OTPActivity

    @ContributesAndroidInjector
    abstract fun SetPasswordActivity(): SetPasswordActivity

    @ContributesAndroidInjector
    abstract fun DriverDetailActivity(): DriverDetailActivity

    @ContributesAndroidInjector
    abstract fun homeActivity(): HomeActivity

    @ContributesAndroidInjector
    abstract fun packageDetailsActivity(): PackageDetailsActivity

   @ContributesAndroidInjector
   abstract fun StripeAccountWebViewActivity(): StripeAccountWebViewActivity

    @ContributesAndroidInjector
    abstract fun mapFragment(): MapFragment

    @ContributesAndroidInjector
    abstract fun messagingFragment(): MessagingFragment

    @ContributesAndroidInjector
    abstract fun deliveryFragment(): DeliveryFragment

    @ContributesAndroidInjector
    abstract fun requestFragment(): RequestFragment

    @ContributesAndroidInjector
    abstract fun setttingsFragment(): SettingsFragment

    @ContributesAndroidInjector
    abstract fun QuotesTabFragment(): QuotesTabFragment

    @ContributesAndroidInjector
    abstract fun RequestsTabFragment(): RequestsTabFragment

   @ContributesAndroidInjector
   abstract fun DeliveryDetailActivity(): DeliveryDetailActivity

    @ContributesAndroidInjector
    abstract fun DeliveryMapScreen(): DeliveryMapScreen

    @ContributesAndroidInjector
    abstract fun SignatureActivity(): SignatureActivity
}