package com.linh.hipster.environment;

import android.app.Application;
import android.os.StrictMode;

import com.linh.hipster.BuildConfig;
import com.linh.hipster.di.ForApplication;

import javax.inject.Inject;
import javax.inject.Singleton;
import rx.schedulers.Schedulers;




@Singleton
public class EnvironmentConfiguration {

    @Inject
    @ForApplication
    Application app;

    @Inject
    public EnvironmentConfiguration() {
    }

    public void configure() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build());
        
        
    }

}
