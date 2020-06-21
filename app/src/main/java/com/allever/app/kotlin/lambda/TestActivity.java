package com.allever.app.kotlin.lambda;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        new Thread(() -> {
            System.out.println("");
            int i = 0;
        }).start();

        new Thread() {

        }.start();


        Lamda lamda = new Lamda();
        lamda.setOnClickListener(() -> System.out.println("hello"));

        lamda.setOnLongClickListener((View view) -> {
            view.getMeasuredHeight();
            System.out.println("hello");
        });

        lamda.setOnItemClickListener((v, position) -> {
            v.getId();
            System.out.println("hello");
        });
    }
}
