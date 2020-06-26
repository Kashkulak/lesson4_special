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
    TextView bodyTV;
    TextView colorTV;
    TextView yearTV;

    public ICarListener listener;

    Car car;

    public MainViewHolder(@NonNull final View itemView) {
        super(itemView);
        modelTV = itemView.findViewById(R.id.tv_vh_model);
        bodyTV = itemView.findViewById(R.id.tv_vh_body);
        colorTV = itemView.findViewById(R.id.tv_vh_color);
        yearTV = itemView.findViewById(R.id.tv_vh_year);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCarClick(car);
            }
        });

    }

    public void onBind(Car car) {
        this.car = car;
        modelTV.setText(car.model);
        colorTV.setText(car.color);
        bodyTV.setText(car.body);
        @SuppressLint("SimpleDateFormat") DateFormat date =  new SimpleDateFormat("yyyy.MM.dd");

        yearTV.setText(date.format(car.year));
    }
}
