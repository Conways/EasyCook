package com.conways.easycook;

import android.app.Application;

import com.conways.easycook.config.Config;
import com.conways.easycook.sharedpreferences.SpManager;

/**
 * Created by Conways on 2017/3/14.
 */

public class EasyCookApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        initSp();
        initConfig();
    }

    private void initSp() {
        SpManager.getInstance().init(this);
    }

    private void initConfig() {
        Config.rockable = SpManager.getInstance().getRockable();
    }
}
