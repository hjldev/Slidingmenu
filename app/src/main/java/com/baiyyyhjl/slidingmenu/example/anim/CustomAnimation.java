package com.baiyyyhjl.slidingmenu.example.anim;

import android.graphics.Canvas;
import android.os.Bundle;
import android.view.Menu;
import android.view.animation.Interpolator;
import android.widget.RadioGroup;

import com.baiyyyhjl.slidingmenu.R;
import com.baiyyyhjl.slidingmenu.example.BaseActivity;
import com.baiyyyhjl.slidingmenu.example.fragments.SampleListFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.CanvasTransformer;

public class CustomAnimation extends BaseActivity {
    private SlidingMenu sm;
    private RadioGroup mode;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set the Above View
        setContentView(R.layout.activity_animation);
        mode = (RadioGroup) findViewById(R.id.mode);
        sm = getSlidingMenu();
        setSlidingActionBarEnabled(true);
        sm.setBehindScrollScale(0.0f);
//		sm.setBehindCanvasTransformer(mTransformer);
        sm.setBehindCanvasTransformer(null);
        mode.check(R.id.none);
        mode.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.none:
                        sm.setBehindCanvasTransformer(null);
                        break;
                    case R.id.scale:
                        sm.setBehindCanvasTransformer(scale);
                        break;
                    case R.id.slide:
                        sm.setBehindCanvasTransformer(slide);
                        break;
                    case R.id.zoom:
                        sm.setBehindCanvasTransformer(zoom);
                        break;
                }
            }
        });


    }

    CanvasTransformer scale = new CanvasTransformer() {
        @Override
        public void transformCanvas(Canvas canvas, float percentOpen) {
            canvas.scale(percentOpen, 1, 0, 0);
        }
    };
    CanvasTransformer slide = new CanvasTransformer() {
        @Override
        public void transformCanvas(Canvas canvas, float percentOpen) {
            canvas.translate(0, canvas.getHeight() * (1 - interp.getInterpolation(percentOpen)));
        }
    };
    private static Interpolator interp = new Interpolator() {
        @Override
        public float getInterpolation(float t) {
            t -= 1.0f;
            return t * t * t + 1.0f;
        }
    };
    CanvasTransformer zoom = new CanvasTransformer() {
        @Override
        public void transformCanvas(Canvas canvas, float percentOpen) {
            float scale = (float) (percentOpen * 0.25 + 0.75);
            canvas.scale(scale, scale, canvas.getWidth() / 2, canvas.getHeight() / 2);
        }
    };

}
