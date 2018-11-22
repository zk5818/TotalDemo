package com.test.totaldemp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.test.totaldemp.R;
import com.test.totaldemp.view.MyToggleButton;

public class SwitchActivity extends AppCompatActivity {
    Switch s;
    private ToggleButton togglebut1;
    MyToggleButton mytogglebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setTheme(R.style.Color1SwitchStyle);//就可以改变颜色了。
        setContentView(R.layout.activity_switch);
        s = (Switch) findViewById(R.id.sw);

        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.e("onCheckedChanged", isChecked + "");
//                s.setChecked(!isChecked);//设置点击switch不生效
            }
        });
        togglebut1 = (ToggleButton) findViewById(R.id.togglebut1);
        togglebut1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(SwitchActivity.this, "打开", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(SwitchActivity.this, "关闭", Toast.LENGTH_LONG).show();
                }
            }
        });
        mytogglebutton = (MyToggleButton) findViewById(R.id.my_togglebut);
        //设置打开背景图
        mytogglebutton.setToggle_bkg_on(R.drawable.switch_button_checked);
        //设置关闭背景图
        mytogglebutton.setToggle_bkg_off(R.drawable.switch_button_normal);
        //设置滑动块背景图
        mytogglebutton.setToggle_slip(R.mipmap.ic_launcher_round);
        //设置ToggleButton初始状态
        mytogglebutton.setToggleState(false);
        //mytogglebutton设置监听
        mytogglebutton.setOnToggleStateChangeListener(new MyToggleButton.OnToggleStateChangeListener() {

            @Override
            public void onToggleStateChange(Boolean state) {
                if (state) {
                    Toast.makeText(SwitchActivity.this, "打开", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SwitchActivity.this, "关闭", Toast.LENGTH_SHORT).show();
                }
            }
        });
        seekBar = (SeekBar) findViewById(R.id.sb);
        tv = (TextView) findViewById(R.id.tv);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv.setText(progress+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(SwitchActivity.this, "按住seekbar", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(SwitchActivity.this, "放开seekbar", Toast.LENGTH_SHORT).show();

            }
        });
    }


    private SeekBar seekBar;
    TextView tv;
}
