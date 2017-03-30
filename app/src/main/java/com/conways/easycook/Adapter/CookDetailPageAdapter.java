/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.conways.easycook.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.conways.easycook.R;
import com.conways.easycook.entity.CookDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Conways on 2017/3/24.
 */

public class CookDetailPageAdapter extends PagerAdapter {
    public static int[] ivs = {R.drawable.pizz, R.drawable.nudle, R.drawable.hum};
    private List<CookDetail> list;
    private Context context;

    public CookDetailPageAdapter(List<CookDetail> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public View instantiateItem(ViewGroup container, int position) {
        View convertView = LayoutInflater.from(context).inflate(R.layout.item_cook_detail_pager,
                null, false);
        ImageView imageView=(ImageView)convertView.findViewById(R.id.item_line_iv) ;
        imageView.setImageResource(ivs[position%3]);
        container.addView(convertView);
        return convertView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    class Hold {
        ImageView imageView;
    }

}
