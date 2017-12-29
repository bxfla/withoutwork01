package com.xb.powerplatform.dailyinspection.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xb.powerplatform.R;
import com.xb.powerplatform.dailyinspection.bean.SystemBean;
import com.xb.powerplatform.dailyinspection.bean.SystemChildBean;

import java.util.ArrayList;
import java.util.List;

public class MySystemExpandAdapter extends BaseExpandableListAdapter {
	private List<SystemBean> list = new ArrayList<SystemBean>();

	private Context context;
	private LayoutInflater infalcter = null;

	

	public MySystemExpandAdapter(List<SystemBean> list, Context context) {
		super();
		this.list = list;
		this.context = context;
		infalcter = LayoutInflater.from(context);
	}

	public List<SystemBean> getList() {
		return list;
	}

	@Override
	public int getGroupCount() {
		return list.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		List<SystemChildBean> data =  list.get(groupPosition).getChild();
		if(data == null){
			return 0;
		}else{
			
			return data.size();
		}
	}

	@Override
	public Object getGroup(int groupPosition) {
		return list.get(groupPosition);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
							 View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if(convertView == null){
			convertView = View.inflate(context, R.layout.item_menutest	, null);
			holder = new ViewHolder(convertView);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}

		
		SystemBean  bean = list.get(groupPosition);
		holder.tv_name1.setText(bean.getName());
		
		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if(convertView == null){
			convertView = View.inflate(context, R.layout.item_menu2test, null);
			holder = new ViewHolder(convertView);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		List<SystemChildBean> childBean = list.get(groupPosition).getChild();
		if(childBean == null){
			
			holder.tv_name1.setText("暂无信息");
		}else{
			
			holder.tv_name1.setText(childBean.get(childPosition).getNames());
		}
		
		
		return convertView;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}

	class ViewHolder{
		private TextView tv_name1;
		private ImageView iv;
		
		public ViewHolder(View view){
			tv_name1 = (TextView) view.findViewById(R.id.tv_name1);
			iv = (ImageView) view.findViewById(R.id.iv);
			view.setTag(this);
			
		}
		
	}
}
