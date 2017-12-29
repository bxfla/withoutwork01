package com.xb.powerplatform.education_and_training.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.xb.powerplatform.utilsclass.base.MyApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/11/28.
 */

public class TestNormalAdapter extends StaticPagerAdapter {
    List<String> list=new ArrayList<String>();

    public TestNormalAdapter(RollPagerView rellPagerView, List<String> list) {
        this.list=list;
    }

    @Override
    public View getView(ViewGroup viewGroup, int i) {

        ImageView view = new ImageView(viewGroup.getContext());
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        Glide.with(MyApplication.getContextObject())
                .load(list.get(i))
                .into(view);
        return view;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
