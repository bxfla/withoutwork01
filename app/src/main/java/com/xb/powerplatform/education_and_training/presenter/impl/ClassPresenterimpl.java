package com.xb.powerplatform.education_and_training.presenter.impl;

import android.content.Context;

import com.xb.powerplatform.education_and_training.bean.assess;
import com.xb.powerplatform.education_and_training.model.ClassModel;
import com.xb.powerplatform.education_and_training.model.impl.ClassModelimpl;
import com.xb.powerplatform.education_and_training.presenter.ClassPresenter;
import com.xb.powerplatform.education_and_training.view.ClassView;
import com.xb.powerplatform.utilsclass.base.BaseModeBackLisenter;
import com.xb.powerplatform.utilsclass.base.Constant;

/**
 * Created by dell on 2017/12/2.
 */

public class ClassPresenterimpl implements ClassPresenter {
    private ClassModel model;
    private Context context;
    private ClassView view;

    public ClassPresenterimpl(ClassView view, Context context) {
        this.context = context;
        this.view = view;
        model = new ClassModelimpl();
    }

    @Override
    public void getPresenteerData(String id) {
        model.getModelData(Constant.DOWNLOAD, context, id,new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                view.getClassViewData((assess) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });

    }
}
