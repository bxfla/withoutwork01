package com.xb.powerplatform.dailyinspection.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xb.powerplatform.R;
import com.xb.powerplatform.dailyinspection.activity.DailyInpectionXQActivity;
import com.xb.powerplatform.utilsclass.base.MyApplication;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * Created by dell on 2017/11/29.
 */

public class DailyinpectionAdapter extends RecyclerView.Adapter<DailyinpectionAdapter.ViewHolder> {
    private View view;
    static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout ll;
        TextView tv_name,tv_address,tv_money,tv_time;
        public ViewHolder(View itemView) {
            super(itemView);
            ll= (LinearLayout) itemView.findViewById(R.id.ll);
            tv_name= (TextView) itemView.findViewById(R.id.tv_name);
            tv_address= (TextView) itemView.findViewById(R.id.tv_address);
            tv_money= (TextView) itemView.findViewById(R.id.tv_money);
            tv_time= (TextView) itemView.findViewById(R.id.tv_time);
        }
    }
    @Override
    public DailyinpectionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view= LayoutInflater.from(MyApplication.getContextObject()).
                inflate(R.layout.adapter_dailtinpection,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyApplication.getContextObject(), DailyInpectionXQActivity.class);
                intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                MyApplication.getContextObject().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(DailyinpectionAdapter.ViewHolder holder, int position) {
        holder.tv_name.setText("刘德华");
        holder.tv_address.setText("采煤二区");
        holder.tv_money.setText("100");
        holder.tv_time.setText("2017.11.29");
    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
