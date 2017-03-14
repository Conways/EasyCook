package com.conways.easycook.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.conways.easycook.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                toTargetActivity(MainActivity.class);
                SplashActivity.this.finish();
            }
        }).start();
    }
}
