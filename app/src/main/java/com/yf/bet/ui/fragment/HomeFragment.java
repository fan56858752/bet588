package com.yf.bet.ui.fragment;

import com.haibing.mvvm.bases.ui.BaseFragment;
import com.yf.bet.R;
import com.yf.bet.databinding.FragmentHomeBinding;

/**
 * <pre>
 *     author: 杨帆
 *     email: yangfan@haibingtech.com
 *     date: 2024/10/6 11:51
 *     desc  :
 *     history:
 * </pre>
 * @author HUAWEI
 */
public class HomeFragment extends BaseFragment<FragmentHomeBinding> {

    public static HomeFragment newInstance(){
        return new HomeFragment();
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {

    }
}
