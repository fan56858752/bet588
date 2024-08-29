package com.yf.bet.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.adayo.retrofit.ApiService;
import com.adayo.retrofit.ApiServiceFactory;
import com.adayo.retrofit.models.responses.QRCodeResponse;
import com.haibing.mvvm.bases.ui.BaseViewModel;
import com.haibing.mvvm.utils.LogUtils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * <pre>
 *     author: 杨帆
 *     email: yangfan@haibingtech.com
 *     date: 2024/9/8 14:44
 *     desc  :
 *     history:
 * </pre>
 */
public class MainViewModel extends BaseViewModel {

    public MutableLiveData<Boolean> testLiveData = new MutableLiveData<>();

    private ApiService mService;

    public MainViewModel(@NonNull Application application) {
        super(application);
        mService = ApiServiceFactory.getInstance().getApiService(ApiService.class);
    }

    public void test(){
        addDisposable(mService.requestQRCode("123456","123456")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        result -> {
                            LogUtils.d("得到结果");
                            testLiveData.postValue(false);
                        },
                        error -> {
                            LogUtils.d("报错");

                        },
                        () -> {
                            LogUtils.d("完成");

                        }
                ));
    }

}
