package com.adayo.retrofit.models.requests;

import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

/**
 * @Description 登录请求参数
 * @Author 王小军
 * @CreateTime 2024年05月17日
 **/

public class LoginRequest {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, LoginRequest.class.getSimpleName());
    public String userId;
    public String appid;
}
