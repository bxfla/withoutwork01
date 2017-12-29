package com.xb.powerplatform.education_and_training.model;

import android.content.Context;

import com.xb.powerplatform.utilsclass.base.BaseModeBackLisenter;

/**
 * Created by dell on 2017/12/2.
 *
 * 获取试题网络数据
 */

public interface RegularModel {
    void getModelData(String httpTag, Context context, String id, BaseModeBackLisenter baseModeBackLisenter);
}
