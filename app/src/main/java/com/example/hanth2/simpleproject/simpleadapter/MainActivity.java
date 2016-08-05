package com.example.hanth2.simpleproject.simpleadapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hanth2.simpleproject.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.simple_list_button)
    void onSimpleListButtonClick() {
        Intent intent = new Intent(this, SimpleListActivity.class);
        startActivity(intent);
    }
}
