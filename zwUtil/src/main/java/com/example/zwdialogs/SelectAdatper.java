package com.example.zwdialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zengwei on 2018/9/18.
 */

public class SelectAdatper extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<String> stringList;
    private String[] strings;
    private SelectListener selectListener;
    private Dialog dialog;
    public SelectAdatper(Context context, List<String> stringList, SelectListener selectListener, Dialog dialog){
        this.context=context;
        this.stringList=stringList;
        this.selectListener=selectListener;
        this.dialog=dialog;
    }
    public SelectAdatper(Context context, String[] strings,SelectListener selectListener, Dialog dialog){
        this.context=context;
        this.strings=strings;
        this.selectListener=selectListener;
        this.dialog=dialog;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.select_item,parent,false);
        return new SelectHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        SelectHolder selectHolder= (SelectHolder) holder;
        if(stringList!=null){
            selectHolder.items.setText(stringList.get(position));
        }else{
            selectHolder.items.setText(strings[position]);
        }
        selectHolder.items.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectListener.itemClick(position);
                dialog.dismiss();
            }
        });
    }

    @Override
    public int getItemCount() {
        if(stringList!=null){
            return stringList.size();
        }else{
            return strings.length;
        }
    }

    class SelectHolder extends RecyclerView.ViewHolder{
        private TextView items;
        public SelectHolder(View itemView) {
            super(itemView);
            items=itemView.findViewById(R.id.items);
        }

    }
}
