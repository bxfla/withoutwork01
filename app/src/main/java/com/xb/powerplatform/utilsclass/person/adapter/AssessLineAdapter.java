package com.xb.powerplatform.utilsclass.person.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xb.powerplatform.R;
import com.xb.powerplatform.utilsclass.person.activity.AssessLineActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2018/1/3.
 */

public class AssessLineAdapter extends RecyclerView.Adapter<AssessLineAdapter.ViewHolder> {
    Context context;
    List<String>mList=new ArrayList<>();
    List<String>mList1=new ArrayList<>();

    public AssessLineAdapter(AssessLineActivity assessLineActivity, List<String> beanList, List<String> beanList1) {
        this.mList=beanList;
        this.mList1=beanList1;
        this.context=assessLineActivity;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        TextView textView1;
        public ViewHolder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.textView);
            textView1= (TextView) itemView.findViewById(R.id.textView1);
        }
    }

    @Override
    public AssessLineAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context)
                .inflate(R.layout.adapter_acceptance,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(AssessLineAdapter.ViewHolder holder, int position) {
        holder.textView.setText(mList.get(position));
        holder.textView1.setText(mList1.get(position)+"分");
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
