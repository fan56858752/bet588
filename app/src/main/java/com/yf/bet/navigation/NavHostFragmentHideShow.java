package com.yf.bet.navigation;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.navigation.Navigator;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.navigation.fragment.NavHostFragment;

import com.yf.bet.R;

/**
 * <pre>
 *     author: 杨帆
 *     email: yangfan@haibingtech.com
 *     date: 2024/10/7 7:50
 *     desc  :
 *     history:
 * </pre>
 * @author HUAWEI
 */
public class NavHostFragmentHideShow extends NavHostFragment {

    private int getContainerId(){
        int id = getId();
        if(id != 0 && id != View.NO_ID){
            return id;
        } else {
            return androidx.navigation.fragment.R.id.nav_host_fragment_container;
        }

    }

//    @NonNull
//    @Override
//    protected Navigator<? extends FragmentNavigator.Destination> createFragmentNavigator() {
//        return new FragmentNavigatorHideShow(requireContext(), getChildFragmentManager(), getContainerId());
//    }
}
