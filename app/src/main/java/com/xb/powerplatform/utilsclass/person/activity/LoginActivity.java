package com.xb.powerplatform.utilsclass.person.activity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.xb.powerplatform.DB.Constant;
import com.xb.powerplatform.DB.DbManager;
import com.xb.powerplatform.DB.MyDatabaseHelper;
import com.xb.powerplatform.R;
import com.xb.powerplatform.SharedPreferencesHelper;
import com.xb.powerplatform.utilsclass.base.BaseActivity;
import com.xb.powerplatform.utilsclass.myViews.Header;
import com.xb.powerplatform.utilsclass.person.entity.User;
import com.xb.powerplatform.utilsclass.person.presenter.LoginPresenter;
import com.xb.powerplatform.utilsclass.person.presenter.presenterImpl.LoginPresenterImpl;
import com.xb.powerplatform.utilsclass.person.view.LoginView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 登录activity
 */
public class LoginActivity extends BaseActivity implements LoginView {
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

    String name,password;
    List<String> list=new ArrayList<>();

    private static boolean isExit = false;
    SharedPreferencesHelper preference;
    //存储个人信息
    List<Map<String, String>> dataList = new ArrayList<>();

    private MyDatabaseHelper helper;
    SQLiteDatabase db;

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
        SharedPreferences preferences=getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        String read=user.getBody().getUser().getCred();
        editor.putString("read", read);
        editor.commit();
        if (String.valueOf(user.isSuccess()).equals("true")){
            if (user.getBody().getBmList().size()!=0){
                int line=user.getBody().getBmList().size();
                for (int i=0;i<line;i++){
                    String examState=user.getBody().getBmList().get(i).getExamState();
                    if (examState.equals("2")){
                        list.add(user.getBody().getBmList().get(i).getClassName());
                    }
//                    SharedPreferences preferences=getSharedPreferences("user", Context.MODE_PRIVATE);
//                    SharedPreferences.Editor editor=preferences.edit();
//                    String name=user.getBody().getBmList().get(i).getEnrolName();
//                    String read=user.getBody().getBmList().get(i).getCrednumber();
//                    editor.putString("name", name);
//                    editor.putString("read", read);
//                    editor.commit();
//                    String cont=user.getBody().getExamClass().classId;
//                    if (cont!=null){
//                        saveData(this,"classId",user.getBody().getExamClass().getClassId());//考试ID
//                    }else {
//                    }
                    String classId = user.getBody().getBmList().get(i).getClassId();
                    String className = user.getBody().getBmList().get(i).getClassName();//题目
                    String dwoStatic="No";
                    ContentValues values = new ContentValues();
                    values.put(Constant.CLASSID, classId);
                    values.put(Constant.CLASSNAME, className);
                    values.put(Constant.DWOSTATIC, dwoStatic);
                    db.insert(Constant.TABBLE_CLASS_NAME, null, values);
                    values.clear();
                }
                preference.saveList("classold",list);
            }else {
            }
            intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this, user.getMsg(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);

        helper = DbManager.getInstance(LoginActivity.this);
        db = helper.getReadableDatabase();

        //获取SharedPreferences对象
        pref= PreferenceManager.getDefaultSharedPreferences(this);
        boolean isRemember=pref.getBoolean("remember_password", false);
        if(isRemember){
            name=pref.getString("name", name);
            password=pref.getString("password", "password1");
            etPhone.setText(name);
            etPassword.setText(password);
            chechBox.setChecked(true);
        }
        preference = new SharedPreferencesHelper(this, "login");
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        String sql = "delete from className";
        db.execSQL(sql);
        name=etPhone.getText().toString();
        password=etPassword.getText().toString();
        if(name.equals("")&&password.equals("")){
            Toast.makeText(this, "登录信息不能为空", Toast.LENGTH_SHORT).show();
        }else {
            editor=pref.edit();
            if(chechBox.isChecked()){
                editor.putBoolean("remember_password", true);
                editor.putString("name", name);
                editor.putString("password", password);
            }else{
                editor.clear();
            }
            editor.commit();//提交数据
            loginPresenter.login(etPhone.getText().toString(), etPassword.getText().toString());
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
        db.close();
    }
}
