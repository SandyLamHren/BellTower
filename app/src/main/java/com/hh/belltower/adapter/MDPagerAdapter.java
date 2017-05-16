package com.hh.belltower.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * 主页 vp adapter
 * Created by Hh on 2017/3/22.
 */
public class MDPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragments;

    public MDPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position % 4) {
            case 0:
                return "新闻通告";
            case 1:
                return "考研专栏";
            case 2:
                return "招聘信息";
            case 3:
                return "科技创新";
        }
        return "";
    }
}


