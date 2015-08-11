package rxtest;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

import java.io.Closeable;
import java.io.IOException;
import java.util.Map;
import java.util.WeakHashMap;

public class AutoCloseOperator<T extends Closeable> implements Observable.Operator<T, T> {
    private final Map<Subscriber, T> previousValues = new WeakHashMap<Subscriber, T>();

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        subscriber.add(Subscriptions.create(new Action0() {
            public void call() {
                // Close when the last subscriber is done.
                closeValue(subscriber, null);
            }
        }));
        return new Subscriber<T>() {
            public void onCompleted() {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onCompleted();
                }
            }

            public void onError(Throwable throwable) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onError(throwable);
                }
            }

            public void onNext(T t) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext(t);
                }
                closeValue(subscriber, t);
            }
        };
    }

    private synchronized void closeValue(Subscriber subscriber, T newValue) {
        T oldValue = null;
        if (previousValues.containsKey(subscriber)) {
            oldValue = previousValues.remove(subscriber);
        }
        if (oldValue != null && oldValue != newValue) {
            if (!previousValues.containsValue(oldValue)) {
                try {
                    oldValue.close();
                } catch (IOException ignore) {
                }
            }
        }
        if (newValue != null) {
            previousValues.put(subscriber, newValue);
        }
    }
}
