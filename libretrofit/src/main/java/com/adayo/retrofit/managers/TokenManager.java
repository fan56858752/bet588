package com.adayo.retrofit.managers;

import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;
import com.adayo.retrofit.models.Token;

/**
 * @Description token管理
 * @Author 王小军
 * @CreateTime 2024年05月27日
 **/

public class TokenManager implements ITokenManager {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, TokenManager.class.getSimpleName());
    private TokenManager() {}
    private static final class TokenManagerHolder {
        private static final TokenManager INSTANCE = new TokenManager();
    }
    public static TokenManager getInstance() {
        return TokenManagerHolder.INSTANCE;
    }
    private Token mToken;
    @Override
    public synchronized void setToken(Token token) {
        this.mToken = token;
    }

    @Override
    public synchronized Token getToken() {
        return mToken;
    }
}
