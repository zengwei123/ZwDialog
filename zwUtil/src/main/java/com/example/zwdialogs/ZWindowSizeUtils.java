package com.example.zwdialogs;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by zengwei on 2018/9/18.
 * 获取屏幕宽高的工具类
 */

public class ZWindowSizeUtils {
    private static ZWindowSizeUtils instance = null;
    private int screenWidth, screenHeight;
    public static ZWindowSizeUtils getInstance(Context mContext) {
        if (instance == null) {
            synchronized (ZWindowSizeUtils.class) {
                if (instance == null)
                    instance = new ZWindowSizeUtils(mContext);
            }
        }
        return instance;
    }

    private ZWindowSizeUtils(Context mContext) {
        WindowManager manager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(dm);
        screenWidth = dm.widthPixels;// 获取屏幕分辨率宽度
        screenHeight = dm.heightPixels;// 获取屏幕分辨率高度
    }
    //获取屏幕宽度
    public float getScreenWidth(float f) {
        return screenWidth*f;
    }
    //获取屏幕高度
    public float getScreenHeight(float f) {
        return screenHeight*f;
    }
}
