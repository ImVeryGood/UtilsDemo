package com.newdicooker.tempetek.utilsdemo.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.newdicooker.tempetek.utilsdemo.R;
import com.newdicooker.tempetek.utilsdemo.base.BaseActivity;
import com.newdicooker.tempetek.utilsdemo.bean.MovieBean;
import com.newdicooker.tempetek.utilsdemo.movie.adapter.MoviesAdapter;
import com.newdicooker.tempetek.utilsdemo.service.MovieService;
import com.newdicooker.tempetek.utilsdemo.utils.net.retrofitUtils.DataLoader;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


public class MainActivity extends BaseActivity {
    final String BASE_URL = "https://api.douban.com/v2/movie/";
    @BindView(R.id.recycler)
    RecyclerView recycler;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(manager);
    }

    @Override
    public void setData() {
        //setRetrofit();
        //setRxJavaAndRetrofit();
        setManage();

    }

    public void setRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MovieService movieService = retrofit.create(MovieService.class);
        Call<MovieBean> call = movieService.getTop250(0, 20);
        call.enqueue(new Callback<MovieBean>() {
            @Override
            public void onResponse(Call<MovieBean> call, Response<MovieBean> response) {
                recycler.setAdapter(new MoviesAdapter(response.body().getSubjects(), MainActivity.this));
                Log.d("SSSSSSSSSS", "onResponse: " + response.body().toString());

            }

            @Override
            public void onFailure(Call<MovieBean> call, Throwable t) {

            }
        });

    }

    public void setRxJavaAndRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MovieService movieService = retrofit.create(MovieService.class);
        movieService.getTop(0, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MovieBean>() {
                    @Override
                    public void onCompleted() {
                        Toast.makeText(MainActivity.this, "Get Top Movie Completed", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(MovieBean movieBean) {
                        recycler.setAdapter(new MoviesAdapter(movieBean.getSubjects(), MainActivity.this));
                    }
                });

    }

    public void setManage() {
        new DataLoader().getMovies(0, 20).subscribe(new Action1<MovieBean>() {
            @Override
            public void call(MovieBean movieBean) {
                recycler.setAdapter(new MoviesAdapter(movieBean.getSubjects(), MainActivity.this));
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

            }
        }, new Action0() {
            @Override
            public void call() {

            }
        });
    }

    @OnClick({R.id.back, R.id.net_work})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.net_work:
                setManage();
                break;
        }
    }
}
