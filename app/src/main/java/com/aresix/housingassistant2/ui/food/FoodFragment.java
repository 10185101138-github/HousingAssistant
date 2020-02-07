package com.aresix.housingassistant2.ui.food;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aresix.housingassistant2.R;

public class FoodFragment extends Fragment {

    private FoodViewModel mViewModel;
    private int[] mFlipPic={
            R.drawable.test01,R.drawable.test02,R.drawable.test03,
            R.drawable.test04,R.drawable.test05
    };

    public static FoodFragment newInstance() {
        return new FoodFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_food, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FoodViewModel.class);
        // TODO: Use the ViewModel
    }

}