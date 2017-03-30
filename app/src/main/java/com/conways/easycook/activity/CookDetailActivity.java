
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
import com.conways.easycook.mvp.presenter.CookDetailPresenterImpl;
import com.conways.easycook.mvp.view.CookDetailView;

import java.util.ArrayList;
import java.util.List;

public class CookDetailActivity extends BaseActivity implements CookDetailView {

    private ViewPager viewPager;
    private CookDetailPageAdapter pageAdapter;
    private CookDetailPresenterImpl cookDetailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook_detail);
        init();
        cookDetailPresenter.getCookDetail();
    }

    private void init() {
        cookDetailPresenter = new CookDetailPresenterImpl(this);
        viewPager = $(R.id.cook_detali_vp);
        viewPager.setPageTransformer(true, new CTransformer());
    }


    @Override
    public void update(List<CookDetail> list) {
        if (null == pageAdapter) {
            pageAdapter = new CookDetailPageAdapter(list, this);
            viewPager.setAdapter(pageAdapter);
        } else {
            pageAdapter.notifyDataSetChanged();
        }
    }
}
