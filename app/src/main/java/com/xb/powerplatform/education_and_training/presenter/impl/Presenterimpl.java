package com.xb.powerplatform.education_and_training.presenter.impl;

import android.content.Context;

import com.xb.powerplatform.education_and_training.bean.assess;
import com.xb.powerplatform.education_and_training.model.IModel;
import com.xb.powerplatform.education_and_training.model.impl.Modelimpl;
import com.xb.powerplatform.education_and_training.presenter.IPresenter;
import com.xb.powerplatform.education_and_training.view.IView;
import com.xb.powerplatform.utilsclass.base.BaseModeBackLisenter;
import com.xb.powerplatform.utilsclass.base.Constant;

/**
 * Created by dell on 2017/12/2.
 */

public class Presenterimpl implements IPresenter {
    private IModel model;
    private Context context;
    private IView view;

    public Presenterimpl(IView view, Context context) {
        this.context = context;
        this.view = view;
        model = new Modelimpl();
    }

    @Override
    public void getPresenteerData(String id) {
        model.getModelData(Constant.DOWNLOAD, context, id,new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                view.getViewData((assess) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });

    }
}
