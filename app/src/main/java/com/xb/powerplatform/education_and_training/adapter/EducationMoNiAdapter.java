package com.xb.powerplatform.education_and_training.adapter;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.xb.powerplatform.DB.DbManager;
import com.xb.powerplatform.DB.MyDatabaseHelper;
import com.xb.powerplatform.R;
import com.xb.powerplatform.education_and_training.activity.EducationMoNiActivity;
import com.xb.powerplatform.education_and_training.activity.MoNiAssessResultActivity;
import com.xb.powerplatform.education_and_training.bean.Question;
import com.xb.powerplatform.utilsclass.base.MyApplication;

import java.util.ArrayList;
import java.util.List;

import static com.xb.powerplatform.R.id.rbA;
import static com.xb.powerplatform.R.id.rbB;
import static com.xb.powerplatform.R.id.rbC;
import static com.xb.powerplatform.R.id.rbD;

/**
 * Created by dell on 2017/12/6.
 */

public class EducationMoNiAdapter extends PagerAdapter {

    EducationMoNiActivity mContext;
    // 传递过来的页面view的集合
    List<View> viewItems;
    // 每个item的页面view
    View convertView;
    // 传递过来的所有数据
    List<Question.BodyBean.ListBean> dataItems;
    //答案集合
    List<String> beanList = new ArrayList<>();
    String answer;
    int code = 0;
    private float startX; // 声明记录手指落下位置的变量
    List<Question.BodyBean.RuleBean> listRb = new ArrayList<>();

    MyDatabaseHelper errorHelper;
    SQLiteDatabase db;
    String classId;
    int erPassMark;

    public EducationMoNiAdapter(EducationMoNiActivity context, List<View> viewItems, List<Question.BodyBean.ListBean> beanList
            , String classId) {
        mContext = context;
        this.viewItems = viewItems;
        this.dataItems = beanList;
        this.classId = classId;
    }

    //初始化
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        final ViewHolder holder = new ViewHolder();
        convertView = viewItems.get(position);
        holder.questionType = (TextView) convertView.findViewById(R.id.activity_prepare_test_no);
        holder.question = (TextView) convertView.findViewById(R.id.activity_prepare_test_question);
        holder.previousBtn = (LinearLayout) convertView.findViewById(R.id.activity_prepare_test_upLayout);
        holder.nextBtn = (LinearLayout) convertView.findViewById(R.id.activity_prepare_test_nextLayout);
        holder.nextText = (TextView) convertView.findViewById(R.id.menu_bottom_nextTV);
        holder.errorBtn = (LinearLayout) convertView.findViewById(R.id.activity_prepare_test_errorLayout);
        holder.totalText = (TextView) convertView.findViewById(R.id.activity_prepare_test_totalTv);
        holder.nextImage = (ImageView) convertView.findViewById(R.id.menu_bottom_nextIV);

        holder.rbA = (RadioButton) convertView.findViewById(rbA);
        holder.rbB = (RadioButton) convertView.findViewById(rbB);
        holder.rbC = (RadioButton) convertView.findViewById(rbC);
        holder.rbD = (RadioButton) convertView.findViewById(rbD);
        holder.rbE = (RadioButton) convertView.findViewById(R.id.rbE);
        holder.rbF = (RadioButton) convertView.findViewById(R.id.rbF);
        holder.rg = (RadioGroup) convertView.findViewById(R.id.rg);

        holder.cbA = (CheckBox) convertView.findViewById(R.id.cbA);
        holder.cbB = (CheckBox) convertView.findViewById(R.id.cbB);
        holder.cbC = (CheckBox) convertView.findViewById(R.id.cbC);
        holder.cbD = (CheckBox) convertView.findViewById(R.id.cbD);
        holder.cbE = (CheckBox) convertView.findViewById(R.id.cbE);
        holder.cbF = (CheckBox) convertView.findViewById(R.id.cbF);
        holder.llQuestion = (LinearLayout) convertView.findViewById(R.id.ll);

        container.addView(viewItems.get(position));
        setData(holder, position);
        setClient(position, holder, convertView);
        return viewItems.get(position);
    }

    //滑动监听
    private void setClient(final int position, final ViewHolder holder, View convertView) {
        convertView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    // 手指落下
                    case MotionEvent.ACTION_DOWN: {
                        startX = event.getX();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        // 从右向左滑动
                        if (event.getX() - startX > 50) {
                            new LinearOnClickListenerup(position - 1, false, position, holder);
                        }
                        if (startX - event.getX() > 50) {
                            new LinearOnClickListenernext(position + 1, true, position, holder);
                        }

                    }
                }

                return true;
            }
        });
    }

    //ABCD赋值
    private void setData(ViewHolder holder, int position) {
        //单选
        if (dataItems.get(position).getQuType().equals("0")) {
            if (dataItems.get(position).getQuD().length() == 0) {
                holder.rbD.setVisibility(View.GONE);
            }
            if (dataItems.get(position).getQuC().length() == 0) {
                holder.rbC.setVisibility(View.GONE);
            }
            if (dataItems.get(position).getQuE().length() == 0) {
                holder.rbE.setVisibility(View.GONE);
            }
            if (dataItems.get(position).getQuF().length() == 0) {
                holder.rbF.setVisibility(View.GONE);
            }
        }
        ////多选
        if (dataItems.get(position).getQuType().equals("1")) {
            holder.rg.setVisibility(View.GONE);
            holder.llQuestion.setVisibility(View.VISIBLE);
            if (dataItems.get(position).getQuD().length() == 0) {
                holder.cbD.setVisibility(View.GONE);
            }
            if (dataItems.get(position).getQuC().length() == 0) {
                holder.cbC.setVisibility(View.GONE);
            }
            if (dataItems.get(position).getQuE().length() == 0) {
                holder.cbE.setVisibility(View.GONE);
            }
            if (dataItems.get(position).getQuF().length() == 0) {
                holder.cbF.setVisibility(View.GONE);
            }
        }

        //判断
        if (dataItems.get(position).getQuType().equals("2")) {
            holder.rbD.setVisibility(View.GONE);
            holder.rbC.setVisibility(View.GONE);
            holder.rbE.setVisibility(View.GONE);
            holder.rbF.setVisibility(View.GONE);
        }

        holder.rbA.setText(dataItems.get(position).getQuA());
        holder.rbB.setText(dataItems.get(position).getQuB());
        holder.rbC.setText(dataItems.get(position).getQuC());
        holder.rbD.setText(dataItems.get(position).getQuD());
        holder.rbE.setText(dataItems.get(position).getQuE());
        holder.rbF.setText(dataItems.get(position).getQuF());

        holder.cbA.setText(dataItems.get(position).getQuA());
        holder.cbB.setText(dataItems.get(position).getQuB());
        holder.cbC.setText(dataItems.get(position).getQuC());
        holder.cbD.setText(dataItems.get(position).getQuD());
        holder.cbE.setText(dataItems.get(position).getQuE());
        holder.cbF.setText(dataItems.get(position).getQuF());
        holder.totalText.setText((position + 1) + "/" + dataItems.size());
        holder.question.setText(dataItems.get(position).getQuContent());
        // 最后一页修改"下一步"按钮文字
        if (position == viewItems.size() - 1) {
            holder.nextText.setText("提交");
            holder.nextImage.setImageResource(R.drawable.vote_submit_finish);
        }
        //上一题  下一题
        holder.previousBtn.setOnClickListener(new LinearOnClickListenerup(position - 1, false, position, holder));
        holder.nextBtn.setOnClickListener(new LinearOnClickListenernext(position + 1, true, position, holder));
    }

    /**
     * @author 设置下一步按钮监听
     */
    class LinearOnClickListenernext implements View.OnClickListener {

        private int mPosition;
        private int mPosition1;
        private boolean mIsNext;
        private ViewHolder viewHolder;

        public LinearOnClickListenernext(int position, boolean mIsNext, int position1, ViewHolder viewHolder) {
            mPosition = position;
            mPosition1 = position1;
            this.viewHolder = viewHolder;
            this.mIsNext = mIsNext;
        }

        @Override
        public void onClick(View v) {
            answer = null;
            if (mPosition == -1) {
                Toast.makeText(mContext, "已经是第一题", Toast.LENGTH_SHORT).show();
            } else if (mPosition == viewItems.size()) {
                addAnswerToList(viewHolder, mPosition1, mPosition);
                upData();
            } else {
                addAnswerToList(viewHolder, mPosition1, mPosition);
            }
        }
    }

    //保存答案到list
    private void addAnswerToList(ViewHolder viewHolder, int mPosition1, int mPosition) {
        if (beanList.size() < mPosition) {
            //单选
            if (viewHolder.rbA.isChecked()) {
                answer = "A";
            } else if (viewHolder.rbB.isChecked()) {
                answer = "B";
            } else if (viewHolder.rbC.isChecked()) {
                answer = "C";
            } else if (viewHolder.rbD.isChecked()) {
                answer = "D";
            } else if (viewHolder.rbE.isChecked()) {
                answer = "E";
            } else if (viewHolder.rbF.isChecked()) {
                answer = "F";
            }

            //多选
            if (viewHolder.cbA.isChecked() && viewHolder.cbB.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbE.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "ABCDEF";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbB.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbE.isChecked()) {
                answer = "ABCDE";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbB.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "ABCDF";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbE.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "ACDEF";
            } else if (viewHolder.cbB.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbE.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "BCDEF";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbB.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked()) {
                answer = "ABCD";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbB.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbE.isChecked()) {
                answer = "ABCE";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbB.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "ABCF";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbE.isChecked()) {
                answer = "ACDE";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "ACDF";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbE.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "ADEF";
            } else if (viewHolder.cbB.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbE.isChecked()) {
                answer = "BCDE";
            } else if (viewHolder.cbB.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "BCDF";
            } else if (viewHolder.cbB.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbE.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "BDEF";
            } else if (viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbE.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "CDEF";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbB.isChecked() && viewHolder.cbC.isChecked()) {
                answer = "ABC";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbB.isChecked() && viewHolder.cbD.isChecked()) {
                answer = "ABD";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbB.isChecked() && viewHolder.cbE.isChecked()) {
                answer = "ABE";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbB.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "ABF";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked()) {
                answer = "ACD";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbE.isChecked()) {
                answer = "ACE";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "ACF";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbE.isChecked()) {
                answer = "ADE";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "ADF";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbE.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "AEF";
            } else if (viewHolder.cbB.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked()) {
                answer = "BCD";
            } else if (viewHolder.cbB.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbE.isChecked()) {
                answer = "BCE";
            } else if (viewHolder.cbB.isChecked() && viewHolder.cbC.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "BCF";
            } else if (viewHolder.cbB.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbE.isChecked()) {
                answer = "BDE";
            } else if (viewHolder.cbB.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "BDF";
            } else if (viewHolder.cbB.isChecked() && viewHolder.cbE.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "BEF";
            } else if (viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbE.isChecked()) {
                answer = "CDE";
            } else if (viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "CDF";
            } else if (viewHolder.cbC.isChecked() && viewHolder.cbE.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "CEF";
            } else if (viewHolder.cbD.isChecked() && viewHolder.cbE.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "DEF";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbB.isChecked()) {
                answer = "AB";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbC.isChecked()) {
                answer = "AC";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbD.isChecked()) {
                answer = "AD";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbE.isChecked()) {
                answer = "AE";
            } else if (viewHolder.cbA.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "AF";
            } else if (viewHolder.cbB.isChecked() && viewHolder.cbC.isChecked()) {
                answer = "BC";
            } else if (viewHolder.cbB.isChecked() && viewHolder.cbD.isChecked()) {
                answer = "BD";
            } else if (viewHolder.cbB.isChecked() && viewHolder.cbE.isChecked()) {
                answer = "BE";
            } else if (viewHolder.cbB.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "BF";
            } else if (viewHolder.cbC.isChecked() && viewHolder.cbD.isChecked()) {
                answer = "CD";
            } else if (viewHolder.cbC.isChecked() && viewHolder.cbE.isChecked()) {
                answer = "CE";
            } else if (viewHolder.cbC.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "CF";
            } else if (viewHolder.cbD.isChecked() && viewHolder.cbE.isChecked()) {
                answer = "DE";
            } else if (viewHolder.cbD.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "DF";
            } else if (viewHolder.cbE.isChecked() && viewHolder.cbF.isChecked()) {
                answer = "EF";
            } else if (viewHolder.cbA.isChecked()) {
                answer = "A";
            } else if (viewHolder.cbB.isChecked()) {
                answer = "B";
            } else if (viewHolder.cbC.isChecked()) {
                answer = "C";
            } else if (viewHolder.cbD.isChecked()) {
                answer = "D";
            } else if (viewHolder.cbE.isChecked()) {
                answer = "E";
            } else if (viewHolder.cbF.isChecked()) {
                answer = "F";
            }
            if (answer != null) {
//                if (!answer.equals(dataItems.get(mPosition1).getQuAnswer())) {
//                    addErrorDb(mPosition1);
//                }
                beanList.add(answer);
                mContext.setCurrentView(mPosition);
            } else {
                Toast.makeText(mContext, "请先选择选项", Toast.LENGTH_SHORT).show();
            }
        } else {
            mContext.setCurrentView(mPosition);
        }
    }


    /**
     * @author 设置上一步按钮监听
     */
    public class LinearOnClickListenerup implements View.OnClickListener {

        private int mPosition;
        private int mPosition1;
        private boolean mIsNext;
        private ViewHolder viewHolder;

        public LinearOnClickListenerup(int position, boolean mIsNext, int position1, ViewHolder viewHolder) {
            mPosition = position;
            mPosition1 = position1;
            this.viewHolder = viewHolder;
            this.mIsNext = mIsNext;
        }

        @Override
        public void onClick(View v) {
            if (mPosition == -1) {
                Toast.makeText(mContext, "已经是第一题", Toast.LENGTH_SHORT).show();
            } else if (mPosition > dataItems.size()) {
                //待定
            } else {
                mContext.setCurrentView(mPosition);
            }
        }

    }

    //启动得分activity
    public void upData() {
        String sql1 = "select * from rule where classid='" + classId + "'";
        Cursor cursor;
        errorHelper = DbManager.getInstance(mContext);
        db = errorHelper.getReadableDatabase();
        cursor = DbManager.queryBySQL(db, sql1, null);
//        if (listRb.size()==0){
//            code=0;
//        }else {
        listRb = DbManager.cursorTorule(cursor);
        int radioSafety = listRb.get(0).getErScoreRadioSafety();//单选安全知识分数
        int radioLaws = listRb.get(0).getErScoreRadioLaws();//单选法律法规分数
        int radioMajor = listRb.get(0).getErScoreRadioMajor();//单选安全知识分数
        int multiSafety = listRb.get(0).getErScoreMultiSafety();//多选安全知识分数
        int multiLaws = listRb.get(0).getErScoreMultiLaws();//多选法律法规分数
        int multiMajor = listRb.get(0).getErScoreMultiMajor();//多选安全知识分数
        int judgeSafety = listRb.get(0).getErScoreJudgeSafety();
        int judgeLaws = listRb.get(0).getErScoreJudgeLaws();
        int judgeMajor = listRb.get(0).getErScoreJudgeMajor();
        erPassMark = listRb.get(0).getErPassMark();
        int erLength = listRb.get(0).getErLength();
        for (int i = 0; i < beanList.size(); i++) {
            if (dataItems.get(i).getQuType().equals("0")) {
                if (dataItems.get(i).getQuCategory().equals("0")) {
                    if (beanList.get(i).equals(dataItems.get(i).getQuAnswer())) {
                        code += radioSafety;
                    }
                }
                if (dataItems.get(i).getQuCategory().equals("1")) {
                    if (beanList.get(i).equals(dataItems.get(i).getQuAnswer())) {
                        code += radioLaws;
                    }
                }
                if (dataItems.get(i).getQuCategory().equals("2")) {
                    if (beanList.get(i).equals(dataItems.get(i).getQuAnswer())) {
                        code += radioMajor;
                    }
                }
            } else if (dataItems.get(i).getQuType().equals("1")) {
                if (dataItems.get(i).getQuCategory().equals("0")) {
                    if (beanList.get(i).equals(dataItems.get(i).getQuAnswer())) {
                        code += multiSafety;
                    }
                }
                if (dataItems.get(i).getQuCategory().equals("1")) {
                    if (beanList.get(i).equals(dataItems.get(i).getQuAnswer())) {
                        code += multiLaws;
                    }
                }
                if (dataItems.get(i).getQuCategory().equals("2")) {
                    if (beanList.get(i).equals(dataItems.get(i).getQuAnswer())) {
                        code += multiMajor;
                    }
                }
            } else if (dataItems.get(i).getQuType().equals("2")) {
                if (dataItems.get(i).getQuCategory().equals("0")) {
                    if (beanList.get(i).equals(dataItems.get(i).getQuAnswer())) {
                        code += judgeSafety;
                    }
                }
                if (dataItems.get(i).getQuCategory().equals("1")) {
                    if (beanList.get(i).equals(dataItems.get(i).getQuAnswer())) {
                        code += judgeLaws;
                    }
                }
                if (dataItems.get(i).getQuCategory().equals("2")) {
                    if (beanList.get(i).equals(dataItems.get(i).getQuAnswer())) {
                        code += judgeMajor;
                    }
                }
            }
        }
        //}

        Intent intent = new Intent(mContext, MoNiAssessResultActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("score", code);
        bundle.putInt("passnum", erPassMark);
        intent.putExtras(bundle);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        MyApplication.getContextObject().startActivity(intent);
        mContext.finish();
    }

    @Override
    public int getCount() {
        if (viewItems == null)
            return 0;
        return viewItems.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewItems.get(position));
    }

    public class ViewHolder {
        TextView questionType;
        TextView question;
        LinearLayout previousBtn, nextBtn, errorBtn, llQuestion;
        TextView nextText;
        TextView totalText;
        ImageView nextImage;
        RadioButton rbA, rbB, rbC, rbD, rbE, rbF;
        CheckBox cbA, cbB, cbC, cbD, cbE, cbF;
        RadioGroup rg;
    }
}
