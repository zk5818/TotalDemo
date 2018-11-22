package com.test.totaldemp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.test.totaldemp.R;
import com.test.totaldemp.view.BitmapDrawView;
import com.test.totaldemp.view.PaintView;
import com.test.totaldemp.view.PathTextView;
import com.test.totaldemp.view.TextDrawView;

public class PaintCanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint_canvas);
        FrameLayout root = (FrameLayout) findViewById(R.id.root);
        //主要是图形界面
//        root.addView(new PaintView(PaintCanvasActivity.this));

        //直线路径和文字
//        root.addView(new PathTextView(PaintCanvasActivity.this));
//        root.addView(new TextDrawView(PaintCanvasActivity.this));

        //图片利用
        root.addView(new BitmapDrawView(PaintCanvasActivity.this));

    }
}
