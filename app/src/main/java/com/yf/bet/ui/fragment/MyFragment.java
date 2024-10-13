package com.yf.bet.ui.fragment;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.haibing.mvvm.bases.ui.BaseFragment;
import com.yf.bet.R;
import com.yf.bet.adapter.MyRecyclerViewAdapter;
import com.yf.bet.databinding.FragmentMyBinding;
import com.yf.bet.databinding.HeaderMyBinding;
import com.yf.bet.model.NormalItem;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author: 杨帆
 *     email: yangfan@haibingtech.com
 *     date: 2024/10/7 9:39
 *     desc  :
 *     history:
 * </pre>
 */
public class MyFragment extends BaseFragment<FragmentMyBinding> {

    public static MyFragment newInstance(){
        return new MyFragment();
    }

    private HeaderMyBinding headerMyBinding;
    private List<NormalItem> dataList = new ArrayList<>();
    private MyRecyclerViewAdapter adapter;

    @Override
    protected int layoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView() {
        dataList.add(new NormalItem(getString(R.string.profile),R.mipmap.ic_launcher));
        dataList.add(new NormalItem(getString(R.string.message),R.mipmap.ic_launcher));
        dataList.add(new NormalItem(getString(R.string.recharge_withdraw),R.mipmap.ic_launcher));
        dataList.add(new NormalItem(getString(R.string.transaction_details),R.mipmap.ic_launcher));
        dataList.add(new NormalItem(getString(R.string.betting_records),R.mipmap.ic_launcher));

        adapter = new MyRecyclerViewAdapter(dataList);
        mViewBinding.swipeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mViewBinding.swipeRecyclerView.setHasFixedSize(true);
        mViewBinding.swipeRecyclerView.setAdapter(adapter);
        headerMyBinding = DataBindingUtil.inflate(getLayoutInflater(),R.layout.header_my,null,false);
        mViewBinding.swipeRecyclerView.addHeaderView(headerMyBinding.getRoot());
    }
}
