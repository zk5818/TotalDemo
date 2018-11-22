package com.test.totaldemp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import com.test.totaldemp.R;
import com.test.totaldemp.adapter.SimpleExpandableListViewAdapter;
import com.test.totaldemp.modle.Classes;
import com.test.totaldemp.modle.College;

import java.util.ArrayList;
import java.util.List;

public class ExpandListActivity3 extends AppCompatActivity {
    ExpandableListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_list3);
        initData();
        // 查找控件
        listview = ((ExpandableListView) findViewById(R.id.tree_view_simple));
        SimpleExpandableListViewAdapter adapter = new SimpleExpandableListViewAdapter(colleges, this);
        listview.setAdapter(adapter);
        for (int i = 0; i < adapter.getGroupCount(); i++) {
            listview.expandGroup(i);
        }

    }

    List<College> colleges;

    /**
     * 初始化数据
     */
    private void initData() {


        College college = new College();
        College college_temp;
        college.name = "科技大学";

        List<Classes> classesList = new ArrayList<>();

        for (int i = 1; i < 3; i++) {
            Classes classes = new Classes();
            classes.name = "计算机" + i + "班";
            List<String> list = new ArrayList<>();
            list.add("mm");
            list.add("dd");
            classes.students = list;
            classesList.add(classes);
        }

        college.classList = classesList;


        colleges = new ArrayList<>();
        for (int j = 1; j < 100; j++) {
            college_temp = new College();
            college_temp.setName("野鸡大学" + j);
            college_temp.setClassList(college.getClassList());
            colleges.add(college_temp);
        }

    }

}
