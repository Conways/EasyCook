package com.conways.easycook.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.ActionMode;
import android.view.WindowManager;

import com.conways.easycook.R;

public class SplashActivity extends BaseActivity {


    private String TAG = getClass().getSimpleName() + "zzzz";

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
