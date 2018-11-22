package com.test.totaldemp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

import com.test.totaldemp.R;

/**
 * Created by Administrator on 2018/7/16.
 */

public class PaintView extends View {

    Context m_context;

    public PaintView(Context context) {
        super(context);
        m_context = context;
    }

    Paint mPaint;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);//抗锯齿功能
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(3);
        mPaint.setShadowLayer(10, 15, 15, Color.GREEN);
        //设置画布背景颜色
        canvas.drawRGB(255, 255, 255);
//        cx：圆心的x坐标。
//        cy：圆心的y坐标。
//        radius：圆的半径。
        canvas.drawCircle(200, 200, 100, mPaint);
        float[] pts = {10, 10, 185, 185, 215, 215, 400, 400};
        canvas.drawLines(pts, mPaint);

        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(15);
        canvas.drawPoint(200, 200, mPaint);
        canvas.drawPoints(pts, mPaint);
        //另一个方法drawPoints(float[] pts, int offset, int count, Paint paint)
        //offset表示从数组的第几个算，count表示算几个
        //canvas.drawPoints(pts, 2, 4, paint)则表示画几个点

        //画矩形
        mPaint.reset();
        mPaint.setColor(getResources().getColor(R.color.c_FF7F66));
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(3);
        canvas.drawRect(420, 10, 650, 300, mPaint);//直接构造 2点斜线然后确定一个矩形

        //画圆角矩形
        mPaint.reset();
        mPaint.setColor(getResources().getColor(R.color.c_FF7F66));
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(5);
        RectF rect = new RectF();
        rect.set(700, 20, 900, 90);
        canvas.drawRoundRect(rect, 10, 20, mPaint);
        mPaint.setColor(Color.BLUE);
        mPaint.setTextSize(35f);
        mPaint.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
        float bottomLineY = rect.centerY() - (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.top;

//        canvas.drawText("我爱你", rect.centerX() - rect.width() / 2, rect.centerY() + rect.top / 2, mPaint);
        canvas.drawText("我爱你",rect.centerX() , bottomLineY, mPaint);


        //画椭圆(椭圆是根据矩形框在矩形内画的)
        mPaint.reset();
        mPaint.setColor(getResources().getColor(R.color.c_56CC8D));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        RectF rect_oval = new RectF();
        rect_oval.set(50, 420, 300, 550);
//        canvas.drawRect(rect_oval, mPaint);
        canvas.drawOval(rect_oval, mPaint);//同一个矩形画椭圆、、、

        //画弧(画弧也是根据矩形框在矩形内画的)
        mPaint.reset();
        mPaint.setColor(getResources().getColor(R.color.c_56CC8D));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        RectF rect_arc = new RectF();
        rect_arc.set(450, 420, 700, 550);
//        canvas.drawRect(rect_oval, mPaint);
        canvas.drawArc(rect_arc, 0, 120, false, mPaint);//true/false 代表是否是要2条半径

    }


}
