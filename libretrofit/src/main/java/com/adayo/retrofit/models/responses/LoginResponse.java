package com.adayo.retrofit.models.responses;

import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;
import com.google.gson.annotations.SerializedName;

/**
 * @Description 登录响应数据
 * @Author 王小军
 * @CreateTime 2024年05月17日
 **/

public class LoginResponse extends BaseResponse {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, LoginResponse.class.getSimpleName());

    public Data data;
    public long respTime;


    public class Data {
        public UserInfo userInfo;
        @SerializedName("refresh-token")
        public String refreshToken;
        @SerializedName("access-token")
        public String accessToken;

        @Override
        public String toString() {
            return "Data{" +
                    "userInfo=" + userInfo +
                    ", refreshToken='" + refreshToken + '\'' +
                    ", accessToken='" + accessToken + '\'' +
                    '}';
        }
    }
    public class UserInfo {
        public long userAccountId;
        public String avatar;
        public String nickName;
        public int userType;
        public int carOwner;

        @Override
        public String toString() {
            return "UserInfo{" +
                    "userAccountId=" + userAccountId +
                    ", avatar='" + avatar + '\'' +
                    ", nickName='" + nickName + '\'' +
                    ", userType=" + userType +
                    ", carOwner=" + carOwner +
                    '}';
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LoginResponse{");
        sb.append("statusCode='").append(statusCode).append('\'');
        sb.append(", statusMessage='").append(statusMessage).append('\'');
        sb.append(", data=").append(data);
        sb.append(", respTime=").append(respTime);
        sb.append('}');
        return sb.toString();
    }
}
