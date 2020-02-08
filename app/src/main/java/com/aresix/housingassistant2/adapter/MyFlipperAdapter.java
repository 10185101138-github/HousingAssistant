package com.aresix.housingassistant2.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.aresix.housingassistant2.MainActivity;
import com.aresix.housingassistant2.R;
import com.aresix.housingassistant2.ui.food.FoodFragment;

public class MyFlipperAdapter extends BaseAdapter {

    private static final String TAG = "Aressssssssss";
    private Context mContext = null;
    private int[] Drawables = null;
    private ImageView[] mPots={null,null,null,null,null};
    private Button mBtnL,mBtnR;

    public MyFlipperAdapter(Context context, int[] drawables, ImageView[] pots, Button l,Button r) {
        mContext = context;
        Drawables = drawables;
        int len = mPots.length;
        System.arraycopy(pots, 0, mPots, 0, len);
        mBtnL=l;
        mBtnR=r;
    }

    @Override
    public int getCount() {
        return Drawables.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = null;
        if (view == null) {
            imageView = new ImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(new ViewGroup
                    .LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    500)); //这里单位不是dp
            view = imageView;
        }else {
            imageView= (ImageView) view;
        }
//        mBtnL.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(mContext,"上一张图片",Toast.LENGTH_SHORT).show();
//            }
//        });

        int len=mPots.length;
        try{
            int prev=(i+len-1)%len;
            mPots[prev].setImageResource(R.drawable.pot1);
            mPots[i].setImageResource(R.drawable.pot0);
        }catch (Exception e){
            Log.d(TAG, "getView: 进度条出错啦");
            Log.e(TAG, "getView: ????",e );
        }

        imageView.setImageResource(Drawables[i]);
        return imageView;
    }

}
