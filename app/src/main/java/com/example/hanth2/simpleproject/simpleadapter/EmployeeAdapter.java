package com.example.hanth2.simpleproject.simpleadapter;

import android.content.Context;
import android.view.View;

import com.example.hanth2.simpleproject.R;
import com.example.hanth2.simpleproject.model.EmployeeModel;

/**
 * Created by HanTH2 on 8/5/2016.
 */
public class EmployeeAdapter extends BaseSimpleAdapter<EmployeeModel, EmployeeViewHolder> {

    public EmployeeAdapter(Context context) {
        super(context);
    }

    @Override
    public EmployeeViewHolder createHolder(View view) {
        return new EmployeeViewHolder(view);
    }

    @Override
    public int getItemLayoutResource() {
        return R.layout.employee_item;
    }
}
