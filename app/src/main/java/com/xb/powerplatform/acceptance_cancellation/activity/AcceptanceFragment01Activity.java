package com.xb.powerplatform.acceptance_cancellation.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.xb.powerplatform.R;
import com.xb.powerplatform.utilsclass.base.BaseActivity;
import com.xb.powerplatform.utilsclass.myViews.Header;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AcceptanceFragment01Activity extends BaseActivity {

    @Bind(R.id.header)
    Header header;
    @Bind(R.id.tv_content)
    TextView tvContent;
    @Bind(R.id.tv1_con)
    TextView tv1Con;
    @Bind(R.id.tv2_con)
    TextView tv2Con;

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
        return R.layout.activity_acceptance_fragment01;
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
}
