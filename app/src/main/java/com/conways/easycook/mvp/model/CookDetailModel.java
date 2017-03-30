package com.conways.easycook.mvp.model;

import com.conways.easycook.entity.CookDetail;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Conways on 2017/03/30
 */

public interface CookDetailModel {

    public Observable<List<CookDetail>> getObservable();

}