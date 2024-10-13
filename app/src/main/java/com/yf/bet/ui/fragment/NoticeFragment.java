package com.yf.bet.ui.fragment;

import android.view.LayoutInflater;

import com.haibing.mvvm.bases.ui.BaseFragment;
import com.yf.bet.R;
import com.yf.bet.databinding.FragmentHomeBinding;

/**
 * <pre>
 *     author: 杨帆
 *     email: yangfan@haibingtech.com
 *     date: 2024/10/7 9:37
 *     desc  :
 *     history:
 * </pre>
 */
public class NoticeFragment extends BaseFragment<FragmentHomeBinding> {

    public static NoticeFragment newInstance() {
        return new NoticeFragment();
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {

    }
}
