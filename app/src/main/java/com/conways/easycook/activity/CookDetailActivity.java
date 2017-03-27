
package com.conways.easycook.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.ListView;

import com.conways.easycook.Adapter.CookDetailPageAdapter;
import com.conways.easycook.R;
import com.conways.easycook.common.CTransformer;
import com.conways.easycook.entity.CookDetail;

import java.util.ArrayList;
import java.util.List;

public class CookDetailActivity extends BaseActivity {

    private ViewPager viewPager;
    private CookDetailPageAdapter pageAdapter;
    private List<CookDetail> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook_detail);
        init();
    }

    private void init() {
        initData();
        viewPager = $(R.id.cook_detali_vp);
        pageAdapter = new CookDetailPageAdapter(list,this);
        viewPager.setAdapter(pageAdapter);
        viewPager.setPageTransformer(true, new CTransformer());
    }



    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            CookDetail detail = new CookDetail();
            detail.setDescribe("test");
            detail.setPrice(0.2f);
            detail.setName(i + "商品");
            list.add(detail);
        }
    }
}
