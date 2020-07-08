package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Bai4Activity extends AppCompatActivity implements View.OnClickListener {
    private Button btnRun;
    private EditText edtTime;
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        setTitle("Bài 4");
        btnRun = (Button) findViewById(R.id.btnRun);
        edtTime = (EditText) findViewById(R.id.edtTime);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnRun.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRun:
                AsyncTaskRunner asyncTaskRunner = new AsyncTaskRunner(this, tvResult,edtTime);
                String sleepTime = edtTime.getText().toString();
                asyncTaskRunner.execute(sleepTime);
                break;
        }
    }
}