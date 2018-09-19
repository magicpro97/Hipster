package com.linh.hipster.util.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;




import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class GsonModule {

    @Provides
    @Singleton
    public GsonBuilder provideDefaultGsonBuilder() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        
        
        gsonBuilder.registerTypeAdapterFactory(new AutoValueTypeAdapterFactory());

        return gsonBuilder;
    }

    @Provides
    @Singleton
    public Gson provideGson(GsonBuilder gsonBuilder) {
        return gsonBuilder.create();
    }

}
