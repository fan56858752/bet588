package com.haibing.mvvm.bases.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.haibing.mvvm.bases.DisposableManagerImpl;
import com.haibing.mvvm.bases.IDisposableManager;
import com.haibing.mvvm.utils.LogUtils;
import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.MotionEventUtils;
import com.haibing.mvvm.utils.StringUtils;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * Description 封装dialog基类，在关键节点和方法加上日志
 * Author 王小军
 * CreateTime 2024年03月21日
 **/

public abstract class BaseDialog<T extends ViewBinding> extends Dialog
        implements DialogInterface.OnCancelListener,
        DialogInterface.OnDismissListener,
        DialogInterface.OnShowListener,
        IDisposableManager {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, BaseDialog.class.getSimpleName());
    private IDisposableManager mDisposableManager = new DisposableManagerImpl();
    public T mViewBinding;
    public BaseDialog(@NonNull Context context) {
        super(context);
        initListeners();
    }

    public BaseDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        initListeners();
    }

    protected BaseDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initListeners();
    }
    /**
     * @desc 初始化监听器
     */
    public void initListeners(){
        setOnCancelListener(this);
        setOnDismissListener(this);
        setOnShowListener(this);
    }

    public void show(){
        super.show();
        LogUtils.i(TAG, StringUtils.concat(getClass().toString(), "==>show"));
    }

    @Override
    public void dismiss() {
        super.dismiss();
        LogUtils.i(TAG, StringUtils.concat(getClass().toString(), "==>dismiss"));
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LogUtils.i(TAG, StringUtils.concat(getClass().toString(), "==>onAttachedToWindow"));
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LogUtils.i(TAG, StringUtils.concat(getClass().toString(), "==>onDetachedFromWindow"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.i(TAG, StringUtils.concat(getClass().toString(), "==>onCreate"));
        mViewBinding = onViewBinding();
        setContentView(mViewBinding.getRoot());
    }
    protected abstract T onViewBinding();


    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.i(TAG, StringUtils.concat(getClass().toString(), "==>onStart"));
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.i(TAG, StringUtils.concat(getClass().toString(), "==>onStop"));
        clearAllDisposable();
    }



    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event) {
        LogUtils.i(TAG, StringUtils.concat(getClass().toString(), "==>onTouchEvent MotionEvent actionName = ", MotionEventUtils.getActionName(event)));
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(@NonNull MotionEvent ev) {
        LogUtils.i(TAG, StringUtils.concat(getClass().toString(), "==>dispatchTouchEvent MotionEvent actionName = ", MotionEventUtils.getActionName(ev)));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        LogUtils.i(TAG, StringUtils.concat(getClass().toString(), "==>onBackPressed"));
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        LogUtils.i(TAG, StringUtils.concat(getClass().toString(), "==>onContentChanged"));
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        LogUtils.i(TAG, StringUtils.concat(getClass().toString(), "==>onWindowFocusChanged"));
    }

    @Override
    public void onCancel(DialogInterface dialogInterface) {
        LogUtils.i(TAG, StringUtils.concat(getClass().toString(), "==>onCancel"));
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {
        LogUtils.i(TAG, StringUtils.concat(getClass().toString(), "==>onDismiss"));
    }

    @Override
    public void onShow(DialogInterface dialogInterface) {
        LogUtils.i(TAG, StringUtils.concat(getClass().toString(), "==>onShow"));
    }

    @Override
    public void addDisposable(Disposable disposable) {
        mDisposableManager.addDisposable(disposable);
    }

    @Override
    public void clearAllDisposable() {
        mDisposableManager.clearAllDisposable();
    }

    @Override
    public CompositeDisposable getCompositeDisposable() {
        return mDisposableManager.getCompositeDisposable();
    }

}
