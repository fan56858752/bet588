package com.adayo.retrofit.managers;

import com.adayo.retrofit.models.Token;

/**
 * @Description token接口
 * @Author 王小军
 * @CreateTime 2024年05月27日
 **/

public interface ITokenManager {
    void setToken(Token token);
    Token getToken();
}
