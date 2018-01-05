package com.xb.powerplatform.utilsclass.person.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.xb.powerplatform.R;
import com.xb.powerplatform.SharedPreferencesHelper;
import com.xb.powerplatform.utilsclass.base.BaseActivity;
import com.xb.powerplatform.utilsclass.myViews.Header;
import com.xb.powerplatform.utilsclass.person.entity.User;
import com.xb.powerplatform.utilsclass.person.presenter.LoginPresenter;
import com.xb.powerplatform.utilsclass.person.presenter.presenterImpl.LoginPresenterImpl;
import com.xb.powerplatform.utilsclass.person.view.LoginView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 登录activity
 */
public class LoginActivity extends BaseActivity implements LoginView {
    @Bind(R.id.checkpwd)
    TextView checkpwd;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    LoginPresenter loginPresenter;
    Intent intent;
    @Bind(R.id.et_phone)
    EditText etPhone;
    @Bind(R.id.et_password)
    EditText etPassword;
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.header)
    Header header;
    @Bind(R.id.chechBox)
    CheckBox chechBox;

    String name, password;

    private static boolean isExit = false;
    SharedPreferencesHelper preference;

    //推出程序
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
        intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }

    //初始化
    @Override
    public void initView() {
        //btnLogin.setOnClickListener(this);
        loginPresenter = new LoginPresenterImpl(this, this);
    }

    @Override
    public void setUser(User user) {
        if (String.valueOf(user.isSuccess()).equals("true")) {
            String cred = user.getBody().getUser().getCred();
            String depart =user.getBody().getUser().getDepart();
            String name =user.getBody().getUser().getName();
            String company = user.getBody().getUser().getCompany();
            preference.saveData(this,"cred",cred);
            preference.saveData(this,"depart",depart);
            preference.saveData(this,"name",name);
            preference.saveData(this,"company",company);
            intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, user.getMsg(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);

        etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());

        //获取SharedPreferences对象
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isRemember = pref.getBoolean("remember_password", false);
        if (isRemember) {
            name = pref.getString("name", name);
            password = pref.getString("password", "password1");
            etPhone.setText(name);
            etPassword.setText(password);
            chechBox.setChecked(true);
        }
        preference = new SharedPreferencesHelper(this, "login");
        if (preference.getData(this,"cred","").length()!=0){
            intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @OnClick({R.id.btn_login,R.id.checkpwd})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                name = etPhone.getText().toString();
                password = etPassword.getText().toString();
                if (name.equals("") && password.equals("")) {
                    Toast.makeText(this, "登录信息不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    editor = pref.edit();
                    if (chechBox.isChecked()) {
                        editor.putBoolean("remember_password", true);
                        editor.putString("name", name);
                        editor.putString("password", password);
                    } else {
                        editor.clear();
                    }
                    editor.commit();//提交数据
                    loginPresenter.login(etPhone.getText().toString(), etPassword.getText().toString());
                }
                break;
            case R.id.checkpwd:
                Intent intent=new Intent(this,CheckPwdActivity.class);
                startActivity(intent);
                finish();
        }

    }

    //推出程序
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            preference.removeData(this);
            finish();
            System.exit(0);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
