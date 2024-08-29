package com.haibing.mvvm.bases.ui;

import com.haibing.mvvm.utils.LogUtils;
import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description 时间跟踪
 * @Author 王小军
 * @CreateTime 2024年07月22日
 **/

public class TimingTracer {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, TimingTracer.class.getSimpleName());
    private static final String TARGET_CLASS_NAME = TimingTracer.class.getName();
    private TimingTracer() {}
    private static final class TimingTracerHolder {
        private static final TimingTracer INSTANCE = new TimingTracer();
    }
    public static TimingTracer getInstance() {
        return TimingTracerHolder.INSTANCE;
    }
    private ConcurrentHashMap<String, Long> mStartTimeMap = new ConcurrentHashMap<>();
    public void start() {
        CallInfo callInfo = getCallInfo();
        String callMessage;
        StringBuilder sb = new StringBuilder();
        if(callInfo != null) {
            sb.append(callInfo.callClassName).append("==>").append(callInfo.callMethodName).append("(")
                    .append(callInfo.callFileName).append(":").append(callInfo.callLineNumber).append(")").append(": ");
        }
        callMessage = sb.toString();
        if(callMessage != null && !callMessage.equals("")) {
            String key = callInfo.callMethodName + "-thread-" + Thread.currentThread().hashCode();
            mStartTimeMap.put(key, System.currentTimeMillis());
            LogUtils.d(TAG, callMessage + " start trace");
        }
    }
    public void end() {
        CallInfo callInfo = getCallInfo();
        String callMessage;
        StringBuilder sb = new StringBuilder();
        if(callInfo != null) {
            sb.append(callInfo.callClassName).append("==>").append(callInfo.callMethodName).append("(")
                    .append(callInfo.callFileName).append(":").append(callInfo.callLineNumber).append(")").append(": ");
        }
        callMessage = sb.toString();
        if(callMessage != null && !callMessage.equals("")) {
            String key = callInfo.callMethodName + "-thread-" + Thread.currentThread().hashCode();
            if(mStartTimeMap.containsKey(key)) {
                long startTime = mStartTimeMap.get(key);
                long endTime = System.currentTimeMillis();
                long costTime = endTime - startTime;
                LogUtils.d(TAG, callMessage + " end trace, cost time: " + costTime + "ms");
            }
        }
    }

    private CallInfo getCallInfo() {
        boolean isTargetClass = false;
        String callClassName = null;
        String callMethodName = null;
        String callFileName = null;
        int callLineNumber = -1;
        String callSimpleClassName = null;
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if(stackTraceElements != null && stackTraceElements.length > 0) {
            for (StackTraceElement element : stackTraceElements) {
                if(isTargetClass) {
                    String className = element.getClassName();
                    if(className != null) {
                        callClassName = className;
                    }
                    String methodName = element.getMethodName();
                    if(methodName != null) {
                        callMethodName = methodName;
                    }
                    String fileName = element.getFileName();
                    if(fileName != null) {
                        callFileName = fileName;
                    }
                    int lineNumber = element.getLineNumber();
                    if(lineNumber > 0) {
                        callLineNumber = lineNumber;
                    }
                    if(className != null) {
                        if(className.contains(".") && !className.endsWith(".")) {
                            String simpleClassName = className.substring(className.lastIndexOf(".") + 1);
                            callSimpleClassName = simpleClassName;
                        }
                    }
                    break;
                } else {
                    String className = element.getClassName();
                    String methodName = element.getMethodName();
                    if(className != null && className.endsWith(TARGET_CLASS_NAME)
                            && methodName != null && !methodName.equals("getCallInfo")) {
                        isTargetClass = true;
                    }
                }
            }
        }
        if(callClassName != null && callMethodName != null
                && callFileName != null && callLineNumber > 0 && callSimpleClassName != null) {
            return new CallInfo(callClassName, callMethodName, callFileName, callLineNumber, callSimpleClassName);
        }
        return null;
    }
}
