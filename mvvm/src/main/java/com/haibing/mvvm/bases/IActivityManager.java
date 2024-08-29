package com.haibing.mvvm.bases;

import com.haibing.mvvm.bases.ui.BaseActivity;

/**
 * @author 王小军
 * @date 2024/03/08
 */
public interface IActivityManager {
    void add(BaseActivity baseActivity);
    void remove(BaseActivity baseActivity);
    void finishAll();
}
