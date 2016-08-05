package com.example.hanth2.simpleproject.section;

import android.content.Context;

import java.util.List;

/**
 * Created by HanTH2 on 8/5/2016.
 */
public class ManyItemSection<TItem> extends Section {

    protected List<TItem> mItems;

    public ManyItemSection(Context context, int viewType) {
        super(context, viewType);
    }

    public ManyItemSection(Context context, int viewType, List<TItem> items) {
        super(context, viewType);
        mItems = items;
    }

    @Override
    public int itemCount() {
        return isNotEmpty(mItems) ? mItems.size() : 0;
    }

    public void setItems(List items){
        if (isNotEmpty(items)){
            mItems.clear();
            mItems = null;
        }
        mItems = items;
    }

    @Override
    public int positionOf(Object object) {
        int size = mItems.size();
        for (int i = 0; i < size; i++){
            if (mItems.get(i).equals(object)){
                return i;
            }
        }
        return super.positionOf(object);
    }
}
