package com.test.totaldemp.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.test.totaldemp.R;

/**
 * Created by Administrator on 2018/7/16.
 */

public class BitmapDrawView extends View {
    public BitmapDrawView(Context context) {
        super(context);
    }

    public BitmapDrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        Paint paint = new Paint();
        //直接完全绘制Bitmap
        canvas.drawBitmap(bitmap, 0, 0, paint);
//        RectF dstRecF = new RectF();
//        dstRecF.left = 0;
//        dstRecF.right = getWidth();
//        dstRecF.top = 0;
//        dstRecF.bottom = getHeight();
//        canvas.drawBitmap(bitmap, null, dstRecF, paint);


//        //绘制Bitmap的一部分，并对其拉伸
//        //srcRect定义了要绘制Bitmap的哪一部分
//        Rect srcRect = new Rect();
//        srcRect.left = 0;
//        srcRect.right = bitmap.getWidth();
//        srcRect.top = 0;
//        srcRect.bottom = (int) (0.33 * bitmap.getHeight());
//        float radio = (float) (srcRect.bottom - srcRect.top) / bitmap.getWidth();
//        //dstRecF定义了要将绘制的Bitmap拉伸到哪里
//        RectF dstRecF = new RectF();
//        dstRecF.left = 0;
//        dstRecF.right = canvas.getWidth();
//        dstRecF.top = bitmap.getHeight();
//        float dstHeight = (dstRecF.right - dstRecF.left) * radio;
//        dstRecF.bottom = dstRecF.top + dstHeight;
//        canvas.drawBitmap(bitmap, srcRect, dstRecF, paint);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    private int measureWidth(int measureSpec) {
        // TODO Auto-generated method stub
        int result = 0; //结果
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        switch (specMode) {
            case MeasureSpec.AT_MOST:  // 子容器可以是声明大小内的任意大小
                Log.e(Tag, "子容器可以是声明大小内的任意大小");
                Log.e(Tag, "大小为:" + specSize);
                result = specSize;
                break;
            case MeasureSpec.EXACTLY: //父容器已经为子容器设置了尺寸,子容器应当服从这些边界,不论子容器想要多大的空间.  比如EditTextView中的DrawLeft
                Log.e(Tag, "父容器已经为子容器设置了尺寸,子容器应当服从这些边界,不论子容器想要多大的空间");
                Log.e(Tag, "大小为:" + specSize);
                result = specSize;
                break;
            case MeasureSpec.UNSPECIFIED:  //父容器对于子容器没有任何限制,子容器想要多大就多大. 所以完全取决于子view的大小
                Log.e(Tag, "父容器对于子容器没有任何限制,子容器想要多大就多大");
                Log.e(Tag, "大小为:" + specSize);
                result = 1500;
                break;
            default:
                break;
        }
        return result;
    }

    private static final String Tag = "BitmapDrawView>>>";

    private int measureHeight(int heightMeasureSpec) {
        // TODO Auto-generated method stub
        int result = 0; //结果
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int specSize = MeasureSpec.getSize(heightMeasureSpec);
        switch (specMode) {
            case MeasureSpec.AT_MOST:  // 子容器可以是声明大小内的任意大小
                Log.e(Tag, "子容器可以是声明大小内的任意大小");
                Log.e(Tag, "大小为:" + specSize);
                result = specSize;
                break;
            case MeasureSpec.EXACTLY: //父容器已经为子容器设置了尺寸,子容器应当服从这些边界,不论子容器想要多大的空间.  比如EditTextView中的DrawLeft
                Log.e(Tag, "父容器已经为子容器设置了尺寸,子容器应当服从这些边界,不论子容器想要多大的空间");
                Log.e(Tag, "大小为:" + specSize);
                result = specSize;
                break;
            case MeasureSpec.UNSPECIFIED:  //父容器对于子容器没有任何限制,子容器想要多大就多大. 所以完全取决于子view的大小
                Log.e(Tag, "父容器对于子容器没有任何限制,子容器想要多大就多大");
                Log.e(Tag, "大小为:" + specSize);
                result = 1500;
                break;
            default:
                break;
        }
        return result;

    }

}
