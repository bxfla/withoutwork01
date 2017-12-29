package com.xb.powerplatform.acceptance_cancellation.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.xb.powerplatform.R;
import com.xb.powerplatform.acceptance_cancellation.fragment.AcceptanceFragment01;
import com.xb.powerplatform.acceptance_cancellation.fragment.AcceptanceFragment02;
import com.xb.powerplatform.utilsclass.base.BaseActivity;
import com.xb.powerplatform.utilsclass.myViews.Header;
import com.xb.powerplatform.utilsclass.person.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 验收消单
 */
public class AcceptanceActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener{

    Fragment fragment1, fragment2;
    List<Fragment> list = new ArrayList<Fragment>();
    @Bind(R.id.header)
    Header header;
    @Bind(R.id.rb1)
    RadioButton rb1;
    @Bind(R.id.rb2)
    RadioButton rb2;
    @Bind(R.id.radionGroup)
    RadioGroup radionGroup;
    @Bind(R.id.viewPage)
    ViewPager viewPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        fragment1 = new AcceptanceFragment01();
        fragment2 = new AcceptanceFragment02();
        list.add(fragment1);
        list.add(fragment2);
        radionGroup.setOnCheckedChangeListener(this);
        viewPage.setAdapter(new FragmentAdapter(getSupportFragmentManager(), list));
        viewPage.setCurrentItem(0, false);
    }

    //布局
    @Override
    protected int provideContentViewId() {
        return R.layout.activity_cancellation;
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

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb1:
                viewPage.setCurrentItem(0, false);
                break;
            case R.id.rb2:
                viewPage.setCurrentItem(1, false);
                break;
        }
    }
}
