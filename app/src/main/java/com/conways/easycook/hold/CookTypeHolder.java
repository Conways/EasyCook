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
 * Created by Conways on 2017/3/27.
 */

public class CookTypeHolder extends RecyclerView.ViewHolder{
    public ImageView ivType;
    public TextView tvName;

    public CookTypeHolder(View itemView) {
        super(itemView);
        ivType=(ImageView)itemView.findViewById(R.id.item_cook_type_type);
        tvName=(TextView)itemView.findViewById(R.id.item_cook_type_name_type);
    }



}
