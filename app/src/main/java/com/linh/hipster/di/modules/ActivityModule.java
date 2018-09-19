package com.linh.hipster.di.modules;

import dagger.Module;
import dagger.Provides;
import com.linh.hipster.di.ActivityScope;
import com.linh.hipster.ui.base.BaseActivity;

@ActivityScope
@Module
public class ActivityModule {

    protected BaseActivity baseActivity;

    public ActivityModule(BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
    }

    @Provides
    protected BaseActivity activity() {
        return baseActivity;
    }
}
