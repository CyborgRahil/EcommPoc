package com.rahil.ecommpoc.appUi.test

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import androidx.test.InstrumentationRegistry
import com.rahil.ecommpoc.appUi.injection.component.DaggerTestApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import com.rahil.ecommpoc.appUi.injection.component.TestApplicationComponent
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class TestApplication: Application(), HasActivityInjector, HasSupportFragmentInjector {

    @Inject lateinit var injector: DispatchingAndroidInjector<Activity>
    @Inject lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    private lateinit var appComponent: TestApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerTestApplicationComponent.builder().application(this).build()
        appComponent.inject(this)
    }

    companion object {

        fun appComponent(): TestApplicationComponent {
            return (InstrumentationRegistry.getTargetContext().applicationContext as TestApplication).
                    appComponent
        }

    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return injector
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentInjector
    }

}