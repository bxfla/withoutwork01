package com.xb.powerplatform.education_and_training.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.xb.powerplatform.R;
import com.xb.powerplatform.utilsclass.base.BaseActivity;
import com.xb.powerplatform.utilsclass.myViews.Header;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MoNiAssessResultActivity extends BaseActivity {

    String score, passnum;
    @Bind(R.id.header)
    Header header;
    @Bind(R.id.tvPass)
    TextView tvPass;
    @Bind(R.id.tvScore)
    TextView tvScore;
    @Bind(R.id.imageView)
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        score = String.valueOf(bundle.getInt("score"));
        passnum = String.valueOf(bundle.getInt("passnum"));
        tvPass.setText(passnum);
        tvScore.setText(score);
        setImage();
    }

    private void setImage() {
        int score1 = Integer.parseInt(score);
        int passnum1 = Integer.parseInt(passnum);
        if (score1 < passnum1) {
            imageView.setBackgroundResource(R.drawable.nopass);
        } else {
            imageView.setBackgroundResource(R.drawable.pass);
        }
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_assessresult;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }
}
