package com.example.hanth2.simpleproject.section;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hanth2.simpleproject.R;
import com.example.hanth2.simpleproject.simpleadapter.EmployeeViewHolder;

/**
 * Created by HanTH2 on 8/5/2016.
 */
public class LoadingSection extends SingleItemSection {

    public LoadingSection(Context context, int viewType) {
        super(context, viewType);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.loading_view, parent, false);
        return new EmployeeViewHolder(view);
    }
}
