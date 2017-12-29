package com.xb.powerplatform.my_tasks.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xb.powerplatform.R;
import com.xb.powerplatform.utilsclass.base.BaseActivity;
import com.xb.powerplatform.utilsclass.myViews.Header;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的任务
 */
public class MyTasksActivity extends BaseActivity {

    @Bind(R.id.header)
    Header header;
    @Bind(R.id.tv1)
    TextView tv1;
    @Bind(R.id.tv2)
    TextView tv2;
    @Bind(R.id.tv3)
    TextView tv3;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mytasks);
        ButterKnife.bind(this);
    }

    //布局
    @Override
    protected int provideContentViewId() {
        return R.layout.activity_mytasks;
    }

    //是否有头部
    @Override
    protected boolean isHasHeader() {
        return true;
    }

    //头部右侧点击事件
    @Override
    protected void rightClient() {

    }

    @OnClick({R.id.tv1, R.id.tv2, R.id.tv3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv1:
                intent=new Intent(this,TaskaHonestActivity.class);
                startActivity(intent);
                break;
            case R.id.tv2:
                intent=new Intent(this,TasksProblemActivity.class);
                startActivity(intent);
                break;
            case R.id.tv3:
                intent=new Intent(this,TasksDangerousActivity.class);
                startActivity(intent);
                break;
        }
    }
}
