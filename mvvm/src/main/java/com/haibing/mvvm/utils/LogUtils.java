package com.haibing.mvvm.utils;

import android.util.Log;

import androidx.annotation.Nullable;

import com.haibing.mvvm.bases.ui.CallInfo;
import com.haibing.mvvm.constants.GlobalConstants;

/**
 * @author 王小军
 * @date 2024/03/08
 */
public class LogUtils {
    private static final String TARGET_CLASS_NAME = LogUtils.class.getName();
    private static final String DEFAULT_TAG = GlobalConstants.TAG_PREFIXES + LogUtils.class.getSimpleName();
    public static final String GLOBAL_TAG = GlobalConstants.TAG_PREFIXES + "Default";
    public static void e(@Nullable String tag,@Nullable String msg) {
        if(msg != null) {
            CallInfo callInfo = getCallInfo();
            StringBuilder sb = new StringBuilder();
            if(callInfo != null) {
                sb.append(callInfo.callClassName).append("==>").append(callInfo.callMethodName).append("(")
                        .append(callInfo.callFileName).append(":").append(callInfo.callLineNumber).append(")").append(": ");
            }
            sb.append(msg);
            if(tag != null) {
                Log.e(tag, sb.toString());
            } else {
                String customTag;
                if(callInfo != null) {
                    customTag = GlobalConstants.TAG_PREFIXES + callInfo.callSimpleClassName;
                } else {
                    customTag = DEFAULT_TAG;
                }
                Log.e(customTag, sb.toString());
            }
        }
    }

    public static void i(@Nullable String tag,@Nullable String msg) {
        if(msg != null) {
            CallInfo callInfo = getCallInfo();
            StringBuilder sb = new StringBuilder();
            if(callInfo != null) {
                sb.append(callInfo.callClassName).append("==>").append(callInfo.callMethodName).append("(")
                        .append(callInfo.callFileName).append(":").append(callInfo.callLineNumber).append(")").append(": ");
            }
            sb.append(msg);
            if(tag != null) {
                Log.i(tag, sb.toString());
            } else {
                String customTag;
                if(callInfo != null) {
                    customTag = GlobalConstants.TAG_PREFIXES + callInfo.callSimpleClassName;
                } else {
                    customTag = DEFAULT_TAG;
                }
                Log.i(customTag, sb.toString());
            }
        }
    }

    public static void d(@Nullable String tag,@Nullable String msg) {
        if(msg != null) {
            CallInfo callInfo = getCallInfo();
            StringBuilder sb = new StringBuilder();
            if(callInfo != null) {
                sb.append(callInfo.callClassName).append("==>").append(callInfo.callMethodName).append("(")
                        .append(callInfo.callFileName).append(":").append(callInfo.callLineNumber).append(")").append(": ");
            }
            sb.append(msg);
            if(tag != null) {
                Log.d(tag, sb.toString());
            } else {
                String customTag;
                if(callInfo != null) {
                    customTag = GlobalConstants.TAG_PREFIXES + callInfo.callSimpleClassName;
                } else {
                    customTag = DEFAULT_TAG;
                }
                Log.d(customTag, sb.toString());
            }
        }
    }

    public static void w(@Nullable String tag,@Nullable String msg) {
        if(msg != null) {
            CallInfo callInfo = getCallInfo();
            StringBuilder sb = new StringBuilder();
            if(callInfo != null) {
                sb.append(callInfo.callClassName).append("==>").append(callInfo.callMethodName).append("(")
                        .append(callInfo.callFileName).append(":").append(callInfo.callLineNumber).append(")").append(": ");
            }
            sb.append(msg);
            if(tag != null) {
                Log.w(tag, sb.toString());
            } else {
                String customTag;
                if(callInfo != null) {
                    customTag = GlobalConstants.TAG_PREFIXES + callInfo.callSimpleClassName;
                } else {
                    customTag = DEFAULT_TAG;
                }
                Log.w(customTag, sb.toString());
            }
        }
    }
    public static void v(@Nullable String tag,@Nullable String msg) {
        if(msg != null) {
            CallInfo callInfo = getCallInfo();
            StringBuilder sb = new StringBuilder();
            if(callInfo != null) {
                sb.append(callInfo.callClassName).append("==>").append(callInfo.callMethodName).append("(")
                        .append(callInfo.callFileName).append(":").append(callInfo.callLineNumber).append(")").append(": ");
            }
            sb.append(msg);
            if(tag != null) {
                Log.v(tag, sb.toString());
            } else {
                String customTag;
                if(callInfo != null) {
                    customTag = GlobalConstants.TAG_PREFIXES + callInfo.callSimpleClassName;
                } else {
                    customTag = DEFAULT_TAG;
                }
                Log.v(customTag, sb.toString());
            }
        }
    }

    public static void e(@Nullable String msg) {
        if(msg != null) {
            CallInfo callInfo = getCallInfo();
            StringBuilder sb = new StringBuilder();
            if(callInfo != null) {
                sb.append(callInfo.callClassName).append("==>").append(callInfo.callMethodName).append("(")
                        .append(callInfo.callFileName).append(":").append(callInfo.callLineNumber).append(")").append(": ");
            }
            sb.append(msg);
            String customTag;
            if(callInfo != null) {
                customTag = GlobalConstants.TAG_PREFIXES + callInfo.callSimpleClassName;
            } else {
                customTag = DEFAULT_TAG;
            }
            Log.e(customTag, sb.toString());
        }
    }

    public static void i(@Nullable String msg) {
        if(msg != null) {
            CallInfo callInfo = getCallInfo();
            StringBuilder sb = new StringBuilder();
            if(callInfo != null) {
                sb.append(callInfo.callClassName).append("==>").append(callInfo.callMethodName).append("(")
                        .append(callInfo.callFileName).append(":").append(callInfo.callLineNumber).append(")").append(": ");
            }
            sb.append(msg);
            String customTag;
            if(callInfo != null) {
                customTag = GlobalConstants.TAG_PREFIXES + callInfo.callSimpleClassName;
            } else {
                customTag = DEFAULT_TAG;
            }
            Log.i(customTag, sb.toString());
        }
    }

    public static void d(@Nullable String msg) {
        if(msg != null) {
            CallInfo callInfo = getCallInfo();
            StringBuilder sb = new StringBuilder();
            if(callInfo != null) {
                sb.append(callInfo.callClassName).append("==>").append(callInfo.callMethodName).append("(")
                        .append(callInfo.callFileName).append(":").append(callInfo.callLineNumber).append(")").append(": ");
            }
            sb.append(msg);
            String customTag;
            if(callInfo != null) {
                customTag = GlobalConstants.TAG_PREFIXES + callInfo.callSimpleClassName;
            } else {
                customTag = DEFAULT_TAG;
            }
            Log.d(customTag, sb.toString());
        }
    }

    public static void w(@Nullable String msg) {
        if(msg != null) {
            CallInfo callInfo = getCallInfo();
            StringBuilder sb = new StringBuilder();
            if(callInfo != null) {
                sb.append(callInfo.callClassName).append("==>").append(callInfo.callMethodName).append("(")
                        .append(callInfo.callFileName).append(":").append(callInfo.callLineNumber).append(")").append(": ");
            }
            sb.append(msg);
            String customTag;
            if(callInfo != null) {
                customTag = GlobalConstants.TAG_PREFIXES + callInfo.callSimpleClassName;
            } else {
                customTag = DEFAULT_TAG;
            }
            Log.w(customTag, sb.toString());
        }
    }
    public static void v(@Nullable String msg) {
        if(msg != null) {
            CallInfo callInfo = getCallInfo();
            StringBuilder sb = new StringBuilder();
            if(callInfo != null) {
                sb.append(callInfo.callClassName).append("==>").append(callInfo.callMethodName).append("(")
                        .append(callInfo.callFileName).append(":").append(callInfo.callLineNumber).append(")").append(": ");
            }
            sb.append(msg);
            String customTag;
            if(callInfo != null) {
                customTag = GlobalConstants.TAG_PREFIXES + callInfo.callSimpleClassName;
            } else {
                customTag = DEFAULT_TAG;
            }
            Log.v(customTag, sb.toString());
        }
    }



    public static CallInfo getCallInfo() {
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
