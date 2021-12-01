package com.example.lab2.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.lab2.Config;
import com.example.lab2.Model.Student;
import com.example.lab2.R;
import com.google.gson.Gson;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private ArrayList<Student> localDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView studentname;
        TextView studentscore;
        TextView student_id;
        Button btn_view;

        public ViewHolder(View view) {// Define click listener for the ViewHolder's View
            super(view);
            studentname = (TextView) view.findViewById(R.id.studentname);
            studentscore = (TextView) view.findViewById(R.id.studentscore);
            student_id = (TextView) view.findViewById(R.id.student_id);
            btn_view = view.findViewById(R.id.btn_view);
        }
    }


    public StudentAdapter(ArrayList<Student> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_student, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Student current = localDataSet.get(position);
        viewHolder.studentname.setText(current.getStudentName());
        viewHolder.studentscore.setText(current.getFinalScore());
        viewHolder.student_id.setText(current.getStudentId());

        viewHolder.btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentSId = current.getStudentId();
                Context mContext = viewHolder.itemView.getContext();

                Uri uri = Uri.parse(Config.PROVIDER_URI + Config.STUDENT_DETAIL+"/"+currentSId);
                Cursor cursor = mContext.getContentResolver().query(uri, null, null, null, null);
                if (cursor != null) {
                    if (cursor.moveToFirst()) {
//                        String sId = cursor.getString(cursor.getColumnIndex("studentId"));
                        String sData = cursor.getString(cursor.getColumnIndex("data"));
                        Toast.makeText(viewHolder.itemView.getContext(), sData, Toast.LENGTH_LONG).show();
                    }
                    cursor.close();

                } else {
                    //Alert result not found
                }


            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

}