package com.aresix.housingassistant2.ui.shelter;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.aresix.housingassistant2.R;
import com.aresix.housingassistant2.adapter.DeviceAdapter;

public class ShelterFragment extends Fragment {

    private ShelterViewModel mViewModel;
    public RecyclerView mRvDevice;

    public static ShelterFragment newInstance() {
        return new ShelterFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel=ViewModelProviders.of(this).get(ShelterViewModel.class);
        View view=inflater.inflate(R.layout.fragment_shelter, container, false);


        mRvDevice=view.findViewById(R.id.devices);
        // 保证 activity 一定在
        if(getActivity()!=null){
            mRvDevice.setLayoutManager(new GridLayoutManager(getActivity(),2));
            mRvDevice.setAdapter(new DeviceAdapter(getActivity(), new DeviceAdapter.OnItemClickListener() {
                @Override
                public void onClick(int pos) {
                    Toast.makeText(getActivity(),"点击了第"+pos+"个选项",Toast.LENGTH_SHORT).show();
                }
            }));
        }
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ShelterViewModel.class);
        // TODO: Use the ViewModel
    }

}
