package com.xb.powerplatform.utilsclass.person.presenter.presenterImpl;

import android.content.Context;

import com.xb.powerplatform.utilsclass.base.BaseModeBackLisenter;
import com.xb.powerplatform.utilsclass.base.Constant;
import com.xb.powerplatform.utilsclass.person.entity.upApp;
import com.xb.powerplatform.utilsclass.person.model.UpAppModel;
import com.xb.powerplatform.utilsclass.person.model.modelImpl.UpAppModelImpl;
import com.xb.powerplatform.utilsclass.person.presenter.UpAppPresenter;
import com.xb.powerplatform.utilsclass.person.view.UpAppView;

/**
 * Created by dell on 2017/8/2.
 */

public class UpAppPresenterImpl implements UpAppPresenter {
    private UpAppModel model;
    private Context context;
    private UpAppView view;

    //构造方法
    public UpAppPresenterImpl(UpAppView view, Context context){
        this.context=context;
        this.view=view;
        model=new UpAppModelImpl();
    }



    @Override
    public void upApp() {
        model.upApp(Constant.LOGIN_HTTP_TAG, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                view.setUser((upApp) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
