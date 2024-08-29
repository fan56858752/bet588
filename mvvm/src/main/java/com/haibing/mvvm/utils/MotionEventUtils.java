package com.haibing.mvvm.utils;

import android.view.MotionEvent;

import com.haibing.mvvm.utils.LogUtils;
import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

/**
 * @Description TODO
 * @Author 王小军
 * @CreateTime 2024年03月21日
 **/

public class MotionEventUtils {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, MotionEventUtils.class.getSimpleName());
    /**
     * @param
     * @return
     * @desc TODO
     */
    public static String getActionName(MotionEvent event){
        String name = "";
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_CANCEL:
                name = "ACTION_CANCEL";
                break;
            case MotionEvent.ACTION_DOWN:
                name = "ACTION_DOWN";
                break;
            case MotionEvent.ACTION_MOVE:
                name = "ACTION_MOVE";
                break;
            case MotionEvent.ACTION_UP:
                name = "ACTION_UP";
                break;
            case MotionEvent.ACTION_OUTSIDE:
                name = "ACTION_OUTSIDE";
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                name = "ACTION_POINTER_DOWN";
                break;
            case MotionEvent.ACTION_POINTER_UP:
                name = "ACTION_POINTER_UP";
                break;
            default:break;
        }
        return name;
    }

    public static String getActionName(int actionMasked){
        String name = "";
        switch (actionMasked) {
            case MotionEvent.ACTION_CANCEL:
                name = "ACTION_CANCEL";
                break;
            case MotionEvent.ACTION_DOWN:
                name = "ACTION_DOWN";
                break;
            case MotionEvent.ACTION_MOVE:
                name = "ACTION_MOVE";
                break;
            case MotionEvent.ACTION_UP:
                name = "ACTION_UP";
                break;
            case MotionEvent.ACTION_OUTSIDE:
                name = "ACTION_OUTSIDE";
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                name = "ACTION_POINTER_DOWN";
                break;
            case MotionEvent.ACTION_POINTER_UP:
                name = "ACTION_POINTER_UP";
                break;
            default:break;
        }
        return name;
    }
}
