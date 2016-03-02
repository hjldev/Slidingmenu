package com.baiyyyhjl.slidingmenu;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.baiyyyhjl.slidingmenu.example.AttachExample;


public class MainActivity extends LauncherActivity {

    String[] names = new String[]{"AttachExample"};
    Class<?>[] classes = {AttachExample.class};

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
