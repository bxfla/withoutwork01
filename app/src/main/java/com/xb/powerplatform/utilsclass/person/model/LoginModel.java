package com.xb.powerplatform.utilsclass.person.model;

import android.content.Context;

import com.xb.powerplatform.utilsclass.base.BaseModeBackLisenter;

/**
 * Created by dell on 2017/8/2.
 */

public interface LoginModel {
    /**
     * 登录方法
     * @param username
     * @param password
     * @param context
     * @param baseModeBackLisenter
     */
    void login(String httpTag, String username, String password, Context context, BaseModeBackLisenter baseModeBackLisenter);
}
