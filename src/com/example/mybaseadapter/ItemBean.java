package com.example.mybaseadapter;

public class ItemBean {

	public int itemImageResId;
	public String itemTitle;
	public String itemContent;
	
//��д���췽������ʼ����������
	public ItemBean(int itemImageResId, String itemTitle, String itemContent) {
		super();
		this.itemImageResId = itemImageResId;
		this.itemTitle = itemTitle;
		this.itemContent = itemContent;
	}

}
