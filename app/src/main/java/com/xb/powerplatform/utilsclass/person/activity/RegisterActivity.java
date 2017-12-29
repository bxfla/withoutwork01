package com.xb.powerplatform.utilsclass.person.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xb.powerplatform.R;
import com.xb.powerplatform.utilsclass.base.BaseActivity;
import com.xb.powerplatform.utilsclass.myViews.Header;
import com.xb.powerplatform.utilsclass.person.entity.register;
import com.xb.powerplatform.utilsclass.person.presenter.RegisterPresenter;
import com.xb.powerplatform.utilsclass.person.presenter.presenterImpl.RegisterPresenterImpl;
import com.xb.powerplatform.utilsclass.person.view.RegisterView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity implements RegisterView {

    RegisterPresenter presenter;
    @Bind(R.id.header)
    Header header;
    @Bind(R.id.etPhone)
    EditText etPhone;
    @Bind(R.id.etCarId)
    EditText etCarId;
    @Bind(R.id.et_password)
    EditText etPassword;
    @Bind(R.id.brnRegister)
    Button brnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_register_;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @Override
    public void getRegisterData(register register) {
        Toast.makeText(this, register.getMsg(), Toast.LENGTH_SHORT).show();
        if (register.getMsg().equals("注册成功！")){
            Intent intent=new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @OnClick(R.id.brnRegister)
    public void onViewClicked() {
        if (etPhone.getText().toString().length()!=0&&
                etCarId.getText().toString().length()!=0&&
                etPassword.getText().toString().length()!=0){
            presenter = new RegisterPresenterImpl(this, this,etPhone.getText().toString(),
                    etCarId.getText().toString(),etPassword.getText().toString());
            presenter.register(etPhone.getText().toString(),
                    etCarId.getText().toString(),etPassword.getText().toString());
        }else {
            Toast.makeText(this, "注册信息 不能为空", Toast.LENGTH_SHORT).show();
        }

    }
}
