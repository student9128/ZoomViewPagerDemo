package com.kevin.tech.zoomviewpagerdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.kevin.tech.zoomviewpagerdemo.adapter.MyViewPagerAdapter;

/**
 * Created by Kevin on 2016/12/27.
 * Blog:http://blog.csdn.net/student9128
 * Description:
 */

public class NextActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private MyViewPagerAdapter mAdapter;
    private LinearLayout mLLContainer;
    private int[] mImageArr = new int[]{R.drawable.ball_green, R.drawable.ball_blue, R.drawable.ball_red};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        mLLContainer = (LinearLayout) findViewById(R.id.ll_container);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        mAdapter = new MyViewPagerAdapter(this, mImageArr);
        mViewPager.setAdapter(mAdapter);
        //添加下面两行代码，解决三个球存在时有两个是大的bug，不过又会出现首次进入三个球一样大的bug
//        mViewPager.setOffscreenPageLimit(20);
//        mViewPager.setPageMargin(10);
        mViewPager.setCurrentItem(1);
        mLLContainer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                return mViewPager.dispatchTouchEvent(event);
            }
        });
    }
}
