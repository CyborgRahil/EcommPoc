package com.rahil.ecommpoc.appUi

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import androidx.multidex.BuildConfig
import com.google.android.gms.security.ProviderInstaller
import com.rahil.ecommpoc.appUi.injection.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import timber.log.Timber
import javax.inject.Inject
import javax.net.ssl.SSLContext


class EcommApplication : Application(), HasActivityInjector , HasSupportFragmentInjector{

    @Inject lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    @Inject lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate() {
        super.onCreate()
        ///SSL handshake terminated errors and using Android 4.0 devices, you will
        // need to enable TLS v1.2 explicitly. Android has supported TLS 1.2 since API 16
        // (Android 4.1). You also should ensure you are using the latest
        // OpenSSL by using the ProviderInstaller
        // https://guides.codepath.com/android/Using-OkHttp#enabling-tls-v1-2-on-older-devices
        try {
            // Google Play will install latest OpenSSL
            ProviderInstaller.installIfNeeded(getApplicationContext());
            var sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(null, null, null);
            sslContext.createSSLEngine();
        } catch (e: Exception) {
            e.printStackTrace();
        }

        DaggerApplicationComponent
                .builder()
                .application(this)
                .build()
                .inject(this)
        setupTimber()
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return  fragmentInjector
    }
}
