package com.bojun.bar;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Build;
import android.view.Surface;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

public class StatusDelegate implements Runnable {

    private StatusBar mImmersionBar;
    private BarProperties mBarProperties;
    private OnBarListener mOnBarListener;
    private int mNotchHeight;

    public StatusDelegate(Object o) {
        if (o instanceof Activity) {
            if (mImmersionBar == null) {
                mImmersionBar = new StatusBar((Activity) o);
            }
        } else if (o instanceof Fragment) {
            if (mImmersionBar == null) {
                if (o instanceof DialogFragment) {
                    mImmersionBar = new StatusBar((DialogFragment) o);
                } else {
                    mImmersionBar = new StatusBar((Fragment) o);
                }
            }
        } else if (o instanceof android.app.Fragment) {
            if (mImmersionBar == null) {
                if (o instanceof android.app.DialogFragment) {
                    mImmersionBar = new StatusBar((DialogFragment) o);
                } else {
                    mImmersionBar = new StatusBar((Fragment) o);
                }
            }
        }
    }

    public StatusDelegate(Activity activity, Dialog dialog) {
        if (mImmersionBar == null) {
            mImmersionBar = new StatusBar(activity, dialog);
        }
    }

    public StatusBar get() {
        return mImmersionBar;
    }

    public void onActivityCreated(Configuration configuration) {
        barChanged(configuration);
    }

    public void onResume() {
        if (mImmersionBar != null) {
            mImmersionBar.onResume();
        }
    }

    public void onDestroy() {
        mBarProperties = null;
        if (mImmersionBar != null) {
            mImmersionBar.onDestroy();
            mImmersionBar = null;
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        if (mImmersionBar != null) {
            mImmersionBar.onConfigurationChanged(newConfig);
            barChanged(newConfig);
        }
    }

    /**
     * 横竖屏切换监听
     * Orientation change.
     *
     * @param configuration the configuration
     */
    private void barChanged(Configuration configuration) {
        if (mImmersionBar != null && mImmersionBar.initialized() && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mOnBarListener = mImmersionBar.getBarParams().onBarListener;
            if (mOnBarListener != null) {
                final Activity activity = mImmersionBar.getActivity();
                if (mBarProperties == null) {
                    mBarProperties = new BarProperties();
                }
                mBarProperties.setPortrait(configuration.orientation == Configuration.ORIENTATION_PORTRAIT);
                int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
                if (rotation == Surface.ROTATION_90) {
                    mBarProperties.setLandscapeLeft(true);
                    mBarProperties.setLandscapeRight(false);
                } else if (rotation == Surface.ROTATION_270) {
                    mBarProperties.setLandscapeLeft(false);
                    mBarProperties.setLandscapeRight(true);
                } else {
                    mBarProperties.setLandscapeLeft(false);
                    mBarProperties.setLandscapeRight(false);
                }
                activity.getWindow().getDecorView().post(this);
            }
        }
    }

    @Override
    public void run() {
        if (mImmersionBar != null && mImmersionBar.getActivity() != null) {
            Activity activity = mImmersionBar.getActivity();
            BarConfig barConfig = new BarConfig(activity);
            mBarProperties.setStatusBarHeight(barConfig.getStatusBarHeight());
            mBarProperties.setNavigationBar(barConfig.hasNavigationBar());
            mBarProperties.setNavigationBarHeight(barConfig.getNavigationBarHeight());
            mBarProperties.setNavigationBarWidth(barConfig.getNavigationBarWidth());
            mBarProperties.setActionBarHeight(barConfig.getActionBarHeight());
            boolean notchScreen = NotchUtils.hasNotchScreen(activity);
            mBarProperties.setNotchScreen(notchScreen);
            if (notchScreen && mNotchHeight == 0) {
                mNotchHeight = NotchUtils.getNotchHeight(activity);
                mBarProperties.setNotchHeight(mNotchHeight);
            }
            mOnBarListener.onBarChange(mBarProperties);
        }
    }
}
