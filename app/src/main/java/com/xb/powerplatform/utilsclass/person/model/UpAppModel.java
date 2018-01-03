package com.xb.powerplatform.utilsclass.person.model;

import android.content.Context;

import com.xb.powerplatform.utilsclass.base.BaseModeBackLisenter;

/**
 * Created by dell on 2017/8/2.
 */

public interface UpAppModel {
    /**
     * 登录方法
     * @param context
     * @param baseModeBackLisenter
     */
    void upApp(String httpTag, Context context, BaseModeBackLisenter baseModeBackLisenter);
}
