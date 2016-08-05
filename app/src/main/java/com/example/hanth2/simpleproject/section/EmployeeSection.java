package com.example.hanth2.simpleproject.section;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hanth2.simpleproject.R;
import com.example.hanth2.simpleproject.model.EmployeeModel;
import com.example.hanth2.simpleproject.simpleadapter.EmployeeViewHolder;

import java.util.List;

/**
 * Created by HanTH2 on 8/5/2016.
 */
public class EmployeeSection extends ManyItemSection<EmployeeModel> {

    public EmployeeSection(Context context, int viewType, List<EmployeeModel> employeeModels) {
        super(context, viewType, employeeModels);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.employee_item, parent, false);
        EmployeeViewHolder holder = new EmployeeViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int sectionPosition) {
        ((EmployeeViewHolder)holder).bind(mItems.get(sectionPosition));
    }
}
