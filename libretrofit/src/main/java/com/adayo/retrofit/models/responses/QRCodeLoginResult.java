package com.adayo.retrofit.models.responses;

import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;
import com.google.gson.annotations.SerializedName;

/**
 * @Description 扫码登录后MQTT回传的结果
 * @Author 王小军
 * @CreateTime 2024年06月12日
 **/

public class QRCodeLoginResult {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, QRCodeLoginResult.class.getSimpleName());
    public int dataType;
    public String msgId;
    public String msgVersion;
    public long sendTime;
    public Data data;
    public class Data {
        @SerializedName("access_token")
        public String accessToken;
        @SerializedName("refresh_token")
        public String refreshToken;
        public UserInfo userInfo;
    }

    public class UserInfo {
        public String avatar;
        public int carOwner;
        public String nickName;
        public long userAccountId;
        public int userType;
    }
}
