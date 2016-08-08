package com.example.hanth2.simpleproject.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hanth2.simpleproject.R;
import com.example.hanth2.simpleproject.sectionadapter.SampleSectionAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HanTH2 on 8/5/2016.
 */
public class SectionListActivity extends AppCompatActivity {

    @BindView(R.id.simple_list_recycler_view)
    RecyclerView mSimpleRecyclerView;

    private SampleSectionAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);
        ButterKnife.bind(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mSimpleRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new SampleSectionAdapter(getApplicationContext());
        mSimpleRecyclerView.setAdapter(mAdapter);
    }

}
