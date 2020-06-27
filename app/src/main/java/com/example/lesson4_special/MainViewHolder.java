package com.example.lesson4_special;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MainViewHolder extends RecyclerView.ViewHolder {

    TextView modelTV;
    TextView groupTV;
    TextView nameTV;
    TextView yearTV;

    public ICarListener listener;

    Student student;

    public MainViewHolder(@NonNull final View itemView) {
        super(itemView);
        modelTV = itemView.findViewById(R.id.tv_vh_surname);
        groupTV = itemView.findViewById(R.id.tv_vh_group);
        nameTV = itemView.findViewById(R.id.tv_vh_name);
        yearTV = itemView.findViewById(R.id.tv_vh_year);



  

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onCarClick(student);
                return true;
            }
        });

    }

    public void onBind(Student student) {
        this.student = student;
        modelTV.setText(student.surname);
        nameTV.setText(student.name);
        groupTV.setText(student.group);
        @SuppressLint("SimpleDateFormat") DateFormat date =  new SimpleDateFormat("yyyy.MM.dd");

        yearTV.setText(date.format(student.year));
    }
}
