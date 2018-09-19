package com.newdicooker.tempetek.utilsdemo.utils.net.retrofitUtils;

import com.google.gson.Gson;
import com.newdicooker.tempetek.utilsdemo.base.BaseApplication;
import com.newdicooker.tempetek.utilsdemo.utils.net.retrofitUtils.interceptor.NetInterceptor;
import com.newdicooker.tempetek.utilsdemo.utils.net.retrofitUtils.interceptor.NoNetInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SPC
 * on 2018/9/18
 * 邮箱：13027699936@163.com.
 * version 2.0.4
 */

/**
 * rxjava+retrofit+okhttp3
 */
public class RetrofitManager {

    private final String BASE_URL = "https://api.douban.com/v2/movie/";
    private static final int DEFAULT_TIME_OUT = 20;//超时时间 5s
    private static final int DEFAULT_READ_TIME_OUT = 10;
    private Retrofit mRetrofit;
    private static RetrofitManager manager;

    public RetrofitManager() {
        File file = new File(BaseApplication.getContext().getCacheDir(), "rxCache");
        //缓存大小10M
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(file, cacheSize);

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addNetworkInterceptor(new NetInterceptor())
                .cache(cache)
                .addInterceptor(new NoNetInterceptor());
        mRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .baseUrl(BASE_URL)
                .build();
    }

    public static RetrofitManager getInstance() {
        if (manager == null) {
            synchronized (RetrofitManager.class) {
                if (manager == null) {
                    manager = new RetrofitManager();
                }
            }
        }
        return manager;
    }

    public <T> T create(Class<T> service) {
        return mRetrofit.create(service);
    }


}
