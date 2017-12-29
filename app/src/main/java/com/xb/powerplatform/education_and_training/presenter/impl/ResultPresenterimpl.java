package com.xb.powerplatform.education_and_training.presenter.impl;

import android.content.Context;
import android.widget.Toast;

import com.xb.powerplatform.education_and_training.bean.result;
import com.xb.powerplatform.education_and_training.model.ResultModel;
import com.xb.powerplatform.education_and_training.model.impl.ResultModelimpl;
import com.xb.powerplatform.education_and_training.presenter.ResultPresenter;
import com.xb.powerplatform.education_and_training.view.ResultView;
import com.xb.powerplatform.utilsclass.base.BaseModeBackLisenter;
import com.xb.powerplatform.utilsclass.base.Constant;

/**
 * Created by dell on 2017/12/2.
 */

public class ResultPresenterimpl implements ResultPresenter {
    private ResultModel model;
    private Context context;
    private ResultView view;

    public ResultPresenterimpl(ResultView view, Context context) {
        this.context = context;
        this.view = view;
        model = new ResultModelimpl();
    }


    @Override
    public void getPresenteerData(String classId, String cred, String score) {
        model.getModelData(Constant.UPRESULT, context, classId,cred,score,new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                view.getViewData((result) o);
            }

            @Override
            public void error(String errorMessage) {
                Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
