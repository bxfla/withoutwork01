package com.xb.powerplatform.utilsclass.person.presenter.presenterImpl;

import android.content.Context;

import com.xb.powerplatform.utilsclass.base.BaseModeBackLisenter;
import com.xb.powerplatform.utilsclass.base.Constant;
import com.xb.powerplatform.utilsclass.person.entity.register;
import com.xb.powerplatform.utilsclass.person.model.CheckPwdModel;
import com.xb.powerplatform.utilsclass.person.model.modelImpl.CheckPwdModelImpl;
import com.xb.powerplatform.utilsclass.person.presenter.CheckPwdPresenter;
import com.xb.powerplatform.utilsclass.person.view.CheckPwdView;

/**
 * Created by dell on 2017/8/2.
 */

public class CheckPwdPresenterImpl implements CheckPwdPresenter {
    private CheckPwdModel model;
    private Context context;
    private CheckPwdView view;
    String phone,cred,password;
    public CheckPwdPresenterImpl(CheckPwdView view, Context context, String s, String toString, String string){
        this.context=context;
        this.view=view;
        model=new CheckPwdModelImpl();
        this.phone=s;
        this.cred=toString;
        this.password=string;
    }

    @Override
    public void CheckPwd(String phone, String cred, String Password) {
        model.getCheckPwdData(Constant.LOGIN_HTTP_TAG, phone, cred, Password, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                view.getCheckPwdData((register) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
