package com.xb.powerplatform.utilsclass.person.model.modelImpl;

import android.content.Context;

import com.xb.powerplatform.utilsclass.base.BaseModeBackLisenter;
import com.xb.powerplatform.utilsclass.base.BaseRequestBackLisenter;
import com.xb.powerplatform.utilsclass.base.Constant;
import com.xb.powerplatform.utilsclass.base.MySubscriberbean;
import com.xb.powerplatform.utilsclass.base.RetrofitService;
import com.xb.powerplatform.utilsclass.person.entity.checkPwd;
import com.xb.powerplatform.utilsclass.person.model.CheckPwdModel;
import com.xb.powerplatform.utilsclass.utils.HttpUtils;

/**
 * Created by dell on 2017/8/2.
 */

public class CheckPwdModelImpl implements CheckPwdModel {

    @Override
    public void getCheckPwdData(String httpTag, String phone, String username, String password, Context context, final BaseModeBackLisenter baseModeBackLisenter) {
        HttpUtils.initlist(HttpUtils.getService(RetrofitService.class).checkPwd(phone, username,password)
                ,new MySubscriberbean(httpTag,context, Constant.CHECK, new BaseRequestBackLisenter<checkPwd>() {
                    @Override
                    public void success(checkPwd checkpwd) {
                        baseModeBackLisenter.success(checkpwd);
                    }

                    @Override
                    public void fail(String message) {
                        baseModeBackLisenter.error(message);
                    }
                }));
    }
}
