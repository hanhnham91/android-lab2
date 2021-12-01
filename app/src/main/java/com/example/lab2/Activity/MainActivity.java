package com.example.lab2.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.lab2.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addActivity(View view) {
        Intent intent = new Intent(this, AddStudentActivity.class);
        startActivity(intent);
    }

    public void viewActivity(View view) {
        Intent intent = new Intent(this, ViewStudentsActivity.class);
        startActivity(intent);
    }
}