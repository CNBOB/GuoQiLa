package com.namilili.guoqila;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.Toast;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class AddItemActivity extends AppCompatActivity{

//    private SurfaceView svItemAddImage;
    private static Context context = null;
 //   private SurfaceHolder surfaceholder;
 //   private Camera camera = null;
//    private DatePicker myExpDatePicker;
    private Calendar calendar;
    private AutoCompleteTextView myExpDate;
    private AutoCompleteTextView myItemConent;

    private int year;
    private int month;
    private int day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        context = this;

        // 获取日历对象
        calendar = Calendar.getInstance();
        // 获取当前对应的年、月、日的信息
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        myExpDate = (AutoCompleteTextView) findViewById(R.id.tvExpDate);
        myItemConent = (AutoCompleteTextView) findViewById(R.id.itemContent);
        myExpDate.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    // 初始化DatePickerDialog
                    new DatePickerDialog(AddItemActivity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            myExpDate.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                            month = monthOfYear;
                            day = dayOfMonth;
                            myItemConent.requestFocus();
                        }
                    }, year, month, day).show();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public boolean onSupportNavigateUp() {
        Toast.makeText(this,"test",Toast.LENGTH_LONG).show();
//        finish();
//        return super.onSupportNavigateUp();
        return true;
    }
}
