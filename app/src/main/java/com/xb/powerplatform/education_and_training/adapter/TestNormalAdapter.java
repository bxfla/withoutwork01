package com.xb.powerplatform.education_and_training.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.xb.powerplatform.R;

/**
 * Created by dell on 2017/11/28.
 */

public class TestNormalAdapter extends StaticPagerAdapter {
    //List<String> list=new ArrayList<String>();

    private int[] imgs = {
            R.drawable.image01,
            R.drawable.image02,
            R.drawable.banner,
    };

    @Override
    public View getView(ViewGroup viewGroup, int i) {

        ImageView view = new ImageView(viewGroup.getContext());
        view.setImageResource(imgs[i]);
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        Glide.with(MyApplication.getContextObject())
//                .load(list.get(i))
//                .into(view);
        return view;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }
}
