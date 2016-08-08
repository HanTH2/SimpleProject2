package com.example.hanth2.simpleproject.base.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by HanTH2 on 8/5/2016.
 */
public abstract class BaseSimpleViewHolder<TItem> extends RecyclerView.ViewHolder {

    protected Context context;

    public BaseSimpleViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(itemView);
    }

    public void bind(TItem item){
        throw new UnsupportedOperationException("You must override this method: " + this.getClass().toString());
    }
}
