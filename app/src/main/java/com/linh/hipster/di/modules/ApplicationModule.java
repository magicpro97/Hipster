package com.linh.hipster.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import javax.inject.Named;
import javax.inject.Singleton;
import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import com.linh.hipster.application.App;
import com.linh.hipster.di.ForApplication;
import com.linh.hipster.storage.Storage;
import com.linh.hipster.domain.executors.JobExecutor;
import com.linh.hipster.domain.executors.ThreadExecutor;


import rx.Scheduler;
import rx.schedulers.Schedulers;


// android-hipster-needle-module-provides-import

@Module
public class ApplicationModule {

    public static final String MAIN_THREAD_HANDLER = "main_thread_handler";

    protected App application;

    public ApplicationModule(App application) {
        this.application = application;
    }

    @ForApplication
    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }

    @ForApplication
    @Provides
    @Singleton
    public App provideApp() {
        return application;
    }

    @Provides
    @Singleton
    public Scheduler provideScheduler() {
        return Schedulers.from(new JobExecutor());
    }

    @ForApplication
    @Provides
    @Singleton
    public Context provideContext() {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    public ThreadExecutor provideThreadExecutor() {
        return new JobExecutor();
    }

    @Provides
    @Singleton
    Storage provideStorage(Gson gson, SharedPreferences preferences) {
        return new Storage(preferences, gson);
    }

    

    @Provides @NonNull @Named(MAIN_THREAD_HANDLER) @Singleton
    public Handler provideMainThreadHandler() {
        return new Handler(Looper.getMainLooper());
    }

    


    // android-hipster-needle-module-provides-method

}
