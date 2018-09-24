
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import skycap.com.driver.go4er.App
import javax.inject.Singleton

@Component(modules = [
    AndroidSupportInjectionModule::class,
    BindingsModule::class,
    AppModule::class,
    NetworkModule::class,
    ViewModelsModule::class

])

@Singleton
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}