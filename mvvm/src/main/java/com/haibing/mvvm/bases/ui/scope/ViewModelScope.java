package com.haibing.mvvm.bases.ui.scope;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * author : 杨帆
 * Email: yangfan@haibingtech.com
 * date: 2024/6/19 12:30
 * Description:
 * History:

 */
public class ViewModelScope {
    private ViewModelProvider mFragmentProvider;
    private ViewModelProvider mActivityProvider;
    private ViewModelProvider mApplicationProvider;

    public <T extends ViewModel> T getFragmentScopeViewModel(@NonNull Fragment fragment, @NonNull Class<T> modelClass) {
        if (mFragmentProvider == null) mFragmentProvider = new ViewModelProvider(fragment);
        return mFragmentProvider.get(modelClass);
    }

    public <T extends ViewModel> T getActivityScopeViewModel(@NonNull AppCompatActivity activity, @NonNull Class<T> modelClass) {
        if (mActivityProvider == null) mActivityProvider = new ViewModelProvider(activity);
        return mActivityProvider.get(modelClass);
    }

    public <T extends ViewModel> T getApplicationScopeViewModel(@NonNull Class<T> modelClass) {
        if (mApplicationProvider == null)
            mApplicationProvider = new ViewModelProvider(ApplicationInstance.getInstance());
        return mApplicationProvider.get(modelClass);
    }
}
