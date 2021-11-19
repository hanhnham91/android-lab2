package com.example.lab2.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import com.example.lab2.Model.Student;
import com.example.lab2.R;
import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private ArrayList<Student> localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView studentname;
        TextView studentscore;
        TextView student_id;
        Button btn_view;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            studentname = (TextView) view.findViewById(R.id.studentname);
            studentscore = (TextView) view.findViewById(R.id.studentscore);
            student_id = (TextView) view.findViewById(R.id.student_id);
            btn_view = view.findViewById(R.id.btn_view);
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public StudentAdapter(ArrayList<Student> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_student, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Student current = localDataSet.get(position);
        viewHolder.studentname.setText(current.getStudentName());
        viewHolder.studentscore.setText(current.getStudentScore());
        viewHolder.student_id.setText(current.getStudentId());

        viewHolder.btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(viewHolder.itemView.getContext(),"StudentId " +current.getStudentId()+" clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }


}