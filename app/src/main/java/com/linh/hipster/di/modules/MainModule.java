package com.linh.hipster.di.modules;

import dagger.Module;
import dagger.Provides;
import  com.linh.hipster.ui.main.MainActivity;

@Module
public class MainModule extends ActivityModule {

    public MainModule(MainActivity activity) {
        super(activity);
      }

}
