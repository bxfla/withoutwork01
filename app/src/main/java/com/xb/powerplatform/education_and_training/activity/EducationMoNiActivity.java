package com.xb.powerplatform.education_and_training.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xb.powerplatform.DB.DbManager;
import com.xb.powerplatform.DB.MyDatabaseHelper;
import com.xb.powerplatform.R;
import com.xb.powerplatform.education_and_training.adapter.EducationMoNiAdapter;
import com.xb.powerplatform.education_and_training.bean.assess;
import com.xb.powerplatform.education_and_training.myview.VoteSubmitViewPager;
import com.xb.powerplatform.utilsclass.base.BaseActivity;
import com.xb.powerplatform.utilsclass.myViews.StatusBarUtils;
import com.xb.powerplatform.utilsclass.myViews.ViewPagerScroller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EducationMoNiActivity extends BaseActivity {

    List<assess.BodyBean.ListBean> beanList = new ArrayList<assess.BodyBean.ListBean>();
    List<View> viewItems = new ArrayList<View>();
    @Bind(R.id.left)
    ImageView left;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.right)
    TextView right;
    @Bind(R.id.vote_submit_viewpager)
    VoteSubmitViewPager voteSubmitViewpager;
    @Bind(R.id.vote_submit_linear_dot)
    LinearLayout voteSubmitLinearDot;
    @Bind(R.id.vote_submit_relative)
    RelativeLayout voteSubmitRelative;
    EducationMoNiAdapter adapter;
    Timer timer;
    TimerTask timerTask;
    int minute = 100;
    int second = 0;
    boolean isPause = false;
    int isFirst;

    List<assess.BodyBean.RuleBean> listRb = new ArrayList<>();
    MyDatabaseHelper helper;
    SQLiteDatabase db;

    //停止计时
    private Handler handlerStopTime = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    stopTime();
                    break;
                case 1:
                    startTime();
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }
    };

    Handler handlerTime = new Handler() {
        public void handleMessage(Message msg) {
            // 判断时间快到前2分钟字体颜色改变
            if (minute < 2) {
                right.setTextColor(Color.RED);
            } else {
                right.setTextColor(Color.WHITE);
            }
            if (minute == 0) {
                if (second == 0) {
                    isFirst += 1;
                    // 时间到
                    if (isFirst == 1) {
                        showTimeOutDialog(true, "0");
                    }
                    right.setText("00:00");
                    if (timer != null) {
                        timer.cancel();
                        timer = null;
                    }
                    if (timerTask != null) {
                        timerTask = null;
                    }
                } else {
                    second--;
                    if (second >= 10) {
                        right.setText("0" + minute + ":" + second);
                    } else {
                        right.setText("0" + minute + ":0" + second);
                    }
                }
            } else {
                if (second == 0) {
                    second = 59;
                    minute--;
                    if (minute >= 10) {
                        right.setText(minute + ":" + second);
                    } else {
                        right.setText("0" + minute + ":" + second);
                    }
                } else {
                    second--;
                    if (second >= 10) {
                        if (minute >= 10) {
                            right.setText(minute + ":" + second);
                        } else {
                            right.setText("0" + minute + ":" + second);
                        }
                    } else {
                        if (minute >= 10) {
                            right.setText(minute + ":0" + second);
                        } else {
                            right.setText("0" + minute + ":0" + second);
                        }
                    }
                }
            }
        }

        ;
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        helper= DbManager.getInstance(this);
        db = helper.getReadableDatabase();
        new StatusBarUtils().setWindowStatusBarColor(EducationMoNiActivity.this, R.color.color_bg_selected);
        Intent intent = getIntent();
        beanList = (List<assess.BodyBean.ListBean>) intent.getSerializableExtra("list");
        String classId=intent.getStringExtra("classId");
        Cursor cursor;
        String sql1 = "select * from rule where classid='" + classId + "'";
        cursor = DbManager.queryBySQL(db, sql1, null);
        listRb = DbManager.cursorTorule(cursor);
        int erLength=listRb.get(0).getErLength();
        title.setText(getResources().getString(R.string.moni_training));
        right.setText(String.valueOf(erLength));
        for (int i = 0; i < beanList.size(); i++) {
            viewItems.add(getLayoutInflater().inflate(
                    R.layout.vote_submit_viewpager_item, null));
        }
        adapter = new EducationMoNiAdapter(EducationMoNiActivity.this, viewItems, beanList,classId);
        voteSubmitViewpager.setAdapter(adapter);
        voteSubmitViewpager.getParent()
                .requestDisallowInterceptTouchEvent(false);
       // initViewPagerScroll();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_educationmo_ni;
    }

    @Override
    protected boolean isHasHeader() {
        return false;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick(R.id.left)
    public void onViewClicked() {
        isPause = true;
        showTimeOutDialog(true, "1");
        Message msg = new Message();
        msg.what = 0;
        handlerStopTime.sendMessage(msg);
    }

    /**
     * 设置ViewPager的滑动速度
     */
    private void initViewPagerScroll() {
        try {
            Field mScroller = null;
            mScroller = ViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            ViewPagerScroller scroller = new ViewPagerScroller(voteSubmitViewpager.getContext());
            mScroller.set(voteSubmitViewpager, scroller);
        } catch (NoSuchFieldException e) {

        } catch (IllegalArgumentException e) {

        } catch (IllegalAccessException e) {

        }
    }

    /**
     * @param index 根据索引值切换页面
     */
    public void setCurrentView(int index) {
        voteSubmitViewpager.setCurrentItem(index);
    }

    // 弹出对话框通知用户答题时间到
    protected void showTimeOutDialog(final boolean flag, final String backtype) {
        final Dialog builder = new Dialog(this, R.style.dialog);
        builder.setContentView(R.layout.my_dialog);
        TextView title = (TextView) builder.findViewById(R.id.dialog_title);
        TextView content = (TextView) builder.findViewById(R.id.dialog_content);
        if (backtype.equals("0")) {
            content.setText("您的答题时间结束,是否提交试卷?");
        } else if (backtype.equals("1")) {
            content.setText("您要结束本次模拟答题吗？");
        } else {
            //content.setText(errorMsg+"");
        }
        final Button confirm_btn = (Button) builder
                .findViewById(R.id.dialog_sure);
        Button cancel_btn = (Button) builder.findViewById(R.id.dialog_cancle);
        if (backtype.equals("0")) {
            confirm_btn.setText("提交");
            cancel_btn.setText("退出");
        } else if (backtype.equals("1")) {
            confirm_btn.setText("退出");
            cancel_btn.setText("继续答题");
        } else {
            confirm_btn.setText("确定");
            cancel_btn.setVisibility(View.GONE);
        }
        confirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (backtype.equals("0")) {
                    builder.dismiss();
                    adapter.upData();
                } else {
                    builder.dismiss();
                    adapter.upData();
                }
            }
        });

        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (backtype.equals("0")) {
                    finish();
                    builder.dismiss();
                } else {
                    isPause = false;
                    builder.dismiss();
                    Message msg = new Message();
                    msg.what = 1;
                    handlerStopTime.sendMessage(msg);
                }
            }
        });
        builder.setCanceledOnTouchOutside(false);// 设置点击Dialog外部任意区域关闭Dialog
        builder.setOnKeyListener(new DialogInterface.OnKeyListener() {

            @Override
            public boolean onKey(DialogInterface dialog, int keyCode,
                                 KeyEvent event) {

                return flag;
            }
        });
        builder.show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            isPause = true;
            showTimeOutDialog(true, "1");
            Message msg = new Message();
            msg.what = 0;
            handlerStopTime.sendMessage(msg);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        Message msg = new Message();
        msg.what = 0;
        handlerStopTime.sendMessage(msg);
        super.onPause();
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        Message msg = new Message();
        msg.what = 1;
        handlerStopTime.sendMessage(msg);
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        stopTime();
        minute = -1;
        second = -1;
        super.onDestroy();
    }

    private void startTime() {
        if (timer == null) {
            timer = new Timer();
        }
        if (timerTask == null) {
            timerTask = new TimerTask() {

                @Override
                public void run() {
                    Message msg = new Message();
                    msg.what = 0;
                    handlerTime.sendMessage(msg);
                }
            };
        }
        if (timer != null && timerTask != null) {
            timer.schedule(timerTask, 0, 1000);
        }
    }

    private void stopTime() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        if (timerTask != null) {
            timerTask.cancel();
            timerTask = null;
        }
    }


}
