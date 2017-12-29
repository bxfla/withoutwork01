package com.xb.powerplatform.acceptance_cancellation.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xb.powerplatform.R;
import com.xb.powerplatform.utilsclass.base.BaseActivity;
import com.xb.powerplatform.utilsclass.myViews.Header;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AcceptanceFragment02Activity extends BaseActivity {

    @Bind(R.id.header)
    Header header;
    @Bind(R.id.tv_content)
    TextView tvContent;
    @Bind(R.id.btn1)
    Button btn1;
    @Bind(R.id.btn2)
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        tvContent.setText("各区域水雾帘要迎向风流、封闭全断面，转载点喷雾对\n" +
                "准转载点，要固定牢固、施雾化效果好，掘进皮带连续化运\n" +
                "输也必须安装转载点喷雾。防尘设施检查时要全部开启并，\n" +
                "大巷自动喷雾正常使用。");
    }

    //布局
    @Override
    protected int provideContentViewId() {
        return R.layout.activity_acceptance_fragment02;
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

    @OnClick({R.id.btn1, R.id.btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                break;
            case R.id.btn2:
                break;
        }
    }
}
