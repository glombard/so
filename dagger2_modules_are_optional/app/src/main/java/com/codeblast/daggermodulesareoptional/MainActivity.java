package com.codeblast.daggermodulesareoptional;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.codeblast.daggermodulesareoptional.hero.Battle;
import com.codeblast.daggermodulesareoptional.util.EventReporter;
import com.codeblast.daggermodulesareoptional.util.LogMessageJoiner;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private Subscription mTimerSubscription;

    private Battle mAvengersBattle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LogMessageJoiner log = new LogMessageJoiner();
        final EventReporter eventReporter = new EventReporter();
        eventReporter.setListener(new EventReporter.EventListener() {
            @Override
            public void onMessage(String message) {
                ((TextView) findViewById(R.id.message)).setText(log.getLogText(message));
            }
        });
        mAvengersBattle = new Battle(eventReporter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mTimerSubscription = Observable.interval(2, 2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.from(AsyncTask.THREAD_POOL_EXECUTOR))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long l) {
                        mAvengersBattle.nextMove();
                    }
                });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mTimerSubscription.unsubscribe();
    }
}
