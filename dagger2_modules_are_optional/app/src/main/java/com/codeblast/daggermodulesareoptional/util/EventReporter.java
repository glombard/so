package com.codeblast.daggermodulesareoptional.util;

public class EventReporter {

    private EventListener mListener;

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
