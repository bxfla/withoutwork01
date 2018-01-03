package com.xb.powerplatform.utilsclass.person.model.modelImpl;

import android.content.Context;

import com.xb.powerplatform.utilsclass.base.BaseModeBackLisenter;
import com.xb.powerplatform.utilsclass.base.BaseRequestBackLisenter;
import com.xb.powerplatform.utilsclass.base.Constant;
import com.xb.powerplatform.utilsclass.base.MySubscriberbean;
import com.xb.powerplatform.utilsclass.base.RetrofitService;
import com.xb.powerplatform.utilsclass.person.entity.upApp;
import com.xb.powerplatform.utilsclass.person.model.UpAppModel;
import com.xb.powerplatform.utilsclass.utils.HttpUtils;

/**
 * Created by dell on 2017/8/2.
 */

public class UpAppModelImpl implements UpAppModel {
    @Override
    public void upApp(String httpTag, final Context context, final BaseModeBackLisenter baseModeBackLisenter) {
        HttpUtils.initlist(HttpUtils.getService(RetrofitService.class).upApp()
                ,new MySubscriberbean(httpTag,context, Constant.LOGIN, new BaseRequestBackLisenter<upApp>() {
            @Override
            public void success(upApp upapp) {
                baseModeBackLisenter.success(upapp);
            }

            @Override
            public void fail(String message) {
                baseModeBackLisenter.error(message);
            }
        }));
    }
}
