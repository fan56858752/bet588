package com.haibing.mvvm.bases;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import androidx.viewbinding.ViewBinding;

import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

/**
 * @Description TODO
 * @Author 王小军
 * @CreateTime 2024年04月15日
 **/

public abstract class BasePopupWindow<T extends ViewBinding> extends PopupWindow {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, BasePopupWindow.class.getSimpleName());
    public T mViewBinding;
    public BasePopupWindow() {
        setWidth(computeWidth());
        setHeight(computeHeight());
        mViewBinding = onViewBinding();
        mViewBinding.getRoot().setLayoutParams(new ViewGroup.LayoutParams(computeWidth(), computeHeight()));
        setContentView(mViewBinding.getRoot());
    }


    /**
     *
     * @return viewBinding
     */
    public abstract T onViewBinding();

    /**
     *
     * @return 计算宽度
     */
    public abstract int computeWidth();

    /**
     *
     * @return 计算高度
     */
    public abstract int computeHeight();
}
