package com.example.hanth2.simpleproject.simpleadapter.viewholder;

import android.view.View;
import android.widget.TextView;

import com.example.hanth2.simpleproject.R;
import com.example.hanth2.simpleproject.base.adapter.BaseSimpleViewHolder;
import com.example.hanth2.simpleproject.model.EmployeeModel;

/**
 * Created by HanTH2 on 8/5/2016.
 */
public class EmployeeViewHolder extends BaseSimpleViewHolder<EmployeeModel> {
    TextView mNameTv;
    TextView mJobTv;

    public EmployeeViewHolder(View itemView) {
        super(itemView);
        mNameTv = (TextView) itemView.findViewById(R.id.name);
        mJobTv = (TextView) itemView.findViewById(R.id.job);
    }

    @Override
    public void bind(EmployeeModel employeeModel) {
        mNameTv.setText(employeeModel.name);
        mJobTv.setText(employeeModel.job);
     }
}
