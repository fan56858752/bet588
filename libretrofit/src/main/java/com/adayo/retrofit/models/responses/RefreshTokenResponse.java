package com.adayo.retrofit.models.responses;

import com.haibing.mvvm.utils.LogUtils;
import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;
import com.google.gson.annotations.SerializedName;

/**
 * @Description TODO
 * @Author 王小军
 * @CreateTime 2024年05月29日
 **/

public class RefreshTokenResponse extends BaseResponse {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, RefreshTokenResponse.class.getSimpleName());
    public Data data;
    public class Data {
        @SerializedName("access_token")
        public String accessToken;
        @SerializedName("refresh_token")
        public String refreshToken;

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Data{");
            sb.append("accessToken='").append(accessToken).append('\'');
            sb.append(", refreshToken='").append(refreshToken).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RefreshTokenResponse{");
        sb.append("data=").append(data);
        sb.append(", statusCode='").append(statusCode).append('\'');
        sb.append(", statusMessage='").append(statusMessage).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
