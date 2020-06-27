package com.example.lesson4_special;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements ICarListener {

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
        startActivityForResult(intent,ADD_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_ACTIVITY && resultCode == RESULT_OK) {
            assert data != null;
            Student student = (Student) data.getSerializableExtra("car");
            assert student != null;
            mainAdapter.addElement(student);
        }
    }

    @Override
    public void onCarClick(Student student) {
        Intent intent = new Intent(this, AddActivity.class);
        intent.putExtra("car", student);
        startActivity(intent);
    }
}