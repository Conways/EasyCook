package com.conways.easycook.mvp.model;


import com.conways.easycook.entity.CookDetail;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by Conways on 2017/03/30
 */

public class CookDetailModelImpl implements CookDetailModel {

    private List<CookDetail> list;

    @Override
    public Observable<List<CookDetail>> getObservable() {

        final Observable<List<CookDetail>> observable = Observable.create(new ObservableOnSubscribe<List<CookDetail>>() {
            @Override
            public void subscribe(ObservableEmitter<List<CookDetail>> e) throws Exception {
                if (null == list) {
                    list = new ArrayList<CookDetail>();
                    for (int i = 0; i < 6; i++) {
                        try {
                            Thread.sleep(100l);
                        } catch (Exception c) {
                            e.onError(c);
                        }
                        CookDetail detail = new CookDetail();
                        detail.setName(i + "种类");
                        list.add(detail);
                    }
                }
                e.onNext(list);
                e.onComplete();

            }
        });
        return observable;
    }
}