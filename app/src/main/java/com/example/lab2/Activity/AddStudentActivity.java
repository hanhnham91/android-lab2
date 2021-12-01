package com.example.lab2.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;
import com.example.lab2.R;

public class AddStudentActivity extends AppCompatActivity {
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Add New Student");
        setContentView(R.layout.activity_add_student);

        this.mContext = getApplicationContext();
    }

    public void addNew(View view) {
        String studentName = ((EditText)findViewById(R.id.editTextName)).getText().toString();
        String studentGender = ((EditText)findViewById(R.id.editTextGender)).getText().toString();
        String studentEmail = ((EditText)findViewById(R.id.editTextemail)).getText().toString();
        String studentTel = ((EditText)findViewById(R.id.editTextTel)).getText().toString();
        String studentDob = ((EditText)findViewById(R.id.editTextDob)).getText().toString();
        String studentScore = ((EditText)findViewById(R.id.editScore)).getText().toString();


        ContentValues contentValues = new ContentValues();
        contentValues.put("name", studentName);
        contentValues.put("gender", studentGender);
        contentValues.put("email", studentEmail);
        contentValues.put("tel", studentTel);
        contentValues.put("dob", studentDob);
        contentValues.put("finalScore", studentScore);

        Uri insertUri =  mContext.getContentResolver().insert(Uri.parse("content://com.example.lab4.provider/student"), contentValues);

        if (insertUri != null) {
            Toast.makeText(mContext, "Student: "+studentName+" is added!", Toast.LENGTH_SHORT).show();
            super.finish();// close this activity
        } else {
            Toast.makeText(mContext, "Add failed!", Toast.LENGTH_SHORT).show();
        }
    }
}