package com.example.lesson4_special;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    ArrayList<Student> data = new ArrayList<>();

    private final int number = 0;
    public ICarListener listener;


    public void addElement(Student student) {
        data.add(number, student);
        notifyDataSetChanged();

    }

    public void setElement(Student student) {
        data.set(number, student);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_holder_main, parent, false);

        MainViewHolder holder = new MainViewHolder(view);
        holder.listener = listener;

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.onBind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
