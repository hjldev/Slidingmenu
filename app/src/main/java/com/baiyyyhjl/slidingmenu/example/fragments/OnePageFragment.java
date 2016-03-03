package com.baiyyyhjl.slidingmenu.example.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baiyyyhjl.slidingmenu.R;

/**
 * Created by huangjinlong on 2016/3/3.
 */
public class OnePageFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page1, container, false);
        return view;
    }
}
