package com.adayo.retrofit.models.responses;

import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

/**
 * @Description 短信验证码响应类
 * @Author 王小军
 * @CreateTime 2024年05月20日
 **/

public class SmsCodeResponse extends BaseResponse {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, SmsCodeResponse.class.getSimpleName());
    public long respTime;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SmsCodeResponse{");
        sb.append("statusCode='").append(statusCode).append('\'');
        sb.append(", statusMessage='").append(statusMessage).append('\'');
        sb.append(", respTime=").append(respTime);
        sb.append('}');
        return sb.toString();
    }
}
