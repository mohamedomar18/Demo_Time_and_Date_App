package sg.edu.rp.c346.id20048218.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    TextView tvDisplay;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnDisplayDate = findViewById(R.id.buttonDisplayDate);
        btnDisplayTime = findViewById(R.id.buttonDisplayTime);
        tvDisplay = findViewById(R.id.textViewDisplay);
        btnReset = findViewById(R.id.btnReset);

        tp.setIs24HourView(true);

        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumberFormat nF = new DecimalFormat("00");
                String current_hour = (nF.format(tp.getCurrentHour()));
                String current_minute = (nF.format(tp.getCurrentMinute()));
                String current_time = "Time is " + current_hour + ":" + current_minute;
                tvDisplay.setText(current_time);
            }
        });

        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int current_day = dp.getDayOfMonth();
                int current_month = dp.getMonth() + 1;
                int current_year = dp.getYear();
                String current_date = "Date is " + current_day + "/" + current_month + "/" + current_year;
                tvDisplay.setText(current_date);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dp.updateDate(2020,0,1);
                tp.setCurrentHour(12);
                tp.setCurrentMinute(00);
                tvDisplay.setText("Time/Date will be displayed here");
            }
        });
    }
}