package com.conways.easycook.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Conways on 2017/3/14.
 */

public class BaseActivity extends AppCompatActivity {

    private Toast toast;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建时压入到activityManager栈顶
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    /**
     * findview简写
     * <p>
     * 可以直接View view=$(R.id.xxx)
     *
     * @param id  viewId
     * @param <T>
     * @return
     */
    protected <T extends View> T $(int id) {
        return (T) findViewById(id);
    }

    /**
     * 跳到目标界面
     *
     * @param activity 目标Activity
     */
    protected void toTargetActivity(Class<?> activity) {
        Intent intent = new Intent(this, activity);
        this.startActivity(intent);
    }

    /**
     * 携带参数跳到目标界面
     *
     * @param activity 目标界面
     * @param bundle   参数包，可以为空
     */
    protected void toTargetActivityWithBundle(Class<?> activity, Bundle bundle) {
        Intent intent = new Intent(this, activity);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        this.startActivity(intent);
    }

    /**
     * @param activity
     * @param requestCode
     */
    protected void toTargetActivityForReasult(Class<?> activity, int requestCode) {
        Intent intent = new Intent(this, activity);
        this.startActivityForResult(intent, requestCode);
    }

    /**
     * @param activity
     * @param bundle
     * @param requestCode
     */
    protected void toTargetActivityForReasultWithBundle(Class<?> activity, Bundle bundle, int
            requestCode) {
        Intent intent = new Intent(this, activity);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        this.startActivityForResult(intent, requestCode);
    }

    /**
     * Toast提示
     *
     * @param msg 提示消息
     */
    protected void showMsg(String msg) {
        if (null == toast) {
            toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        }
        toast.setText(msg);
        toast.show();
    }

    /**
     * Toast提示
     *
     * @param textId 提示消息StringId
     */
    protected void showMsg(int textId) {
        showMsg(getText(textId).toString());
    }

    /**
     * 显示进度对话框
     *
     * @param msg 对话框提示信息
     */
    protected void showProgress(String msg) {
        if (null == progressDialog) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage(msg);
            progressDialog.setCancelable(true);
        }
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    /**
     * 显示进度对话框
     *
     * @param textId
     */
    protected void showProgress(int textId) {
        showMsg(getText(textId).toString());
    }


    protected int getColorById(int colorId) {
        return getResources().getColor(colorId);
    }
}
