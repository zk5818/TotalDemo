package com.test.totaldemp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/7/16.
 */

public class PathTextView extends View {
    Context mContext;
    Paint paint;

    public PathTextView(Context context) {
        this(context, null);

    }

    public PathTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new Paint();
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.STROKE);//填充样式改为描边
        paint.setStrokeWidth(5);//设置画笔宽度

        Path path = new Path();

//        path.moveTo(10, 10); //设定起始点
//        path.lineTo(10, 100);//第一条直线的终点，也是第二条直线的起点
//        path.lineTo(300, 200);//画第二条直线
//        path.lineTo(500, 100);//第三条直线
//        path.close();//闭环

        path.moveTo(50, 50); //设定起始点
        path.lineTo(700, 50); //设定起始点
        path.close();//闭环
        canvas.drawPath(path, paint);
//
//        Path CCWRectpath = new Path();
//        RectF rect1 =  new RectF(50, 50, 240, 200);
//        CCWRectpath.addRect(rect1, Path.Direction.CCW);// Path.Direction.CCW :逆时针生成

        String text="风萧萧兮易水寒，壮士一去兮不复返";
        paint.setColor(Color.GRAY);
        paint.setTextSize(35);
        paint.setStrokeWidth(3);//设置画笔宽度
        canvas.drawTextOnPath(text, path, 10, 20, paint);//  10：表示距离直线左端的距离 20：表示在线的上方下方显示的相对度
    }
}
