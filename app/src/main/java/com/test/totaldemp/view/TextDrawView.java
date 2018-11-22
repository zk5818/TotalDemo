package com.test.totaldemp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/7/16.
 */

public class TextDrawView extends View {
    public TextDrawView(Context context) {
        super(context);
    }

    public TextDrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        int baseLineX = 0 ;
        int baseLineY = 200;

        //画基线
        Paint paint = new Paint();
//        paint.setColor(Color.RED);
//        canvas.drawLine(baseLineX, baseLineY, 3000, baseLineY, paint);

        //写文字
        paint.setColor(Color.GREEN);
        paint.setTextSize(120); //以px为单位
        canvas.drawText("harvic\'s blog", baseLineX, baseLineY, paint);

    }
}
