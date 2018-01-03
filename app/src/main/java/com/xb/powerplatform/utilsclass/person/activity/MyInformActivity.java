package com.xb.powerplatform.utilsclass.person.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xb.powerplatform.R;
import com.xb.powerplatform.utilsclass.base.BaseActivity;
import com.xb.powerplatform.utilsclass.myViews.Header;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
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
                Intent intent = new Intent(MyInformActivity.this,AssessLineActivity.class);
                startActivity(intent);
                break;
        }
    }
}
