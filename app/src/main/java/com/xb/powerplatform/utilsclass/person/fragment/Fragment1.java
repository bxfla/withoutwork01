package com.xb.powerplatform.utilsclass.person.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xb.powerplatform.R;
import com.xb.powerplatform.SharedPreferencesHelper;
import com.xb.powerplatform.utilsclass.base.Constant;
import com.xb.powerplatform.utilsclass.base.MyApplication;
import com.xb.powerplatform.utilsclass.person.activity.CheckPwdActivity;
import com.xb.powerplatform.utilsclass.person.activity.MyInformActivity;
import com.xb.powerplatform.utilsclass.person.presenter.UpAppPresenter;
import com.xb.powerplatform.utilsclass.person.presenter.presenterImpl.UpAppPresenterImpl;
import com.xb.powerplatform.utilsclass.person.view.UpAppView;
import com.xb.powerplatform.utilsclass.utils.AlertDialogUtil;
import com.xb.powerplatform.utilsclass.utils.ProgressDialogUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.xb.powerplatform.SharedPreferencesHelper.saveData;

/**
 * Created by dell on 2017/8/1.
 */

public class Fragment1 extends Fragment implements UpAppView{
    @Bind(R.id.tvName)
    TextView tvName;
    @Bind(R.id.tvIdcard)
    TextView tvIdcard;
    @Bind(R.id.myinform)
    LinearLayout myinform;
    @Bind(R.id.checkpwd)
    LinearLayout checkpwd;
    @Bind(R.id.upApp)
    LinearLayout upApp;
    private View view;

    UpAppPresenter presenter;
    SharedPreferencesHelper preference;
    private AlertDialogUtil alertDialogUtil;
    private String mSavePath;
    /* 是否取消更新 */
    private boolean cancelUpdate = false;
    String version;
    Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        presenter=new UpAppPresenterImpl(this,getActivity());
        presenter.upApp();
        view = inflater.inflate(R.layout.fragment1, container, false);
        ButterKnife.bind(this, view);
        SharedPreferences preferences=getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        String read=preferences.getString("read", "");
        tvIdcard.setText(read);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.myinform, R.id.checkpwd,R.id.upApp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.myinform:
                intent = new Intent(MyApplication.getContextObject(), MyInformActivity.class);
                startActivity(intent);
                break;
            case R.id.checkpwd:
                intent = new Intent(MyApplication.getContextObject(), CheckPwdActivity.class);
                startActivity(intent);
                break;
            case R.id.upApp:
                String version1=preference.getData(getActivity(),"upApp","");
                if (version1.length()==0){
                    saveData(getActivity(),"upApp",version);//程序版本
                }else {
                    if (version1.equals(version)){
                        alertDialogUtil= new AlertDialogUtil(getActivity());
                        alertDialogUtil.showSmallDialog(getResources().getString(R.string.new_App));
                    }else {
                        //util.showDialog(getResources().getString(R.string.or_upApp),new AlertDialogCallBack alertDialogCallBack );
                        final AlertDialog.Builder diolag=new AlertDialog.Builder(getActivity());
                        diolag.setTitle(getResources().getString(R.string.title_tips));
                        diolag.setMessage(getResources().getString(R.string.or_upApp));
                        diolag.setCancelable(false);
                        diolag.setPositiveButton(getResources().getString(R.string.title_tips_confim), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ProgressDialogUtil.startLoad(getActivity(), Constant.GETDATA);
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
                break;
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
    }

    @Override
    public void setUser(com.xb.powerplatform.utilsclass.person.entity.upApp upapp) {
        version=upapp.getVersion();

    }
}
