package com.xb.powerplatform.education_and_training.util;

/**
 * Created by dell on 2017/12/18.
 */

public interface BaseRequestAssessLisenter<T,T1> {
    void success(T t,T1 t1);
    void fail(String message);
}
