package com.aresix.housingassistant2.ui.food;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterViewFlipper;
import android.widget.ImageView;

import com.aresix.housingassistant2.R;
import com.aresix.housingassistant2.adapter.MyFlipperAdapter;

public class FoodFragment extends Fragment implements android.view.GestureDetector.OnGestureListener {

    private FoodViewModel mViewModel;
    private GestureDetector mGestureDetector=null;
    private AdapterViewFlipper mFlipper=null;
    private int[] mFlipPic={
            R.drawable.test02,R.drawable.test01,R.drawable.test03,
            R.drawable.test04,R.drawable.test05
    };
    private ImageView[] pots={null,null,null,null,null};
    private static final String TAG = "Heliosssss";

    public static FoodFragment newInstance() {
        return new FoodFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_food, container, false);
        mFlipper=view.findViewById(R.id.flipper);
        mGestureDetector=new GestureDetector(getContext(),this);

         pots[0]= view.findViewById(R.id.PicCarousel_img0);
         pots[1]= view.findViewById(R.id.PicCarousel_img1);
         pots[2]= view.findViewById(R.id.PicCarousel_img2);
         pots[3]= view.findViewById(R.id.PicCarousel_img3);
         pots[4]= view.findViewById(R.id.PicCarousel_img4);

        MyFlipperAdapter adapter = new MyFlipperAdapter(getContext(),mFlipPic,pots);
        mFlipper.setAdapter(adapter);

//        Log.d(TAG, "onCreateView: "+pots[0]);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FoodViewModel.class);
        // TODO: Use the ViewModel
    }


    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        if (motionEvent1.getX() - motionEvent.getX() > 120) {			 // 从左向右滑动（左进右出）
//            Animation rInAnim = AnimationUtils.loadAnimation(getContext(), R.anim.push_right_in); 	// 向右滑动左侧进入的渐变效果（alpha  0.1 -> 1.0）
//            Animation rOutAnim = AnimationUtils.loadAnimation(getContext(), R.anim.push_right_out); // 向右滑动右侧滑出的渐变效果（alpha 1.0  -> 0.1）

            mFlipper.setInAnimation(getContext(),R.anim.push_right_in);
            mFlipper.setOutAnimation(getContext(),R.anim.push_right_out);
            mFlipper.showPrevious();
            // TODO:点的跟进
            return true;
        } else if (motionEvent1.getX() - motionEvent.getX() < -120) {		 // 从右向左滑动（右进左出）
//            Animation lInAnim = AnimationUtils.loadAnimation(getContext(), R.anim.push_left_in);		// 向左滑动左侧进入的渐变效果（alpha 0.1  -> 1.0）
//            Animation lOutAnim = AnimationUtils.loadAnimation(getContext(), R.anim.push_left_out); 	// 向左滑动右侧滑出的渐变效果（alpha 1.0  -> 0.1）

            mFlipper.setInAnimation(getContext(),R.anim.push_left_in);
            mFlipper.setOutAnimation(getContext(),R.anim.push_left_out);
            mFlipper.showNext();
            return true;
        }
        return true;
    }
}
