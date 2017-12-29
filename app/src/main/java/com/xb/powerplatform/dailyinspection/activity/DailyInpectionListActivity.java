package com.xb.powerplatform.dailyinspection.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xb.powerplatform.R;
import com.xb.powerplatform.dailyinspection.adapter.DailyinpectionAdapter;
import com.xb.powerplatform.utilsclass.base.BaseActivity;
import com.xb.powerplatform.utilsclass.base.MyApplication;
import com.xb.powerplatform.utilsclass.myViews.DividerItemDecoration;
import com.xb.powerplatform.utilsclass.myViews.Header;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DailyInpectionListActivity extends BaseActivity {

    @Bind(R.id.header)
    Header header;
    @Bind(R.id.recycleView)
    RecyclerView recycleView;
    DailyinpectionAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        header.setTvTitle(intent.getStringExtra("text"));
        LinearLayoutManager manager = new LinearLayoutManager(MyApplication.getContextObject());
        recycleView.setLayoutManager(manager);
        recycleView.addItemDecoration(new DividerItemDecoration(getResources().getColor(R.color.line)
                , 2, LinearLayoutManager.VERTICAL));
        adapter=new DailyinpectionAdapter();
        recycleView.setAdapter(adapter);
    }

    //布局
    @Override
    protected int provideContentViewId() {
        return R.layout.activity_dailyinpection_list;
    }
    //是否显示头部
    @Override
    protected boolean isHasHeader() {
        return true;
    }
    //头部右侧点击事件
    @Override
    protected void rightClient() {
        Intent intent=new Intent(this,DailyInpectionAddActivity.class);
        startActivity(intent);
    }
}
