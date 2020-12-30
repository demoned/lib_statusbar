package com.bojun.bar;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.view.View;
import android.view.WindowManager;
import java.util.HashMap;
import java.util.Map;

/**
 * 沉浸式参数信息
 */
public class BarParams implements Cloneable {
    /**
     * 状态栏颜色
     */
    @ColorInt
    public int statusBarColor = Color.TRANSPARENT;
    /**
     * 导航栏颜色
     */
    @ColorInt
    public int navigationBarColor = Color.BLACK;

    /**
     * The Default navigation bar color.
     */
    public int defaultNavigationBarColor = Color.BLACK;
    /**
     * 状态栏透明度
     */
    @FloatRange(from = 0f, to = 1f)
    public float statusBarAlpha = 0.0f;

    @FloatRange(from = 0f, to = 1f)
    public float statusBarTempAlpha = 0.0f;
    /**
     * 导航栏透明度
     */
    @FloatRange(from = 0f, to = 1f)
    public float navigationBarAlpha = 0.0f;
    @FloatRange(from = 0f, to = 1f)
    public float navigationBarTempAlpha = 0.0f;
    /**
     * 有导航栏的情况，全屏显示
     */
    public boolean fullScreen = false;
    /**
     * 是否隐藏了导航栏
     */
    public boolean hideNavigationBar = false;
    /**
     * 隐藏Bar
     */
    public BarHide barHide = BarHide.FLAG_SHOW_BAR;
    /**
     * 状态栏字体深色与亮色标志位
     */
    public boolean statusBarDarkFont = false;

    /**
     * 导航栏图标深色与亮色标志位
     */
    public boolean navigationBarDarkIcon = false;
    /**
     * 是否启用 自动根据StatusBar颜色调整深色模式与亮色模式
     */
    public boolean autoStatusBarDarkModeEnable = false;

    /**
     * 是否启用 自动根据NavigationBar颜色调整深色模式与亮色模式
     */
    public boolean autoNavigationBarDarkModeEnable = false;

    /**
     * The Auto status bar dark mode alpha.
     */
    @FloatRange(from = 0f, to = 1f)
    public float autoStatusBarDarkModeAlpha = 0.0f;

    /**
     * The Auto navigation bar dark mode alpha.
     */
    @FloatRange(from = 0f, to = 1f)
    public float autoNavigationBarDarkModeAlpha = 0.0f;

    /**
     * 是否可以修改状态栏颜色
     * The Status bar flag.
     */
    public boolean statusBarColorEnabled = true;
    /**
     * 状态栏变换后的颜色
     * The Status bar color transform.
     */
    @ColorInt
    public int statusBarColorTransform = Color.BLACK;
    /**
     * 导航栏变换后的颜色
     * The Navigation bar color transform.
     */
    @ColorInt
    public int navigationBarColorTransform = Color.BLACK;
    /**
     * 支持view变色
     * The View map.
     */
    Map<View, Map<Integer, Integer>> viewMap = new HashMap<>();
    /**
     * The View alpha.
     */
    @FloatRange(from = 0f, to = 1f)
    public float viewAlpha = 0.0f;
    /**
     * The Status bar color content view.
     */
    @ColorInt
    public int contentColor = Color.TRANSPARENT;
    /**
     * The Status bar color content view transform.
     */
    @ColorInt
    public int contentColorTransform = Color.BLACK;
    /**
     * The Status bar content view alpha.
     */
    @FloatRange(from = 0f, to = 1f)
    public float contentAlpha = 0.0f;
    /**
     * 解决标题栏与状态栏重叠问题
     * The Fits.
     */
    public boolean fits = false;
    /**
     * 解决标题栏与状态栏重叠问题
     * The Title bar view.
     */
    public View titleBarView;
    /**
     * 解决标题栏与状态栏重叠问题
     * The Status bar view by height.
     */
    public View statusBarView;
    /**
     * 是否可以解决标题栏与状态栏重叠问题
     */
    public boolean fitsLayoutOverlapEnable = true;
    /**
     * flymeOS状态栏字体变色
     * The Flyme os status bar font color.
     */
    @ColorInt
    public int flymeOSStatusBarFontColor;
    @ColorInt
    public int flymeOSStatusBarFontTempColor;
    /**
     * 结合actionBar使用
     * The Is support action bar.
     */
    public boolean isSupportActionBar = false;

    /**
     * 是否能修改导航栏颜色
     * The Navigation bar enable.
     */
    public boolean navigationBarEnable = true;
    /**
     * 是否能修改4.4手机以及华为emui3.1导航栏颜色
     * The Navigation bar with kitkat enable.
     */
    public boolean navigationBarWithKitkatEnable = true;
    /**
     * 是否可以修改emui3系列手机导航栏
     * The Navigation bar with emui 3 enable.
     */
    public boolean navigationBarWithEMUI3Enable = true;
    /**
     * 是否可以沉浸式
     * The Init enable.
     */
    public boolean barEnable = true;

    /**
     * 导航栏显示隐藏监听
     */
    public OnNavigationBarListener onNavigationBarListener;

    /**
     * 横竖屏监听
     */
    public OnBarListener onBarListener;

    @Override
    protected BarParams clone() {
        BarParams barParams = null;
        try {
            barParams = (BarParams) super.clone();
        } catch (CloneNotSupportedException ignored) {
        }
        return barParams;
    }
}
