package com.xb.powerplatform.training_evaluation.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.xb.powerplatform.R;
import com.xb.powerplatform.training_evaluation.fragment.TrainingEvaluationFragment01;
import com.xb.powerplatform.training_evaluation.fragment.TrainingEvaluationFragment02;
import com.xb.powerplatform.utilsclass.base.BaseActivity;
import com.xb.powerplatform.utilsclass.myViews.Header;
import com.xb.powerplatform.utilsclass.myViews.NoScrollViewPager;
import com.xb.powerplatform.utilsclass.person.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 培训评价
 */
public class TrainingEvaluationActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener{
    public Fragment fragment0;
    public Fragment fragment1;
    List<Fragment> list = new ArrayList<Fragment>();
    @Bind(R.id.header)
    Header header;
    @Bind(R.id.rb0)
    RadioButton rb0;
    @Bind(R.id.rb1)
    RadioButton rb1;
    @Bind(R.id.mRadionGroup)
    RadioGroup mRadionGroup;
    @Bind(R.id.mViewPage)
    NoScrollViewPager mViewPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        fragment0 = new TrainingEvaluationFragment01();
        fragment1 = new TrainingEvaluationFragment02();
        list.add(fragment0);
        list.add(fragment1);
        mRadionGroup.setOnCheckedChangeListener(this);
        mViewPage.setAdapter(new FragmentAdapter(getSupportFragmentManager(), list));
        mViewPage.setCurrentItem(0, false);
    }

    //布局
    @Override
    protected int provideContentViewId() {
        return R.layout.activity_trainingevaluation;
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
            case R.id.rb0:
                mViewPage.setCurrentItem(0, false);
                break;
            case R.id.rb2:
                mViewPage.setCurrentItem(1, false);
                break;
        }
    }
}
