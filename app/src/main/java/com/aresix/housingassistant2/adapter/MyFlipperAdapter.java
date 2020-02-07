package com.aresix.housingassistant2.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.aresix.housingassistant2.ui.food.FoodFragment;

public class MyFlipperAdapter extends BaseAdapter {

    private static final String TAG = "Aressssssssss";
    private Context mContext = null;
    private int[] Drawables = null;

    public MyFlipperAdapter(Context context, int[] drawables) {
        mContext = context;
        Drawables = drawables;
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
                    500));
            view = imageView;
            Log.d(TAG, "getView: 这时i = "+i);
        }else {
            imageView= (ImageView) view;
            Log.d(TAG, "else: 这时i = "+i);
        }

        imageView.setImageResource(Drawables[i]);
        return imageView;
    }
}
