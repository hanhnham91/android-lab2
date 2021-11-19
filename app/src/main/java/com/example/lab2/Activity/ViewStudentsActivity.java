package com.example.lab2.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.example.lab2.R;
import com.example.lab2.Model.Student;
import com.example.lab2.Adapter.StudentAdapter;

import java.util.ArrayList;

public class ViewStudentsActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewStudentList;
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
        students.add(new Student("001","VAN ANH", "8.4"));
        students.add(new Student("002","BANG LANG", "5.6"));
        students.add(new Student("003","ANH TUAN", "6.9"));
        students.add(new Student("004","DOAN XUAN", "7.4"));
        students.add(new Student("005","HOAI AN", "9.6"));
        students.add(new Student("006","LAM PHONG", "4.9"));
        return students;
    }
}