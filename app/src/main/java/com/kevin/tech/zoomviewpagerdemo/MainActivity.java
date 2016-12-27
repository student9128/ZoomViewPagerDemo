package com.kevin.tech.zoomviewpagerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.kevin.tech.zoomviewpagerdemo.fragment.LongFragment;
import com.kevin.tech.zoomviewpagerdemo.fragment.MediumFragment;
import com.kevin.tech.zoomviewpagerdemo.fragment.ShortFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPagerCompat.OnPageChangeListener, View.OnClickListener {
    private int[] mImgs = new int[]{R.drawable.ball_red, R.drawable.ball_blue, R.drawable.ball_green};
    private List<Fragment> mFragments = new ArrayList<Fragment>();
    private RelativeLayout mPagerContainer;
    private ViewPagerCompat mViewPager;

    private List<ImageView> mImageViews = new ArrayList<ImageView>();
    private MyViewPagerAdapter mAdapter;

    private int[] locationOne = null;
    private int[] locationTwo = null;

    int oneTouch = 0;
    int TwoTouch = 0;
    int ThrTouch = 0;
    private MediumFragment mMediumFragment;
    private ShortFragment mShortFragment;
    private LongFragment mLongFragment;

    private Button mBtnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();

        mPagerContainer = (RelativeLayout) findViewById(R.id.pager_layout);
        mViewPager = (ViewPagerCompat) findViewById(R.id.viewpager);
        mBtnNext = (Button) findViewById(R.id.btn_next);
        mBtnNext.setOnClickListener(this);
        locationOne = new int[2];
        locationTwo = new int[2];
        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        mAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(20);
        mViewPager.setPageMargin(10);
        mViewPager.setCurrentItem(1);
        mPagerContainer.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return mViewPager.dispatchTouchEvent(event);
            }
        });
        mViewPager.setOnPageChangeListener(this);
    }

    /**
     * 初始化Fragment
     */
    private void initFragment() {
        mShortFragment = new ShortFragment();
        mFragments.add(mShortFragment);

        mMediumFragment = new MediumFragment();
        mFragments.add(mMediumFragment);

        mLongFragment = new LongFragment();
        mFragments.add(mLongFragment);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (mPagerContainer != null) {
            mPagerContainer.invalidate();
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(MainActivity.this,NextActivity.class));
    }


//    @Override
//    protected void onResume() {
//        // TODO Auto-generated method stub
//        super.onResume();
//        mViewPager.getLocationInWindow(locationOne);
//        int oneX = locationOne[0];
//        int oneY = locationOne[1];
//        int width = mViewPager.getWidth();
//        int everyWidth = width / 3;
//        oneTouch = everyWidth;
//        TwoTouch = 2 * everyWidth;
//        ThrTouch = 3 * everyWidth;
//    }

    class MyViewPagerAdapter extends FragmentStatePagerAdapter {

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
            // TODO Auto-generated constructor stub
        }

        @Override
        public Fragment getItem(int arg0) {
            return mFragments.get(arg0);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return mFragments.size();
        }

    }
}
