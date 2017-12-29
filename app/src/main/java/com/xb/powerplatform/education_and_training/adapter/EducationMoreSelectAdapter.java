package com.xb.powerplatform.education_and_training.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.xb.powerplatform.R;
import com.xb.powerplatform.education_and_training.activity.MoreSelectActivity;
import com.xb.powerplatform.education_and_training.bean.assess;

import java.util.List;

import static com.xb.powerplatform.R.id.btn;
import static com.xb.powerplatform.R.id.rbA;
import static com.xb.powerplatform.R.id.rbB;
import static com.xb.powerplatform.R.id.rbC;
import static com.xb.powerplatform.R.id.rbD;

/**
 * Created by dell on 2017/12/6.
 */

public class EducationMoreSelectAdapter extends PagerAdapter {

    MoreSelectActivity mContext;
    // 传递过来的页面view的集合
    List<View> viewItems;
    // 每个item的页面view
    View convertView;
    // 传递过来的所有数据
    List<assess.BodyBean.ListBean> dataItems;
    String answer,answer1,answer2,answer3,answer4;
    int code=0;

    public EducationMoreSelectAdapter(MoreSelectActivity context, List<View> viewItems, List<assess.BodyBean.ListBean> beanList) {
        mContext = context;
        this.viewItems = viewItems;
        this.dataItems = beanList;
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

        holder.rbA= (RadioButton) convertView.findViewById(rbA);
        holder.rbB= (RadioButton) convertView.findViewById(rbB);
        holder.rbC= (RadioButton) convertView.findViewById(rbC);
        holder.rbD= (RadioButton) convertView.findViewById(rbD);

        holder.cbA= (CheckBox) convertView.findViewById(R.id.cbA);
        holder.cbB= (CheckBox) convertView.findViewById(R.id.cbB);
        holder.cbC= (CheckBox) convertView.findViewById(R.id.cbC);
        holder.cbD= (CheckBox) convertView.findViewById(R.id.cbD);
        holder.cbE= (CheckBox) convertView.findViewById(R.id.cbE);
        holder.cbF= (CheckBox) convertView.findViewById(R.id.cbF);
        holder.ll_text= (LinearLayout) convertView.findViewById(R.id.ll_text);

        holder.rg= (RadioGroup) convertView.findViewById(R.id.rg);
        holder.ll= (LinearLayout) convertView.findViewById(R.id.ll);
        holder.rg.setVisibility(View.GONE);
        holder.ll.setVisibility(View.VISIBLE);

        holder.btn= (Button) convertView.findViewById(btn);
        holder.btn.setVisibility(View.VISIBLE);

        holder.answer= (TextView) convertView.findViewById(R.id.answer);
        holder.result= (TextView) convertView.findViewById(R.id.result);
        holder.ll_result= (LinearLayout) convertView.findViewById(R.id.ll_result);
        container.addView(viewItems.get(position));
        setData(holder, position);
        return viewItems.get(position);
    }

    //ABCD赋值
    private void setData(ViewHolder holder, int position) {
        if (dataItems.get(position).getQuType().equals("1")){
            holder.rg.setVisibility(View.GONE);
            if (dataItems.get(position).getQuD().length()==0){
                holder.cbD.setVisibility(View.GONE);
            }
            if (dataItems.get(position).getQuC().length()==0){
                holder.cbC.setVisibility(View.GONE);
            }
            if (dataItems.get(position).getQuE().length()==0){
                holder.cbE.setVisibility(View.GONE);
            }
            if (dataItems.get(position).getQuF().length()==0){
                holder.cbF.setVisibility(View.GONE);
            }
        }
        holder.rbA.setText(dataItems.get(position).getQuA());
        holder.rbB.setText(dataItems.get(position).getQuB());
        holder.rbC.setText(dataItems.get(position).getQuC());
        holder.rbD.setText(dataItems.get(position).getQuD());

        holder.cbA.setText(dataItems.get(position).getQuA());
        holder.cbB.setText(dataItems.get(position).getQuB());
        holder.cbC.setText(dataItems.get(position).getQuC());
        holder.cbD.setText(dataItems.get(position).getQuD());
        holder.cbE.setText(dataItems.get(position).getQuE());
        holder.cbF.setText(dataItems.get(position).getQuF());

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

    private void setClient(final ViewHolder viewHolder, final int position) {
        viewHolder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //多选
                if (viewHolder.cbA.isChecked()&&viewHolder.cbB.isChecked()&&viewHolder.cbC.isChecked()&&viewHolder.cbD.isChecked()&&viewHolder.cbE.isChecked()&&viewHolder.cbF.isChecked()){
                    answer="ABCDEF";
                }else if (viewHolder.cbA.isChecked()&&viewHolder.cbB.isChecked()&&viewHolder.cbC.isChecked()&&viewHolder.cbD.isChecked()&&viewHolder.cbE.isChecked()){
                    answer="ABCDE";
                }else if (viewHolder.cbA.isChecked()&&viewHolder.cbB.isChecked()&&viewHolder.cbC.isChecked()&&viewHolder.cbD.isChecked()&&viewHolder.cbF.isChecked()){
                    answer="ABCDF";
                }else if (viewHolder.cbA.isChecked()&&viewHolder.cbC.isChecked()&&viewHolder.cbD.isChecked()&&viewHolder.cbE.isChecked()&&viewHolder.cbF.isChecked()){
                    answer="ACDEF";
                }else if (viewHolder.cbB.isChecked()&&viewHolder.cbC.isChecked()&&viewHolder.cbD.isChecked()&&viewHolder.cbE.isChecked()&&viewHolder.cbF.isChecked()){
                    answer="BCDEF";
                }else if (viewHolder.cbA.isChecked()&&viewHolder.cbB.isChecked()&&viewHolder.cbC.isChecked()&&viewHolder.cbD.isChecked()){
                    answer="ABCD";
                }else if (viewHolder.cbA.isChecked()&&viewHolder.cbB.isChecked()&&viewHolder.cbC.isChecked()&&viewHolder.cbE.isChecked()){
                    answer="ABCE";
                }else if (viewHolder.cbA.isChecked()&&viewHolder.cbB.isChecked()&&viewHolder.cbC.isChecked()&&viewHolder.cbF.isChecked()){
                    answer="ABCF";
                }else if (viewHolder.cbA.isChecked()&&viewHolder.cbC.isChecked()&&viewHolder.cbD.isChecked()&&viewHolder.cbE.isChecked()){
                    answer="ACDE";
                }else if (viewHolder.cbA.isChecked()&&viewHolder.cbC.isChecked()&&viewHolder.cbD.isChecked()&&viewHolder.cbF.isChecked()){
                    answer="ACDF";
                }else if (viewHolder.cbA.isChecked()&&viewHolder.cbD.isChecked()&&viewHolder.cbE.isChecked()&&viewHolder.cbF.isChecked()){
                    answer="ADEF";
                }else if (viewHolder.cbB.isChecked()&&viewHolder.cbC.isChecked()&&viewHolder.cbD.isChecked()&&viewHolder.cbE.isChecked()){
                    answer="BCDE";
                }else if (viewHolder.cbB.isChecked()&&viewHolder.cbC.isChecked()&&viewHolder.cbD.isChecked()&&viewHolder.cbF.isChecked()){
                    answer="BCDF";
                }else if (viewHolder.cbB.isChecked()&&viewHolder.cbD.isChecked()&&viewHolder.cbE.isChecked()&&viewHolder.cbF.isChecked()){
                    answer="BDEF";
                }else if (viewHolder.cbC.isChecked()&&viewHolder.cbD.isChecked()&&viewHolder.cbE.isChecked()&&viewHolder.cbF.isChecked()){
                    answer="CDEF";
                }else if (viewHolder.cbA.isChecked()&&viewHolder.cbB.isChecked()&&viewHolder.cbC.isChecked()){
                    answer="ABC";
                }else if (viewHolder.cbA.isChecked()&&viewHolder.cbB.isChecked()&&viewHolder.cbD.isChecked()){
                    answer="ABD";
                }else if (viewHolder.cbA.isChecked()&&viewHolder.cbB.isChecked()&&viewHolder.cbE.isChecked()){
                    answer="ABE";
                }else if (viewHolder.cbA.isChecked()&&viewHolder.cbB.isChecked()&&viewHolder.cbF.isChecked()){
                    answer="ABF";
                }else if (viewHolder.cbA.isChecked()&&viewHolder.cbC.isChecked()&&viewHolder.cbD.isChecked()){
                    answer="ACD";
                }else if (viewHolder.cbA.isChecked()&&viewHolder.cbC.isChecked()&&viewHolder.cbE.isChecked()){
                    answer="ACE";
                }else if (viewHolder.cbA.isChecked()&&viewHolder.cbC.isChecked()&&viewHolder.cbF.isChecked()){
                    answer="ACF";
                }else if (viewHolder.cbA.isChecked()&&viewHolder.cbD.isChecked()&&viewHolder.cbE.isChecked()){
                    answer="ADE";
                }else if (viewHolder.cbA.isChecked()&&viewHolder.cbD.isChecked()&&viewHolder.cbF.isChecked()){
                    answer="ADF";
                }else if (viewHolder.cbA.isChecked()&&viewHolder.cbE.isChecked()&&viewHolder.cbF.isChecked()){
                    answer="AEF";
                }else if (viewHolder.cbB.isChecked()&&viewHolder.cbC.isChecked()&&viewHolder.cbD.isChecked()){
                    answer="BCD";
                }else if (viewHolder.cbB.isChecked()&&viewHolder.cbC.isChecked()&&viewHolder.cbE.isChecked()){
                    answer="BCE";
                }else if (viewHolder.cbB.isChecked()&&viewHolder.cbC.isChecked()&&viewHolder.cbF.isChecked()){
                    answer="BCF";
                }else if (viewHolder.cbB.isChecked()&&viewHolder.cbD.isChecked()&&viewHolder.cbE.isChecked()){
                    answer="BDE";
                }else if (viewHolder.cbB.isChecked()&&viewHolder.cbD.isChecked()&&viewHolder.cbF.isChecked()){
                    answer="BDF";
                }else if (viewHolder.cbB.isChecked()&&viewHolder.cbE.isChecked()&&viewHolder.cbF.isChecked()){
                    answer="BEF";
                }else if (viewHolder.cbC.isChecked()&&viewHolder.cbD.isChecked()&&viewHolder.cbE.isChecked()){
                    answer="CDE";
                }else if (viewHolder.cbC.isChecked()&&viewHolder.cbD.isChecked()&&viewHolder.cbF.isChecked()){
                    answer="CDF";
                }else if (viewHolder.cbC.isChecked()&&viewHolder.cbE.isChecked()&&viewHolder.cbF.isChecked()){
                    answer="CEF";
                }else if (viewHolder.cbD.isChecked()&&viewHolder.cbE.isChecked()&&viewHolder.cbF.isChecked()){
                    answer="DEF";
                }else if (viewHolder.cbA.isChecked()&&viewHolder.cbB.isChecked()){
                    answer="AB";
                }else if (viewHolder.cbA.isChecked()&&viewHolder.cbC.isChecked()){
                    answer="AC";
                }else if (viewHolder.cbA.isChecked()&&viewHolder.cbD.isChecked()){
                    answer="AD";
                }else if (viewHolder.cbA.isChecked()&&viewHolder.cbE.isChecked()){
                    answer="AE";
                }else if (viewHolder.cbA.isChecked()&&viewHolder.cbF.isChecked()){
                    answer="AF";
                } else if (viewHolder.cbB.isChecked()&&viewHolder.cbC.isChecked()){
                    answer="BC";
                }else if (viewHolder.cbB.isChecked()&&viewHolder.cbD.isChecked()){
                    answer="BD";
                }else if (viewHolder.cbB.isChecked()&&viewHolder.cbE.isChecked()){
                    answer="BE";
                }else if (viewHolder.cbB.isChecked()&&viewHolder.cbF.isChecked()){
                    answer="BF";
                }else if (viewHolder.cbC.isChecked()&&viewHolder.cbD.isChecked()){
                    answer="CD";
                }else if (viewHolder.cbC.isChecked()&&viewHolder.cbE.isChecked()){
                    answer="CE";
                }else if (viewHolder.cbC.isChecked()&&viewHolder.cbF.isChecked()){
                    answer="CF";
                }else if (viewHolder.cbD.isChecked()&&viewHolder.cbE.isChecked()){
                    answer="DE";
                }else if (viewHolder.cbD.isChecked()&&viewHolder.cbF.isChecked()){
                    answer="DF";
                }else if (viewHolder.cbE.isChecked()&&viewHolder.cbF.isChecked()){
                    answer="EF";
                }else if (viewHolder.cbA.isChecked()){
                    answer="A";
                }else if (viewHolder.cbB.isChecked()){
                    answer="B";
                }else if (viewHolder.cbC.isChecked()){
                    answer="C";
                }else if (viewHolder.cbD.isChecked()){
                    answer="D";
                }else if (viewHolder.cbE.isChecked()){
                    answer="E";
                }else if (viewHolder.cbF.isChecked()){
                    answer="F";
                }
                if (!answer.equals(dataItems.get(position).getQuAnswer())) {
                    viewHolder.ll_result.setVisibility(View.VISIBLE);
                    viewHolder.answer.setText(dataItems.get(position).getQuAnswer());
                    viewHolder.result.setText(dataItems.get(position).getQuAnalyze());
                }else {
                    viewHolder.ll_result.setVisibility(View.VISIBLE);
                    viewHolder.answer.setVisibility(View.GONE);
                    viewHolder.ll_text.setVisibility(View.GONE);
                    viewHolder.result.setText("回答正确");
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
        RadioButton rbA,rbB,rbC,rbD;
        CheckBox cbA,cbB,cbC,cbD,cbE,cbF;
        LinearLayout ll_result;
        RadioGroup rg;
        LinearLayout ll,ll_text;
        Button btn;
    }
}
