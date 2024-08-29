package com.haibing.mvvm.utils;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import com.haibing.mvvm.utils.LogUtils;
import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

/**
 * @Description TODO
 * @Author 王小军
 * @CreateTime 2024年04月28日
 **/

public class SystemUIUtils {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, SystemUIUtils.class.getSimpleName());

    public static void navigationBar(Window window, final boolean show) {
        final int decorFitsFlags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        final View decorView = window.getDecorView();
        final int sysUiVis = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility(show
                ? sysUiVis & ~decorFitsFlags
                : sysUiVis | decorFitsFlags);
    }


    //设置沉浸式交互
    public static void setImmersive(Window window) {
        final int decorFitsFlags = View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        final View decorView = window.getDecorView();
        final int sysUiVis = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility(sysUiVis | decorFitsFlags);
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    public static void hideNavigationBar(Window window) {
        navigationBar(window, false);
    }

    public static void showNavigationBar(Window window) {
        navigationBar(window, true);
    }

    public static void hideStatusBar(Window window) {
        WindowInsetsControllerCompat compat = new WindowInsetsControllerCompat(window, window.getDecorView());
        compat.hide(WindowInsetsCompat.Type.statusBars());
    }

    public static void showStatusBar(Window window) {
        WindowInsetsControllerCompat compat = new WindowInsetsControllerCompat(window, window.getDecorView());
        compat.show(WindowInsetsCompat.Type.statusBars());
    }

    public static void hideSystemUI(Window window) {
        hideStatusBar(window);
        hideNavigationBar(window);
    }

    public static void showSystemUI(Window window) {
        showStatusBar(window);
        showNavigationBar(window);
    }
    
    public static void setSoft(Window window) {
        WindowInsetsControllerCompat insetsController = new WindowInsetsControllerCompat(window, window.getDecorView());
        insetsController.setSystemBarsBehavior(WindowInsetsControllerCompat.BEHAVIOR_SHOW_BARS_BY_SWIPE);
    }

    public static int getNavigationBarHeight(Context context) {
        int navigationBarHeight = 0;
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            navigationBarHeight = resources.getDimensionPixelSize(resourceId);
        }
        return navigationBarHeight;
    }

    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
    
    public static void hideSoftInput(Window window) {
        WindowInsetsControllerCompat insetsController = new WindowInsetsControllerCompat(window, window.getDecorView());
        insetsController.hide(WindowInsetsCompat.Type.ime());
        
    }

    public static void showSoftInput(Window window) {
        WindowInsetsControllerCompat insetsController = new WindowInsetsControllerCompat(window, window.getDecorView());
        insetsController.show(WindowInsetsCompat.Type.ime());
    }

}
