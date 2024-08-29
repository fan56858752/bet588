package com.adayo.retrofit.models.requests;

import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

/**
 * @Description 解绑三方账号
 * @Author 王小军
 * @CreateTime 2024年05月23日
 **/

public class UnbindThirdAccountRequest extends BaseRequest {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, UnbindThirdAccountRequest.class.getSimpleName());
    public String vin;
    public long accountId;
    public String appkey;
    public String version;
}
