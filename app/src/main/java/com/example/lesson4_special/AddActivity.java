package com.example.lesson4_special;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddActivity extends AppCompatActivity implements ICarListener {
    String name;
    String group;
    String surname;
    Date year;
    EditText nameEt, surnameET, groupET;
    TextView dateTV;
    Button save, chooseDate;
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initView();
        initTextChanged();
        onClick();
        getIntentData();

    }

    private void getIntentData() {
        Intent intentGet = getIntent();
        if (intentGet != null) {
            Student student = (Student) intentGet.getSerializableExtra("student");
            if (student != null) {
                nameEt.setText(student.name);
                surnameET.setText(student.surname);
                groupET.setText(student.group);
                @SuppressLint("SimpleDateFormat") DateFormat date = new SimpleDateFormat("YYYY.MM.dd");
                dateTV.setText(date.format(student.year));
            }
        }
    }

    private void onClick() {
        chooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                dateTV.setText(dayOfMonth + "." + (month + 1) + "." + year);
                                AddActivity.this.year = new Date(year, month, dayOfMonth);
                            }
                        }, year, month, day);

                dialog.show();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("TAG", "onClick: " + name + " " + group);
                student = new Student();
                student.name = name;
                student.year = year;
                student.group = group;
                student.surname = surname;
                Intent intent = getIntent();
                intent.putExtra("student", student);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void initTextChanged() {
        nameEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                AddActivity.this.name = s.toString();
            }
        });

        surnameET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                surname = s.toString();
            }
        });
        groupET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                group = s.toString();
            }
        });
    }

    private void initView() {
        chooseDate = findViewById(R.id.btn_add_year);
        save = findViewById(R.id.btn_add_save);
        nameEt = findViewById(R.id.et_name);
        surnameET = findViewById(R.id.et_surname);
        groupET = findViewById(R.id.et_group);
        dateTV = findViewById(R.id.tv_add_year);
    }


    @Override
    public void onCarClick(Student student) {

    }
}