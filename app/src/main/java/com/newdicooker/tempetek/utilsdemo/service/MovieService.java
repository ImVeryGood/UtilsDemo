package com.newdicooker.tempetek.utilsdemo.service;

import com.newdicooker.tempetek.utilsdemo.bean.MovieBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


/**
 * Created by SPC
 * on 2018/9/18
 * 邮箱：13027699936@163.com.
 * version 2.0.4
 */

public interface MovieService {
    //    retrofit
    @GET("top250")
    Call<MovieBean> getTop250(@Query("start") int start, @Query("count") int count);

    /**
     * rxjava
     */
    @GET("top250")
    Observable<MovieBean> getTop(@Query("start") int start, @Query("count") int count);
}
