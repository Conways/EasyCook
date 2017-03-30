package com.conways.easycook;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.conways.easycook.config.Config;
import com.conways.easycook.sp.SpConstants;
import com.conways.easycook.sp.SpManager;

import java.util.Locale;

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
        initLanguagueCofig();
    }

    private void initLanguagueCofig() {
        String language = SpManager.getInstance().getLanguage();
        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        DisplayMetrics dm = resources.getDisplayMetrics();

        switch (language) {
            case SpConstants.Langue.LANGUAGE_SIMPLE_CHINESE:
                config.locale = Locale.SIMPLIFIED_CHINESE;
                resources.updateConfiguration(config, dm);
                break;
            case SpConstants.Langue.LANGUAGE_TRADITIONAL_CHINESE:
                config.locale = Locale.TRADITIONAL_CHINESE;
                resources.updateConfiguration(config, dm);
                break;
            case SpConstants.Langue.LANGUAGE_ENGLISH:
                config.locale = Locale.ENGLISH;
                resources.updateConfiguration(config, dm);
                break;
            case SpConstants.Langue.LANGUAGE_JAPANESE:
                config.locale = Locale.JAPANESE;
                resources.updateConfiguration(config, dm);
                break;

            default:
                break;
        }

    }
}
