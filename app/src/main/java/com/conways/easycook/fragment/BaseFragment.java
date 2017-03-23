package com.conways.easycook.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.conways.easycook.R;

/**
 * Created by Conways on 2017/3/14.
 */

public abstract class BaseFragment extends Fragment {
    private Toast toast;
    private ProgressDialog progressDialog;
    protected String TAG = "zzzz" + getClass().getSimpleName();


    protected abstract void initTitle();

    protected abstract void initContent();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initTitle();
        initContent();
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
        return (T) getView().findViewById(id);
    }

    /**
     * 跳到目标界面
     *
     * @param activity 目标Activity
     */
    protected void toTargetActivity(Class<?> activity) {
        Intent intent = new Intent(getActivity(), activity);
        this.startActivity(intent);
    }

    /**
     * 携带参数跳到目标界面
     *
     * @param activity 目标界面
     * @param bundle   参数包，可以为空
     */
    protected void toTargetActivityWithBundle(Class<?> activity, Bundle bundle) {
        Intent intent = new Intent(getActivity(), activity);
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
        Intent intent = new Intent(getActivity(), activity);
        this.startActivityForResult(intent, requestCode);
    }

    /**
     * @param activity
     * @param bundle
     * @param requestCode
     */
    protected void toTargetActivityForReasultWithBundle(Class<?> activity, Bundle bundle, int
            requestCode) {
        Intent intent = new Intent(getActivity(), activity);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        this.startActivityForResult(intent, requestCode);
    }

    /**
     * 消息提示
     *
     * @param msg 提示消息
     */
    protected void showShortMsg(CharSequence msg) {
        if (null == toast) {
            toast = Toast.makeText(getActivity(), "msg", Toast.LENGTH_SHORT);
        }else{
            toast.setText(msg);
        }
        toast.show();
    }

    /**
     * 消息提示
     *
     * @param msgId 提示消息Id
     */
    protected void showShortMsg(int msgId) {
        showShortMsg(getText(msgId));
    }

    /**
     * 显示进度对话框
     *
     * @param msg 对话框提示信息
     */
    protected void showProgress(String msg) {
        if (null == progressDialog) {
            progressDialog = new ProgressDialog(getActivity());
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
        showProgress(getText(textId).toString());
    }
}
