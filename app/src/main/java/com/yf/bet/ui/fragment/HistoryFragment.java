package com.yf.bet.ui.fragment;

import android.view.LayoutInflater;

import com.haibing.mvvm.bases.ui.BaseFragment;
import com.yf.bet.R;
import com.yf.bet.databinding.FragmentHomeBinding;

/**
 * <pre>
 *     author: 杨帆
 *     email: yangfan@haibingtech.com
 *     date: 2024/10/7 9:38
 *     desc  :
 *     history:
 * </pre>
 */
public class HistoryFragment extends BaseFragment<FragmentHomeBinding> {

    public static HistoryFragment newInstance(){
        return new HistoryFragment();
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {

    }
}
