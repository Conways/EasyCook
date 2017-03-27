/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.conways.easycook.common;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.conways.easycook.R;

/**
 * Created by Conways on 2017/3/24.
 */

public class CTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {
        Log.d("zzzzz", "transformPage: " + position);
        ImageView imageView = (ImageView) page.findViewById(R.id.item_line_iv);
        if (position % 1 == 0f) {
            imageView.setTranslationX(0);
            return;
        }

        if (Math.abs(position) < 1) {
            imageView.setTranslationX(-position * 400);
        }
    }
}
