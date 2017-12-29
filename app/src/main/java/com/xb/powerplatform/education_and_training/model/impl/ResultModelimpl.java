package com.xb.powerplatform.education_and_training.model.impl;

import android.content.Context;

import com.xb.powerplatform.education_and_training.bean.result;
import com.xb.powerplatform.education_and_training.model.ResultModel;
import com.xb.powerplatform.utilsclass.base.BaseModeBackLisenter;
import com.xb.powerplatform.utilsclass.base.BaseRequestBackLisenter;
import com.xb.powerplatform.utilsclass.base.Constant;
import com.xb.powerplatform.utilsclass.base.MySubscriberbean;
import com.xb.powerplatform.utilsclass.base.RetrofitService;
import com.xb.powerplatform.utilsclass.utils.HttpUtils;

/**
 * Created by dell on 2017/12/2.
 *
 */

public class ResultModelimpl implements ResultModel{

    @Override
    public void getModelData(String httpTag, Context context, String classId, String cred, String score, final BaseModeBackLisenter baseModeBackLisenter) {
        HttpUtils.initlist(HttpUtils.getService(RetrofitService.class).upResultAssess(classId,cred,score)
                ,new MySubscriberbean(httpTag,context, Constant.UPRESULT, new BaseRequestBackLisenter<result>() {
                    @Override
                    public void success(result assesses) {
                        baseModeBackLisenter.success(assesses);
                    }

                    @Override
                    public void fail(String message) {
                        baseModeBackLisenter.error(message);
                    }
                }));
    }
}
