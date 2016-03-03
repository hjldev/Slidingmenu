package com.baiyyyhjl.slidingmenu.example;

import android.os.Bundle;

import com.baiyyyhjl.slidingmenu.R;
import com.baiyyyhjl.slidingmenu.example.fragments.SampleListFragment;
import com.baiyyyhjl.slidingmenu.example.fragments.ThreeFragment;
import com.baiyyyhjl.slidingmenu.example.fragments.TwoPageFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;


public class LeftAndRightActivity extends BaseActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSlidingMenu().setMode(SlidingMenu.LEFT_RIGHT);
		getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		setContentView(R.layout.content_frame);
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.content_frame, new TwoPageFragment())
		.commit();
		
		getSlidingMenu().setSecondaryMenu(R.layout.menu_frame_two);
		getSlidingMenu().setSecondaryShadowDrawable(R.drawable.shadowright);
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.menu_frame_two, new ThreeFragment())
		.commit();
	}

}
