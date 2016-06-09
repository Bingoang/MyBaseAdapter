package com.example.mybaseadapter;

public class ItemBean {

	public int itemImageResId;
	public String itemTitle;
	public String itemContent;
	
//重写构造方法，初始化三个属性
	public ItemBean(int itemImageResId, String itemTitle, String itemContent) {
		super();
		this.itemImageResId = itemImageResId;
		this.itemTitle = itemTitle;
		this.itemContent = itemContent;
	}

}
