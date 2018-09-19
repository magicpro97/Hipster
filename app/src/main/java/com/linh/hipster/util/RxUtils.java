package com.linh.hipster.util;

import java.util.concurrent.TimeUnit;

import rx.Observable;


public class RxUtils {

    private RxUtils() {

    }

    public static Observable<?> getRetryObservable(Observable<? extends Throwable> observable, int count) {
        return observable.zipWith(Observable.range(1, count), (throwable, integer) -> {
            if (integer < count) {
                
                return Observable.timer(1, TimeUnit.SECONDS);
            }
            
            return Observable.error(new IllegalStateException());
        });
    }

    public static <T> Observable.Transformer<T, Long> zipWithFlatMap(int attempts, int backoff) {
        return observable ->
                observable
                        .zipWith(Observable.range(1, attempts), (t, repeatAttempt) -> repeatAttempt)
                        .flatMap(repeatAttempt -> Observable.timer(repeatAttempt * backoff, TimeUnit.SECONDS));
    }
}
