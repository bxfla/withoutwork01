package com.xb.powerplatform.utilsclass.person.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.xb.powerplatform.R;
import com.xb.powerplatform.SharedPreferencesHelper;
import com.xb.powerplatform.utilsclass.base.BaseActivity;
import com.xb.powerplatform.utilsclass.myViews.Header;
import com.xb.powerplatform.utilsclass.myViews.NoScrollViewPager;
import com.xb.powerplatform.utilsclass.myViews.StatusBarUtils;
import com.xb.powerplatform.utilsclass.person.FragmentAdapter;
import com.xb.powerplatform.utilsclass.person.fragment.Fragment0;
import com.xb.powerplatform.utilsclass.person.fragment.Fragment1;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener{
    private static boolean isExit = false;
    SharedPreferencesHelper preference;

    //推出程序
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };
    @Bind(R.id.header)
    Header header;
    @Bind(R.id.mViewPage)
    NoScrollViewPager mViewPage;
    @Bind(R.id.rb0)
    RadioButton rb0;
    @Bind(R.id.rb1)
    RadioButton rb1;
    @Bind(R.id.mRadionGroup)
    RadioGroup mRadionGroup;

    public Fragment fragment0;
    public Fragment fragment1;
    List<Fragment> list=new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        preference = new SharedPreferencesHelper(this, "login");

        new StatusBarUtils().setWindowStatusBarColor(MainActivity.this, R.color.color_bg_selected);
        fragment0=new Fragment0();
        fragment1=new Fragment1();
        list.add(fragment0);
        list.add(fragment1);
        mRadionGroup.setOnCheckedChangeListener(this);
        mViewPage.setAdapter(new FragmentAdapter(getSupportFragmentManager(), list));
        mViewPage.setCurrentItem(0,false);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb0:
                mViewPage.setCurrentItem(0, false);
                break;
            case R.id.rb1:
                mViewPage.setCurrentItem(1, false);
                break;
        }
    }

    //推出程序
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            preference.removeData(this);
            finish();
            System.exit(0);
        }
    }

}
