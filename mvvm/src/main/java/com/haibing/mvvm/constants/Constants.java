package com.haibing.mvvm.constants;

import com.haibing.mvvm.utils.StringUtils;

/**
 * @Description 常量配置
 * @Author 王小军
 * @CreateTime 2024年05月28日
 **/

public class Constants {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, Constants.class.getSimpleName());
    public static final String SERVER_URL = "ssl://emq-test-single.bjev.com.cn:8883";
    public static final String VIN = "LURJAVBW4PSB25016";
    public static final String ICCID = "89860919730063615136";
    public static final String PDSN = "898609197300636151360063615136";
    public static final String PROJECT_CODE = "C37TB";
    public static final String PROJECT_KEY = "6e2da935bbb0262b1e5c349a1a0c0a31";

    public static final String MQTT_MESSAGE_ACTION = "com.adayo.mqtt";
}
