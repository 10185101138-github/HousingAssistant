package com.aresix.housingassistant2.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.aresix.housingassistant2.ui.food.FoodFragment;

public class MyFlipperAdapter extends BaseAdapter {

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
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new ViewGroup
                    .LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            view = imageView;
        }else {
            imageView= (ImageView) view;
        }

        imageView.setImageResource(Drawables[i]);
        return imageView;
    }
}
