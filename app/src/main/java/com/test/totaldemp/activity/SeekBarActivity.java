package com.test.totaldemp.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.test.totaldemp.R;

public class SeekBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);
        CoordinatorLayout cl = (CoordinatorLayout) findViewById(R.id.cl);
//        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
        //如果加入在cl（CoordinatorLayout）布局中，那么就可以点击右滑消失
        Snackbar snackbar = Snackbar.make(cl, "您有新短消息，请注意查收。", Snackbar.LENGTH_INDEFINITE)
                .setAction("点击查看", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SeekBarActivity.this, "TODO 查看消息", Toast.LENGTH_SHORT).show();
                    }
                }).setActionTextColor(Color.RED);
        setSnackbarMessageTextColor(snackbar, Color.GREEN);
        snackbar.show();
    }


    public void setSnackbarMessageTextColor(Snackbar snackbar, int color) {
        View view = snackbar.getView();
        ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(color);
    }
}
