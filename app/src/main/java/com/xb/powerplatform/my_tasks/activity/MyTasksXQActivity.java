package com.xb.powerplatform.my_tasks.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.xb.powerplatform.R;
import com.xb.powerplatform.utilsclass.base.BaseActivity;
import com.xb.powerplatform.utilsclass.myViews.Header;

import butterknife.Bind;

public class MyTasksXQActivity extends BaseActivity {

    @Bind(R.id.header)
    Header header;
    @Bind(R.id.textView)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //布局
    @Override
    protected int provideContentViewId() {
        return R.layout.activity_morinpaper_xq;
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
