package com.example.zwdialogs;


import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Html;
import android.util.AttributeSet;



/**
 * Created by zengwei on 2018/7/7.
 * 重写用来设置字体图库
 */

public class ZwTextView extends android.support.v7.widget.AppCompatTextView {
    private String s;
    public ZwTextView(Context context) {
        super(context);
        setTypeface(getTypeFace(context));
        s=getText().toString();
        setText(Html.fromHtml(s));
    }
    public ZwTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(getTypeFace(context));
        s=getText().toString();
        setText(Html.fromHtml(s));
    }
    public ZwTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(getTypeFace(context));
        s=getText().toString();
        setText(Html.fromHtml(s));
    }
    public Typeface getTypeFace(Context context){
        Typeface typeface=Typeface.createFromAsset(context.getAssets(),"font/icomoon.ttf");
        return typeface;
    }
}
