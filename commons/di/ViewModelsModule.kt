package skycap.com.driver.go4er.di
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import skycap.com.driver.go4er.views.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import skycap.com.driver.go4er.views.home.delivery.DeliveryViewModel
import skycap.com.driver.go4er.views.home.deliveryDetail.DeliveryDetailViewModel
import skycap.com.driver.go4er.views.home.deliveryMapScreen.DeliveryMapScreenViewModel
import skycap.com.driver.go4er.views.home.map.MapViewModel
import skycap.com.driver.go4er.views.home.messaging.MessagingViewModel
import skycap.com.driver.go4er.views.home.packageDetail.PackageDetailViewModel
import skycap.com.driver.go4er.views.home.request.QuotesTab.QuotesTabViewModel
import skycap.com.driver.go4er.views.home.request.RequestViewModel
import skycap.com.driver.go4er.views.home.request.requestTab.RequestTabViewModel
import skycap.com.driver.go4er.views.home.settings.SettingsViewModel
import skycap.com.driver.go4er.views.home.signature.SignatureViewModel
import skycap.com.driver.go4er.views.login.LoginViewModel
import skycap.com.driver.go4er.views.login.driverActivationAccount.DriverAccountActivationViewModel
import skycap.com.driver.go4er.views.login.driverActivationAccount.driverSetPassword.SetPasswordViewModel
import skycap.com.driver.go4er.views.login.driverDetails.DriverDetailViewModel
import skycap.com.driver.go4er.views.login.forgotPassword.ForgotPasswordViewModel
import skycap.com.driver.go4er.views.stripeAccountConfig.StripeAccountViewModel
import javax.inject.Singleton
@Module
abstract class ViewModelsModule {

    @Module
    companion object {
        @Provides
        @Singleton
        @JvmStatic
        fun viewModelProviderFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory = factory
    }

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(viewModel: SplashViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(viewModel: LoginViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ForgotPasswordViewModel::class)
    abstract fun bindForgotPasswordViewModel(viewModel: ForgotPasswordViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DriverAccountActivationViewModel::class)
    abstract fun bindDriverAccountActivationViewModel(viewModel: DriverAccountActivationViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DriverDetailViewModel::class)
    abstract fun bindDriverDetailViewModel(viewModel: DriverDetailViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MapViewModel::class)
    abstract fun bindMapViewModel(viewModel: MapViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RequestViewModel::class)
    abstract fun bindRequestViewModel(viewModel: RequestViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DeliveryViewModel::class)
    abstract fun bindDeliveryViewModel(viewModel: DeliveryViewModel):ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(SettingsViewModel::class)
    abstract fun bindSettingsViewModel(viewModel: SettingsViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RequestTabViewModel::class)
    abstract fun bindRequestTabViewModel(viewModel: RequestTabViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(QuotesTabViewModel::class)
    abstract fun bindQuotesTabViewModel(viewModel: QuotesTabViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PackageDetailViewModel::class)
    abstract fun bindPackageDetailViewModel(viewModel: PackageDetailViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SetPasswordViewModel::class)
    abstract fun bindSetPasswordViewModel(viewModel: SetPasswordViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DeliveryDetailViewModel::class)
    abstract fun bindDeliveryDetailViewModel(viewModel: DeliveryDetailViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(StripeAccountViewModel::class)
    abstract fun bindStripeAccountViewModel(viewModel: StripeAccountViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MessagingViewModel::class)
    abstract fun bindMessagingViewModel(viewModel: MessagingViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DeliveryMapScreenViewModel::class)
    abstract fun bindDeliveryMapScreenViewModel(viewModel: DeliveryMapScreenViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SignatureViewModel::class)
    abstract fun bindSignatureViewModel(viewModel: SignatureViewModel):ViewModel

}