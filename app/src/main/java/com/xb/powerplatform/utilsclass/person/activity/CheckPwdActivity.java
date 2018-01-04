package com.xb.powerplatform.utilsclass.person.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xb.powerplatform.R;
import com.xb.powerplatform.utilsclass.base.BaseActivity;
import com.xb.powerplatform.utilsclass.myViews.Header;
import com.xb.powerplatform.utilsclass.person.entity.register;
import com.xb.powerplatform.utilsclass.person.presenter.CheckPwdPresenter;
import com.xb.powerplatform.utilsclass.person.presenter.presenterImpl.CheckPwdPresenterImpl;
import com.xb.powerplatform.utilsclass.person.view.CheckPwdView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CheckPwdActivity extends BaseActivity implements CheckPwdView{

    CheckPwdPresenter presenter;

    @Bind(R.id.header)
    Header header;
    @Bind(R.id.etName)
    EditText etName;
    @Bind(R.id.etIdcard)
    EditText etIdcard;
    @Bind(R.id.etNewPwd)
    EditText etNewPwd;
    @Bind(R.id.btn)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_checkpwd;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        if (etName.getText().toString().length()!=0&&
                etIdcard.getText().toString().length()!=0&&
                etNewPwd.getText().toString().length()!=0){
            presenter = new CheckPwdPresenterImpl(this, this,etName.getText().toString(),
                    etIdcard.getText().toString(),etNewPwd.getText().toString());
            presenter.CheckPwd(etName.getText().toString(),
                    etIdcard.getText().toString(),etNewPwd.getText().toString());
        }else {
            Toast.makeText(this, "注册信息 不能为空", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void getCheckPwdData(register register) {

    }
}
