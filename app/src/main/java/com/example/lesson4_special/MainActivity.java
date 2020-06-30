package com.example.lesson4_special;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements ICarListener {
    Student student;
    MainAdapter mainAdapter;

    private static final int ADD_ACTIVITY = 476;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        mainAdapter = new MainAdapter();
        mainAdapter.listener = this;

        recyclerView.setAdapter(mainAdapter);


    }

    public void onAddElement(View view) {
        Intent intent = new Intent(this, AddActivity.class);
        startActivityForResult(intent, ADD_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            if (requestCode == ADD_ACTIVITY) {
                student = (Student) data.getSerializableExtra("student");
                assert student != null;
                Log.e("TAG", "onActivityResult: " + student.name + " " + student.group);
                mainAdapter.addElement(student);

            } else if (requestCode == 101) {
                student = (Student) data.getSerializableExtra("student");
                assert student != null;
                Log.e("TAG", "onActivityResult: " + student.name + " " + student.group);
                //noinspection ResultOfMethodCallIgnored
                mainAdapter.setElement(student);
            }
        }

    }

    @Override
    public void onCarClick(Student student) {
        Intent intent = new Intent(this, AddActivity.class);
        intent.putExtra("student", student);
        startActivityForResult(intent, 101);
    }
}