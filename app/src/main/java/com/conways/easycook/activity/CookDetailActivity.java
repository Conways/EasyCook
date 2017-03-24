
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

import java.util.ArrayList;
import java.util.List;

public class CookDetailActivity extends BaseActivity {

    private ViewPager viewPager;
    private CookDetailPageAdapter pageAdapter;
    private List<View> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook_detail);
        init();
    }

    private void init() {
        initData();
        viewPager=$(R.id.cook_detali_vp);
        pageAdapter=new CookDetailPageAdapter(list);
        viewPager.setAdapter(pageAdapter);
        viewPager.setPageTransformer(true,new CTransformer());
    }

    private void initData(){
        list=new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            View view= LayoutInflater.from(this).inflate(R.layout.item_cook_detail_pager,null);
            list.add(view);
        }
    }
}
