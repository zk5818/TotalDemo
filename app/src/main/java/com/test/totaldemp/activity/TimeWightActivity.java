package com.test.totaldemp.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextClock;

import com.test.totaldemp.R;

import java.io.IOException;
import java.io.InputStream;

public class TimeWightActivity extends AppCompatActivity {
    private TextClock mTextClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_wight);

        mTextClock = (TextClock) findViewById(R.id.tc);
        // 设置12时制显示格式
//        mTextClock.setFormat12Hour("EEEE, MMMM dd, yyyy h:mmaa");
        // 设置24时制显示格式
        mTextClock.setFormat24Hour("yyyy-MM-dd HH:mm:ss, EEEE");
        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputStream is = null;
                try {
                    is = getAssets().open("icon_login_water.png");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Bitmap bitmap = BitmapFactory.decodeStream(is);

                ((ImageView) findViewById(R.id.img)).setImageBitmap(bitmap);
            }
        });
    }
}
