package com.xb.powerplatform.utilsclass.person.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xb.powerplatform.R;
import com.xb.powerplatform.utilsclass.base.BaseActivity;
import com.xb.powerplatform.utilsclass.base.MyApplication;
import com.xb.powerplatform.utilsclass.myViews.DividerItemDecoration;
import com.xb.powerplatform.utilsclass.myViews.Header;
import com.xb.powerplatform.utilsclass.person.adapter.AssessLineAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AssessLineActivity extends BaseActivity {

    @Bind(R.id.header)
    Header header;
    @Bind(R.id.recycleView)
    RecyclerView recycleView;
    AssessLineAdapter adapter;
    List<String>list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        list=intent.getStringArrayListExtra("list");
        LinearLayoutManager manager = new LinearLayoutManager(MyApplication.getContextObject());
        recycleView.setLayoutManager(manager);
        recycleView.addItemDecoration(new DividerItemDecoration(getResources().getColor(R.color.line)
                , 2, LinearLayoutManager.VERTICAL));
        adapter=new AssessLineAdapter(this,list);
        recycleView.setAdapter(adapter);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_assess_line;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }
}
