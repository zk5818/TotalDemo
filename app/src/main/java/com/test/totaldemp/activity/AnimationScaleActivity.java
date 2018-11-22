package com.test.totaldemp.activity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.test.totaldemp.R;

public class AnimationScaleActivity extends AppCompatActivity {


    Button scaleBtn;
    Animation scaleAnimation;
//ValueAnimator
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_scale);

        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scaleanim);
//        scaleAnimation.setre
        scaleBtn = (Button) findViewById(R.id.btn_animation);
        tv = (TextView) findViewById(R.id.tv);
        // tv.layout();
        scaleBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                tv.startAnimation(scaleAnimation);
            }
        });

    }

}
