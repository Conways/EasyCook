/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.conways.easycook.hold;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.conways.easycook.R;

/**
 * Created by Conways on 2017/3/22.
 */

public class LanguageSlectHolder extends RecyclerView.ViewHolder {

    public TextView tvLanguage;
    public ImageView ivSlect;

    public LanguageSlectHolder(View itemView) {
        super(itemView);
        tvLanguage = (TextView) itemView.findViewById(R.id.item_language_select_language);
        ivSlect = (ImageView) itemView.findViewById(R.id.item_language_select_checkbox);
    }
}
