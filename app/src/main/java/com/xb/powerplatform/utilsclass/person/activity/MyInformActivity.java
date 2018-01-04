package com.xb.powerplatform.utilsclass.person.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xb.powerplatform.R;
import com.xb.powerplatform.SharedPreferencesHelper;
import com.xb.powerplatform.utilsclass.base.BaseActivity;
import com.xb.powerplatform.utilsclass.myViews.Header;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyInformActivity extends BaseActivity {

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
    List<String> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        preference = new SharedPreferencesHelper(this, "login");
        list=preference.getList("classold");
        SharedPreferences preferences=getSharedPreferences("user", Context.MODE_PRIVATE);
        String read=preferences.getString("read", "");
        tvIdcard.setText(read);
        if (list.size()!=0){
            tvAssessLine.setText(list.get(0));
        }else {
            tvAssessLine.setText("暂无考试记录");
        }
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

    @OnClick({R.id.ll1, R.id.ll2, R.id.ll3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll1:
                break;
            case R.id.ll2:
                break;
            case R.id.ll3:
                if (list.size()!=0){
                    Intent intent = new Intent(MyInformActivity.this,AssessLineActivity.class);
                    intent.putExtra("list", (Serializable) list);
                    startActivity(intent);
                }
                break;
        }
    }
}
