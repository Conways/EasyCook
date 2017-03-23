/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.conways.easycook.widget.progressdialog;


import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.conways.easycook.R;

public class EcNormalPgDialog extends DialogFragment {

    private static final String MSG_KEY = "msg";
    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
        tvMsg.setText(this.msg);
    }

    public EcNormalPgDialog() {
    }

    private TextView tvMsg;

    public static EcNormalPgDialog newInstance(String msg) {
        EcNormalPgDialog fragment = new EcNormalPgDialog();
        Bundle bundle = new Bundle();
        bundle.putString(MSG_KEY, msg);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        msg = getArguments().getString(MSG_KEY);
        setStyle(STYLE_NO_TITLE,R.style.ProgressDialog);
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.dialog_normal_progress, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvMsg = (TextView) getView().findViewById(R.id.dialog_normal_progress_msg);
        tvMsg.setText(msg);
    }
}
