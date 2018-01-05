package com.xb.powerplatform.education_and_training.adapter;

import android.database.sqlite.SQLiteDatabase;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.xb.powerplatform.DB.DbManager;
import com.xb.powerplatform.DB.MyDatabaseHelper;
import com.xb.powerplatform.R;
import com.xb.powerplatform.education_and_training.activity.OneSelectActivity;
import com.xb.powerplatform.education_and_training.bean.Question;
import com.xb.powerplatform.education_and_training.util.AddErrorList;
import com.xb.powerplatform.utilsclass.base.MyApplication;

import java.util.ArrayList;
import java.util.List;

import static com.xb.powerplatform.R.id.rbA;
import static com.xb.powerplatform.R.id.rbB;
import static com.xb.powerplatform.R.id.rbC;
import static com.xb.powerplatform.R.id.rbD;
import static com.xb.powerplatform.R.id.rbE;
import static com.xb.powerplatform.R.id.rbF;

/**
 * Created by dell on 2017/12/6.
 */

public class EducationOneSelectAdapter extends PagerAdapter {

    OneSelectActivity mContext;
    // 传递过来的页面view的集合
    List<View> viewItems;
    // 每个item的页面view
    View convertView;
    // 传递过来的所有数据
    List<Question.BodyBean.ListBean> dataItems=new ArrayList<>();
    List<Question.BodyBean.ListBean> beanListE=new ArrayList<>();
    String answer;
    MyDatabaseHelper errorHelper;
    SQLiteDatabase db;

    public EducationOneSelectAdapter(OneSelectActivity context, List<View> viewItems, List<Question.BodyBean.ListBean> beanList) {
        mContext = context;
        this.viewItems = viewItems;
        this.dataItems = beanList;
    }



    //初始化
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        final ViewHolder holder = new ViewHolder();
        errorHelper = DbManager.getInstance(mContext);
        db = errorHelper.getReadableDatabase();
        convertView = viewItems.get(position);
        holder.questionType = (TextView) convertView.findViewById(R.id.activity_prepare_test_no);
        holder.question = (TextView) convertView.findViewById(R.id.activity_prepare_test_question);
        holder.previousBtn = (LinearLayout) convertView.findViewById(R.id.activity_prepare_test_upLayout);
        holder.nextBtn = (LinearLayout) convertView.findViewById(R.id.activity_prepare_test_nextLayout);
        holder.nextText = (TextView) convertView.findViewById(R.id.menu_bottom_nextTV);
        holder.errorBtn = (LinearLayout) convertView.findViewById(R.id.activity_prepare_test_errorLayout);
        holder.totalText = (TextView) convertView.findViewById(R.id.activity_prepare_test_totalTv);
        holder.nextImage = (ImageView) convertView.findViewById(R.id.menu_bottom_nextIV);

        holder.rbA= (RadioButton) convertView.findViewById(rbA);
        holder.rbB= (RadioButton) convertView.findViewById(rbB);
        holder.rbC= (RadioButton) convertView.findViewById(rbC);
        holder.rbD= (RadioButton) convertView.findViewById(rbD);
        holder.rbE= (RadioButton) convertView.findViewById(rbE);
        holder.rbF= (RadioButton) convertView.findViewById(rbF);

        holder.cbA= (CheckBox) convertView.findViewById(R.id.cbA);
        holder.cbB= (CheckBox) convertView.findViewById(R.id.cbB);
        holder.cbC= (CheckBox) convertView.findViewById(R.id.cbC);
        holder.cbD= (CheckBox) convertView.findViewById(R.id.cbD);

        holder.answer= (TextView) convertView.findViewById(R.id.answer);
        holder.result= (TextView) convertView.findViewById(R.id.result);
        holder.ll_result= (LinearLayout) convertView.findViewById(R.id.ll_result);
        container.addView(viewItems.get(position));
        setData(holder, position);
        return viewItems.get(position);
    }

    //ABCD赋值
    private void setData(ViewHolder holder, int position) {
        if (dataItems.get(position).getQuD().length()==0){
            holder.rbD.setVisibility(View.GONE);
        }
        if (dataItems.get(position).getQuC().length()==0){
            holder.rbC.setVisibility(View.GONE);
        }
        if (dataItems.get(position).getQuE().length()==0){
            holder.rbE.setVisibility(View.GONE);
        }
        if (dataItems.get(position).getQuF().length()==0){
            holder.rbF.setVisibility(View.GONE);
        }
        holder.rbA.setText(dataItems.get(position).getQuA());
        holder.rbB.setText(dataItems.get(position).getQuB());
        holder.rbC.setText(dataItems.get(position).getQuC());
        holder.rbD.setText(dataItems.get(position).getQuD());

        holder.cbA.setText(dataItems.get(position).getQuA());
        holder.cbB.setText(dataItems.get(position).getQuB());
        holder.cbC.setText(dataItems.get(position).getQuC());
        holder.cbD.setText(dataItems.get(position).getQuD());
        holder.totalText.setText((position+1)+"/"+dataItems.size());
        holder.question.setText(dataItems.get(position).getQuContent());
        // 最后一页修改"下一步"按钮文字
        if (position == viewItems.size()-1) {
            holder.nextText.setText("提交");
            holder.nextImage.setImageResource(R.drawable.vote_submit_finish);
        }
        //上一题  下一题
        holder.previousBtn.setOnClickListener(new LinearOnClickListenerup(position - 1, false, position, holder));
        holder.nextBtn.setOnClickListener(new LinearOnClickListenernext(position + 1, true, position, holder));
        setClient(holder,position);
    }

    private void setClient(final ViewHolder holder, final int position) {
        holder.rbA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = String.valueOf("A");
                if (!answer.equals(dataItems.get(position).getQuAnswer())) {
                    holder.ll_result.setVisibility(View.VISIBLE);
                    new AddErrorList(db,errorHelper,beanListE,dataItems,position, MyApplication.getContextObject()).AddErrorList();
                    holder.answer.setText(dataItems.get(position).getQuAnswer());
                    holder.result.setText(dataItems.get(position).getQuAnalyze());
                }
            }
        });
        holder.rbB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = String.valueOf("B");
                if (!answer.equals(dataItems.get(position).getQuAnswer())) {
                    holder.ll_result.setVisibility(View.VISIBLE);
                    new AddErrorList(db,errorHelper,beanListE,dataItems,position,
                            MyApplication.getContextObject()).AddErrorList();
                    holder.answer.setText(dataItems.get(position).getQuAnswer());
                    holder.result.setText(dataItems.get(position).getQuAnalyze());
                }
            }
        });
        holder.rbC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = String.valueOf("C");
                if (!answer.equals(dataItems.get(position).getQuAnswer())) {
                    holder.ll_result.setVisibility(View.VISIBLE);
                    new AddErrorList(db,errorHelper,beanListE,dataItems,position, MyApplication.getContextObject()).AddErrorList();
                    holder.answer.setText(dataItems.get(position).getQuAnswer());
                    holder.result.setText(dataItems.get(position).getQuAnalyze());
                }
            }
        });
        holder.rbD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = String.valueOf("D");
                if (!answer.equals(dataItems.get(position).getQuAnswer())) {
                    holder.ll_result.setVisibility(View.VISIBLE);
                    new AddErrorList(db,errorHelper,beanListE,dataItems,position, MyApplication.getContextObject()).AddErrorList();
                    holder.answer.setText(dataItems.get(position).getQuAnswer());
                    holder.result.setText(dataItems.get(position).getQuAnalyze());
                }
            }
        });
        holder.rbE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = String.valueOf("E");
                if (!answer.equals(dataItems.get(position).getQuAnswer())) {
                    holder.ll_result.setVisibility(View.VISIBLE);
                    new AddErrorList(db,errorHelper,beanListE,dataItems,position, MyApplication.getContextObject()).AddErrorList();
                    holder.answer.setText(dataItems.get(position).getQuAnswer());
                    holder.result.setText(dataItems.get(position).getQuAnalyze());
                }
            }
        });
        holder.rbF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = String.valueOf("F");
                if (!answer.equals(dataItems.get(position).getQuAnswer())) {
                    holder.ll_result.setVisibility(View.VISIBLE);
                    new AddErrorList(db,errorHelper,beanListE,dataItems,position, MyApplication.getContextObject()).AddErrorList();
                    holder.answer.setText(dataItems.get(position).getQuAnswer());
                    holder.result.setText(dataItems.get(position).getQuAnalyze());
                }
            }
        });
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
            if (mPosition==-1){
                Toast.makeText(mContext, "已经是第一题", Toast.LENGTH_SHORT).show();
            }else if (mPosition==viewItems.size()){
            }else {
                mContext.setCurrentView(mPosition);
            }
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
            if (mPosition==-1){
                Toast.makeText(mContext, "已经是第一题", Toast.LENGTH_SHORT).show();
            }else if (mPosition>dataItems.size()){
                //待定
            }else {
                mContext.setCurrentView(mPosition);
            }
        }

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
        LinearLayout previousBtn, nextBtn, errorBtn;
        TextView nextText;
        TextView totalText,answer,result;
        ImageView nextImage;
        RadioButton rbA,rbB,rbC,rbD,rbE,rbF;
        CheckBox cbA,cbB,cbC,cbD;
        LinearLayout ll_result;
    }
}
