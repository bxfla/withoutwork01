package com.xb.powerplatform.utilsclass.person.model;

import android.content.Context;

import com.xb.powerplatform.utilsclass.base.BaseModeBackLisenter;

/**
 * Created by dell on 2017/8/2.
 */

public interface AssessListModel {
    /**
     * 考试记录
     * @param context
     * @param baseModeBackLisenter
     */
    void getAssessList(String httpTag, String id,Context context, BaseModeBackLisenter baseModeBackLisenter);
}
