package com.xb.powerplatform.utilsclass.person.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xb.powerplatform.R;
import com.xb.powerplatform.SharedPreferencesHelper;
import com.xb.powerplatform.utilsclass.base.MyApplication;
import com.xb.powerplatform.utilsclass.person.activity.CheckPwdActivity;
import com.xb.powerplatform.utilsclass.person.activity.MyInformActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dell on 2017/8/1.
 */

public class Fragment1 extends Fragment {
    @Bind(R.id.tvName)
    TextView tvName;
    @Bind(R.id.tvIdcard)
    TextView tvIdcard;
    @Bind(R.id.myinform)
    LinearLayout myinform;
    @Bind(R.id.checkpwd)
    LinearLayout checkpwd;
    @Bind(R.id.upApp)
    LinearLayout upApp;
    private View view;

    SharedPreferencesHelper preference;
    Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment1, container, false);
        ButterKnife.bind(this, view);
        String name = preference.getData(getActivity(), "enrolName", "");
        String Idcard = preference.getData(getActivity(), "crednumber", "");
        tvName.setText(name);
        tvIdcard.setText(Idcard);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.myinform, R.id.checkpwd,R.id.upApp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.myinform:
                intent = new Intent(MyApplication.getContextObject(), MyInformActivity.class);
                startActivity(intent);
                break;
            case R.id.checkpwd:
                intent = new Intent(MyApplication.getContextObject(), CheckPwdActivity.class);
                startActivity(intent);
                break;
            case R.id.upApp:
                break;
        }
    }

}
