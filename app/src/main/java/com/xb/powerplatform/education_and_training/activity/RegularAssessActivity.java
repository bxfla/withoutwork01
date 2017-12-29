package com.xb.powerplatform.education_and_training.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xb.powerplatform.R;
import com.xb.powerplatform.SharedPreferencesHelper;
import com.xb.powerplatform.education_and_training.adapter.RegularAssessAdapter;
import com.xb.powerplatform.education_and_training.bean.RegularAssess;
import com.xb.powerplatform.education_and_training.myview.VoteSubmitViewPager;
import com.xb.powerplatform.education_and_training.presenter.RegulatrPresenter;
import com.xb.powerplatform.education_and_training.presenter.impl.RegularPresenterimpl;
import com.xb.powerplatform.education_and_training.view.RegalarView;
import com.xb.powerplatform.utilsclass.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RegularAssessActivity extends BaseActivity implements RegalarView {
    List<RegularAssess.BodyBean.NewListBean> beanList = new ArrayList<RegularAssess.BodyBean.NewListBean>();
    List<View> viewItems = new ArrayList<View>();
    RegularAssess.BodyBean.RuleBean beanRule;
    SharedPreferencesHelper preference;
    RegulatrPresenter presenter;

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
    RegularAssessAdapter adapter;
    Timer timer;
    TimerTask timerTask;
    int minute = 5;
    int second = 0;
    boolean isPause = false;
    int isFirst;
    String classId=null;
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
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        preference = new SharedPreferencesHelper(this, "login");
        classId= preference.getData(this,"classId","");
        presenter = new RegularPresenterimpl(this, this);
        presenter.getPresenteerData(classId);

        title.setText(getResources().getString(R.string.zaixian_stydy));
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_regularassess;
    }

    @Override
    protected boolean isHasHeader() {
        return false;
    }

    @Override
    protected void rightClient() {

    }

    //view回调
    @Override
    public void getViewData(RegularAssess assess) {
        //考试规则
        //beanRule.erLength=assess.getBody().getRule().erLength;//考试时长
        minute=assess.getBody().getRule().erLength;
        int num=assess.getBody().getRule().erPassMark;//及格分数
        int erPassMark=assess.getBody().getRule().erPassMark;//及格分数
        int erTotalScore=assess.getBody().getRule().erTotalScore;//满分
        int erScoreRadioSafety=assess.getBody().getRule().erScoreRadioSafety;//安全知识单选分值
        int erScoreRadioLaws=assess.getBody().getRule().erScoreRadioLaws;//法律法规单选分数
        int erScoreRadioMajor=assess.getBody().getRule().erScoreRadioMajor;//专业知识单选分数
        int erScoreMultiSafety=assess.getBody().getRule().erScoreMultiSafety;//多选安全知识分值
        int erScoreMultiLaws=assess.getBody().getRule().erScoreMultiLaws;//多选法律法规分数
        int erScoreMultiMajor=assess.getBody().getRule().erScoreMultiMajor;//多选专业知识分数
        int erScoreJudgeSafety=assess.getBody().getRule().erScoreJudgeSafety;//判断安全知识分值
        int erScoreJudgeLaws=assess.getBody().getRule().erScoreJudgeLaws;//判断法律法规分数
        int erScoreJudgeMajor=assess.getBody().getRule().erScoreJudgeMajor;//判断专业知识分数
        beanRule = new RegularAssess.BodyBean.RuleBean(
                minute,erPassMark,erTotalScore,erScoreRadioSafety,erScoreRadioLaws,erScoreRadioMajor,
                erScoreMultiSafety,erScoreMultiLaws,erScoreMultiMajor,erScoreJudgeSafety,
                erScoreJudgeLaws,erScoreJudgeMajor
        );

        //考试题目
        RegularAssess.BodyBean.NewListBean bean = null;
        for (int i = 0; i < assess.getBody().getNewList().size(); i++) {
            bean = new RegularAssess.BodyBean.NewListBean();
            bean.id = assess.getBody().getNewList().get(i).getId();
            bean.quContent = assess.getBody().getNewList().get(i).getQuContent();//题目
            bean.quAnalyze = assess.getBody().getNewList().get(i).getQuAnalyze();//题目解析
            bean.quAnswer = assess.getBody().getNewList().get(i).getQuAnswer();//答案
            bean.quA = assess.getBody().getNewList().get(i).getQuA();
            bean.quB = assess.getBody().getNewList().get(i).getQuB();
            bean.quC = assess.getBody().getNewList().get(i).getQuC();
            bean.quD = assess.getBody().getNewList().get(i).getQuD();
            bean.quE = assess.getBody().getNewList().get(i).getQuE();
            bean.quF = assess.getBody().getNewList().get(i).getQuF();
            bean.quType = assess.getBody().getNewList().get(i).getQuType();//类型 0单选 1多选 2判断
            bean.quCategory = assess.getBody().getNewList().get(i).getQuCategory();//0安全知识 1法律法规 2专业知识
            beanList.add(bean);
        }
        Message message=new Message();
        message.what=1;
        handler.sendMessage(message);
    }

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int time=beanRule.erLength;
            right.setText(String.valueOf(time-1));
            for (int i = 0; i < beanList.size(); i++) {
                viewItems.add(getLayoutInflater().inflate(
                        R.layout.vote_submit_viewpager_item, null));
            }

            adapter = new RegularAssessAdapter(RegularAssessActivity.this, viewItems, beanList,beanRule);
            voteSubmitViewpager.setAdapter(adapter);
            voteSubmitViewpager.getParent()
                    .requestDisallowInterceptTouchEvent(false);
        }
    };

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
                    //uploadExamination(pagerAdapter.errorTopicNum());
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
