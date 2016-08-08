package com.example.hanth2.simpleproject.activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.hanth2.simpleproject.R;
import com.example.hanth2.simpleproject.activity.SectionListActivity;
import com.example.hanth2.simpleproject.activity.SimpleListActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.simple_list_button)
    void onSimpleListButtonClick() {
        Intent intent = new Intent(this, SimpleListActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.section_list_button)
    void onSectionListButtonClick() {
        Intent intent = new Intent(this, SectionListActivity.class);
        startActivity(intent);
    }
}
