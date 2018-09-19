package com.example.zwdialogs;

import android.animation.FloatEvaluator;
import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by zengwei on 2018/9/19.
 * 一些小设置
 */

public class ZwUtil {
    /**
     * 获取图片并设置大小
     * @param context
     * @param width
     * @param image
     * @return
     */
    public static Bitmap loadImage(Context context, int width, int image){
        Resources res =context.getResources();
        return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res,image), width, width, true);
    }

    /**
     * 屏幕最小尺寸
     * @param activity
     * @return
     */
    public static int getScreenManager(Activity activity){
        WindowManager manager = activity.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int width2 = outMetrics.widthPixels;
        int height2 = outMetrics.heightPixels;
        return width2>height2?height2:width2;
    }

    /**
     * 属性动画
     * @param view   控件
     * @param time   动画执行时间
     * @param animStr  动画类型
     * @param floats   属性
     */
    public static void AnimatorFloat(View view,int time,String animStr,float... floats){
        ObjectAnimator objectAnimator= ObjectAnimator.ofFloat(view,animStr, floats);       //透明度
        objectAnimator.setEvaluator(new FloatEvaluator());    //设置一个估值器，常用的有ArgbEvaluator\IntEvaluator\FloatEvaluator
        objectAnimator.setDuration(time);
        objectAnimator.start();
    }
    public static void AnimatorInt(View view,int time,String animStr,int... ints){
        ObjectAnimator objectAnimator= ObjectAnimator.ofInt(view,animStr, ints);       //透明度
        objectAnimator.setEvaluator(new IntEvaluator());    //设置一个估值器，常用的有ArgbEvaluator\IntEvaluator\FloatEvaluator
        objectAnimator.setDuration(time);
        objectAnimator.start();
    }
}
