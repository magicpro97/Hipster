package com.linh.hipster.di.components;

import dagger.Component;
import com.linh.hipster.di.ActivityScope;
import com.linh.hipster.di.modules.MainModule;
import com.linh.hipster.ui.main.MainActivity;
import com.linh.hipster.ui.main.MainFragment;

@ActivityScope
@Component(dependencies = {ApplicationComponent.class}, modules = {MainModule.class})
public interface MainComponent {

    void inject(MainActivity activity);
    void inject(MainFragment fragment);

}
