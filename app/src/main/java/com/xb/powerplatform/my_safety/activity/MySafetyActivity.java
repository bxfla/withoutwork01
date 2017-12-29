package com.xb.powerplatform.my_safety.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.xb.powerplatform.R;
import com.xb.powerplatform.utilsclass.base.BaseActivity;
import com.xb.powerplatform.utilsclass.myViews.Header;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 我的安全
 */
public class MySafetyActivity extends BaseActivity {

    @Bind(R.id.header)
    Header header;
    @Bind(R.id.mSpinner)
    Spinner mSpinner;
    private static final String[] address = {"1区", " 2区 ", " 3区 ", " 4区 ", " 5区 ", " 6区 "};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mysafety);
        ButterKnife.bind(this);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, address);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter1);
    }

    //布局
    @Override
    protected int provideContentViewId() {
        return R.layout.activity_mysafety;
    }

    //头部
    @Override
    protected boolean isHasHeader() {
        return true;
    }

    //头部右侧点击事件
    @Override
    protected void rightClient() {

    }
}
