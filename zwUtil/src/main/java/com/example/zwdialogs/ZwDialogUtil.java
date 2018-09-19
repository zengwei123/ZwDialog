package com.example.zwdialogs;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.List;

/**
 * Created by zengwei on 2018/9/18.
 * 对话框
 */

public class ZwDialogUtil{
    /**确认对话框**/
    public void determine(final Activity activity, String titleStr, String messageStr, final DetermineListener determineListener){
        /**布局**/
        final Dialog dialog = new Dialog(activity, R.style.NormalDialogStyle);
        View view = View.inflate(activity, R.layout.determine, null);
        TextView title =  view.findViewById(R.id.title);
        TextView message =  view.findViewById(R.id.message);
        TextView cancel =  view.findViewById(R.id.cancel);
        TextView confirm =  view.findViewById(R.id.confirm);
        title.setText(titleStr);  //标题
        message.setText(messageStr);   //内容
        /**设置布局**/
        dialog.setContentView(view);
        //使得点击对话框外部不消失对话框
        dialog.setCanceledOnTouchOutside(false);
        /**设置对话框的宽高大小位置**/
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = (int)ZWindowSizeUtils.getInstance(activity).getScreenWidth(0.75f);
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        dialogWindow.setAttributes(lp);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                determineListener.no();
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                determineListener.ok();
            }
        });
        dialog.show();
    }

    /**底部列表对话框**/
    public void select(final Activity activity, String[] strings,final SelectListener selectListener){
        /**布局**/
        final Dialog dialog = new Dialog(activity, R.style.NormalDialogStyle);
        View view = View.inflate(activity, R.layout.select, null);
        TextView cancel =  view.findViewById(R.id.cancel);
        RecyclerView recyclerView=view.findViewById(R.id.selectRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(new SelectAdatper(activity.getApplicationContext(),strings,selectListener,dialog));
        /**设置布局**/
        dialog.setContentView(view);
        //使得点击对话框外部不消失对话框
        dialog.setCanceledOnTouchOutside(false);
        /**设置对话框的宽高大小位置**/
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = (int)ZWindowSizeUtils.getInstance(activity).getScreenWidth(0.90f);
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.BOTTOM;
        dialogWindow.setAttributes(lp);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                selectListener.no();
            }
        });
        dialog.show();
    }
    /**底部列表对话框**/
    public void select(final Activity activity, List<String> stringList, final SelectListener selectListener){
        /**布局**/
        final Dialog dialog = new Dialog(activity, R.style.NormalDialogStyle);
        View view = View.inflate(activity, R.layout.select, null);
        /**取消按钮**/
        TextView cancel =  view.findViewById(R.id.cancel);
        /**列表**/
        RecyclerView recyclerView=view.findViewById(R.id.selectRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(new SelectAdatper(activity.getApplicationContext(),stringList,selectListener,dialog));
        /**设置布局**/
        dialog.setContentView(view);
        //使得点击对话框外部不消失对话框
        dialog.setCanceledOnTouchOutside(false);
        /**设置对话框的宽高大小位置**/
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        /**设置宽**/
        lp.width = (int)ZWindowSizeUtils.getInstance(activity).getScreenWidth(0.90f);
        /**高度自适应**/
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        /**置于底部**/
        lp.gravity = Gravity.BOTTOM;
        dialogWindow.setAttributes(lp);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                selectListener.no();
            }
        });
        dialog.show();
    }

    /**加载对话框**/
    public Dialog littie(final Activity activity,int i,String color){
        /**布局**/
        final Dialog dialog = new Dialog(activity, R.style.NormalDialogStyle1);
        View view = View.inflate(activity, R.layout.lottie, null);
        if(color!=null){
            view.setBackgroundColor(Color.parseColor(color));
        }
        LottieAnimationView animation_view;
        switch (i){
            case 0:animation_view=view.findViewById(R.id.animation_view1);break;
            case 1:animation_view=view.findViewById(R.id.animation_view2);break;
            case 2:animation_view=view.findViewById(R.id.animation_view3);break;
            case 3:animation_view=view.findViewById(R.id.animation_view4);break;
            default:animation_view=view.findViewById(R.id.animation_view1);break;
        }
        animation_view.setVisibility(View.VISIBLE);
        animation_view.playAnimation();
        /**设置布局**/
        dialog.setContentView(view);
        //使得点击对话框外部不消失对话框
        dialog.setCanceledOnTouchOutside(false);
        /**设置对话框的宽高大小位置**/
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = (int)ZWindowSizeUtils.getInstance(activity).getScreenWidth(0.25f);
        lp.height = (int)ZWindowSizeUtils.getInstance(activity).getScreenWidth(0.25f);
        lp.gravity = Gravity.CENTER;
        dialogWindow.setAttributes(lp);
        dialog.show();
        return dialog;
    }
}
