package com.xb.powerplatform.utilsclass.person.presenter.presenterImpl;
import android.content.Context;

import com.xb.powerplatform.utilsclass.base.BaseModeBackLisenter;
import com.xb.powerplatform.utilsclass.base.Constant;
import com.xb.powerplatform.utilsclass.person.entity.AssessList;
import com.xb.powerplatform.utilsclass.person.model.AssessListModel;
import com.xb.powerplatform.utilsclass.person.model.modelImpl.AssessListModelImpl;
import com.xb.powerplatform.utilsclass.person.presenter.AssessListPresenter;
import com.xb.powerplatform.utilsclass.person.view.AssessListView;

/**
 * Created by dell on 2017/8/2.
 */

public class AssessListPresenterImpl implements AssessListPresenter {
    private AssessListModel Model;
    private Context context;
    private AssessListView View;

    //构造方法
    public AssessListPresenterImpl(AssessListView View, Context context){
        this.context=context;
        this.View=View;
        Model=new AssessListModelImpl();
    }

    @Override
    public void getAssessList (String id) {
        Model.getAssessList(Constant.LOGIN_HTTP_TAG, id, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                View.getAssessList((AssessList) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
