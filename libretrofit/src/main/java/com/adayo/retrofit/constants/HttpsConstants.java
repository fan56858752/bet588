package com.adayo.retrofit.constants;

import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

/**
 * @Description 常量
 * @Author 王小军
 * @CreateTime 2024年05月17日
 **/

public class HttpsConstants {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, HttpsConstants.class.getSimpleName());
    public static final String PROJECT_KEY = "6e2da935bbb0262b1e5c349a1a0c0a31";
    public static final String API_HOST_PRO = "https://ivstsptest.bjev.com.cn";//需要双向认证，车机需要导入证书
    public static final String API_HOST_TEST = "https://testicctsp.bjev.com.cn";//单向认证，只认证服务器
    public static final String PATH_LOGIN = "/auth/userLogin";
    public static final String PATH_REQUEST_QR_CODE = "/vcm/getQRRandomCode/{vin}/{pdsn}";
    public static final String PATH_REQUEST_SMS_CODE = "/vcm/getIdentifyCodeV2/{phone}";
    public static final String PATH_LOGOUT = "/auth/logout";
    public static final String PATH_THIRD_ACCOUNTS = "/app/account/applist";
    public static final String PATH_UNBIND_THIRD_ACCOUNT = "/app/account/unLink";
    public static final String PATH_REFRESH_TOKEN = "/auth/forceRefreshToken";

    public static final String PATH_CONFIGS = "user/userSetting/getAll";
    public static final String PATH_SAVE_SINGLE_CONFIG = "user/userSetting/saveSingleConfig";
    public static final String PATH_GET_SINGLE_CONFIG = "user/userSetting/getSingleConfig";
}
