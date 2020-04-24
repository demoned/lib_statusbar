package com.bojun.bar;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.Nullable;

public final class RequestManagerFragment extends Fragment {

    private StatusDelegate mDelegate;

    public StatusBar get(Object o) {
        if (mDelegate == null) {
            mDelegate = new StatusDelegate(o);
        }
        return mDelegate.get();
    }

    public StatusBar get(Activity activity, Dialog dialog) {
        if (mDelegate == null) {
            mDelegate = new StatusDelegate(activity, dialog);
        }
        return mDelegate.get();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mDelegate != null) {
            mDelegate.onActivityCreated(getResources().getConfiguration());
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mDelegate != null) {
            mDelegate.onResume();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mDelegate != null) {
            mDelegate.onDestroy();
            mDelegate = null;
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (mDelegate != null) {
            mDelegate.onConfigurationChanged(newConfig);
        }
    }
}
