package com.linh.hipster.di.components;

import javax.inject.Singleton;

import dagger.Component;
import com.linh.hipster.application.App;
import com.linh.hipster.util.gson.GsonModule;
import com.linh.hipster.environment.EnvironmentModule;
import com.linh.hipster.di.ForApplication;
import com.linh.hipster.di.components.DaggerApplicationComponent;
import com.linh.hipster.di.modules.AndroidModule;
import com.linh.hipster.di.modules.ApplicationModule;
import com.linh.hipster.environment.EnvironmentConfiguration;
import com.linh.hipster.network.OkHttpInterceptorsModule;
import com.linh.hipster.util.gson.GsonModule;

import android.content.Context;

import com.linh.hipster.domain.executors.ThreadExecutor;
import com.linh.hipster.storage.Storage;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;
import android.support.annotation.NonNull;




// android-hipster-needle-component-injection-import

@Singleton
@Component(modules = {
        ApplicationModule.class,
        AndroidModule.class,
        GsonModule.class,
        OkHttpInterceptorsModule.class,
        EnvironmentModule.class}
)
public interface ApplicationComponent {

    ThreadExecutor provideThreadExecutor();

    Storage provideStorage();

    Retrofit provideRetrofit();

    @ForApplication
    Context provideContext();

    Gson provideGson();

    

    void inject(App app);

    // android-hipster-needle-component-injection-method

    final class Initializer {
          public static ApplicationComponent init(App app) {
              return DaggerApplicationComponent.builder()
                            .androidModule(new AndroidModule())
                            .gsonModule(new GsonModule())
                            .applicationModule(new ApplicationModule(app))
                            .environmentModule(new EnvironmentModule(app))
                            .okHttpInterceptorsModule(new OkHttpInterceptorsModule())
                            .build();
          }
    }

}
