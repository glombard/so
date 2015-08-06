package com.codeblast.daggermodulesareoptional;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.codeblast.daggermodulesareoptional.hero.Battle;
import com.codeblast.daggermodulesareoptional.hero.DaggerAvengersBattleComponent;
import com.codeblast.daggermodulesareoptional.util.DaggerUtilComponent;
import com.codeblast.daggermodulesareoptional.util.EventReporter;
import com.codeblast.daggermodulesareoptional.util.LogMessageJoiner;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    // This is a completely contrived class hierarchy, but the point here is to demonstrate
    // the gratuitous injectfest! Inject all the things! And note: only two Dagger 2 Components -
    // one for the util singletons, and one for the hero stuff. No Dagger modules needed at all.
    @Inject
    Battle mAvengersBattle;

    @Inject
    LogMessageJoiner mLogJoiner;

    @Inject
    EventReporter mEventReporter;

    private Subscription mTimerSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inject all the things!
        DaggerAvengersBattleComponent.builder()
                .utilComponent(DaggerUtilComponent.create())
                .build()
                .initialize(this);

        mEventReporter.setListener(new EventReporter.EventListener() {
            @Override
            public void onMessage(String message) {
                ((TextView) findViewById(R.id.message)).setText(mLogJoiner.getLogText(message));
            }
        });
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
