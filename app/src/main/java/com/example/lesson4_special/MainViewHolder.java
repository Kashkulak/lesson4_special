package com.example.lesson4_special;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MainViewHolder extends RecyclerView.ViewHolder {

    TextView surnameTV;
    TextView groupTV;
    TextView nameTV;
    TextView yearTV;

    public ICarListener listener;

    Student student;

    public MainViewHolder(@NonNull final View itemView) {
        super(itemView);
        surnameTV = itemView.findViewById(R.id.tv_vh_surname);
        groupTV = itemView.findViewById(R.id.tv_vh_group);
        nameTV = itemView.findViewById(R.id.tv_vh_name);
        yearTV = itemView.findViewById(R.id.tv_vh_year);


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCarClick(student);
            }
        });
    }

    public void onBind(Student student) {
        this.student = student;
        surnameTV.setText(student.surname);
        nameTV.setText(student.name);
        groupTV.setText(student.group);
        @SuppressLint("SimpleDateFormat") DateFormat date = new SimpleDateFormat("YYYY.MM.dd");
        yearTV.setText(date.format(student.year));
    }
}
