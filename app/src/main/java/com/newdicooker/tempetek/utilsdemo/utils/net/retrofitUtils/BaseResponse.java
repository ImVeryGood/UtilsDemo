package com.newdicooker.tempetek.utilsdemo.utils.net.retrofitUtils;

/**
 * Created by SPC
 * on 2018/9/18
 * 邮箱：13027699936@163.com.
 * version 2.0.4
 */

public class BaseResponse<T> {
    public int status;
    public String message;
    public T data;
    public boolean isSuccess(){
        return status == 200;
    }
}
