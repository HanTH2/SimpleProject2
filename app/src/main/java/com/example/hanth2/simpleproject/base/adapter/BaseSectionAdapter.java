package com.example.hanth2.simpleproject.base.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.hanth2.simpleproject.section.Section;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HanTH2 on 8/5/2016.
 */
public abstract class BaseSectionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected Context mContext;
    protected List<Section> mSections;

    public BaseSectionAdapter(Context context){
        mContext = context;
        mSections = new ArrayList<>();
    }

    public Section getSectionByType(int type){
        for (Section section : mSections){
            if (section.viewType() == type){
                return section;
            }
        }
        return null;
    }

    public int getSectionPosByType(int type) {
        int pos = 0;
        for (Section section : mSections) {
            if (section.viewType() == type) {
                return pos;
            }
            pos++;
        }
        return pos;
    }

    public void addSection(Section section) {
        mSections.add(section);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        int sectionPosition = position;
        for (Section section : mSections) {
            if (sectionPosition < section.itemCount()) {
                return section.viewType();
            }
            sectionPosition -= section.itemCount();
        }
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        for (Section section : mSections) {
            if (section.viewType() == viewType) {
                return section.onCreateViewHolder(parent);
            }
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int sectionPosition = position;
        for (Section section : mSections) {
            if (sectionPosition < section.itemCount()) {
                section.onBindViewHolder(holder, sectionPosition);
                return;
            }
            sectionPosition -= section.itemCount();
        }
    }

    @Override
    public int getItemCount() {
        int count = 0;
        for (Section section : mSections) {
            count += section.itemCount();
        }
        return count;
    }
}
