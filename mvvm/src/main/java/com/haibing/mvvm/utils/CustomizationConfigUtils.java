package com.haibing.mvvm.utils;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import com.haibing.mvvm.constants.ConfigConstants;
import com.haibing.mvvm.utils.LogUtils;
import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

/**
 * @Description 千人千面配置工具
 * @Author 王小军
 * @CreateTime 2024年07月15日
 **/

public class CustomizationConfigUtils {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, CustomizationConfigUtils.class.getSimpleName());
    private static boolean update(Context context, String key, String value, String label) {
        if(key != null && value != null) {
            ContentValues values = new ContentValues();
            values.put("userId", UserCenterUtils.getUserId());
            values.put("key", key);
            values.put("value", value);
            values.put("label", label);
            values.put("access_token", UserCenterUtils.getAccessToken(context));
            Uri uri = Uri.parse("content://com.adayo.app.usercenter/configs/");
            int row = context.getContentResolver().update(uri, values, null, null);
            return row > 0;
        } else {
            String error = "userId or key or value argument error.";
            LogUtils.w(TAG, StringUtils.concat("==>update error: ", error));
        }
        return false;
    }

    //更新座椅记忆1
    public static boolean updateSeatMemory1(Context context, int value) {
        return update(context, ConfigConstants.SEAT_MEMORY_1, String.valueOf(value), "座椅记忆1");
    }

    //更新座椅记忆2
    public static boolean updateSeatMemory2(Context context, int value) {
        return update(context, ConfigConstants.SEAT_MEMORY_2, String.valueOf(value), "座椅记忆2");
    }

    //更新座椅记忆3
    public static boolean updateSeatMemory3(Context context, int value) {
        return update(context, ConfigConstants.SEAT_MEMORY_3, String.valueOf(value), "座椅记忆3");
    }

    //更新驾驶模式
    public static boolean updateDriveMode(Context context, int value) {
        return update(context, ConfigConstants.DRIVE_MODE, String.valueOf(value), "驾驶模式");
    }
    //电动助力转向
    public static boolean updateEspMode(Context context, int value) {
        return update(context, ConfigConstants.ESP_MODE, String.valueOf(value), "电动助力转向");
    }
    //尾门最大高度
    public static boolean updateTailgateMaxHeight(Context context, int value) {
        return update(context, ConfigConstants.TAILGATE_MAX_HEIGHT, String.valueOf(value), "尾门最大高度");
    }

    //氛围灯色彩调节
    public static boolean updateRgbSetting(Context context, String value) {
        return update(context, ConfigConstants.RGB_SETTING, value, "氛围灯色彩调节");
    }

    //氛围灯亮度调节
    public static boolean updateBrightnessSetting(Context context, int value) {
        return update(context, ConfigConstants.BRIGHTNESS_SETTING, String.valueOf(value), "氛围灯亮度调节");
    }

    //氛围灯智能模式
    public static boolean updateLightIntelligentMode(Context context, int value) {
        return update(context, ConfigConstants.LIGHT_INTELLIGENT_MODE, String.valueOf(value), "氛围灯智能模式");
    }

    //伴我回家
    public static boolean updateTakeMeHome(Context context, int value) {
        return update(context, ConfigConstants.TAKE_ME_HOME, String.valueOf(value), "伴我回家");
    }

    public static boolean updateTurnFlashFrequency(Context context, int value) {
        return update(context, ConfigConstants.TURN_FLASH_FREQUENCY, String.valueOf(value), "变道转向灯闪烁次数");
    }
    //大灯高度调节
    public static boolean updateHeadlightHeight(Context context, int value) {
        return update(context, ConfigConstants.HEADLIGHT_HEIGHT, String.valueOf(value), "大灯高度调节");
    }
    //蓝牙电话隐私模式
    public static boolean updatePrivacyMode(Context context, boolean value) {
        return update(context, ConfigConstants.PRIVACY_MODE, String.valueOf(value), "蓝牙电话隐私模式");
    }
    //语言设置
    public static boolean updateLanguageSetting(Context context, int value) {
        return update(context, ConfigConstants.LANGUAGE_SETTING, String.valueOf(value), "语言设置");
    }
    //主题模式
    public static boolean updateThemeMode(Context context, int value) {
        return update(context, ConfigConstants.THEME_MODE, String.valueOf(value), "主题模式");
    }
    //速度音量补偿
    public static boolean updateVolumeCompensation(Context context, int value) {
        return update(context, ConfigConstants.VOLUME_COMPENSATION, String.valueOf(value), "速度音量补偿");
    }
    //导航混音设置
    public static boolean updateNavigationSoundSetting(Context context, Integer value) {
        return update(context, ConfigConstants.NAVIGATION_SOUND_SETTING, String.valueOf(value), "导航混音设置");
    }
    //音量平衡
    public static boolean updateVolumeBalance(Context context, String value) {
        return update(context, ConfigConstants.VOLUME_BALANCE, String.valueOf(value), "音量平衡");
    }
    //均衡器
    public static boolean updateEqualizerSetting(Context context, String value) {
        return update(context, ConfigConstants.EQUALIZER_SETTING, String.valueOf(value), "均衡器");
    }
    //自定义唤醒词
    public static boolean updateAwakeningWords(Context context, String value) {
        return update(context, ConfigConstants.AWAKENING_WORDS, String.valueOf(value), "自定义唤醒词");
    }
    //发声人选择
    public static boolean updateSpeakerSetting(Context context, int value) {
        return update(context, ConfigConstants.SPEAKER_SETTING, String.valueOf(value), "发声人选择");
    }
}
