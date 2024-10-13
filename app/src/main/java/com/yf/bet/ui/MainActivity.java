package com.yf.bet.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.haibing.mvvm.bases.ui.BaseActivity;
import com.haibing.mvvm.utils.LogUtils;
import com.yf.bet.R;
import com.yf.bet.databinding.ActivityMainBinding;
import com.yf.bet.ui.fragment.HistoryFragment;
import com.yf.bet.ui.fragment.HomeFragment;
import com.yf.bet.ui.fragment.MyFragment;
import com.yf.bet.ui.fragment.NoticeFragment;
import com.yf.bet.ui.view.CommonPagerIndicator;
import com.yf.bet.viewmodel.MainViewModel;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView;

import java.util.ArrayList;

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

    /**
     * 标题集合
     */
    private ArrayList<String> mtitles = new ArrayList();
    private ArrayList<Integer> mIconsSelected= new ArrayList();
    private ArrayList<Integer> mIconsUnSelected = new ArrayList();

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mtitles.add(getString(R.string.title_home));
        mtitles.add(getString(R.string.title_notice));
        mtitles.add(getString(R.string.title_history));
        mtitles.add(getString(R.string.title_my));
        mIconsSelected.add(R.mipmap.icon_tab1_pre);
        mIconsSelected.add(R.mipmap.icon_tab2_pre);
        mIconsSelected.add(R.mipmap.icon_tab3_pre);
        mIconsSelected.add(R.mipmap.icon_tab3_pre);
        mIconsUnSelected.add(R.mipmap.icon_tab1);
        mIconsUnSelected.add(R.mipmap.icon_tab2);
        mIconsUnSelected.add(R.mipmap.icon_tab3);
        mIconsUnSelected.add(R.mipmap.icon_tab3);
        mViewBinding.mainViewpager.setOffscreenPageLimit(mtitles.size());
        mViewBinding.mainViewpager.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                switch (position){
                    case 0:
                        return HomeFragment.newInstance();
                    case 1:
                        return NoticeFragment.newInstance();
                    case 2:
                        return HistoryFragment.newInstance();
                    case 3:
                        return MyFragment.newInstance();
                    default:
                        return null;
                }
            }

            @Override
            public int getItemCount() {
                return mtitles.size();
            }
        });

        CommonNavigator mCommonNavigator = getCommonNavigator();
        mViewBinding.magicIndicator.setNavigator(mCommonNavigator);
        mViewBinding.mainViewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                mViewBinding.magicIndicator.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mViewBinding.magicIndicator.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
                mViewBinding.magicIndicator.onPageScrollStateChanged(state);
            }
        });
    }

    private @NonNull CommonNavigator getCommonNavigator() {
        CommonNavigator mCommonNavigator = new CommonNavigator(this);
        mCommonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mtitles.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, int index) {
                CommonPagerTitleView mCommonPagerTitleView =new CommonPagerTitleView(context);
                mCommonPagerTitleView.setContentView(R.layout.main_pager_title_view);
                ImageView icon = mCommonPagerTitleView.findViewById(R.id.icon);
                TextView name = mCommonPagerTitleView.findViewById(R.id.name);
                name.setText(mtitles.get(index));
                mCommonPagerTitleView.setOnPagerTitleChangeListener(new CommonPagerTitleView.OnPagerTitleChangeListener() {
                    @Override
                    public void onSelected(int index, int totalCount) {
                        icon.setBackgroundResource(mIconsSelected.get(index));
                        name.setTextColor(context.getColor(R.color.purple_200));
                    }

                    @Override
                    public void onDeselected(int index, int totalCount) {
                        icon.setBackgroundResource(mIconsUnSelected.get(index));
                        name.setTextColor(context.getColor(R.color.color_CCC7C0));
                    }

                    @Override
                    public void onLeave(int index, int totalCount, float leavePercent, boolean leftToRight) {

                    }

                    @Override
                    public void onEnter(int index, int totalCount, float enterPercent, boolean leftToRight) {

                    }
                });
                mCommonPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mViewBinding.mainViewpager.setCurrentItem(index);
                    }
                });
                return mCommonPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                return new CommonPagerIndicator(context);
            }
        });
        mCommonNavigator.setAdjustMode(true);
        return mCommonNavigator;
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
