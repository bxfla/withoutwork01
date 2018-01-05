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
    List<String> list = new ArrayList<>();
    @Bind(R.id.tvcomp)
    TextView tvcomp;
    @Bind(R.id.ll4)
    LinearLayout ll4;
    @Bind(R.id.tvaddress)
    TextView tvaddress;
    @Bind(R.id.ll5)
    LinearLayout ll5;
    @Bind(R.id.activity_myinform)
    LinearLayout activityMyinform;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        preference = new SharedPreferencesHelper(this, "login");
        list = preference.getList("classold");
        SharedPreferences preferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        String read = preferences.getString("read", "");
        String wname = preferences.getString("wname", "");
        String addredd = preferences.getString("addredd", "");
        String department = preferences.getString("department", "");
        if (wname.length() != 0) {
            ll1.setVisibility(View.VISIBLE);
            tvName.setText(wname);
        }
        if (addredd.length() != 0) {
            ll5.setVisibility(View.VISIBLE);
            tvaddress.setText(addredd);
        }
        if (department.length() != 0) {
            ll2.setVisibility(View.VISIBLE);
            tvcomp.setText(department);
        }
        tvIdcard.setText(read);
        if (list.size() != 0) {
            tvAssessLine.setText(list.get(0));
        } else {
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

    @OnClick({R.id.ll1, R.id.ll2, R.id.ll4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll1:
                break;
            case R.id.ll2:
                break;
            case R.id.ll4:
                if (list.size() != 0) {
                    Intent intent = new Intent(MyInformActivity.this, AssessLineActivity.class);
                    intent.putExtra("list", (Serializable) list);
                    startActivity(intent);
                }
                break;
        }
    }
}
