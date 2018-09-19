package com.linh.hipster.application;

import android.app.Application;
import android.support.multidex.MultiDex;
import android.content.Context;

import com.linh.hipster.environment.EnvironmentConfiguration;
import com.linh.hipster.R;
import com.linh.hipster.di.components.ApplicationComponent;
import com.linh.hipster.di.ForApplication;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;






import javax.inject.Inject;

public class App extends Application {

    protected ApplicationComponent graph;

    protected RefWatcher refWatcher;

    @ForApplication
    @Inject
    protected Context context;

    @Inject
    protected EnvironmentConfiguration environmentConfiguration;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public void onCreate() {
        super.onCreate();

        LeakCanary.install(this);
        refWatcher = LeakCanary.install(this);

        
        
        
        

        graph = createComponent();

        environmentConfiguration.configure();

    }

    public RefWatcher getRefWatcher() {
        if (refWatcher == null) {
            refWatcher = LeakCanary.install(this);
        }
        return refWatcher;
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        if (graph == null) {
            createComponent();
        }
        return graph;
    }

    protected ApplicationComponent createComponent() {
        graph = ApplicationComponent.Initializer.init(this);
        graph.inject(this);
        return graph;
    }

    

    public void recreateComponents() {
        graph = ApplicationComponent.Initializer.init(this);
        graph.inject(this);
        environmentConfiguration.configure();
    }


}
