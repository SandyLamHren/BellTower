package com.hh.belltower.adapter.base;

import android.content.Context;
import android.view.LayoutInflater;

import java.util.List;

/**
 * Base RecyclerView adapter
 * Created by zhy on 16/4/9.
 */
public abstract class RecyclerAdapter<T> extends MultiItemTypeAdapter<T> {

    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    public RecyclerAdapter(Context context, int layoutId, List<T> datas) {
        super(context, datas);
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;

        addItemViewDelegate(new ItemViewDelegate<T>() {
            @Override
            public int getItemViewLayoutId()
            {
                return layoutId;
            }

            @Override
            public boolean isForViewType( T item, int position)
            {
                return true;
            }

            @Override
            public void convert(ViewHolder holder, T t, int position) {
                RecyclerAdapter.this.convert(holder, t, position);
            }
        });
    }

    protected abstract void convert(ViewHolder holder, T t, int position);

}
