package com.codeblast.daggermultiplescopes;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private static final String TAG = "MainActivityFragment";

    @Inject
    MainPresenter applicationScopeDependency;

    @Inject
    Context activityScopeDependency;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Would probably be more accurate to create and expose this from the MainActivity...
        final MainComponent mainComponent = DaggerMainComponent.builder()
                .applicationComponent(((App) getActivity().getApplication()).getComponent())
                .mainModule(new MainModule(getActivity()))
                .build();
        mainComponent.initialize(this);

        if (applicationScopeDependency == null) {
            throw new IllegalStateException("presenter null!");
        }
        if (activityScopeDependency == null) {
            throw new IllegalStateException("activity dependency null");
        }

        Log.d(TAG, "app dependency: " + applicationScopeDependency);
        Log.d(TAG, "activity dependency: " + activityScopeDependency);

        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
