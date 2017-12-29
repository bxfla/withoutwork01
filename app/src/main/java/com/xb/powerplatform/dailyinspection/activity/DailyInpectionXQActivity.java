package com.xb.powerplatform.dailyinspection.activity;

import android.os.Bundle;

import com.xb.powerplatform.R;
import com.xb.powerplatform.utilsclass.base.BaseActivity;

public class DailyInpectionXQActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //布局
    @Override
    protected int provideContentViewId() {
        return R.layout.activity_dailyinpection_xq;
    }
    //是否显示头部
    @Override
    protected boolean isHasHeader() {
        return true;
    }
    //头部右侧点击事件
    @Override
    protected void rightClient() {

    }
}
