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
        //����������ֵ�������췽��ItemBean()
        for(int i=0;i<20;i++)  
        {
        	itemBeanList.add(new ItemBean(R.drawable.ic_launcher, 
        			"���Ǳ���"+i, "��������"+i));
        }
        ListView listView=(ListView) findViewById(R.id.lv_main);
        //������������list����������Ĵ���ȥ
        listView.setAdapter(new MyAdapter(itemBeanList, this));
    }
}
