package com.haibing.mvvm.utils;

import android.content.Context;
import android.database.ContentObserver;
import android.provider.Settings;

import com.haibing.mvvm.constants.GlobalConstants;

/**
 * @Description 工具
 * @Author 王小军
 * @CreateTime 2024年08月14日
 **/

public class SystemSettingsUtils {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, SystemSettingsUtils.class.getSimpleName());
    public static <T> boolean setValue(Context context, String key, T value) {
        boolean result = false;
        if(context != null && key != null && value != null) {
            if(value instanceof Integer) {
                result = Settings.System.putInt(context.getContentResolver(), key, (Integer) value);
            } else if(value instanceof Float) {
                result = Settings.System.putFloat(context.getContentResolver(), key, (Float) value);
            } else if(value instanceof Long) {
                result = Settings.System.putLong(context.getContentResolver(), key, (Long) value);
            } else if(value instanceof String) {
                result = Settings.System.putString(context.getContentResolver(), key, (String) value);
            }
        }
        return result;
    }
    
    public static Integer getIntValue(Context context, String key) {
        if(context != null && key != null) {
            try {
                return Settings.System.getInt(context.getContentResolver(), key);
            } catch (Throwable t){
                t.printStackTrace();
                String localizedMessage = t.getLocalizedMessage();
                if(localizedMessage != null) {
                    LogUtils.w(TAG, localizedMessage);
                }
            }
        }
        return null;
    }

    public static Float getFloatValue(Context context, String key) {
        if(context != null && key != null) {
            try {
                return Settings.System.getFloat(context.getContentResolver(), key);
            } catch (Throwable t){
                t.printStackTrace();
                String localizedMessage = t.getLocalizedMessage();
                if(localizedMessage != null) {
                    LogUtils.w(TAG, localizedMessage);
                }
            }
        }
        return null;
    }

    public static Long getLongValue(Context context, String key) {
        if(context != null && key != null) {
            try {
                return Settings.System.getLong(context.getContentResolver(), key);
            } catch (Throwable t){
                t.printStackTrace();
                String localizedMessage = t.getLocalizedMessage();
                if(localizedMessage != null) {
                    LogUtils.w(TAG, localizedMessage);
                }
            }
        }
        return null;
    }

    public static String getStringValue(Context context, String key) {
        if(context != null && key != null) {
            return Settings.System.getString(context.getContentResolver(), key);
        }
        return null;
    }
    
    public static void registerContentObserver(Context context, String key, ContentObserver contentObserver) {
        if(context != null && key != null && contentObserver != null) {
            context.getContentResolver().registerContentObserver(Settings.System.getUriFor(key), false, contentObserver);
        }
    }
    
    public static void unregisterContentObserver(Context context, ContentObserver contentObserver) {
        if(context != null && contentObserver != null) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }
}
