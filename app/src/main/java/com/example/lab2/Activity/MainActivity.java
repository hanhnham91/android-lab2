package com.example.lab2.Activity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.lab2.R;

public class MainActivity extends AppCompatActivity {



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