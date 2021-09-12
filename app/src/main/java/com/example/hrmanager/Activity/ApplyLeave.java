package com.example.hrmanager.Activity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hrmanager.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ApplyLeave extends AppCompatActivity {

    ImageView back;
    DatePicker picker;
    EditText leave_from,leave_to,time_from,time_to;
    Calendar myCalendar = Calendar.getInstance();

    private static final String[] paths = {"Sick Leave", "Compensatory Leave", "Earned Leave"};
    private static final String[] paths1 = {"Half Day Leave", "Full Day Leave"};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apply_leave);

        findViews();
    }
    @SuppressLint("SimpleDateFormat")
    private void updateStartTime() {
        String myFormat = "dd/MMM/yyyy"; //In which you need put here
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat(myFormat);

        leave_from.setText(sdf.format(myCalendar.getTime()));
    }
    @SuppressLint("SimpleDateFormat")
    private void updateEndTime() {
        String myFormat = "dd/MMM/yyyy"; //In which you need put here
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat(myFormat);

        leave_to.setText(sdf.format(myCalendar.getTime()));
    }
    private void showTimePicker(){
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                if(selectedHour<10 && selectedMinute==0)
                {
                    time_from.setText("0"+selectedHour+":"+selectedMinute+"0");
                }
                else if (selectedHour<10)
                {
                    time_from.setText("0"+selectedHour+":"+selectedMinute);

                }
                else if (selectedMinute==0)
                {
                    time_from.setText(selectedHour+":"+selectedMinute+"0");

                }
                else {
                    time_from.setText(selectedHour + ":" + selectedMinute);
                }
            }
        }, hour, minute, false);
        timePickerDialog.show();
    }
    private void showTimePicker1(){
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {

            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                if(selectedHour<10 && selectedMinute==0)
                {
                    time_to.setText("0"+selectedHour+":"+selectedMinute+"0");
                }
                else if (selectedHour<10)
                {
                    time_to.setText("0"+selectedHour+":"+selectedMinute);

                }
                else if (selectedMinute==0)
                {
                    time_to.setText(selectedHour+":"+selectedMinute+"0");

                }
                else {
                    time_to.setText(selectedHour + ":" + selectedMinute);
                }
            }
        }, hour, minute, false);
        timePickerDialog.show();
    }

    private void findViews() {
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        leave_from = findViewById(R.id.leave_from);
        leave_to = findViewById(R.id.leave_to);
        time_to = findViewById(R.id.time_to);
        time_from = findViewById(R.id.time_from);
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateStartTime();
            }

        };
        time_from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePicker();
            }
        });
        time_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePicker1();
            }
        });
        DatePickerDialog.OnDateSetListener date1 = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateEndTime();
            }

        };
        leave_from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(getApplicationContext(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        leave_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(getApplicationContext(), date1, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        Spinner spinner = (Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.BLACK);
                ((TextView) adapterView.getChildAt(0)).setTextSize(16);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Spinner spinner1 = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<String>adapters = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,paths1);

        adapters.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapters);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.BLACK);
                ((TextView) adapterView.getChildAt(0)).setTextSize(16);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
