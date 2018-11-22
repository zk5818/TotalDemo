package com.test.totaldemp.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.test.totaldemp.R;
import com.test.totaldemp.adapter.DividerItemDecoration;
import com.test.totaldemp.adapter.RecyclerViewAdapter;
import com.test.totaldemp.adapter.RecyclerViewHolder;
import com.test.totaldemp.modle.Classes;

import java.util.ArrayList;
import java.util.List;

public class ListviewControlActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RecyclerView rv;
    HorizontalScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_control);
        scrollView = (HorizontalScrollView) findViewById(R.id.scrollView);
        initTopView();
        initButtomView();
    }

    private void initTopView() {
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        for (int i = 0; i < 15; i++) {
            RadioGroup.LayoutParams lp = new RadioGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            lp.setMargins(15, 5, 5, 5);//设置边距
            RadioButton radioButton = new RadioButton(this);
            radioButton.setTag(i);
            radioButton.setId(100 + i);
            radioButton.setText("第" + i + "个");
            radioButton.setButtonDrawable(null);
            radioButton.setBackground(getResources().getDrawable(R.drawable.rdobtn_selecter_slide));
            radioButton.setTextColor(getResources().getColorStateList(R.color.radiobutton_text_color));
            radioButton.setPadding(15, 5, 15, 5);
            radioButton.setChecked(false);
            radioButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v.getTag() != null) {
                        int position = (Integer) v.getTag();
                        View itemView = radioGroup.getChildAt(position);
                        int itemWidth = itemView.getWidth();
                        int scrollViewWidth = getScreenWidth(v.getContext());
                        Log.e("滑动了->", itemView.getLeft() - (scrollViewWidth / 2 - itemWidth / 2) + "");
                        scrollView.smoothScrollTo(itemView.getLeft() - (scrollViewWidth / 2 - itemWidth / 2), 0);
                    }
                }
            });
            radioGroup.addView(radioButton, lp);
        }
    }

    private RecyclerViewAdapter mAdapter;

    private void initButtomView() {
        rv = (RecyclerView) findViewById(R.id.rv);
        List<Classes> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Classes c = new Classes();
            c.setName("任务" + i);
            list.add(c);
        }
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        rv.setAdapter(mAdapter = new RecyclerViewAdapter<Classes>(this, R.layout.item_search_house, list) {
            @Override
            public void convert(RecyclerViewHolder holder, final Classes data, int position) {
                holder.setText(R.id.tv_data, data.getName());
            }
        });
        rv.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int firstPosition;

                switch (newState) {
                    case RecyclerView.SCROLL_STATE_IDLE:
                        RecyclerView.LayoutManager layoutManager = rv.getLayoutManager();
                        LinearLayoutManager linearManager = (LinearLayoutManager) layoutManager;
                        firstPosition = linearManager.findFirstVisibleItemPosition();
                        Log.e("lll", "现在在哪个位置》》》" + firstPosition + "----" + firstPosition / 10);
                        RadioButton itemView = (RadioButton) radioGroup.getChildAt(firstPosition / 10);
                        itemView.callOnClick();
                        itemView.setChecked(true);
                        break;
                }

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        mAdapter.notifyDataSetChanged();
    }

    LinearLayoutManager finalLayoutMgr;
    boolean outputPortDragging;

    /**
     * 获取屏幕宽度
     */
    public static int getScreenWidth(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.widthPixels;
    }
}
