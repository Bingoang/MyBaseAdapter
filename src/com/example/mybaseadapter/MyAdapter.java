package com.example.mybaseadapter;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	private List<ItemBean> mList;
	private LayoutInflater mInflater;
	private long mSumTime;

	// 把前面MainActivity封装的list对象传进来
	public MyAdapter(List<ItemBean> list, Context context) {
		mList = list;
		/*
		 * 通过传进来的context对象初始化mInflater对象 context:要使用当前的Adapter的界面对象
		 * mInflater：布局装载器对象
		 */
		mInflater = LayoutInflater.from(context);

	}

	@Override
	public int getCount() {
		// 返回ListView需要显示的数据量
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		// 取出指定索引所对应的数据项，这些数据项都保存在mList中
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// 返回指定索引对应的数据项
		return position;
	}

	// 返回每一项的显示内容
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		/*
		 * 逗比式，没有利用到ListView缓存机制，造成极大浪费（每次都通过mInflater对象创建一个新的view，找到对应控件）
		 */
		// //通过mInflater对象，将xml文件转化成view对象.后一个参数通常写null
		// View view=mInflater.inflate(R.layout.item, null);
		// //在转化后的view中绑定控件,并初始化
		// ImageView imageView=(ImageView) view.findViewById(R.id.iv_image);
		// TextView title=(TextView) view.findViewById(R.id.tv_title);
		// TextView content=(TextView) view.findViewById(R.id.tv_content);
		// //将从mList取出来的数据传给三个控件,所有数据都从bean对象中取出
		// ItemBean bean=mList.get(position);
		// imageView.setImageResource(bean.itemImageResId);
		// title.setText(bean.itemTitle);
		// content.setText(bean.itemContent);
		// return view;

		/*
		 * 普通式（加入了判断，避免了重复创建convertView对象）
		 */
		// //如果缓冲池中没有convertView对象，则通过mInflater创建一个
		// if(convertView==null)
		// {
		// //这个操作很耗时、很资源！！！加入这个判断可以避免创建大量的convertView对象
		// convertView=mInflater.inflate(R.layout.item, null);
		// }
		// //如果缓冲池中已有convertView对象，则直接初始化控件对象
		// ImageView imageView=(ImageView)
		// convertView.findViewById(R.id.iv_image);
		// TextView title=(TextView) convertView.findViewById(R.id.tv_title);
		// TextView content=(TextView)
		// convertView.findViewById(R.id.tv_content);
		// //将从mList取出来的数据传给三个控件,所有数据都从bean对象中取出
		// ItemBean bean=mList.get(position);
		// imageView.setImageResource(bean.itemImageResId);
		// title.setText(bean.itemTitle);
		// content.setText(bean.itemContent);
		// return convertView;

		/*
		 * 文艺式（通过ViewHolder优化BaseAdapter。避免两个耗时操作:重复创建convertView;findViewById）
		 */
		long start=System.nanoTime();//获取系统纳秒时间
		ViewHolder viewHolder;
		if (convertView == null) {
			// 实例化viewHolder，找到的控件都保存在viewHolder中，所以避免重复找
			viewHolder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.item, null);
			viewHolder.imageView = (ImageView) convertView
					.findViewById(R.id.iv_image);
			viewHolder.title = (TextView) convertView
					.findViewById(R.id.tv_title);
			viewHolder.content = (TextView) convertView
					.findViewById(R.id.tv_content);
			// 通过setTag将convertView与viewHolder绑定
			convertView.setTag(viewHolder);
		} else {
			// 当convertView不为空时，直接通过getTag取出viewHolder对象，也是就三个控件，避免了findviewbyid
			viewHolder = (ViewHolder) convertView.getTag();
		}
		// 将从mList取出来的数据传给三个控件,所有数据都从bean对象中取出
		ItemBean bean = mList.get(position);
		viewHolder.imageView.setImageResource(bean.itemImageResId);
		viewHolder.title.setText(bean.itemTitle);
		viewHolder.content.setText(bean.itemContent);
		long end=System.nanoTime();
		long dValue=end-start;
		mSumTime+=dValue;
		Log.v("ang", mSumTime+"");
		return convertView;

	}

	// 创建内部类ViewHolder
	class ViewHolder {
		// 声明三个控件
		public ImageView imageView;
		public TextView title;
		public TextView content;
	}
}
