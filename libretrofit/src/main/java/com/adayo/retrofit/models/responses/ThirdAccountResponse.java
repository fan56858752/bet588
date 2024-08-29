package com.adayo.retrofit.models.responses;

import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

import java.util.List;

/**
 * @Description 第三方账号列表响应数据
 * @Author 王小军
 * @CreateTime 2024年05月22日
 **/

public class ThirdAccountResponse extends BaseResponse {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, ThirdAccountResponse.class.getSimpleName());
    public long respTime;
    public Data data;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ThirdAccountResponse{");
        sb.append("respTime=").append(respTime);
        sb.append(", data=").append(data);
        sb.append(", statusCode='").append(statusCode).append('\'');
        sb.append(", statusMessage='").append(statusMessage).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public class Data {
        public List<Account> list;
    }

    public class Account {
        public String appkey;
        public String appname;
        public String appicon;
        public int bindStatus;//绑定状态，1->已绑定，0->未绑定
        public Opts funcItem;

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Account{");
            sb.append("appkey='").append(appkey).append('\'');
            sb.append(", appname='").append(appname).append('\'');
            sb.append(", appicon='").append(appicon).append('\'');
            sb.append(", bindStatus=").append(bindStatus);
            sb.append(", funcItem=").append(funcItem);
            sb.append('}');
            return sb.toString();
        }
    }

    public class Opts {
        public int bindAccount;//是否允许绑定，1->支持绑定，0->不支持绑定
        public int unbindAccount;//是否允许解绑，1->支持解绑，0,->不支持解绑

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Opts{");
            sb.append("bindAccount=").append(bindAccount);
            sb.append(", unbindAccount=").append(unbindAccount);
            sb.append('}');
            return sb.toString();
        }
    }
}
