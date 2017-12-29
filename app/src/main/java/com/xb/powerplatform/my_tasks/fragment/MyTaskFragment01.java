package com.xb.powerplatform.my_tasks.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xb.powerplatform.R;
import com.xb.powerplatform.my_tasks.adapter.MyTasksAdapter;
import com.xb.powerplatform.utilsclass.base.MyApplication;
import com.xb.powerplatform.utilsclass.myViews.DividerItemDecoration;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by dell on 2017/8/4.
 */

public class MyTaskFragment01 extends Fragment {
    @Bind(R.id.recycleView)
    RecyclerView recycleView;
    private View view;
    MyTasksAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_mytasks_yinhuan, container, false);
        ButterKnife.bind(this, view);
        LinearLayoutManager manager = new LinearLayoutManager(MyApplication.getContextObject());
        recycleView.setLayoutManager(manager);
        recycleView.addItemDecoration(new DividerItemDecoration(getResources().getColor(R.color.line)
                , 2, LinearLayoutManager.VERTICAL));
        adapter=new MyTasksAdapter();
        recycleView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
