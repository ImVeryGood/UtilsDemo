package com.newdicooker.tempetek.utilsdemo.utils.net.retrofitUtils.interceptor;

import android.util.Log;

import com.newdicooker.tempetek.utilsdemo.utils.net.NetUtil;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * author: zh on 2017/4/13.
 * 在没有网络的情况下，取读缓存数据
 */

public class NoNetInterceptor implements Interceptor {
    public  String TAG = "Interceptor";
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long startTime = System.currentTimeMillis();
        okhttp3.Response response = chain.proceed(chain.request());
        long endTime = System.currentTimeMillis();
        long duration=endTime-startTime;
        okhttp3.MediaType mediaType = response.body().contentType();
        String content = response.body().string();
        Log.d(TAG,"\n");
        Log.d(TAG,"----------Start----------------");
        Log.d(TAG, "| "+request.toString());
        String method=request.method();
        if("POST".equals(method)){
            StringBuilder sb = new StringBuilder();
            if (request.body() instanceof FormBody) {
                FormBody body = (FormBody) request.body();
                for (int i = 0; i < body.size(); i++) {
                    sb.append(body.encodedName(i) + "=" + body.encodedValue(i) + ",");
                }
                sb.delete(sb.length() - 1, sb.length());
                Log.d(TAG, "| RequestParams:{"+sb.toString()+"}");
            }
        }
        Log.d(TAG, "| Response:" + content);
        Log.d(TAG,"----------End:"+duration+"毫秒----------");


        boolean connected = NetUtil.isNetworkAvailable();
        //如果没有网络，则启用 FORCE_CACHE
        if (!connected) {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
            Log.e("zhanghe", "无网络设置_common");

            return response.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=3600")
                    .removeHeader("Pragma")
                    .build();
        }
        //有网络的时候，这个拦截器不做处理，直接返回
        return chain.proceed(request);

    }


}
