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
import com.conways.easycook.common.OnItemClickLisenter;
import com.conways.easycook.entity.CookType;
import com.conways.easycook.hold.CookTypeHolder;

import java.util.List;

/**
 * Created by Conways on 2017/3/27.
 */

public class CookTypeAdapter extends RecyclerView.Adapter<CookTypeHolder> {

    private List<CookType> list;
    private Context context;
    private OnItemClickLisenter onItemClickLisenter;

    public CookTypeAdapter(List<CookType> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setOnItemClickLisenter(OnItemClickLisenter onItemClickLisenter) {
        this.onItemClickLisenter = onItemClickLisenter;
    }

    @Override
    public CookTypeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CookTypeHolder(LayoutInflater.from(context).inflate(R.layout.item_cook_type,
                parent, false));
    }

    @Override
    public void onBindViewHolder(CookTypeHolder holder, final int position) {
        holder.tvName.setText(list.get(position).getName());
        holder.ivType.setImageResource(CookDetailPageAdapter.ivs[position % 3]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickLisenter == null) {
                    return;
                }
                onItemClickLisenter.itemClick(position, CookTypeAdapter.this);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
