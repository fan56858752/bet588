package com.haibing.mvvm.constants;

import com.haibing.mvvm.BuildConfig;
import com.haibing.mvvm.utils.StringUtils;

public class GlobalConstants {
    public static final String TAG_PREFIXES = StringUtils.concat("mvvm-", "mvvm", "-");
    public static final String NOTIFICATION_GROUP_ERROR = "error";
    public static final String NOTIFICATION_GROUP_APPLICATION = "application";
    public static final String NOTIFICATION_GROUP_SYSTEM = "system";
    public static final String CHANNEL_ID_DYNAMIC_ISLAND = "channel_dynamic_island";
    public static final String CHANNEL_ID_ORDINARY_MESSAGE = "channel_ordinary_message";
    public static final String CHANNEL_ID_STATUS_BAR_MESSAGE = "channel_status_bar_message";

    public static final String TAG_OTA = "tag_ota_upgrade";
}
