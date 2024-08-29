package com.adayo.retrofit.models.responses;

import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

/**
 * @Description TODO
 * @Author 王小军
 * @CreateTime 2024年05月17日
 **/

public class BaseResponse {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, BaseResponse.class.getSimpleName());
    public String statusCode;
    public String statusMessage;

    @Override
    public String toString() {
        return "BaseResponse{" +
                "statusCode='" + statusCode + '\'' +
                ", statusMessage='" + statusMessage + '\'' +
                '}';
    }
}
