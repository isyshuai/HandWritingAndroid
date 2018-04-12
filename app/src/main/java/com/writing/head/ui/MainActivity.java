package com.writing.head.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.writing.head.R;
import com.writing.head.view.HandWriteView;

import java.io.File;
import java.io.IOException;

/**
 * Author: Create by YuanShuai
 * <p>
 * Create_date: 2018/4/11 17:21
 * <p>
 * Function_description: 手写签名
 */
public class MainActivity extends AppCompatActivity {
    HandWriteView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        view = findViewById(R.id.view);
        view.setPaintColor(Color.parseColor("#B4A078"));

            findViewById(R.id.result).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view2) {
                    if (view.isSign())
                        try {
                            view.save(StartActivity.path);
                            setResult(100);
                            finish();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                }
            });
            findViewById(R.id.eliminate).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view2) {
                    view.clear();
                }
            });
    }
}
