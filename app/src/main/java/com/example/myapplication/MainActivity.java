package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tencent.bugly.crashreport.CrashReport;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnContent;
    private Button mBtnNull;
    private Button mBtnCalss;
    private TextView mTvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtnContent = (Button) findViewById(R.id.btn_content);
        mBtnNull = (Button) findViewById(R.id.btn_null);
        mBtnCalss = (Button) findViewById(R.id.btn_calss);

        mBtnContent.setOnClickListener(this);
        mBtnNull.setOnClickListener(this);
        mBtnCalss.setOnClickListener(this);
        mTvContent = (TextView) findViewById(R.id.tv_content);
        mTvContent.setOnClickListener(this);
    }

    ArrayList<String> mNull;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_content:
                CrashReport.testJavaCrash();
                break;
            case R.id.btn_null:
                mTvContent.setText(mNull.size());
                break;
            case R.id.btn_calss:
                String name = "name";
                int number = Integer.valueOf(name);
                mTvContent.setText(String.valueOf(number));
                break;
        }
    }
}
