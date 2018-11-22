package com.test.totaldemp.utils;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.test.totaldemp.R;

/**
 * Created by Administrator on 2018/7/19.
 */

public class ToastUtil {
    static String message;
    static Context mContext;
    private static TextView mTextView;
    private static Toast mToast;

    public static  void showToast(Context context, String msg) {
        message = msg;
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_toast_msg, null);
        mTextView = (TextView) view.findViewById(R.id.toast_msg);
        mTextView.setText(msg);
        if (mToast == null) {
            mToast = new Toast(context);
            Log.i("ToastUtil", "Toast create...");
        }
        //设置toast居中显示
        mToast.setGravity(Gravity.CENTER, 0, 0);
        mToast.setDuration(Toast.LENGTH_SHORT);
        mToast.setView(view);
        mToast.show();
    }
//
//    public ToastUtil(Context context, String msg) {
//
//    }

    private static boolean canceled = true;
    private static Handler mHandler = new Handler();

    /**
     * 自定义居中显示toast
     */
    public void show() {
        mToast.show();
        Log.i("ToastUtil", "Toast show...");
    }

    private static TimeCount timeCount;

    /**
     * 自定义时长、居中显示toast
     *
     * @param duration
     */
    public static void show(int duration) {
        timeCount = new TimeCount(duration, 1000);
        Log.i("ToastUtil", "Toast show...");
        if (canceled) {
            timeCount.start();
            canceled = false;
            showUntilCancel();
        }
    }

    private static void showUntilCancel() {
        if (canceled) { //如果已经取消显示，就直接return
            return;
        }
        mToast.show();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i("ToastUtil", "Toast showUntilCancel...");
                showUntilCancel();
            }
        }, Toast.LENGTH_LONG);
    }

    /**
     * 隐藏toast
     */
    private static void hide() {
        if (mToast != null) {
            mToast.cancel();
        }
        canceled = true;
        Log.i("ToastUtil", "Toast that customed duration hide...");
    }

    /**
     * 自定义计时器
     */
    private static class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval); //millisInFuture总计时长，countDownInterval时间间隔(一般为1000ms)
        }

        @Override
        public void onTick(long millisUntilFinished) {
            mTextView.setText(message + ": " + millisUntilFinished / 1000 + "s后消失");
        }

        @Override
        public void onFinish() {
            hide();
        }
    }
}
