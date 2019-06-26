package com.ssb.app0626;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateTimeActivity extends AppCompatActivity {
    TextView display;
    Button datebtn, timebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        display = (TextView)findViewById(R.id.datetimedisplay);
        datebtn =(Button)findViewById(R.id.datebtn);
        timebtn =(Button)findViewById(R.id.timebtn);

        //현재 날짜 및 시간
        Calendar today = new GregorianCalendar();

        datebtn.setOnClickListener((view)->{
            DatePickerDialog dpd = new DatePickerDialog(DateTimeActivity.this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                            display.setText(i+"-"+(i1+1)+"-"+i2);
                            //위 3개의 데이터를 가지고 java.sql.Date 나
                            //java.util.Date 객체 만들기
                            Calendar cal = new GregorianCalendar(i,i1,i2);
                            java.sql.Date date = new java.sql.Date(cal.getTimeInMillis());
                            Log.e("date",date.toString());
                        }
                    },
                    today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH));
            dpd.show();
        });

        timebtn.setOnClickListener((view)->{
            new TimePickerDialog(DateTimeActivity.this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int i, int i1) {
                    display.setText(i+":"+i1);
                }
                }, today.get(Calendar.HOUR), today.get(Calendar.MINUTE),false).show();

        });

    }
}
