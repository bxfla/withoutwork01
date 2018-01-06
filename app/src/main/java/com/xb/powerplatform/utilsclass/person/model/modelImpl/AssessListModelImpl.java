package com.xb.powerplatform.utilsclass.person.model.modelImpl;

import android.content.Context;

import com.xb.powerplatform.utilsclass.base.BaseModeBackLisenter;
import com.xb.powerplatform.utilsclass.base.BaseRequestBackLisenter;
import com.xb.powerplatform.utilsclass.base.Constant;
import com.xb.powerplatform.utilsclass.base.MySubscriberbean;
import com.xb.powerplatform.utilsclass.base.RetrofitService;
import com.xb.powerplatform.utilsclass.person.entity.AssessList;
import com.xb.powerplatform.utilsclass.person.model.AssessListModel;
import com.xb.powerplatform.utilsclass.utils.HttpUtils;

/**
 * Created by dell on 2017/8/2.
 */

public class AssessListModelImpl implements AssessListModel {
    @Override
    public void getAssessList(String httpTag, String id, final Context context, final BaseModeBackLisenter baseModeBackLisenter) {
        HttpUtils.initlist(HttpUtils.getService(RetrofitService.class).getAssessList(id)
                ,new MySubscriberbean(httpTag,context, Constant.LOGIN, new BaseRequestBackLisenter<AssessList>() {
            @Override
            public void success(AssessList upapp) {
                baseModeBackLisenter.success(upapp);
            }

            @Override
            public void fail(String message) {
                baseModeBackLisenter.error(message);
            }
        }));
    }
}
