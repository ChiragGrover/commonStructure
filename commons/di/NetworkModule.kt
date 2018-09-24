package skycap.com.driver.go4er.di

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import skycap.com.driver.go4er.AppConstants
import skycap.com.driver.go4er.BuildConfig
import skycap.com.driver.go4er.data.apis.GoogleApiServices
import skycap.com.driver.go4er.data.apis.WebServices
import skycap.com.driver.go4er.utils.AuthInterceptor
import skycap.com.driver.go4er.utils.prefs.SharedPrefsHelperImpl
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
object NetworkModule {

    @Provides
    @Singleton
    @JvmStatic
    fun okHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {

        return OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS)
                .addInterceptor(getHttpLoggingInterceptor())
                .addInterceptor(authInterceptor)
                .build()
    }

    @Provides
    @Singleton
    @JvmStatic
    fun retrofit(client: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
    }

    @Provides
    @Singleton
    @JvmStatic
    fun refreshTokenInterceptor(helper: SharedPrefsHelperImpl, gson: Gson): AuthInterceptor = AuthInterceptor(helper, gson)

    @Provides
    @Singleton
    @JvmStatic
    fun webService(retrofit: Retrofit): WebServices = retrofit.create(WebServices::class.java)

    @Provides
    @Singleton
    @JvmStatic
    fun googleApiService(): GoogleApiServices {

        val client = OkHttpClient.Builder()
                .addInterceptor(getHttpLoggingInterceptor())
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()

        val retrofit = Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(AppConstants.GOOGLE_API_BASE_URL)
                .client(client)
                .build()

        return retrofit.create(GoogleApiServices::class.java)
    }

    private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }
}