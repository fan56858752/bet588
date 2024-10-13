package com.haibing.mvvm.bases.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.viewbinding.ViewBinding;

import com.haibing.mvvm.bases.ActivityManagerImpl;
import com.haibing.mvvm.bases.IActivityManager;
import com.haibing.mvvm.bases.ui.scope.ViewModelScope;
import com.haibing.mvvm.utils.LogUtils;

/**
 * author 王小军
 * date 2024/03/08
 */
public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity
        implements IActivityManager {
    public T mViewBinding;

    private final ViewModelScope mViewModelScope = new ViewModelScope();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        BarUtils.setStatusBarColor(this, Color.TRANSPARENT);
//        BarUtils.setStatusBarLightMode(this, true);
        super.onCreate(savedInstanceState);
        add(this);
        LogUtils.i(getClass() + "==>onCreate");
        mViewBinding = DataBindingUtil.setContentView(this,layoutId());
        mViewBinding.setLifecycleOwner(this);
        initView();
        initViewModel();
        createObserver();
    }

    protected abstract int layoutId();
    protected abstract void initView();
    /**
     * 初始化ViewModel
     */
    protected abstract void initViewModel();

    protected abstract void createObserver();

    protected abstract void removeObserver();

    /**
     * 获取Activity作用域的ViewModel
     * @param modelClass
     * @return
     * @param <V>
     */
    protected <V extends ViewModel> V getActivityScopeViewModel(@NonNull Class<V> modelClass) {
        return mViewModelScope.getActivityScopeViewModel(this, modelClass);
    }

    /**
     * 获取Application作用域的ViewModel
     * @param modelClass
     * @return
     * @param <V>
     */
    protected <V extends ViewModel> V getApplicationScopeViewModel(@NonNull Class<V> modelClass) {
        return mViewModelScope.getApplicationScopeViewModel(modelClass);
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.i(getClass() + "==>onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.i(getClass() + "==>onRestart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.i(getClass() + "==>onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.i(getClass() + "==>onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.i(getClass() + "==>onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.i(getClass() + "==>onDestroy");
        removeObserver();
        remove(this);
        mViewBinding = null;
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LogUtils.i(getClass() + "==>onAttachedToWindow");
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LogUtils.i(getClass() + "==>onDetachedFromWindow");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        LogUtils.i(getClass() + "==>onWindowFocusChanged hasFocus = " + hasFocus);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        LogUtils.i(getClass() + "==>onRestoreInstanceState");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogUtils.i(getClass() + "==>onNewIntent");
    }


    @Override
    public void add(BaseActivity baseActivity) {
        ActivityManagerImpl.newInstance().add(this);
    }

    @Override
    public void remove(BaseActivity baseActivity) {
        ActivityManagerImpl.newInstance().remove(this);
    }

    @Override
    public void finishAll() {
        ActivityManagerImpl.newInstance().finishAll();
    }
}
