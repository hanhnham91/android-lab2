package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;

public class AddStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Add New Student");
        setContentView(R.layout.activity_add_student);
    }

    public void addNew(View view) {
        EditText editTextName = (EditText) findViewById(R.id.editTextName);
        String studentName = editTextName.getText().toString();
        EditText editTextScore = (EditText) findViewById(R.id.editTextScore);
        String studentScore = editTextScore.getText().toString();

        Context context = getApplicationContext();
        CharSequence text = "Student: "+studentName+" is added!";
        int duration = Toast.LENGTH_LONG;
        Toast.makeText(context, text, duration).show();

        super.finish();
    }
}