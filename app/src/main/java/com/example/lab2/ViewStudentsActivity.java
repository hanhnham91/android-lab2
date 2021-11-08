package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ViewStudentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("View All Students");
        setContentView(R.layout.activity_view_students);
    }
}