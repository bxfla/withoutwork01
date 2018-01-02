package com.xb.powerplatform.education_and_training.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xb.powerplatform.DB.DbManager;
import com.xb.powerplatform.DB.MyDatabaseHelper;
import com.xb.powerplatform.R;
import com.xb.powerplatform.SharedPreferencesHelper;
import com.xb.powerplatform.education_and_training.bean.result;
import com.xb.powerplatform.education_and_training.presenter.ResultPresenter;
import com.xb.powerplatform.education_and_training.presenter.impl.ResultPresenterimpl;
import com.xb.powerplatform.education_and_training.view.ResultView;
import com.xb.powerplatform.utilsclass.myViews.Header;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.xb.powerplatform.SharedPreferencesHelper.saveData;

public class AssessResultActivity extends AppCompatActivity implements ResultView {

    String score, passnum;
    @Bind(R.id.header)
    Header header;
    @Bind(R.id.tvPass)
    TextView tvPass;
    @Bind(R.id.tvScore)
    TextView tvScore;
    @Bind(R.id.imageView)
    ImageView imageView;
    @Bind(R.id.left)
    ImageView left;
    @Bind(R.id.title)
    TextView title;

    private MyDatabaseHelper helper;
    SQLiteDatabase db;

    SharedPreferencesHelper preference;
    ResultPresenter presenter;
    String classId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessresult);
        ButterKnife.bind(this);
        helper = DbManager.getInstance(AssessResultActivity.this);
        db = helper.getReadableDatabase();
        Bundle bundle = getIntent().getExtras();
        score = String.valueOf(bundle.getInt("score"));
        passnum = String.valueOf(bundle.getInt("passnum"));
        tvPass.setText(passnum);
        tvScore.setText(score);
        setImage();
        preference = new SharedPreferencesHelper(this, "login");
        classId = preference.getData(this, "classId", "");
        String cred = preference.getData(this, "crednumber", "");
        presenter = new ResultPresenterimpl(this, this);
        presenter.getPresenteerData(classId, cred, score);
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
    public void getViewData(result result) {
        //删除下载考试目录
        String sql = "delete from dwoClassName where classid='" + classId + "'";
        db.execSQL(sql);
        String sql1 = "delete from moni where classid='" + classId + "'";
        db.execSQL(sql1);
        saveData(this, "classId", "");//考试ID
        Toast.makeText(this, result.getMsg(), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.left)
    public void onViewClicked() {
        Intent intent=new Intent(AssessResultActivity.this,EducationActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intent intent=new Intent(AssessResultActivity.this,EducationActivity.class);
        startActivity(intent);
        finish();
        return super.onKeyDown(keyCode, event);
    }
}
