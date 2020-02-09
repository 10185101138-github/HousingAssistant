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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.aresix.housingassistant2.R;
import com.aresix.housingassistant2.adapter.MyFlipperAdapter;

public class FoodFragment extends Fragment {

    private FoodViewModel mViewModel;
    private int[] mFlipPic = {
            R.drawable.test02, R.drawable.test01, R.drawable.test03,
            R.drawable.test04, R.drawable.test05
    };
    private AdapterViewFlipper mFlipper;
    private ImageView[] pots;
    private static final String TAG = "Heliosssss";
    private RelativeLayout[] mRL3 = {null, null, null, null, null};
    private RelativeLayout[] mRL2 = {null, null};
    private RelativeLayout mRLCard = null;
    private TextView mTvCardTitle = null, mTvCardContent = null;
    private ImageView mBtnCard=null;

    public static FoodFragment newInstance() {
        return new FoodFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food, container, false);
        mFlipper = view.findViewById(R.id.flipper);

        /* ======== initialize ======== */
        pots = new ImageView[]{
                view.findViewById(R.id.PicCarousel_img0),
                view.findViewById(R.id.PicCarousel_img1),
                view.findViewById(R.id.PicCarousel_img2),
                view.findViewById(R.id.PicCarousel_img3),
                view.findViewById(R.id.PicCarousel_img4),
        };
        Button btnLeft = view.findViewById(R.id.prevPic);
        Button btnRight = view.findViewById(R.id.nextPic);

        mRL2[0] = view.findViewById(R.id.leftFood);
        mRL2[1] = view.findViewById(R.id.rightFood);

        mRL3[0] = view.findViewById(R.id.foodItem0301);
        mRL3[1] = view.findViewById(R.id.foodItem0302);
        mRL3[2] = view.findViewById(R.id.foodItem0303);
        mRL3[3] = view.findViewById(R.id.foodItem0304);
        mRL3[4] = view.findViewById(R.id.foodItem0305);

        mRLCard = view.findViewById(R.id.foodCard);
        mTvCardContent = view.findViewById(R.id.cardContent);
        mTvCardTitle = view.findViewById(R.id.cardTitle);
        mBtnCard=view.findViewById(R.id.close);
        /* ======== initialize ======== */

        MyFlipperAdapter adapter = new MyFlipperAdapter(getContext(), mFlipPic, pots, btnLeft, btnRight);
        mFlipper.setAdapter(adapter);

        btnChoose(btnLeft, btnRight);
        rl2Click(mRL2);
        rl3Click(mRL3, mRLCard, mTvCardTitle, mTvCardContent,mBtnCard);
        return view;
    }

    private void rl3Click(RelativeLayout[] rl3, final RelativeLayout rlCard,
                          final TextView tvCardTitle, final TextView tvCardContent, ImageView btnCard) {
        rl3[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rlCard.setVisibility(View.VISIBLE);
                tvCardTitle.setText(R.string.lzysFamousDishes);
                tvCardContent.setText(R.string.lzysFamousDishesContent);
            }
        });
        rl3[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rlCard.setVisibility(View.VISIBLE);
                tvCardTitle.setText(R.string.loveProducer);
                tvCardContent.setText(R.string.loveProducerContent);
            }
        });
        rl3[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rlCard.setVisibility(View.VISIBLE);
                tvCardTitle.setText(R.string.psycho);
                tvCardContent.setText(R.string.psychoContent);
            }
        });
        rl3[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rlCard.setVisibility(View.VISIBLE);
                tvCardTitle.setText(R.string.souvenir);
                tvCardContent.setText(R.string.souvenirContent);
            }
        });
        rl3[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rlCard.setVisibility(View.VISIBLE);
                tvCardTitle.setText(R.string.license);
                tvCardContent.setText(R.string.licenseContent);
            }
        });

        //没有必要 判断 card 的状态 因为RelativeLayout不在了 那么button也看不见了
        btnCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rlCard.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void rl2Click(RelativeLayout[] rl2) {
        rl2[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "欢迎点击-饮食全记录", Toast.LENGTH_SHORT).show();
            }
        });
        rl2[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "欢迎点击-我的收藏", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FoodViewModel.class);
        // TODO: Use the ViewModel
    }

    private void btnChoose(Button btnLeft, Button btnRight) {
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
