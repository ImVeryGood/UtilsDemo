package com.newdicooker.tempetek.utilsdemo.utils.net.retrofitUtils;

import com.newdicooker.tempetek.utilsdemo.bean.MovieBean;
import com.newdicooker.tempetek.utilsdemo.service.MovieService;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by SPC
 * on 2018/9/18
 * 邮箱：13027699936@163.com.
 * version 2.0.4
 */

public class DataLoader extends ObjectLoader {
    private MovieService movieService;

    public DataLoader() {
        movieService = RetrofitManager.getInstance().create(MovieService.class);
    }

    public Observable<MovieBean> getMovies(int start, int count) {
        return observable(movieService.getTop(start, count)).map(new Func1<MovieBean, MovieBean>() {
            @Override
            public MovieBean call(MovieBean movieBean) {
                return movieBean;
            }
        });
    }
}
