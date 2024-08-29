package com.haibing.mvvm.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.util.Log;

import com.haibing.mvvm.utils.LogUtils;
import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Description 内存使用情况
 * @Author 王小军
 * @CreateTime 2024年06月17日
 **/

public class MemoryUsageChecker {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, MemoryUsageChecker.class.getSimpleName());
    public static void printMemoryUsage(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> processes = activityManager.getRunningAppProcesses();
        List<Data> memoryInfos = new ArrayList<>();
        for (ActivityManager.RunningAppProcessInfo processInfo : processes) {

            Data data = new Data();



            int pid = processInfo.pid;
            int uid = processInfo.uid;
            String processName = processInfo.processName;

            Debug.MemoryInfo[] memoryInfoArray = activityManager.getProcessMemoryInfo(new int[]{pid});
            Debug.MemoryInfo memoryInfo = memoryInfoArray[0];

            data.processName = processName;
            data.memoryInfo = memoryInfo;

            int totalPss = memoryInfo.getTotalPss();
            int totalPrivateDirty = memoryInfo.getTotalPrivateDirty();
            int totalSharedDirty = memoryInfo.getTotalSharedDirty();

            /*System.out.println("PID: " + pid + " UID: " + uid + " Process Name: " + processName);
            System.out.println("Total PSS: " + totalPss + " KB");
            System.out.println("Total Private Dirty: " + totalPrivateDirty + " KB");
            System.out.println("Total Shared Dirty: " + totalSharedDirty + " KB");*/

            memoryInfos.add(data);
        }

        Collections.sort(memoryInfos, new Comparator<Data>() {
            @Override
            public int compare(Data data1, Data data2) {
                return data2.memoryInfo.getTotalPss() - data1.memoryInfo.getTotalPss();
            }
        });

        for (Data data : memoryInfos) {
            System.out.println("Process Name: " + data.processName);
            System.out.println("Total PSS: " + data.memoryInfo.getTotalPss() + " KB");
            System.out.println("Total Private Dirty: " + data.memoryInfo.getTotalPrivateDirty() + " KB");
            System.out.println("Total Shared Dirty: " + data.memoryInfo.getTotalSharedDirty() + " KB");
        }
    }

    public static class Data {
        public Debug.MemoryInfo memoryInfo;
        public String processName;
    }
}
