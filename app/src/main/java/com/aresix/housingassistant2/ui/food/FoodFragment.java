package com.aresix.housingassistant2.ui.food;

import androidx.lifecycle.ViewModelProviders;

import android.gesture.GestureOverlayView;
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
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.ImageView;

import com.aresix.housingassistant2.R;
import com.aresix.housingassistant2.adapter.MyFlipperAdapter;

public class FoodFragment extends Fragment {

    private FoodViewModel mViewModel;
    private int[] mFlipPic={
            R.drawable.test02,R.drawable.test01,R.drawable.test03,
            R.drawable.test04,R.drawable.test05
    };
    private AdapterViewFlipper mFlipper;
    private ImageView[] pots;
    private static final String TAG = "Heliosssss";

    public static FoodFragment newInstance() {
        return new FoodFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_food, container, false);
         mFlipper = view.findViewById(R.id.flipper);

        pots = new ImageView[]{
                view.findViewById(R.id.PicCarousel_img0),
                view.findViewById(R.id.PicCarousel_img1),
                view.findViewById(R.id.PicCarousel_img2),
                view.findViewById(R.id.PicCarousel_img3),
                view.findViewById(R.id.PicCarousel_img4),
        };
        Button btnLeft = view.findViewById(R.id.prevPic);
        Button btnRight = view.findViewById(R.id.nextPic);

        MyFlipperAdapter adapter = new MyFlipperAdapter(getContext(),mFlipPic,pots,btnLeft,btnRight);
        mFlipper.setAdapter(adapter);

        btnChoose(btnLeft,btnRight);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FoodViewModel.class);
        // TODO: Use the ViewModel
    }

    private void btnChoose(Button btnLeft, Button btnRight){
        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pots[mFlipper.getDisplayedChild()].setImageResource(R.drawable.pot1);
                //获取当前播放的图片是 第几站图片 下标从 0 开始
                mFlipper.showPrevious();
                pots[mFlipper.getDisplayedChild()].setImageResource(R.drawable.pot0);
            }
        });
        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pots[mFlipper.getDisplayedChild()].setImageResource(R.drawable.pot1);
                //获取当前播放的图片是第几站图片 下标从 0 开始
                mFlipper.showNext();
                pots[mFlipper.getDisplayedChild()].setImageResource(R.drawable.pot0);
            }
        });
    }
}
