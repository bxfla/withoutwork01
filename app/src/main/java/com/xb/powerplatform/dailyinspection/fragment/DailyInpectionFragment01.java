package com.xb.powerplatform.dailyinspection.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xb.powerplatform.R;
import com.xb.powerplatform.dailyinspection.activity.DailyInpectionListActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dell on 2017/8/2.
 */

public class DailyInpectionFragment01 extends Fragment {
    @Bind(R.id.tv1)
    TextView tv1;
    @Bind(R.id.tv2)
    TextView tv2;
    @Bind(R.id.tv3)
    TextView tv3;
    @Bind(R.id.tv4)
    TextView tv4;
    private View view;
    private Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_dailyinspection, container, false);
        ButterKnife.bind(this, view);
        tv1.setText(getResources().getString(R.string.three_violations));
        tv2.setText(getResources().getString(R.string.hidden_trouble));
        tv3.setText(getResources().getString(R.string.problem));
        tv4.setVisibility(View.GONE);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.tv1, R.id.tv2, R.id.tv3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
                case R.id.tv1:
                    intent=new Intent(getActivity(), DailyInpectionListActivity.class);
                    intent.putExtra("text", tv1.getText().toString());
                    getActivity().startActivity(intent);
                    break;
                case R.id.tv2:
                    intent=new Intent(getActivity(), DailyInpectionListActivity.class);
                    intent.putExtra("text", tv2.getText().toString());
                    getActivity().startActivity(intent);
                    break;
                case R.id.tv3:
                    intent=new Intent(getActivity(), DailyInpectionListActivity.class);
                    intent.putExtra("text", tv3.getText().toString());
                    getActivity().startActivity(intent);
                    break;
        }
    }
}
