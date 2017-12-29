package com.xb.powerplatform.utilsclass.person.presenter.presenterImpl;
import android.content.Context;

import com.xb.powerplatform.utilsclass.base.BaseModeBackLisenter;
import com.xb.powerplatform.utilsclass.base.Constant;
import com.xb.powerplatform.utilsclass.person.entity.User;
import com.xb.powerplatform.utilsclass.person.model.LoginModel;
import com.xb.powerplatform.utilsclass.person.model.modelImpl.LoginModelImpl;
import com.xb.powerplatform.utilsclass.person.presenter.LoginPresenter;
import com.xb.powerplatform.utilsclass.person.view.LoginView;

/**
 * Created by dell on 2017/8/2.
 */

public class LoginPresenterImpl implements LoginPresenter {
    private LoginModel userModel;
    private Context context;
    private LoginView loginView;

    //构造方法
    public LoginPresenterImpl(LoginView loginView, Context context){
        this.context=context;
        this.loginView=loginView;
        userModel=new LoginModelImpl();
    }

    @Override
    public void login(String userName, String passWord) {
        userModel.login(Constant.LOGIN_HTTP_TAG, userName, passWord, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                loginView.setUser((User) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
