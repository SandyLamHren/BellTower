package com.hh.belltower.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.haoren.belltower.R;
import com.hh.belltower.adapter.base.RecyclerAdapter;
import com.hh.belltower.adapter.base.ViewHolder;
import com.hh.belltower.bean.NewsBean;
import com.hh.belltower.constants.Constants;
import com.hh.belltower.retrofit.base.API;
import com.hh.belltower.ui.activity.NewsDetailActivity;

import java.util.List;

/**
 * Created by Hh on 2017/5/22.
 */

public class NewsAdapter extends RecyclerAdapter<NewsBean> {


    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL = 1;

    private Context mContext;

    public NewsAdapter(Context context, int layoutId, List<NewsBean> datas) {
        super(context, layoutId, datas);
        this.mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return TYPE_HEADER;
            default:
                return TYPE_CELL;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_HEADER) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item_card_big, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item_card_small, parent, false);
        }
        return ViewHolder.createViewHolder(mContext, view);
    }


    @Override
    protected void convert(ViewHolder holder, NewsBean newsBean, int position) {

        holder.setText(R.id.item_title, newsBean.getTitle());

        Glide.with(mContext).load(API.BASE_URL + newsBean.getImg()).
                into((ImageView) holder.getView(R.id.item_img));

        if (position == 0) {
            holder.setText(R.id.item_content, newsBean.getContent());
        }

        holder.setOnClickListener(R.id.item_root, v -> {
            Intent intent = new Intent(mContext, NewsDetailActivity.class);
            intent.putExtra(Constants.KEY_NEWS, newsBean);
            mContext.startActivity(intent);
        });

    }
}
