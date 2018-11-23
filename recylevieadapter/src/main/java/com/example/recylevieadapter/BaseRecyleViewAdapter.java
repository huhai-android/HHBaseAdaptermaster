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

    private static final int TYPE_NORMAL = 0;
    private static final int TYPE_HEADER = -1;
    private static final int TYPE_bOTTOM = 1;
    private static final String TAG = "BaseRecyleViewAdapter";
    private int layoutId;
    private List<? extends T> data;
    public Context context;
    private OnItemClickListner onItemClickListner;//单击事件
    private OnItemLongClickListner onItemLongClickListner;//长按单击事件
    private boolean clickFlag = true;//单击事件和长单击事件的屏蔽标识
    private int headView;
    private int bottomview;
    private int headercount = 0;
    private int buttoncount = 0;
    private BaseViewHolder holder;

    public BaseRecyleViewAdapter(Context context, int layoutId, List<? extends T> data) {
        this.layoutId = layoutId;
        this.data = data;
        this.context = context;
    }

    public BaseRecyleViewAdapter(Context context, int layoutId, List<? extends T> data, int headerView, int bottomview) {
        this.layoutId = layoutId;
        this.data = data;
        this.context = context;
        this.headView = headerView;
        headercount = (headView == 0 ? 0 : 1);
        this.bottomview = bottomview;
        buttoncount = (bottomview == 0 ? 0 : 1);

    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = null;
        BaseViewHolder holder = null;
        if (viewType == TYPE_HEADER) {
            v = LayoutInflater.from(context).inflate(headView, parent, false);
            holder = new BaseViewHolder(v, context);
        } else if (viewType == TYPE_bOTTOM) {
            v = LayoutInflater.from(context).inflate(bottomview, parent, false);
            holder = new BaseViewHolder(v, context);
        } else {
            v = LayoutInflater.from(context).inflate(layoutId, parent, false);
            holder = new BaseViewHolder(v, context);
        }
        //单击事件回调

        final BaseViewHolder finalHolder = holder;
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickFlag) {
                    if (onItemClickListner!=null)
                    onItemClickListner.onItemClickListner(v, finalHolder.getLayoutPosition());
                }
                clickFlag = true;
            }
        });
        //单击长按事件回调
        final BaseViewHolder finalHolder1 = holder;
        v.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onItemClickListner!=null)
                onItemLongClickListner.onItemLongClickListner(v, finalHolder1.getLayoutPosition());
                clickFlag = false;
                return false;
            }
        });
        return holder;

    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (position == 0) {
            if (headercount == 0) {
                convert(holder, data.get(position - headercount));
            } else {
                convertHeader(holder);
            }
        } else if (position == data.size() - 1 + headercount + buttoncount) {
            if (buttoncount == 0) {
                convert(holder, data.get(position - headercount));
            } else {
                convertBottom(holder);
            }
        } else {
            convert(holder, data.get(position - headercount));
        }


    }

    public abstract void convertBottom(BaseViewHolder holder);

    public abstract void convertHeader(BaseViewHolder holder);

    protected abstract void convert(BaseViewHolder holder, T bean);

    @Override
    public int getItemCount() {
        if (data != null) {
            return data.size() + headercount + buttoncount;
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            if (headView == 0) {
                return TYPE_NORMAL;
            } else {
                return TYPE_HEADER;
            }
        } else if (position == data.size() - 1 + headercount + buttoncount) {
            if (bottomview == 0) {
                return TYPE_NORMAL;
            } else {
                return TYPE_bOTTOM;
            }
        }
        return TYPE_NORMAL;
    }

    public void setOnItemClickListner(OnItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    public void setOnItemLongClickListner(OnItemLongClickListner onItemLongClickListner) {
        this.onItemLongClickListner = onItemLongClickListner;
    }

}
