package com.codeblast.daggermodulesareoptional.util;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class EventReporter {

    private EventListener mListener;

    @Inject
    public EventReporter() {
    }

    public void show(String message) {
        if (mListener != null) {
            mListener.onMessage(message);
        }
    }

    public void setListener(EventListener listener) {
        mListener = listener;
    }

    public interface EventListener {

        void onMessage(String message);
    }
}
