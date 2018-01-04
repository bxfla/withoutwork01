package com.xb.powerplatform.utilsclass.person.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.xb.powerplatform.R;
import com.xb.powerplatform.SharedPreferencesHelper;
import com.xb.powerplatform.utilsclass.base.BaseActivity;
import com.xb.powerplatform.utilsclass.base.Constant;
import com.xb.powerplatform.utilsclass.myViews.Header;
import com.xb.powerplatform.utilsclass.myViews.NoScrollViewPager;
import com.xb.powerplatform.utilsclass.myViews.StatusBarUtils;
import com.xb.powerplatform.utilsclass.person.FragmentAdapter;
import com.xb.powerplatform.utilsclass.person.entity.upApp;
import com.xb.powerplatform.utilsclass.person.fragment.Fragment0;
import com.xb.powerplatform.utilsclass.person.fragment.Fragment1;
import com.xb.powerplatform.utilsclass.person.presenter.UpAppPresenter;
import com.xb.powerplatform.utilsclass.person.presenter.presenterImpl.UpAppPresenterImpl;
import com.xb.powerplatform.utilsclass.person.view.UpAppView;
import com.xb.powerplatform.utilsclass.utils.ProgressDialogUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.xb.powerplatform.SharedPreferencesHelper.saveData;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, UpAppView {
    private static boolean isExit = false;
    SharedPreferencesHelper preference;
    /* 下载保存路径 */
    private String mSavePath;
    /* 是否取消更新 */
    private boolean cancelUpdate = false;

    //推出程序
    Handler mHandler1 = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };
    @Bind(R.id.header)
    Header header;
    @Bind(R.id.mViewPage)
    NoScrollViewPager mViewPage;
    @Bind(R.id.rb0)
    RadioButton rb0;
    @Bind(R.id.rb1)
    RadioButton rb1;
    @Bind(R.id.mRadionGroup)
    RadioGroup mRadionGroup;

    public Fragment fragment0;
    public Fragment fragment1;
    List<Fragment> list=new ArrayList<Fragment>();

    UpAppPresenter presenter;
    String version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        preference = new SharedPreferencesHelper(this, "login");

        new StatusBarUtils().setWindowStatusBarColor(MainActivity.this, R.color.color_bg_selected);
        fragment0=new Fragment0();
        fragment1=new Fragment1();
        list.add(fragment0);
        list.add(fragment1);
        mRadionGroup.setOnCheckedChangeListener(this);
        mViewPage.setAdapter(new FragmentAdapter(getSupportFragmentManager(), list));
        mViewPage.setCurrentItem(0,false);
        presenter=new UpAppPresenterImpl(this,this);
        presenter.upApp();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb0:
                mViewPage.setCurrentItem(0, false);
                break;
            case R.id.rb1:
                mViewPage.setCurrentItem(1, false);
                break;
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
            mHandler1.sendEmptyMessageDelayed(0, 2000);
        } else {
            preference.removeData(this);
            finish();
            System.exit(0);
        }
    }

    @Override
    public void setUser(upApp upapp) {
        version=upapp.getVersion();
        String version1=preference.getData(this,"upApp","");
        if (version1.length()==0){
            saveData(this,"upApp",upapp.getVersion());//程序版本
        }else {
            if (version1.equals(upapp.getVersion())){
                //
            }else {
                //util.showDialog(getResources().getString(R.string.or_upApp),new AlertDialogCallBack alertDialogCallBack );
                final AlertDialog.Builder diolag=new AlertDialog.Builder(MainActivity.this);
                diolag.setTitle(getResources().getString(R.string.title_tips));
                diolag.setMessage(getResources().getString(R.string.or_upApp));
                diolag.setCancelable(false);
                diolag.setPositiveButton(getResources().getString(R.string.title_tips_confim), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ProgressDialogUtil.startLoad(MainActivity.this, Constant.GETDATA);
                        downloadApk();
                    }
                });
                diolag.setNegativeButton(getResources().getString(R.string.camera_cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                diolag.show();
            }
        }
    }
    /**
     * 下载apk文件
     */
    private void downloadApk() {
        // 启动新线程下载软件
        new downloadApkThread().start();
    }
    /**
     * 下载文件线程
     *
     */
    private class downloadApkThread extends Thread{
        @Override
        public void run() {
            try {
                // 判断SD卡是否存在，并且是否具有读写权限
                if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    // 获得存储卡的路径
                    String sdpath = Environment.getExternalStorageDirectory() + "/";
                    mSavePath = sdpath + "download";
                    URL url = new URL(Constant.BASE_URL+"app_download");
                    // 创建连接
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.connect();
                    // 获取文件大小
                    int length = conn.getContentLength();
                    // 创建输入流
                    InputStream is = conn.getInputStream();

                    File file = new File(mSavePath);
                    // 判断文件目录是否存在
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    File apkFile = new File(mSavePath, "myApp.apk");
                    FileOutputStream fos = new FileOutputStream(apkFile);
                    int count = 0;
                    // 缓存
                    byte buf[] = new byte[1024];
                    // 写入到文件中
                    do {
                        int numread = is.read(buf);
                        count += numread;
                        if (numread <= 0) {
                            // 下载完成
                            ProgressDialogUtil.stopLoad();
                            break;
                        }
                        // 写入文件
                        fos.write(buf, 0, numread);
                    } while (!cancelUpdate);// 点击取消就停止下载.
                    // 安装文件
                    installApk();
                    fos.close();
                    is.close();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    /**
     * 安装APK文件
     */
    private void installApk() {
        File apkfile = new File(mSavePath, "myApp.apk");
        if (!apkfile.exists())
        {
            return;
        }
        // 通过Intent安装APK文件
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setDataAndType(Uri.parse("file://" + apkfile.toString()), "application/vnd.android.package-archive");
        startActivity(i);
        saveData(this,"upApp",version);//程序版本
    }

}
