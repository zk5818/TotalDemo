package com.test.totaldemp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.test.totaldemp.R;

/**
 * Created by Administrator on 2018/7/12.
 */

public class CenterShowHorizontalScrollView extends HorizontalScrollView {
    private LinearLayout mShowLinear;

    public CenterShowHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mShowLinear = new LinearLayout(context);
        mShowLinear.setOrientation(LinearLayout.HORIZONTAL);
        HorizontalScrollView.LayoutParams params = new HorizontalScrollView.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mShowLinear.setGravity(Gravity.CENTER_VERTICAL);
        this.addView(mShowLinear, params);
    }

    public void onClicked(View v) {
        if (v.getTag(R.id.item_position) != null) {
            int position = (Integer) v.getTag(R.id.item_position);
            View itemView = mShowLinear.getChildAt(position);
            int itemWidth = itemView.getWidth();
            int screenWidth = getScreenWidth(v.getContext());

            smoothScrollTo(itemView.getLeft() - (screenWidth / 2 - itemWidth / 2), 0);
        }
    }

    public LinearLayout getLinear() {
        return mShowLinear;
    }

    public void addItemView(View itemView, int position) {
        itemView.setTag(R.id.item_position, position);
        mShowLinear.addView(itemView);
    }

    public static int getScreenWidth(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

}

