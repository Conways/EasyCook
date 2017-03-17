/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.conways.easycook.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Conways on 2017/3/16.
 */

public class SpManager {


    private Context context;

    private static SpManager spManager;

    private SpManager() {
    }

    public static SpManager getInstance() {
        if (null == spManager) {
            spManager = new SpManager();
        }
        return spManager;
    }

    public void init(Context context) {
        this.context = context;
    }


    public void setRockable(boolean rockable) {
        check();
        SharedPreferences sp = context.getSharedPreferences(SpConstants.SP_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(SpConstants.ROCKABLE, rockable);
        editor.commit();
    }

    public boolean getRockable() {
        check();
        SharedPreferences sp = context.getSharedPreferences(SpConstants.SP_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(SpConstants.ROCKABLE, true);
    }


    public void setLangague(String langague) {
        check();
        SharedPreferences sp = context.getSharedPreferences(SpConstants.SP_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(SpConstants.LANGUAGE, langague);
        editor.commit();
    }
    public String getLanguage() {
        check();
        SharedPreferences sp = context.getSharedPreferences(SpConstants.SP_NAME, Context.MODE_PRIVATE);
        return sp.getString(SpConstants.LANGUAGE, SpConstants.Langue.LANGUAGE_SIMPLE_CHINESE);
    }

    private void check() {
        if (null == context) {
            throw new NullPointerException("please call init() before use it,suggest call init() " +
                    "in application oncreate()");
        }
    }
}
