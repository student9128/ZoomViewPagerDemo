package com.kevin.tech.zoomviewpagerdemo.fragment;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kevin.tech.zoomviewpagerdemo.R;

@SuppressLint("ValidFragment")
public class LongFragment extends Fragment {

    private ImageView imageView_show;
    private TextView textView_show;
    private TextView textView_id;
    private int id;
    private String str;
    private RelativeLayout mRLLong;
//    public ThreeFragment(int id, String str) {
//        this.id = id;
//        this.str = str;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.item_long, null);
        mRLLong = (RelativeLayout) view.findViewById(R.id.rl_ball_long);
        imageView_show = (ImageView) view.findViewById(R.id.imageView_show);
        textView_show = (TextView) view.findViewById(R.id.textView_show);
        ObjectAnimator animator = ObjectAnimator.ofFloat(mRLLong, "scale", 1.0f, 0.8f);
        animator.setDuration(100).start();
//        textView_id = (TextView) view.findViewById(R.id.textView_id);
//		imageView_show.setImageBitmap(MainActivity.mActivity.readBitMap(getActivity(), id));
//        textView_id.setVisibility(View.VISIBLE);
//		imageView_show.setImageResource(R.drawable.bk_empty);
//		imageView_show.setImageResource(id);
        /*Glide.with(getActivity())
        .load(id)
		.diskCacheStrategy(DiskCacheStrategy.SOURCE)
		.fitCenter()
		.placeholder(R.drawable.bk_empty)
		.crossFade()
		.into(imageView_show);
		textView_show.setText(str);*/
        return view;
    }
}
