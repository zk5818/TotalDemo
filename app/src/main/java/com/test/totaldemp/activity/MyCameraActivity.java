package com.test.totaldemp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.test.totaldemp.R;
import com.test.totaldemp.view.CameraSurfaceView;
import com.test.totaldemp.view.RectOnCamera;

public class MyCameraActivity  extends Activity implements View.OnClickListener,RectOnCamera.IAutoFocus,CameraSurfaceView.TakenFinished{
    private CameraSurfaceView mCameraSurfaceView;
    private RectOnCamera mRectOnCamera;
    private Button takePicBtn;

    private boolean isClicked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_my_camera);
        mCameraSurfaceView = (CameraSurfaceView) findViewById(R.id.cameraSurfaceView);
        mRectOnCamera = (RectOnCamera) findViewById(R.id.rectOnCamera);
        mRectOnCamera.setIAutoFocus(this);
        mCameraSurfaceView.setTakenFinished(this);
        takePicBtn= (Button) findViewById(R.id.takePic);
        takePicBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.takePic:
                mCameraSurfaceView.takePicture();
                break;
            default:
                break;
        }
    }

    @Override
    public void autoFocus() {
        mCameraSurfaceView.setAutoFocus();
    }


    @Override
    public void finishToken() {
        Toast.makeText(MyCameraActivity.this,"图片已保存",Toast.LENGTH_LONG).show();
//        Snackbar.make(getWindow().getDecorView(),"图片已保存",Snackbar.LENGTH_LONG).show();
        finish();
    }
}
