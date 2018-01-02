package com.xb.powerplatform;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.xb.powerplatform.utilsclass.base.BaseActivity;
import com.xb.powerplatform.utilsclass.myViews.Header;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CacheActivity extends BaseActivity {

    @Bind(R.id.header)
    Header header;
    @Bind(R.id.activity_cache)
    LinearLayout activityCache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        String title=intent.getStringExtra("title");
        header.setTvTitle(title);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_cache;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }
}
