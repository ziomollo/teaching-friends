package com.ebin;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Main {
    public static void main(String[] args) {
        Flowable.range(1, 1_000_000_000)
                .flatMap(v ->
                        Flowable.just(v)
                                .subscribeOn(Schedulers.computation())
                                .map(w -> w * (w % 5))
                )
                .blockingSubscribe(System.out::println);
    }
}
