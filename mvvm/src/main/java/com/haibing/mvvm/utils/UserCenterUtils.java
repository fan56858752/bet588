package com.haibing.mvvm.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;

import com.haibing.mvvm.constants.GlobalConstants;

/**
 * @Description 用户中心工具
 * @Author 王小军
 * @CreateTime 2024年07月09日
 **/

public class UserCenterUtils {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, UserCenterUtils.class.getSimpleName());
    public static void setLogin(boolean isLogin) {
        SystemProperties.set("com.adayo.app.usercenter.isLogin", String.valueOf(isLogin));
    }
    public static boolean isLogin() {
        try {
            String login = SystemProperties.get("com.adayo.app.usercenter.isLogin", "false");
            return Boolean.parseBoolean(login);
        } catch (Throwable t){
            t.printStackTrace();
            LogUtils.w(TAG, t.getLocalizedMessage());
        }
        return false;
    }
    public static void setUserId(long userId) {
        SystemProperties.set("com.adayo.app.usercenter.userId", String.valueOf(userId));
    }

    //-1代表未登录
    public static long getUserId() {
        try {
            String userIdString = SystemProperties.get("com.adayo.app.usercenter.userId", "-1");
             return Long.parseLong(userIdString);
        } catch (Throwable t){
            t.printStackTrace();
            LogUtils.w(TAG, t.getLocalizedMessage());
        }
        return -1l;
    }
    //1代表车主，0代表授权，-1代表为未登录
    public static int getCarOwner() {
        try {
            String carOwner = SystemProperties.get("com.adayo.app.usercenter.carOwner", "-1");
            return Integer.parseInt(carOwner);
        } catch (Throwable t){
            t.printStackTrace();
            LogUtils.w(TAG, t.getLocalizedMessage());
        }
        return -1;
    }

    public static void setCarOwner(int carOwner) {
        SystemProperties.set("com.adayo.app.usercenter.carOwner", String.valueOf(carOwner));
    }

    public static String getUserName() {
        try {
            String userName = SystemProperties.get("com.adayo.app.usercenter.userName", "");
            return userName;
        } catch (Throwable t){
            t.printStackTrace();
            LogUtils.w(TAG, t.getLocalizedMessage());
        }
        return "";
    }

    public static void setUserName(String userName) {
        if(userName != null) {
            SystemProperties.set("com.adayo.app.usercenter.userName", userName);
        } else {
            SystemProperties.set("com.adayo.app.usercenter.userName", "");
        }
    }

    //用户头像
    public static String getUserImg() {
        try {
            String userName = SystemProperties.get("com.adayo.app.usercenter.userImg", "");
            return userName;
        } catch (Throwable t){
            t.printStackTrace();
            LogUtils.w(TAG, t.getLocalizedMessage());
        }
        return "";
    }

    public static void setUserImg(String userImg) {
        if(userImg != null) {
            SystemProperties.set("com.adayo.app.usercenter.userImg", userImg);
        } else {
            SystemProperties.set("com.adayo.app.usercenter.userImg", "");
        }
    }
    
    public static String getAccessToken(Context context) {
        /*try {
            String accessToken = SystemProperties.get("com.adayo.app.usercenter.accessToken", "");
            return accessToken;
        } catch (Throwable t){
            t.printStackTrace();
            LogUtils.w(TAG, t.getLocalizedMessage());
        }*/
        String accessToken = context.getContentResolver().getType(Uri.parse("content://com.adayo.app.usercenter/configs/accessToken"));
        if(accessToken != null) {
            return accessToken;
        }
        return "";
    }
    
    public static void setAccessToken(Context context, String accessToken) {
        /*if(accessToken != null) {
            SystemProperties.set("com.adayo.app.usercenter.accessToken", accessToken);
        } else {
            SystemProperties.set("com.adayo.app.usercenter.accessToken", "");
        }*/

        SharedPreferences sp = context.getSharedPreferences("current_token", Context.MODE_PRIVATE);
        if(accessToken != null) {
            sp.edit().putString("com.adayo.app.usercenter.accessToken", accessToken).commit();
        } else {
            sp.edit().putString("com.adayo.app.usercenter.accessToken", "").commit();
        }
    }



    public static String getRefreshToken(Context context) {
        /*try {
            String refreshToken = SystemProperties.get("com.adayo.app.usercenter.refreshToken", "");
            return refreshToken;
        } catch (Throwable t){
            t.printStackTrace();
            LogUtils.w(TAG, t.getLocalizedMessage());
        }*/

        String refreshToken = context.getContentResolver().getType(Uri.parse("content://com.adayo.app.usercenter/configs/refreshToken"));
        if(refreshToken != null) {
            return refreshToken;
        }
        return "";
    }

    public static void setRefreshToken(Context context, String refreshToken) {
        /*if(refreshToken != null) {
            SystemProperties.set("com.adayo.app.usercenter.refreshToken", refreshToken);
        } else {
            SystemProperties.set("com.adayo.app.usercenter.refreshToken", "");
        }*/

        SharedPreferences sp = context.getSharedPreferences("current_token", Context.MODE_PRIVATE);
        if(refreshToken != null) {
            sp.edit().putString("com.adayo.app.usercenter.refreshToken", refreshToken).commit();
        } else {
            sp.edit().putString("com.adayo.app.usercenter.refreshToken", "").commit();
        }
    }
    
    public static void logout(Context context) {
        if(isLogin()) {
            Intent intent = new Intent();
            intent.putExtra("userId", UserCenterUtils.getUserId());
            intent.setClassName("com.adayo.app.usercenter", "com.adayo.app.usercenter.LogoutService");
            intent.setAction("com.adayo.app.usercenter.LogoutService");
            context.startService(intent);
        }
    }
}
