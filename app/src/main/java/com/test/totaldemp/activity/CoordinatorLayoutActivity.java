package com.test.totaldemp.activity;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.test.totaldemp.R;
import com.test.totaldemp.adapter.MyAdapter;
import com.test.totaldemp.helper.ItemDragHelperCallback;
import com.test.totaldemp.modle.CellData;

import java.util.ArrayList;
import java.util.List;

import static android.view.WindowManager.LayoutParams;

public class CoordinatorLayoutActivity extends AppCompatActivity {
    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);
        //沉浸式状态栏
        getWindow().addFlags(LayoutParams.FLAG_TRANSLUCENT_STATUS);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //给页面设置工具栏
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        if (collapsingToolbar != null) {
            //设置隐藏图片时候ToolBar的颜色
            collapsingToolbar.setContentScrimColor(getResources().getColor(R.color.c_65D1D3));
            //设置工具栏标题
            collapsingToolbar.setTitle("编程是一种信仰");
            collapsingToolbar.setCollapsedTitleGravity(Gravity.CENTER);//设置收缩后标题的位置
            collapsingToolbar.setExpandedTitleGravity(Gravity.LEFT | Gravity.BOTTOM);////设置展开后标题的位置
        }
        List<CellData> list = initData();
        if (mRecyclerView != null) {
            mRecyclerView.setHasFixedSize(true);
            LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            mRecyclerView.setLayoutManager(manager);
            // 长按拖拽打开
            ItemDragHelperCallback callback = new ItemDragHelperCallback() {
                @Override
                public boolean isLongPressDragEnabled() {
                    return true;
                }
            };
            ItemTouchHelper helper = new ItemTouchHelper(callback);
            helper.attachToRecyclerView(mRecyclerView);
            //设置adapter
            MyAdapter mAdapter = new MyAdapter(list);
            mRecyclerView.setAdapter(mAdapter);
            //设置RecyclerView的每一项的点击事件
            mAdapter.setRecyclerViewOnItemClickListener(new MyAdapter.RecyclerViewOnItemClickListener() {
                @Override
                public void onItemClickListener(View view, int position) {
                    Snackbar.make(view, "点击了：" + (position + 1), Snackbar.LENGTH_SHORT).show();
                }

            });
            //设置RecyclerView的每一项的长按事件
            mAdapter.setOnItemLongClickListener(new MyAdapter.RecyclerViewOnItemLongClickListener() {
                @Override
                public boolean onItemLongClickListener(View view, int position) {
                    Snackbar.make(view, "长按了：" + (position + 1), Snackbar.LENGTH_SHORT).show();
                    return true;
                }

            });
            mAdapter.setOnItemMovedListener(new MyAdapter.RecyclerViewOnItemMovedListener() {
                @Override
                public boolean onItemMovedListener(int fromPosition, int toPosition) {
                    Snackbar.make(getWindow().getDecorView(), "从-" + (fromPosition + 1) + "-移动到" + (toPosition + 1), Snackbar.LENGTH_SHORT).show();
                    return false;
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //点击了返回箭头
                Snackbar.make(getWindow().getDecorView(), "我要回家", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.about:
                new AlertDialog.Builder(this).setMessage("作者:阿钟\ncsdn地址:http://blog.csdn.net/a_zhon/").show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private List<CellData> initData() {
        List<CellData> list = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            CellData cellData = new CellData("逗比程序员 +" + i, "不想当项目经理的程序员不是个好程序员" + i);
            list.add(cellData);
        }
        return list;
    }


}
