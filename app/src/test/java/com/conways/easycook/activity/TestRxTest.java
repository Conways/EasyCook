/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.conways.easycook.activity;

import org.junit.Test;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Conways on 2017/3/28.
 */
public class TestRxTest {
    @Test
    public void run() throws Exception {

        Observable<String> observable= Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("test1");
                e.onNext("test2");
                e.onNext("test3");
                e.onNext("test4");
                e.onNext("test5");
                e.onComplete();
//                e.onError(new NullPointerException());
            }
        });

        Observer observer=new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {
                try {
                    Thread.sleep(200l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(value.toString()+"\n");
            }

            @Override
            public void onError(Throwable e) {
                System.out.print(e.toString());
            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);
    }

}