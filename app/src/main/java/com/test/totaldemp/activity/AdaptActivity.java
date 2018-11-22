package com.test.totaldemp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.test.totaldemp.R;

public class AdaptActivity extends AppCompatActivity {
    private ArrayAdapter<String> adapter;
    private ListView listView;
    private String[] datas = {"张三","李四","王五","麻子","小强"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapt);
        listView = (ListView) findViewById(R.id.lv);
//        初始化适配器
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, getResources().getStringArray(R.array.myArrays));
        listView.setAdapter(adapter);

    }
}
