package com.baiyyyhjl.slidingmenu;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.baiyyyhjl.slidingmenu.example.AttachExample;
import com.baiyyyhjl.slidingmenu.example.BirdActivity;
import com.baiyyyhjl.slidingmenu.example.FragmentChangeActivity;
import com.baiyyyhjl.slidingmenu.example.LeftAndRightActivity;
import com.baiyyyhjl.slidingmenu.example.PropertiesActivity;
import com.baiyyyhjl.slidingmenu.example.ResponsiveUIActivity;
import com.baiyyyhjl.slidingmenu.example.ViewPagerActivity;
import com.baiyyyhjl.slidingmenu.example.anim.CustomAnimation;


public class MainActivity extends LauncherActivity {

    String[] names = new String[]{"AttachExample", "PropertiesActivity", "LeftAndRightActivity", "CustomAnimation", "ViewPagerActivity", "FragmentChangeActivity", "ResponsiveUIActivity", "BirdActivity"};
    Class<?>[] classes = {AttachExample.class, PropertiesActivity.class, LeftAndRightActivity.class, CustomAnimation.class, ViewPagerActivity.class
    , FragmentChangeActivity.class, ResponsiveUIActivity.class, BirdActivity.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        setListAdapter(adapter);
    }

    @Override
    protected Intent intentForPosition(int position) {
        return new Intent(MainActivity.this, classes[position]);
    }
}
