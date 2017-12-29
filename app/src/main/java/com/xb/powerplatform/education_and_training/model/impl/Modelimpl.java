package com.xb.powerplatform.education_and_training.model.impl;

import android.content.Context;

import com.xb.powerplatform.education_and_training.bean.assess;
import com.xb.powerplatform.education_and_training.model.IModel;
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

public class Modelimpl implements IModel{

    @Override
    public void getModelData(String httpTag, Context context, String id, final BaseModeBackLisenter baseModeBackLisenter) {
        HttpUtils.initlist(HttpUtils.getService(RetrofitService.class).getAssessData(id)
                ,new MySubscriberbean(httpTag,context, Constant.DOWNLOAD, new BaseRequestBackLisenter<assess>() {
                    @Override
                    public void success(assess assesses) {
                        baseModeBackLisenter.success(assesses);
                    }

                    @Override
                    public void fail(String message) {
                        baseModeBackLisenter.error(message);
                    }
                }));
    }
}
