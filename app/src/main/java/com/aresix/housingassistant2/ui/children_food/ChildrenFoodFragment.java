package com.aresix.housingassistant2.ui.children_food;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.aresix.housingassistant2.R;
import com.aresix.housingassistant2.adapter.MyFlipperAdapter;

/** 儿童饮食模式**/
public class ChildrenFoodFragment extends Fragment {

    /** 顶部图片切换栏 **/
    private AdapterViewFlipper mFoodFlipper;
    private int[] mChildrenFlipPic = {
            R.drawable.children_food_top, R.drawable.children_food_top, R.drawable.children_food_top,
            R.drawable.children_food_top, R.drawable.children_food_top
    };
    private ImageView[] pots;

    /** 左右图片切换 **/
    private Button mChildrenPrevPic;
    private Button mChildrenNextPic;

    /** 饮食全记录和我的收藏 **/
    private RelativeLayout mFoodRecord;
    private RelativeLayout mMyStar;

    /** 食物卡片 **/
    private CardView[] mFoodCard = {null, null, null};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_children_food, container, false);

        /** 设置顶部图像切换栏**/
        mFoodFlipper = view.findViewById(R.id.childrenFlipper);
        pots = new ImageView[]{
                view.findViewById(R.id.childrenPicCarousel_img0),
                view.findViewById(R.id.childrenPicCarousel_img1),
                view.findViewById(R.id.childrenPicCarousel_img2),
                view.findViewById(R.id.childrenPicCarousel_img3),
                view.findViewById(R.id.childrenPicCarousel_img4),
        };
        mChildrenPrevPic = (Button) view.findViewById(R.id.childrenPrevPic);
        mChildrenPrevPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pots[mFoodFlipper.getDisplayedChild()].setImageResource(R.drawable.pot1);
                //获取当前播放的图片是 第几站图片 下标从 0 开始
                mFoodFlipper.showPrevious();
                pots[mFoodFlipper.getDisplayedChild()].setImageResource(R.drawable.pot0);
            }
        });
        mChildrenNextPic = (Button) view.findViewById(R.id.childrenNextPic);
        mChildrenNextPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pots[mFoodFlipper.getDisplayedChild()].setImageResource(R.drawable.pot1);
                //获取当前播放的图片是第几站图片 下标从 0 开始
                mFoodFlipper.showNext();
                pots[mFoodFlipper.getDisplayedChild()].setImageResource(R.drawable.pot0);
            }
        });
        MyFlipperAdapter adapter = new MyFlipperAdapter(getContext(), mChildrenFlipPic, pots, mChildrenPrevPic, mChildrenNextPic);
        mFoodFlipper.setAdapter(adapter);

        /** 饮食全记录 **/
        mFoodRecord = (RelativeLayout) view.findViewById(R.id.childrenLeftFood);
        mFoodRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(getContext())
                        .setTitle("饮食全记录")
                        .setMessage("欢迎点击饮食全记录")
                        .setPositiveButton("确定", null)
                        .create();
                dialog.show();
            }
        });

        /** 我的收藏 **/
        mMyStar = (RelativeLayout) view.findViewById(R.id.childrenRightFood);
        mMyStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(getContext())
                        .setTitle("我的收藏")
                        .setMessage("欢迎点击我的收藏")
                        .setPositiveButton("确定", null)
                        .create();
                dialog.show();
            }
        });


        /** 食物卡片 **/
        mFoodCard[0] = (CardView) view.findViewById(R.id.children_food_card1);
        mFoodCard[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(getContext())
                        .setTitle(R.string.children_food_card1)
                        .setMessage(R.string.children_food_card1_content)
                        .setPositiveButton("确定", null)
                        .create();
                dialog.show();
            }
        });

        mFoodCard[1] = (CardView) view.findViewById(R.id.children_food_card2);
        mFoodCard[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(getContext())
                        .setTitle(R.string.children_food_card2)
                        .setMessage(R.string.children_food_card2_content)
                        .setPositiveButton("确定", null)
                        .create();
                dialog.show();
            }
        });

        mFoodCard[2] = (CardView) view.findViewById(R.id.children_food_card3);
        mFoodCard[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(getContext())
                        .setTitle(R.string.children_food_card3)
                        .setMessage(R.string.children_food_card3_content)
                        .setPositiveButton("确定", null)
                        .create();
                dialog.show();
            }
        });



        return view;
    }
}
