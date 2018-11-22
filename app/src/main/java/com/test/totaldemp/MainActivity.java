package com.test.totaldemp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.test.totaldemp.activity.AdaptActivity;
import com.test.totaldemp.activity.AnimationScaleActivity;
import com.test.totaldemp.activity.ClickEventActivity;
import com.test.totaldemp.activity.CoordinatorLayoutActivity;
import com.test.totaldemp.activity.ExpandListActivity3;
import com.test.totaldemp.activity.GreenDaoActivity;
import com.test.totaldemp.activity.ListviewControlActivity;
import com.test.totaldemp.activity.MyCameraActivity;
import com.test.totaldemp.activity.PaintCanvasActivity;
import com.test.totaldemp.activity.SeekBarActivity;
import com.test.totaldemp.activity.SwitchActivity;
import com.test.totaldemp.activity.TimeWightActivity;
import com.test.totaldemp.activity.UpdateActivity;
import com.test.totaldemp.utils.ToastUtil;
import com.test.totaldemp.view.TestPopWindow;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9, tv10,
            tv11, tv12, tv13, tv14, tv15, tv16, tv17, tv18, tv19, tv20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        ToastUtil.showToast(MainActivity.this, "halo，各位小弟弟啊，小妹妹啊！");
    }

    void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setOnClickListener(this);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv2.setOnClickListener(this);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv3.setOnClickListener(this);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv4.setOnClickListener(this);
        tv5 = (TextView) findViewById(R.id.tv5);
        tv5.setOnClickListener(this);
        tv6 = (TextView) findViewById(R.id.tv6);
        tv6.setOnClickListener(this);
        tv7 = (TextView) findViewById(R.id.tv7);
        tv7.setOnClickListener(this);
        tv8 = (TextView) findViewById(R.id.tv8);
        tv8.setOnClickListener(this);
        tv9 = (TextView) findViewById(R.id.tv9);
        tv9.setOnClickListener(this);
        tv10 = (TextView) findViewById(R.id.tv10);
        tv10.setOnClickListener(this);
        tv11 = (TextView) findViewById(R.id.tv11);
        tv11.setOnClickListener(this);
        tv12 = (TextView) findViewById(R.id.tv12);
        tv12.setOnClickListener(this);
        tv13 = (TextView) findViewById(R.id.tv13);
        tv13.setOnClickListener(this);
        tv14 = (TextView) findViewById(R.id.tv14);
        tv14.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv1:
                startActivity(new Intent(this, ExpandListActivity3.class));
                break;
            case R.id.tv2:
                startActivity(new Intent(this, GreenDaoActivity.class));
                break;
            case R.id.tv3:
                TestPopWindow pop = new TestPopWindow(this);
                pop.showAsDropDown(v, 0, 0);
                lightOff();
                // 消失时屏幕变亮
                pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
                        layoutParams.alpha = 1.0f;
                        getWindow().setAttributes(layoutParams);
                    }
                });
                break;
            case R.id.tv4:
                startActivity(new Intent(this, ListviewControlActivity.class));
                break;
            case R.id.tv5:
                startActivity(new Intent(this, MyCameraActivity.class));
                break;
            case R.id.tv6:
                startActivity(new Intent(this, AnimationScaleActivity.class));
                break;
            case R.id.tv7:
                startActivity(new Intent(this, PaintCanvasActivity.class));
                break;
            case R.id.tv8:
                startActivity(new Intent(this, SwitchActivity.class));
                break;
            case R.id.tv9:
                startActivity(new Intent(this, TimeWightActivity.class));
                break;
            case R.id.tv10:
                startActivity(new Intent(this, CoordinatorLayoutActivity.class));
                break;
            case R.id.tv11:
                startActivity(new Intent(this, SeekBarActivity.class));
                break;
            case R.id.tv12:
                startActivity(new Intent(this, AdaptActivity.class));
                break;
            case R.id.tv13:
                startActivity(new Intent(this, UpdateActivity.class));
                break;
            case R.id.tv14:
                startActivity(new Intent(this, ClickEventActivity.class));
                break;
        }
    }

    /**
     * 显示时屏幕变暗
     */
    private void lightOff() {

        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();

        layoutParams.alpha = 0.3f;

        getWindow().setAttributes(layoutParams);

    }
}