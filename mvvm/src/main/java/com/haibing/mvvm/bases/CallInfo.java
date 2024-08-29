package com.haibing.mvvm.bases.ui;

import com.haibing.mvvm.utils.LogUtils;
import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

/**
 * @Description 调用信息
 * @Author 王小军
 * @CreateTime 2024年07月22日
 **/

public class CallInfo {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, CallInfo.class.getSimpleName());
    public String callClassName = null;
    public String callMethodName = null;
    public String callFileName = null;
    public int callLineNumber = -1;
    public String callSimpleClassName = null;

    public CallInfo(String callClassName, String callMethodName, String callFileName, int callLineNumber, String callSimpleClassName) {
        this.callClassName = callClassName;
        this.callMethodName = callMethodName;
        this.callFileName = callFileName;
        this.callLineNumber = callLineNumber;
        this.callSimpleClassName = callSimpleClassName;
    }

    @Override
    public String toString() {
        return "CallInfo{" +
                "callClassName='" + callClassName + '\'' +
                ", callMethodName='" + callMethodName + '\'' +
                ", callFileName='" + callFileName + '\'' +
                ", callLineNumber=" + callLineNumber +
                ", callSimpleClassName='" + callSimpleClassName + '\'' +
                '}';
    }
}
