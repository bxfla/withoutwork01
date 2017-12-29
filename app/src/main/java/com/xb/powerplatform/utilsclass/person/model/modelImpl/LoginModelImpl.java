package com.xb.powerplatform.utilsclass.person.model.modelImpl;
import android.content.Context;

import com.xb.powerplatform.utilsclass.base.BaseModeBackLisenter;
import com.xb.powerplatform.utilsclass.base.BaseRequestBackLisenter;
import com.xb.powerplatform.utilsclass.base.Constant;
import com.xb.powerplatform.utilsclass.base.MySubscriberbean;
import com.xb.powerplatform.utilsclass.base.RetrofitService;
import com.xb.powerplatform.utilsclass.person.entity.User;
import com.xb.powerplatform.utilsclass.person.model.LoginModel;
import com.xb.powerplatform.utilsclass.utils.HttpUtils;

/**
 * Created by dell on 2017/8/2.
 */

public class LoginModelImpl implements LoginModel {
    @Override
    public void login(String httpTag, String username, String password,
                      final Context context, final BaseModeBackLisenter baseModeBackLisenter) {
        HttpUtils.initlist(HttpUtils.getService(RetrofitService.class).lgoin(username, password)
                ,new MySubscriberbean(httpTag,context, Constant.LOGIN, new BaseRequestBackLisenter<User>() {
            @Override
            public void success(User user) {
                baseModeBackLisenter.success(user);
            }

            @Override
            public void fail(String message) {
                baseModeBackLisenter.error(message);
            }
        }));
    }
}
