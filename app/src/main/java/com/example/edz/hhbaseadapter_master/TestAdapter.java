package com.example.edz.hhbaseadapter_master;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.example.recylevieadapter.BaseRecyleViewAdapter;
import com.example.recylevieadapter.BaseViewHolder;
import com.example.recylevieadapter.OnClickListener;

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

    public TestAdapter(Context context, int layoutId, List<Person> data) {

        super(context, layoutId, data);

    }

    public TestAdapter(Context context, int layoutId, List<Person> list, int headerviewID, int bottomViewID) {
        super(context, layoutId, list,headerviewID,bottomViewID);
    }


    @Override
    protected void convert(BaseViewHolder holder, Person bean) {
        holder.setText(R.id.tv_text, bean.getName());
    }

    @Override
    public void convertBottom(BaseViewHolder holder) {
        holder.setOnCLickListener(R.id.tv_buttom, new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"点击了底部",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void convertHeader(BaseViewHolder holder) {
        holder.setOnCLickListener(R.id.tv_header, new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"点击了头部",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
