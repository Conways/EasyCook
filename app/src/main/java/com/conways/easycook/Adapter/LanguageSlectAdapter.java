/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.conways.easycook.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.conways.easycook.R;
import com.conways.easycook.config.Config;
import com.conways.easycook.hold.LanguageSlectHolder;

/**
 * Created by Conways on 2017/3/22.
 */

public class LanguageSlectAdapter extends RecyclerView.Adapter<LanguageSlectHolder> {

    private Context context;
    private String[] languages;
    private int slectPosition = -1;

    public LanguageSlectAdapter(Context context, String[] languages, int slectPosition) {
        this.context = context;
        this.languages = languages;
        this.slectPosition = slectPosition;
    }

    public LanguageSlectAdapter(Context context, String[] languages) {
        this.context = context;
        this.languages = languages;
    }

    public int getSlectPosition() {
        return slectPosition;
    }

    @Override
    public LanguageSlectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LanguageSlectHolder(LayoutInflater.from(context).inflate(R.layout
                .item_language_slect, parent, false));
    }

    @Override
    public void onBindViewHolder(LanguageSlectHolder holder, final int position) {
        holder.tvLanguage.setText(languages[position]);
        holder.ivSlect.setImageResource(position == slectPosition ? R.drawable.check_checked : R
                .drawable.check_normal);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slectPosition = position;
                LanguageSlectAdapter.this.notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return languages.length;
    }
}
