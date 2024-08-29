package com.haibing.mvvm.bases.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import com.haibing.mvvm.bases.DisposableManagerImpl;
import com.haibing.mvvm.bases.IDisposableManager;
import com.haibing.mvvm.bases.IViewModel;
import com.haibing.mvvm.utils.LogUtils;
import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * Description TODO
 * Author 王小军
 * CreateTime 2024年04月16日
 **/

public abstract class BaseDialogFragment<T extends ViewBinding> extends DialogFragment
        implements IViewModel, IDisposableManager {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, BaseDialogFragment.class.getSimpleName());
    public T mViewBinding;
    private IDisposableManager mDisposableManager = new DisposableManagerImpl();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.i(getClass() + "==>onCreate");
    }

    protected abstract T onViewBinding(LayoutInflater inflater);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LogUtils.i(getClass() + "==>onCreateView");
        mViewBinding = onViewBinding(inflater);
        return mViewBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LogUtils.i(getClass() + "==>onViewCreated");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtils.i(getClass() + "==>onDestroyView");
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtils.i(getClass() + "==>onStart");
    }


    @Override
    public void onResume() {
        super.onResume();
        LogUtils.i(getClass() + "==>onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtils.i(getClass() + "==>onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtils.i(getClass() + "==>onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.i(getClass() + "==>onDestroy");
        clearAllDisposable();
    }


    @Override
    public ViewModel getViewModel(Class clazz) {
        return new ViewModelProvider(getActivity()).get(clazz);
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
