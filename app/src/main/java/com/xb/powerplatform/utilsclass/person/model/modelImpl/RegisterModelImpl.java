package com.xb.powerplatform.utilsclass.person.model.modelImpl;

import android.content.Context;

import com.xb.powerplatform.utilsclass.base.BaseModeBackLisenter;
import com.xb.powerplatform.utilsclass.base.BaseRequestBackLisenter;
import com.xb.powerplatform.utilsclass.base.Constant;
import com.xb.powerplatform.utilsclass.base.MySubscriberbean;
import com.xb.powerplatform.utilsclass.base.RetrofitService;
import com.xb.powerplatform.utilsclass.person.entity.register;
import com.xb.powerplatform.utilsclass.person.model.RegisterModel;
import com.xb.powerplatform.utilsclass.utils.HttpUtils;

/**
 * Created by dell on 2017/8/2.
 */

public class RegisterModelImpl implements RegisterModel {

    @Override
    public void getRegisterData(String httpTag, String phone, String username, String password, Context context, final BaseModeBackLisenter baseModeBackLisenter) {
        HttpUtils.initlist(HttpUtils.getService(RetrofitService.class).Register(phone, username,password)
                ,new MySubscriberbean(httpTag,context, Constant.REGISTER, new BaseRequestBackLisenter<register>() {
                    @Override
                    public void success(register register) {
                        baseModeBackLisenter.success(register);
                    }

                    @Override
                    public void fail(String message) {
                        baseModeBackLisenter.error(message);
                    }
                }));
    }
}
