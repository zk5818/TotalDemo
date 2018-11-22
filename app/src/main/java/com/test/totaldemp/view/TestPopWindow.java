package com.test.totaldemp.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.test.totaldemp.R;

/**
 * Created by Administrator on 2018/7/9.
 */

public class TestPopWindow extends PopupWindow {
    Context mContext;
    private LayoutInflater mInflater;
    private View mContentView;

    public TestPopWindow(Context context) {
        super(context);
        this.mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mContentView = mInflater.inflate(R.layout.layout_pop_test, null);
        setContentView(mContentView);

        //设置宽与高

        DisplayMetrics dm = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay().getMetrics(dm);
        setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        setWidth((int) (dm.widthPixels * 0.8));


        setBackgroundDrawable(new ColorDrawable());
        /**
         * 设置可以获取集点
         */
        setFocusable(true);

        /**
         * 设置点击外边可以消失
         */
        setOutsideTouchable(true);

        /**
         *设置可以触摸
         */
        setTouchable(true);
        setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                /**
                 * 判断是不是点击了外部
                 */
                if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
                    return true;
                }
                //不是点击外部
                return false;
            }
        });
        /**
         * 设置进出动画
         */
        setAnimationStyle(R.style.TestPop);


    }

    @Override
    public void showAsDropDown(View anchor) {
        super.showAsDropDown(anchor);
    }
}
