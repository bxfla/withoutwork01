package com.xb.powerplatform.utilsclass.person.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xb.powerplatform.R;
import com.xb.powerplatform.moring_paper.activity.MoringPaperXQActivity;
import com.xb.powerplatform.utilsclass.base.MyApplication;

import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * Created by dell on 2018/1/3.
 */

public class AssessLineAdapter extends RecyclerView.Adapter<AssessLineAdapter.ViewHolder> {
    Context context;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.textView);
        }
    }
    public AssessLineAdapter(Context context, List<String> mList){
        // this.mList=mList;
        this.context=context;
    }

    @Override
    public AssessLineAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context)
                .inflate(R.layout.adapter_acceptance,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Intent intent=new Intent(MyApplication.getContextObject(), MoringPaperXQActivity.class);
                intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                MyApplication.getContextObject().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(AssessLineAdapter.ViewHolder holder, int position) {
        holder.textView.setText("各区域水雾帘要迎向风流、封闭全断面，转载点喷雾对\n" +
                "\"准转载点，要固定牢固、施雾化效果好，掘进皮带连续化运\\n\" +\n" +
                "\"输也必须安装转载点喷雾。防尘设施检查时要全部开启并，\\n\" +\n" +
                "\"大巷自动喷雾正常使用。");
    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
