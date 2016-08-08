package com.example.hanth2.simpleproject.sectionadapter;

import android.content.Context;

import com.example.hanth2.simpleproject.base.adapter.BaseSectionAdapter;
import com.example.hanth2.simpleproject.model.EmployeeModel;
import com.example.hanth2.simpleproject.sectionadapter.section.EmployeeSection;
import com.example.hanth2.simpleproject.sectionadapter.section.LoadingSection;
import com.example.hanth2.simpleproject.sectionadapter.section.SampleTitleSection;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HanTH2 on 8/5/2016.
 */
public class SampleSectionAdapter extends BaseSectionAdapter {
    final int TITLE_TYPE = 1;
    final int EMPLOYEE_TYPE = 2;
    final int LOADING_TYPE = 3;

    public SampleSectionAdapter(Context context){
        super(context);

        try {
            InputStream is = mContext.getAssets().open("simple_list_data.json");
            Type typeList = new TypeToken<ArrayList<EmployeeModel>>(){}.getType();
            StringWriter writer = new StringWriter();
            IOUtils.copy(is, writer, "UTF-8");
            String jsonArrayStr = writer.toString();
            List<EmployeeModel> employeeModels = new Gson().fromJson(jsonArrayStr, typeList);

            SampleTitleSection sampleTitleSection = new SampleTitleSection(mContext, TITLE_TYPE);
            EmployeeSection employeeSection = new EmployeeSection(mContext, EMPLOYEE_TYPE, employeeModels);
            LoadingSection loadingSection = new LoadingSection(mContext, LOADING_TYPE);

            addSection(sampleTitleSection);
            addSection(employeeSection);
            addSection(loadingSection);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
