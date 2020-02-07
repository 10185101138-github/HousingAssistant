package com.aresix.housingassistant2.ui.food;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;

import com.aresix.housingassistant2.R;
import com.aresix.housingassistant2.adapter.MyFlipperAdapter;

public class FoodFragment extends Fragment {

    private FoodViewModel mViewModel;
    private AdapterViewFlipper mFlipper=null;
    private int[] mFlipPic={
            R.drawable.test02,R.drawable.test01,R.drawable.test03,
            R.drawable.test04,R.drawable.test05
    };

    public static FoodFragment newInstance() {
        return new FoodFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_food, container, false);
        mFlipper=view.findViewById(R.id.flipper);

        MyFlipperAdapter adapter = new MyFlipperAdapter(getContext(),mFlipPic);
        mFlipper.setAdapter(adapter);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FoodViewModel.class);
        // TODO: Use the ViewModel
    }

}
