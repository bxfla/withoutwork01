package com.xb.powerplatform.utilsclass.base;

/**
 * Created by dell on 2017/4/20.
 */

public interface BaseRequestBackLisenter<T> {
    void success(T t);
    void fail(String message);



}


