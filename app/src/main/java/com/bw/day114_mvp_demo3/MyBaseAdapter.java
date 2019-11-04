package com.bw.day114_mvp_demo3;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Copyright (C)
 * <p>
 * FileName: MyBaseAdapter
 * <p>
 * Author: zhaozhipeng
 * <p>
 * Date: 2019/11/4 16:35
 * <p>
 * Description:
 */
public class MyBaseAdapter extends BaseAdapter {
    private Context context;
    private List<StudentBean.ListdataBean> listdata;

    public MyBaseAdapter(Context context, List<StudentBean.ListdataBean> listdata) {
        this.context = context;
        this.listdata = listdata;
    }

    @Override
    public int getCount() {
        return listdata.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item, null);
            holder.iv = convertView.findViewById(R.id.iv);
            holder.name = convertView.findViewById(R.id.name);
            holder.shi = convertView.findViewById(R.id.shi);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final ViewHolder finalHolder = holder;
        NetUtil.getInstance().doPhoto(listdata.get(position).getAvatar(), new NetUtil.Shared() {
            @Override
            public void doGetSuccess(String json) {

            }

            @Override
            public void doGetFiled(String error) {

            }

            @Override
            public void doPhotoSuccess(Bitmap json) {
                finalHolder.iv.setImageBitmap(json);
            }

            @Override
            public void doPhotoFiled(String error) {

            }
        });

        holder.name.setText(listdata.get(position).getName() + "");
        holder.shi.setText(listdata.get(position).getInfo() + "");
        return convertView;
    }

    class ViewHolder {
        ImageView iv;
        TextView name, shi;
    }
}
