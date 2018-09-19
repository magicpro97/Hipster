package com.linh.hipster.ui.base;

import com.linh.hipster.application.App;
import android.os.Bundle;
import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.v7.app.AppCompatActivity;

import com.squareup.leakcanary.RefWatcher;


import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import com.linh.hipster.util.EspressoIdlingResource;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    @CallSuper
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        injectModule();
        
        getPresenter().onDestroy();
    }

    protected abstract void injectModule();

    protected abstract int getLayoutResource();

    @CallSuper
    @Override
    public void onDestroy() {
        
        super.onDestroy();
        RefWatcher refWatcher = App.get(this).getRefWatcher();
        refWatcher.watch(this);
    }

    


    
    @CallSuper
    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().onTakeView(this);
    }

    @CallSuper
    @Override
    protected void onPause() {
        super.onPause();
        getPresenter().onDropView();
    }

    protected abstract P getPresenter();
    
}
