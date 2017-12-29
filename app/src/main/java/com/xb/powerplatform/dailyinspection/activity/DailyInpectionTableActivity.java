package com.xb.powerplatform.dailyinspection.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import com.xb.powerplatform.R;
import com.xb.powerplatform.dailyinspection.adapter.MySystemExpandAdapter;
import com.xb.powerplatform.dailyinspection.bean.SystemBean;
import com.xb.powerplatform.dailyinspection.bean.SystemChildBean;
import com.xb.powerplatform.utilsclass.base.BaseActivity;
import com.xb.powerplatform.utilsclass.myViews.Header;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DailyInpectionTableActivity extends BaseActivity {

    @Bind(R.id.header)
    Header header;
    @Bind(R.id.Ex_listview)
    ExpandableListView ExListview;
    private MySystemExpandAdapter adapter;
    List<SystemBean> list = new ArrayList<SystemBean>();
    //List<Assess> assess = new ArrayList<Assess>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        getGroupList();
        setClient();
    }

    //布局
    @Override
    protected int provideContentViewId() {
        return R.layout.activity_dailyinpection_table;
    }

    //是否显示头部
    @Override
    protected boolean isHasHeader() {
        return true;
    }

    //头部右侧点击事件
    @Override
    protected void rightClient() {
    }

    //ExpandableListView的点击事件
    private void setClient() {
        //一级菜单点击事件
        ExListview.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                boolean flag = list.get(groupPosition).isFlag();
                selectPosition = groupPosition;
                if (flag) {
                    //如果是展开 什么都不操作
                } else {
                    //如果没有展开，调用接口请求数据,然后把标记设置为true
                    getMenu2();
                    list.get(groupPosition).setFlag(true);
                }
                return false;
            }
        });
        //二级菜单点击事件
        ExListview.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                boolean flag = list.get(groupPosition).isFlag();
                selectPosition = groupPosition;
                if (flag) {
                    //如果是展开 什么都不操作
                    Intent intent = new Intent(DailyInpectionTableActivity.this, DailyInpectionTableXQActivity.class);
                    //intent.setData(Uri.parse(adapter.getList().get(groupPosition).videos.get(childPosition).url));
                    intent.putExtra("data",list.get(groupPosition).getChild().get(childPosition).getNames());
                    //intent.setData("data",list.get(groupPosition).getChild().get(childPosition).getNames());
                    startActivity(intent);
                    return true;
                } else {
                    //如果没有展开，调用接口请求数据,然后把标记设置为true
                    getMenu2();
                    list.get(groupPosition).setFlag(true);
                }
                return true;
            }
        });

    }

    //二级菜单显示
    private void getMenu2() {
        List<SystemChildBean> listChild = new ArrayList<SystemChildBean>();
//        for (int i = 0; i < assess.size(); i++) {
//            //listChild.clear();
//            SystemChildBean bean = new SystemChildBean();
//            //String name = assess.get(i).item1;
//            //bean.setNames(name);
//            listChild.add(bean);
//        }
        list.get(selectPosition).setChild(listChild);
        adapter.notifyDataSetChanged();
    }

    private int selectPosition = -1;

    //一级菜单显示
    private void getGroupList() {
//        MyDatabaseHelper helper = DbManager.getInstance(MyFormActivity.this);
//        SQLiteDatabase db = helper.getReadableDatabase();
//        String sql = "select * from moni order by random() limit 100";
//        Cursor cursor = DbManager.queryBySQL(db, sql, null);
//        assess = DbManager.cursorToPerson(cursor);
//        db.close();
//        for (int i = 0; i < assess.size(); i++) {
//            SystemBean bean = new SystemBean();
//            String name = assess.get(i).question;
//            bean.setName(name);
//            list.add(bean);
     //   }
 //       adapter.notifyDataSetChanged();

    }
}
