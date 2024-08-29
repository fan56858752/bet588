package com.adayo.retrofit.models.responses;

import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

/**
 * @Description 二维码响应类
 * @Author 王小军
 * @CreateTime 2024年05月20日
 **/

public class QRCodeResponse extends BaseResponse {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, QRCodeResponse.class.getSimpleName());
    public Data data;
    public class Data {
        public String randomCode;
        public Long vaildTime;
    }
}
