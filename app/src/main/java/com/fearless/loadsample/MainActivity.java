package com.fearless.loadsample;

import android.app.Dialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.fearless.loadsample.util.LoadingUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Dialog dialog = LoadingUtil.showLoadDialog(this, "加载中...");
        dialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), "加载完成", Toast.LENGTH_LONG).show();
            }
        }, 3000);
    }
}
