package com.xb.powerplatform.education_and_training.model.impl;

import android.content.Context;

import com.xb.powerplatform.R;
import com.xb.powerplatform.education_and_training.bean.assess;
import com.xb.powerplatform.education_and_training.model.ClassModel;
import com.xb.powerplatform.utilsclass.base.BaseModeBackLisenter;
import com.xb.powerplatform.utilsclass.base.BaseRequestBackLisenter;
import com.xb.powerplatform.utilsclass.base.Constant;
import com.xb.powerplatform.utilsclass.base.MyApplication;
import com.xb.powerplatform.utilsclass.base.MySubscriberbean;
import com.xb.powerplatform.utilsclass.base.RetrofitService;
import com.xb.powerplatform.utilsclass.utils.AlertDialogUtil;
import com.xb.powerplatform.utilsclass.utils.HttpUtils;

/**
 * Created by dell on 2017/12/2.
 *
 */

public class ClassModelimpl implements ClassModel {

    @Override
    public void getModelData(String httpTag, final Context context, String id, final BaseModeBackLisenter baseModeBackLisenter) {
        HttpUtils.initlist(HttpUtils.getService(RetrofitService.class).getClass(id)
                ,new MySubscriberbean(httpTag,context, Constant.DOWNLOAD, new BaseRequestBackLisenter<assess>() {
                    @Override
                    public void success(assess assesses) {
                        if (assesses.getBody().getBmList().size()==0){
                            new AlertDialogUtil(context).
                                    showSmallDialog(MyApplication.getContextObject().getResources().
                                            getString(R.string.no_assess));
                        }else {
                            baseModeBackLisenter.success(assesses);
                        }
                    }

                    @Override
                    public void fail(String message) {
                        //baseModeBackLisenter.error(message);
                    }
                }));
    }
}
