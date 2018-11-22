package com.example.recylevieadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/*
 *  @项目名：  HHBaseAdaptermaster
 *  @包名：    com.example.edz.hhbaseadapter_master
 *  @文件名:   BaseViewHolder
 *  @创建者:   huhai
 *  @创建时间:  2018/11/22 16:04
 *  @描述：
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {
    View convertView;
    Context context;

    public BaseViewHolder(View v, Context context) {
        super(v);
        this.convertView = itemView;
        this.context = context;
    }

    public void setText(int id, String text) {
        TextView tx = (TextView) convertView.findViewById(id);
        tx.setText(text);
    }

    public void setImageResource(int id, int resouceId) {
        ImageView img = (ImageView) convertView.findViewById(id);
        img.setImageResource(resouceId);
    }

}
