package com.linh.hipster.ui.main;

import android.os.Bundle;
import com.linh.hipster.di.ActivityScope;
import com.linh.hipster.di.components.MainComponent;
import com.linh.hipster.di.HasComponent;
import com.linh.hipster.ui.base.BaseActivity;
import com.linh.hipster.R;
import com.linh.hipster.application.App;
import com.linh.hipster.di.components.DaggerMainComponent;
import com.linh.hipster.di.modules.MainModule;



import javax.inject.Inject;

@ActivityScope
public class MainActivity extends BaseActivity<MainPresenter> implements MainView, HasComponent<MainComponent> {

    @Inject
    MainPresenter mainPresenter;

    MainComponent component;

    protected void injectModule() {
        component = DaggerMainComponent.builder().applicationComponent(App.get(this).getComponent()).mainModule(new MainModule(this)).build();
        component.inject(this);
    }

    
    @Override
    protected MainPresenter getPresenter() {
        return mainPresenter;
    }

    public void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
    }

    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    public MainComponent getComponent() {
        return component;
    }

}
