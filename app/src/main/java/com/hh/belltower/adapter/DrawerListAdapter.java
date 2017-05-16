package com.hh.belltower.adapter;

import android.content.Context;

import com.hh.belltower.adapter.base.RecyclerAdapter;
import com.hh.belltower.adapter.base.ViewHolder;
import com.hh.belltower.bean.DrawItemBean;

import java.util.List;


/**
 * Created by Hh on 2017/3/21.
 */

public class DrawerListAdapter extends RecyclerAdapter<DrawItemBean> {

    public DrawerListAdapter(Context context, int layoutId, List<DrawItemBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, DrawItemBean drawItemBean, int position) {

    }
}
