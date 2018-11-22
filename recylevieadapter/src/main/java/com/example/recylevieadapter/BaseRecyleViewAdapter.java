package com.example.recylevieadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/*
 *  @项目名：  HHBaseAdaptermaster
 *  @包名：    com.example.edz.hhbaseadapter_master
 *  @文件名:   BaseRecyleViewAdapter
 *  @创建者:   huhai
 *  @创建时间:  2018/11/22 16:04
 *  @描述：
 */
public abstract class BaseRecyleViewAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    private int layoutId;
    private List<? extends T> data;
    private Context context;
    private OnItemClickListner onItemClickListner;//单击事件
    private OnItemLongClickListner onItemLongClickListner;//长按单击事件
    private boolean clickFlag = true;//单击事件和长单击事件的屏蔽标识

    public BaseRecyleViewAdapter(Context context, int layoutId, List<? extends T> data) {
        this.layoutId = layoutId;
        this.data = data;
        this.context = context;
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(layoutId, parent, false);
        final BaseViewHolder holder = new BaseViewHolder(v, context);
        //单击事件回调
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickFlag) {
                    onItemClickListner.onItemClickListner(v, holder.getLayoutPosition());
                }
                clickFlag = true;
            }
        });
        //单击长按事件回调
        v.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onItemLongClickListner.onItemLongClickListner(v, holder.getLayoutPosition());
                clickFlag = false;
                return false;
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        convert(holder, data.get(position));
    }

    protected abstract void convert(BaseViewHolder holder, T bean);

    @Override
    public int getItemCount() {
        if (data != null) {
            return data.size();
        }
        return 0;
    }

    public void setOnItemClickListner(OnItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    public void setOnItemLongClickListner(OnItemLongClickListner onItemLongClickListner) {
        this.onItemLongClickListner = onItemLongClickListner;
    }



}
