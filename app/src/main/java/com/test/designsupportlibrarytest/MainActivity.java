package com.test.designsupportlibrarytest;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.test.designsupportlibrarytest.view_page.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toast.makeText(this, "Toast 입니다", Toast.LENGTH_LONG).show();
//
//        View parentView = findViewById(R.id.tab_layout);
//        Snackbar.make(parentView, "test", Snackbar.LENGTH_LONG).show();

//        // add tab
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
//        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//        tabLayout.addTab(tabLayout.newTab());
//        tabLayout.addTab(tabLayout.newTab());
//        tabLayout.addTab(tabLayout.newTab());

        // set viewPager
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
//
        // set viewPager of tabLayout
        tabLayout.setupWithViewPager(viewPager);

//        // numberPickerTest
//        Button button = (Button) findViewById(R.id.number_picker);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(NumberPickerActivity.createIntent(MainActivity.this));
//                finish();
//            }
//        });
    }
}
