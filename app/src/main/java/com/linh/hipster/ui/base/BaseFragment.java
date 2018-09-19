package com.linh.hipster.ui.base;

import com.linh.hipster.di.HasComponent;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.v4.app.Fragment;


public abstract class BaseFragment<P extends BasePresenter> extends Fragment {

    @CallSuper
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutResource(), container, false);
        
        return rootView;
    }

    @CallSuper
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        inject();
        
    }

    @CallSuper
    @Override
    public void onResume() {
        super.onResume();
        getPresenter().onTakeView(this);
    }

    @CallSuper
    @Override
    public void onPause() {
        super.onPause();
        getPresenter().onDropView();
    }

    @CallSuper
    @Override
    public void onDestroyView() {
        
        super.onDestroyView();
        getPresenter().onDestroy();
    }

    public BaseActivity getBaseActivity() {
        return (BaseActivity) getActivity();
    }

    @CallSuper
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }

    protected abstract void inject();

    protected abstract int getLayoutResource();

    protected abstract P getPresenter();

}
