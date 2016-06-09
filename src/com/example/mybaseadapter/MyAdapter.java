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

	// ��ǰ��MainActivity��װ��list���󴫽���
	public MyAdapter(List<ItemBean> list, Context context) {
		mList = list;
		/*
		 * ͨ����������context�����ʼ��mInflater���� context:Ҫʹ�õ�ǰ��Adapter�Ľ������
		 * mInflater������װ��������
		 */
		mInflater = LayoutInflater.from(context);

	}

	@Override
	public int getCount() {
		// ����ListView��Ҫ��ʾ��������
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		// ȡ��ָ����������Ӧ���������Щ�����������mList��
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// ����ָ��������Ӧ��������
		return position;
	}

	// ����ÿһ�����ʾ����
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		/*
		 * ����ʽ��û�����õ�ListView������ƣ���ɼ����˷ѣ�ÿ�ζ�ͨ��mInflater���󴴽�һ���µ�view���ҵ���Ӧ�ؼ���
		 */
		// //ͨ��mInflater���󣬽�xml�ļ�ת����view����.��һ������ͨ��дnull
		// View view=mInflater.inflate(R.layout.item, null);
		// //��ת�����view�а󶨿ؼ�,����ʼ��
		// ImageView imageView=(ImageView) view.findViewById(R.id.iv_image);
		// TextView title=(TextView) view.findViewById(R.id.tv_title);
		// TextView content=(TextView) view.findViewById(R.id.tv_content);
		// //����mListȡ���������ݴ��������ؼ�,�������ݶ���bean������ȡ��
		// ItemBean bean=mList.get(position);
		// imageView.setImageResource(bean.itemImageResId);
		// title.setText(bean.itemTitle);
		// content.setText(bean.itemContent);
		// return view;

		/*
		 * ��ͨʽ���������жϣ��������ظ�����convertView����
		 */
		// //����������û��convertView������ͨ��mInflater����һ��
		// if(convertView==null)
		// {
		// //��������ܺ�ʱ������Դ��������������жϿ��Ա��ⴴ��������convertView����
		// convertView=mInflater.inflate(R.layout.item, null);
		// }
		// //��������������convertView������ֱ�ӳ�ʼ���ؼ�����
		// ImageView imageView=(ImageView)
		// convertView.findViewById(R.id.iv_image);
		// TextView title=(TextView) convertView.findViewById(R.id.tv_title);
		// TextView content=(TextView)
		// convertView.findViewById(R.id.tv_content);
		// //����mListȡ���������ݴ��������ؼ�,�������ݶ���bean������ȡ��
		// ItemBean bean=mList.get(position);
		// imageView.setImageResource(bean.itemImageResId);
		// title.setText(bean.itemTitle);
		// content.setText(bean.itemContent);
		// return convertView;

		/*
		 * ����ʽ��ͨ��ViewHolder�Ż�BaseAdapter������������ʱ����:�ظ�����convertView;findViewById��
		 */
		long start=System.nanoTime();//��ȡϵͳ����ʱ��
		ViewHolder viewHolder;
		if (convertView == null) {
			// ʵ����viewHolder���ҵ��Ŀؼ���������viewHolder�У����Ա����ظ���
			viewHolder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.item, null);
			viewHolder.imageView = (ImageView) convertView
					.findViewById(R.id.iv_image);
			viewHolder.title = (TextView) convertView
					.findViewById(R.id.tv_title);
			viewHolder.content = (TextView) convertView
					.findViewById(R.id.tv_content);
			// ͨ��setTag��convertView��viewHolder��
			convertView.setTag(viewHolder);
		} else {
			// ��convertView��Ϊ��ʱ��ֱ��ͨ��getTagȡ��viewHolder����Ҳ�Ǿ������ؼ���������findviewbyid
			viewHolder = (ViewHolder) convertView.getTag();
		}
		// ����mListȡ���������ݴ��������ؼ�,�������ݶ���bean������ȡ��
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

	// �����ڲ���ViewHolder
	class ViewHolder {
		// ���������ؼ�
		public ImageView imageView;
		public TextView title;
		public TextView content;
	}
}
