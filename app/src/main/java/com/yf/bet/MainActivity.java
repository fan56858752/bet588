package com.yf.bet;

import android.util.Log;

import com.haibing.mvvm.bases.ui.BaseActivity;
import com.haibing.mvvm.utils.LogUtils;
import com.yf.bet.databinding.ActivityMainBinding;
import com.yf.bet.viewmodel.MainViewModel;

/**
 * <pre>
 *     author: 杨帆
 *     email: yangfan@haibingtech.com
 *     date: 2024/9/2 8:27
 *     desc  :
 *     history:
 * </pre>
 */
public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private MainViewModel mMainViewModel;

    @Override
    protected ActivityMainBinding onViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initViewModel() {
        mMainViewModel = getActivityScopeViewModel(MainViewModel.class);
    }

    @Override
    protected void createObserver() {
        mMainViewModel.testLiveData.observe(this,s->{
            LogUtils.d("s = " + s);
        });
    }

    @Override
    protected void removeObserver() {

    }
}
