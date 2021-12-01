package com.example.lab2.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.example.lab2.Config;
import com.example.lab2.R;
import com.example.lab2.Model.Student;
import com.example.lab2.Adapter.StudentAdapter;

import java.util.ArrayList;

public class ViewStudentsActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewStudentList;

    private static final String TAG = ViewStudentsActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("View All Students");
        setContentView(R.layout.activity_view_students);
        recyclerViewStudentList();

    }

    private void recyclerViewStudentList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewStudentList = findViewById(R.id.recyclerView);
        recyclerViewStudentList.setLayoutManager(linearLayoutManager);

        adapter = new StudentAdapter(getListStudent());
        recyclerViewStudentList.setAdapter(adapter);
    }

    private ArrayList<Student> getListStudent(){
        ArrayList<Student> students = new ArrayList<>();

        Uri uri = Uri.parse(Config.PROVIDER_URI + Config.STUDENTS_TABLE);
        Cursor cursor = getApplicationContext().getContentResolver().query(uri, null, null, null, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    String sId = cursor.getString(cursor.getColumnIndex("studentId")).toString();
                    String sName = cursor.getString(cursor.getColumnIndex("name")).toString();
                    String sGender = cursor.getString(cursor.getColumnIndex("gender")).toString();
                    String sEmail = cursor.getString(cursor.getColumnIndex("email")).toString();
                    String sTel = cursor.getString(cursor.getColumnIndex("tel")).toString();
                    String sDob = cursor.getString(cursor.getColumnIndex("dob")).toString();
                    float sScore = cursor.getFloat(cursor.getColumnIndex("finalScore"));

                    students.add(new Student(sId,sName,sGender,sEmail,sTel,sDob,sScore));
                } while (cursor.moveToNext());
            }
            cursor.close();
        } else {
//            Log.e (TAG, "onBindViewHolder: Cursor is null.");
        }
        return students;
    }
}