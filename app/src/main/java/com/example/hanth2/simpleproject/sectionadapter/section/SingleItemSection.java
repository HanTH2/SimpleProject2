package com.example.hanth2.simpleproject.sectionadapter.section;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

/**
 * Created by HanTH2 on 8/5/2016.
 */
public class SingleItemSection extends Section {

    public SingleItemSection(Context context, int viewType) {
        super(context, viewType);
    }

    @Override
    public int itemCount() {
        return isEnabled()? 1 : 0;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int sectionPosition) {
        // not need
    }
}
