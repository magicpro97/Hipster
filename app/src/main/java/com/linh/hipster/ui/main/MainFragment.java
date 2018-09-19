package com.linh.hipster.ui.main;

import com.linh.hipster.di.components.MainComponent;
import com.linh.hipster.ui.base.BaseFragment;
import com.linh.hipster.ui.base.EmptyPresenter;
import com.linh.hipster.R;

public class MainFragment extends BaseFragment<EmptyPresenter> {

    @Override
    protected void inject() {
        getComponent(MainComponent.class).inject(this);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_main;
    }

    @Override
    protected EmptyPresenter getPresenter() {
        return new EmptyPresenter();
    }


}
