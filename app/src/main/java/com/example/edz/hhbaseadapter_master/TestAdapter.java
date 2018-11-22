package com.example.edz.hhbaseadapter_master;

import android.content.Context;

import com.example.recylevieadapter.BaseRecyleViewAdapter;
import com.example.recylevieadapter.BaseViewHolder;

import java.util.List;

/*
 *  @项目名：  HHBaseAdaptermaster
 *  @包名：    com.example.edz.hhbaseadapter_master
 *  @文件名:   TestAdapter
 *  @创建者:   huhai
 *  @创建时间:  2018/11/22 15:58
 *  @描述：
 */
public class TestAdapter extends BaseRecyleViewAdapter<Person> {


    /**
     * @param context  //上下文
     * @param layoutId //布局id
     * @param data     //数据源
     */
    public TestAdapter(Context context, int layoutId, List<Person> data) {
        super(context, layoutId, data);

    }


    @Override
    protected void convert(BaseViewHolder holder, Person bean) {
        holder.setText(R.id.tv_text, bean.getName());
    }
}
