package com.xb.powerplatform.utilsclass.person.presenter.presenterImpl;
import android.content.Context;

import com.xb.powerplatform.utilsclass.base.BaseModeBackLisenter;
import com.xb.powerplatform.utilsclass.base.Constant;
import com.xb.powerplatform.utilsclass.person.entity.register;
import com.xb.powerplatform.utilsclass.person.model.RegisterModel;
import com.xb.powerplatform.utilsclass.person.model.modelImpl.RegisterModelImpl;
import com.xb.powerplatform.utilsclass.person.presenter.RegisterPresenter;
import com.xb.powerplatform.utilsclass.person.view.RegisterView;

/**
 * Created by dell on 2017/8/2.
 */

public class RegisterPresenterImpl implements RegisterPresenter {
    private RegisterModel model;
    private Context context;
    private RegisterView view;
    String phone,cred,password;
    public RegisterPresenterImpl(RegisterView view, Context context, String s, String toString, String string){
        this.context=context;
        this.view=view;
        model=new RegisterModelImpl();
        this.phone=s;
        this.cred=toString;
        this.password=string;
    }

    @Override
    public void register(String phone, String cred, String Password) {
        model.getRegisterData(Constant.LOGIN_HTTP_TAG, phone, cred, Password, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                view.getRegisterData((register) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
