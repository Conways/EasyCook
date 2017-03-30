package com.conways.easycook.mvp.presenter;


import com.conways.easycook.entity.CookDetail;
import com.conways.easycook.mvp.model.CookDetailModelImpl;
import com.conways.easycook.mvp.view.CookDetailView;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Conways on 2017/03/30
 */

public class CookDetailPresenterImpl implements CookDetailPresenter {

    private CookDetailModelImpl cookDetailModel;
    private CookDetailView cookDetailView;

    public CookDetailPresenterImpl(CookDetailView cookDetailView) {
        this.cookDetailView = cookDetailView;
        cookDetailModel = new CookDetailModelImpl();
    }

    @Override
    public void getCookDetail() {
        cookDetailModel.getObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<CookDetail>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<CookDetail> value) {
                        cookDetailView.update(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}