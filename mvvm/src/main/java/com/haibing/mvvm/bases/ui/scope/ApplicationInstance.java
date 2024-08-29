package com.haibing.mvvm.bases.ui.scope;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

/**
 * <pre>
 *     author: 杨帆
 *     email: yangfan@haibingtech.com
 *     date: 2024/6/19 12:30
 *     desc  :
 *     history:
 * </pre>
 */
public class ApplicationInstance implements ViewModelStoreOwner {
    private final static ApplicationInstance sInstance = new ApplicationInstance();
    private ViewModelStore mAppViewModelStore;

    private ApplicationInstance() {
    }

    public static ApplicationInstance getInstance() {
        return sInstance;
    }

    @NonNull
    @Override
    public ViewModelStore getViewModelStore() {
        if (mAppViewModelStore == null) mAppViewModelStore = new ViewModelStore();
        return mAppViewModelStore;
    }
}
