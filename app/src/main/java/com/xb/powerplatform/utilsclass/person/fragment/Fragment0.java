package com.xb.powerplatform.utilsclass.person.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xb.powerplatform.CacheActivity;
import com.xb.powerplatform.R;
import com.xb.powerplatform.education_and_training.activity.EducationActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dell on 2017/8/1.
 */

public class Fragment0 extends Fragment {
    @Bind(R.id.mIvBanner)
    ImageView mIvBanner;
    @Bind(R.id.rb1)
    RadioButton rb1;
    @Bind(R.id.rb2)
    RadioButton rb2;
    @Bind(R.id.rb3)
    RadioButton rb3;
    @Bind(R.id.rb4)
    RadioButton rb4;
    @Bind(R.id.rb5)
    RadioButton rb5;
    @Bind(R.id.rb6)
    RadioButton rb6;
    @Bind(R.id.rb7)
    RadioButton rb7;
    @Bind(R.id.rb8)
    RadioButton rb8;
    @Bind(R.id.moringNews)
    RelativeLayout moringNews;
    @Bind(R.id.moreNews)
    TextView moreNews;
    private View view;
    private Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment0, container, false);
        ButterKnife.bind(this, view);
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

    @OnClick({R.id.rb1, R.id.rb2, R.id.rb3, R.id.rb4, R.id.rb5, R.id.rb6, R.id.rb7, R.id.rb8, R.id.moringNews, R.id.moreNews})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //日常检查
            case R.id.rb1:
                intent=new Intent(getActivity(), CacheActivity.class);
                intent.putExtra("title",rb1.getText().toString());
//                intent = new Intent(getActivity(), DailyInpectionActivity.class);
                startActivity(intent);
                break;
            //我的任务
            case R.id.rb2:
                intent=new Intent(getActivity(), CacheActivity.class);
                intent.putExtra("title",rb2.getText().toString());
//                intent = new Intent(getActivity(), MyTasksActivity.class);
                startActivity(intent);
                break;
            //验收消单
            case R.id.rb3:
                intent=new Intent(getActivity(), CacheActivity.class);
                intent.putExtra("title",rb3.getText().toString());
//                intent = new Intent(getActivity(), AcceptanceActivity.class);
                startActivity(intent);
                break;
            //我的安全
            case R.id.rb4:
                intent=new Intent(getActivity(), CacheActivity.class);
                intent.putExtra("title",rb4.getText().toString());
//                intent = new Intent(getActivity(), MySafetyActivity.class);
                startActivity(intent);
                break;
            //诚信安全
            case R.id.rb5:
                intent=new Intent(getActivity(), CacheActivity.class);
                intent.putExtra("title",rb5.getText().toString());
//                intent = new Intent(getActivity(), SafetyAndHonestyActivity.class);
                startActivity(intent);
                break;
            //培训评价
           case R.id.rb6:
               intent=new Intent(getActivity(), CacheActivity.class);
               intent.putExtra("title",rb6.getText().toString());
//                intent = new Intent(getActivity(), TrainingEvaluationActivity.class);
                startActivity(intent);
                break;
           //教育培训
            case R.id.rb7:
                intent = new Intent(getActivity(), EducationActivity.class);
                intent.putExtra("title",rb7.getText().toString());
                startActivity(intent);
                break;
            //培训大数据
            case R.id.rb8:
                intent=new Intent(getActivity(), CacheActivity.class);
                intent.putExtra("title",rb8.getText().toString());
//                intent = new Intent(getActivity(), TrainBigDataActivity.class);
                startActivity(intent);
                break;
            case R.id.moringNews:
                intent=new Intent(getActivity(), CacheActivity.class);
                intent.putExtra("title","综合早报");
//                intent = new Intent(getActivity(), MoringPaperActivity.class);
                startActivity(intent);
                break;
            case R.id.moreNews:
                intent=new Intent(getActivity(), CacheActivity.class);
                intent.putExtra("title",getResources().getString(R.string.more_news));
//                intent = new Intent(getActivity(), NewsActivity.class);
                startActivity(intent);
                break;
        }
    }
}
