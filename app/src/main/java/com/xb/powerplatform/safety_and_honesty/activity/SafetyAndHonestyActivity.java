package com.xb.powerplatform.safety_and_honesty.activity;

import android.os.Bundle;

import com.xb.powerplatform.R;
import com.xb.powerplatform.utilsclass.base.BaseActivity;

/**
 * 安全诚信
 */
public class SafetyAndHonestyActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    //布局
    @Override
    protected int provideContentViewId() {
        return R.layout.activity_safetyandhonesty;
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
