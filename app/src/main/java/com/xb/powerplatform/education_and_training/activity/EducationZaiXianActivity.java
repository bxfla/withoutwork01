package com.xb.powerplatform.education_and_training.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.xb.powerplatform.DB.DbManager;
import com.xb.powerplatform.DB.MyDatabaseHelper;
import com.xb.powerplatform.R;
import com.xb.powerplatform.education_and_training.bean.Question;
import com.xb.powerplatform.utilsclass.base.BaseActivity;
import com.xb.powerplatform.utilsclass.myViews.Header;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EducationZaiXianActivity extends BaseActivity {

    @Bind(R.id.header)
    Header header;
    @Bind(R.id.ll1)
    LinearLayout ll1;
    @Bind(R.id.ll2)
    LinearLayout ll2;
    @Bind(R.id.ll3)
    LinearLayout ll3;
    @Bind(R.id.ll4)
    LinearLayout ll4;
    @Bind(R.id.activity_education_zaixian)
    LinearLayout activityEducationZaixian;

    MyDatabaseHelper helper;
    List<Question.BodyBean.ListBean> beanList = new ArrayList<>();
    Intent intent;
    String classId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        classId=intent.getStringExtra("classId");
        helper=DbManager.getInstance(EducationZaiXianActivity.this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_education_zaixian;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick({R.id.ll1, R.id.ll2, R.id.ll3, R.id.ll4})
    public void onViewClicked(View view) {
        beanList.clear();
        switch (view.getId()) {
            case R.id.ll1:
                intent=new Intent(EducationZaiXianActivity.this,TorFActivity.class);
                intent.putExtra("classId", classId);
                startActivity(intent);
                break;
            case R.id.ll2:
                //getOneSelectData();
                intent=new Intent(EducationZaiXianActivity.this,OneSelectActivity.class);
                intent.putExtra("classId", classId);
                startActivity(intent);
                break;
            case R.id.ll3:
                intent=new Intent(EducationZaiXianActivity.this,MoreSelectActivity.class);
                intent.putExtra("classId", classId);
                startActivity(intent);
                break;
            case R.id.ll4:
                getErrorData();
                intent=new Intent(EducationZaiXianActivity.this,ErrorActivity.class);
                intent.putExtra("list", (Serializable) beanList);
                startActivity(intent);
                break;
        }
    }

    private void getErrorData() {
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "select * from error";
        Cursor cursor = DbManager.queryBySQL(db, sql, null);
        beanList = DbManager.cursorToPerson(cursor);
    }

}
