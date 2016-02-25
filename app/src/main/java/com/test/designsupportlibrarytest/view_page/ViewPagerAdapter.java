package com.test.designsupportlibrarytest.view_page;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private static final int PAGE_FIRST = 0;
    private static final int PAGE_SECOND = 1;
    private static final int PAGE_THIRD = 2;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) { // 표시할 Fragment
        switch (position) {
            case PAGE_FIRST:
                return FirstFragment.newInstance(); // 빨
            case PAGE_SECOND:
                return SecondFragment.newInstance(); // 초
            case PAGE_THIRD:
                return ThirdFragment.newInstance(); // 파
            default:
                return null;
        }
    }

    @Override
    public int getCount() { // Tab 의 갯수
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "탭 " + position; // 페이지(position)에 따른 tab 의 타이틀 지정
    }
}