package com.xb.powerplatform.utilsclass.person.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xb.powerplatform.R;
import com.xb.powerplatform.SharedPreferencesHelper;
import com.xb.powerplatform.utilsclass.base.BaseActivity;
import com.xb.powerplatform.utilsclass.myViews.Header;
import com.xb.powerplatform.utilsclass.person.entity.AssessList;
import com.xb.powerplatform.utilsclass.person.presenter.AssessListPresenter;
import com.xb.powerplatform.utilsclass.person.presenter.presenterImpl.AssessListPresenterImpl;
import com.xb.powerplatform.utilsclass.person.view.AssessListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyInformActivity extends BaseActivity implements AssessListView{

    @Bind(R.id.header)
    Header header;
    @Bind(R.id.tvName)
    TextView tvName;
    @Bind(R.id.ll1)
    LinearLayout ll1;
    @Bind(R.id.tvIdcard)
    TextView tvIdcard;
    @Bind(R.id.ll2)
    LinearLayout ll2;
    @Bind(R.id.tvAssessLine)
    TextView tvAssessLine;
    @Bind(R.id.ll3)
    LinearLayout ll3;
    SharedPreferencesHelper preference;
    @Bind(R.id.tvcomp)
    TextView tvcomp;
    @Bind(R.id.ll4)
    LinearLayout ll4;
    @Bind(R.id.activity_myinform)
    LinearLayout activityMyinform;

    List<String>beanList=new ArrayList<>();
    List<String>beanList1=new ArrayList<>();

    AssessListPresenter presenter;
    String className;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        preference = new SharedPreferencesHelper(this, "login");
        preference = new SharedPreferencesHelper(this, "login");
        String read = preference.getData(this,"cred","");
        String wname = preference.getData(this,"name","");
        String depart = preference.getData(this,"depart","");
        if (wname.length() != 0) {
            tvName.setText(wname);
        }
        if (depart.length() != 0) {
            tvcomp.setText(depart);
        }
        if (read.length() != 0) {
            tvIdcard.setText(read);
        }
        if (beanList.size() != 0) {
            tvAssessLine.setText(beanList.get(0));
        } else {
            tvAssessLine.setText("暂无考试记录");
        }
        presenter=new AssessListPresenterImpl(this,this);
        presenter.getAssessList(preference.getData(this,"cred",""));
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_myinform;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick({R.id.ll1, R.id.ll2, R.id.ll4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll1:
                break;
            case R.id.ll2:
                break;
            case R.id.ll4:
                if (beanList.size() != 0) {
                    Intent intent = new Intent(MyInformActivity.this, AssessLineActivity.class);
                    intent.putExtra("list", (Serializable) beanList);
                    intent.putExtra("list1", (Serializable) beanList1);
                    startActivity(intent);
                }
                break;
        }
    }

    @Override
    public void getAssessList(AssessList assessList) {
        if (assessList.getBody().getScoreList().size()!=0){
            for (int i=0;i<assessList.getBody().getScoreList().size();i++){
                beanList.add(assessList.getBody().getScoreList().get(i).getClassName());
                beanList1.add(assessList.getBody().getScoreList().get(i).getScore());
            }
            className=assessList.getBody().getScoreList().get(0).getClassName();
            Message message=new Message();
            message.what=1;
            handler.sendMessage(message);
        }
    }

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tvAssessLine.setText(className);
        }
    };
}
