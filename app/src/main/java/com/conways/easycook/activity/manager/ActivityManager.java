package com.conways.easycook.activity.manager;

import com.conways.easycook.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Conways on 2017/3/14.
 */

public class ActivityManager {

    private List<BaseActivity> list;

    private ActivityManager() {
        if (list==null){
            list=new ArrayList<>();
        }
    }

    private static ActivityManager manager;

    public static ActivityManager getInstance() {
        if (null == manager) {
            manager = new ActivityManager();
        }
        return manager;
    }


    public void pushActivity(){
//        list
    }


}
