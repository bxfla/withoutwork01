package com.xb.powerplatform.acceptance_cancellation.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xb.powerplatform.R;
import com.xb.powerplatform.acceptance_cancellation.adapter.AcceptanceAdapter01;
import com.xb.powerplatform.utilsclass.base.MyApplication;
import com.xb.powerplatform.utilsclass.myViews.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by dell on 2017/8/2.
 */

public class AcceptanceFragment01 extends Fragment {

    @Bind(R.id.recycleView)
    RecyclerView recycleView;
    private View view;
    AcceptanceAdapter01 adapter;
    List<String> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_acceptance, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayoutManager manager = new LinearLayoutManager(MyApplication.getContextObject());
        recycleView.setLayoutManager(manager);
        recycleView.addItemDecoration(new DividerItemDecoration(getResources().getColor(R.color.line)
                , 2, LinearLayoutManager.VERTICAL));
        adapter = new AcceptanceAdapter01(getActivity(), list);
        recycleView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
