package com.adayo.retrofit;

import com.adayo.retrofit.constants.HttpsConstants;
import com.adayo.retrofit.models.requests.LoginRequest;
import com.adayo.retrofit.models.requests.SaveSingleConfigRequest;
import com.adayo.retrofit.models.requests.ThirdAccountRequest;
import com.adayo.retrofit.models.requests.UnbindThirdAccountRequest;
import com.adayo.retrofit.models.responses.ConfigsResponse;
import com.adayo.retrofit.models.responses.GetSingleConfigResponse;
import com.adayo.retrofit.models.responses.LoginResponse;
import com.adayo.retrofit.models.responses.LogoutResponse;
import com.adayo.retrofit.models.responses.QRCodeResponse;
import com.adayo.retrofit.models.responses.RefreshTokenResponse;
import com.adayo.retrofit.models.responses.SaveSingleConfigResponse;
import com.adayo.retrofit.models.responses.SmsCodeResponse;
import com.adayo.retrofit.models.responses.ThirdAccountResponse;
import com.adayo.retrofit.models.responses.UnbindThirdAccountResponse;

import io.reactivex.rxjava3.core.Flowable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @Description 接口定义
 * @Author 王小军
 * @CreateTime 2024年05月16日
 **/

public interface ApiService {
    @POST(HttpsConstants.PATH_LOGIN)
    Flowable<LoginResponse> login(@Body LoginRequest request);
    @POST(HttpsConstants.PATH_LOGIN)
    Flowable<LoginResponse> loginBySmsCode(@Query("loginId") String loginId, @Query("password") String password,
                                           @Query("deviceType") String deviceType, @Query("loginType") String loginType,
                                           @Query("vin") String vin, @Query("ts") String ts, @Query("sign") String sign);
    @POST(HttpsConstants.PATH_LOGIN)
    Flowable<LoginResponse> loginByBluetoothKey(@Query("loginId") String loginId, @Query("password") String password,
                                           @Query("deviceType") String deviceType, @Query("loginType") String loginType,
                                           @Query("vin") String vin, @Query("ts") String ts, @Query("sign") String sign);
    @GET(HttpsConstants.PATH_REQUEST_QR_CODE)
    Flowable<QRCodeResponse> requestQRCode(@Path("vin") String vin, @Path("pdsn") String pdsn);
    @GET(HttpsConstants.PATH_REQUEST_SMS_CODE)
    Flowable<SmsCodeResponse> requestSmsCode(@Path("phone") String phone, @Query("vin") String vin, @Query("logicType") String logicType);
    @DELETE(HttpsConstants.PATH_LOGOUT)
    Flowable<LogoutResponse> logout(@Header("Authorization") String auth);
    @POST(HttpsConstants.PATH_THIRD_ACCOUNTS)
    Flowable<ThirdAccountResponse> requestThirdAccounts(@Header("Authorization") String auth, @Body ThirdAccountRequest request);
    @POST(HttpsConstants.PATH_UNBIND_THIRD_ACCOUNT)
    Flowable<UnbindThirdAccountResponse> requestUnbindThirdAccount(@Header("Authorization") String auth, @Body UnbindThirdAccountRequest request);
    @GET(HttpsConstants.PATH_REFRESH_TOKEN)
    Flowable<RefreshTokenResponse> refreshToken(@Header("Authorization") String auth);
    @GET(HttpsConstants.PATH_CONFIGS)
    Flowable<ConfigsResponse> requestConfigs(@Header("Authorization") String auth);
    @POST(HttpsConstants.PATH_SAVE_SINGLE_CONFIG)
    Flowable<SaveSingleConfigResponse> saveSingleConfig(@Header("Authorization") String auth, @Body SaveSingleConfigRequest request);
    @GET(HttpsConstants.PATH_GET_SINGLE_CONFIG)
    Flowable<GetSingleConfigResponse> getSingleConfig(@Header("Authorization") String auth, @Query("type") int type);

}
