package com.xb.powerplatform.my_tasks.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xb.powerplatform.R;
import com.xb.powerplatform.my_tasks.adapter.MyTasksAdapter;
import com.xb.powerplatform.utilsclass.base.BaseActivity;
import com.xb.powerplatform.utilsclass.base.MyApplication;
import com.xb.powerplatform.utilsclass.myViews.DividerItemDecoration;
import com.xb.powerplatform.utilsclass.myViews.Header;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TasksProblemActivity extends BaseActivity {

    @Bind(R.id.header)
    Header header;
    @Bind(R.id.recycleView)
    RecyclerView recycleView;
    MyTasksAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        LinearLayoutManager manager = new LinearLayoutManager(MyApplication.getContextObject());
        recycleView.setLayoutManager(manager);
        recycleView.addItemDecoration(new DividerItemDecoration(getResources().getColor(R.color.line)
                , 2, LinearLayoutManager.VERTICAL));
        adapter=new MyTasksAdapter();
        recycleView.setAdapter(adapter);
    }

    //布局
    @Override
    protected int provideContentViewId() {
        return R.layout.activity_tasksproblem;
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
