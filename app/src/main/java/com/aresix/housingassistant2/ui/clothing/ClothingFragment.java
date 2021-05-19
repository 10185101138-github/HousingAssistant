package com.aresix.housingassistant2.ui.clothing;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aresix.housingassistant2.R;

/** 穿衣模式（包括天气） **/
public class ClothingFragment extends Fragment {

    private ClothingViewModel mViewModel;

    public static ClothingFragment newInstance() {
        return new ClothingFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_clothing, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ClothingViewModel.class);
        // TODO: Use the ViewModel
    }

}
