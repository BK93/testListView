package com.test.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.test.myapplication.multipleCustomLayout.MultipleCustomLayoutActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        leapYear();

        startActivity(MultipleCustomLayoutActivity.createIntent(this));
        finish();
    }

//    public static void leapYear() {
//        LocalDate localDate = new LocalDate();
////        int year = localDate.getYear();
//        int year = 2015;
//
//        Log.e("this year", "--> " + year);
//        boolean isLeapYear = false;
//
//        if ((0 == (year % 4) &&
//                0 != (year % 100)) ||
//                0 == year % 400) {
//            isLeapYear = true;
//        } else {
//            isLeapYear = false;
//        }
//
//        if (isLeapYear) {
//            Log.e("test-->", "윤년");
//        } else {
//            Log.e("test-->", "윤년아님");
//        }
//    }
}
