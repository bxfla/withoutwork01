package com.xb.powerplatform.education_and_training.presenter.impl;

import android.content.Context;
import android.widget.Toast;

import com.xb.powerplatform.education_and_training.bean.RegularAssess;
import com.xb.powerplatform.education_and_training.model.RegularModel;
import com.xb.powerplatform.education_and_training.model.impl.RegularModelimpl;
import com.xb.powerplatform.education_and_training.presenter.RegulatrPresenter;
import com.xb.powerplatform.education_and_training.view.RegalarView;
import com.xb.powerplatform.utilsclass.base.BaseModeBackLisenter;
import com.xb.powerplatform.utilsclass.base.Constant;

/**
 * Created by dell on 2017/12/2.
 */

public class RegularPresenterimpl implements RegulatrPresenter {
    private RegularModel model;
    private Context context;
    private RegalarView view;

    public RegularPresenterimpl(RegalarView view, Context context) {
        this.context = context;
        this.view = view;
        model = new RegularModelimpl();
    }


    @Override
    public void getPresenteerData(String id) {
            model.getModelData(Constant.DOWNLOAD, context, id,new BaseModeBackLisenter() {
                @Override
                public void success(Object o) {
                    view.getViewData((RegularAssess) o);
                }

                @Override
                public void error(String errorMessage) {
                    Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show();
                }
            });
    }
}
