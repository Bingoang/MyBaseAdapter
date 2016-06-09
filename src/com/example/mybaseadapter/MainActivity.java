package com.example.mybaseadapter;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.widget.ListView;
import android.app.Activity;

public class MainActivity extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<ItemBean> itemBeanList=new ArrayList<ItemBean>();
        //把三个参数值传给构造方法ItemBean()
        for(int i=0;i<20;i++)  
        {
        	itemBeanList.add(new ItemBean(R.drawable.ic_launcher, 
        			"我是标题"+i, "我是内容"+i));
        }
        ListView listView=(ListView) findViewById(R.id.lv_main);
        //绑定适配器，把list对象和上下文传进去
        listView.setAdapter(new MyAdapter(itemBeanList, this));
    }
}
