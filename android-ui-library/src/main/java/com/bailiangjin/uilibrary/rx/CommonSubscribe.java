package com.bailiangjin.uilibrary.rx;

import rx.Subscriber;

/**
 * Created by bailiangjin on 2017/3/30.
 */

public abstract class CommonSubscribe<T> extends Subscriber<T>{
    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }


}
