package com.adayo.retrofit.models;

import com.haibing.mvvm.utils.LogUtils;
import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

/**
 * @Description token实体封装
 * @Author 王小军
 * @CreateTime 2024年05月27日
 **/

public class Token {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, Token.class.getSimpleName());
    public String mAccessToken;
    public String mRefreshToken;

    public String getAccessToken() {
        return mAccessToken;
    }

    public void setAccessToken(String accessToken) {
        this.mAccessToken = accessToken;
    }

    public String getRefreshToken() {
        return mRefreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.mRefreshToken = refreshToken;
    }
}
