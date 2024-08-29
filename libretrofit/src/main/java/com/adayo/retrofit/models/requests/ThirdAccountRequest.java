package com.adayo.retrofit.models.requests;

import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

/**
 * @Description 第三方账号列表请求参数
 * @Author 王小军
 * @CreateTime 2024年05月22日
 **/

public class ThirdAccountRequest extends BaseRequest {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, ThirdAccountRequest.class.getSimpleName());
    public String vin;
    public long accountId;
    public int currentPage = 1;//默认第一页
    public int pageSize = 20;//默认20条
}
