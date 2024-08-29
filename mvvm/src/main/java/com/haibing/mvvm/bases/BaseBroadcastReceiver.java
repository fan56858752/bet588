package com.haibing.mvvm.bases;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.haibing.mvvm.utils.LogUtils;

public class BaseBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        LogUtils.i(getClass().getSimpleName() + "==>onReceive");
        LogUtils.i(getClass().getSimpleName() + "==>action = " + intent.getAction());
    }
}
