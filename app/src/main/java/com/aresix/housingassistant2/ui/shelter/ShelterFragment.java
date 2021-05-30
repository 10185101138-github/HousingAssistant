package com.aresix.housingassistant2.ui.shelter;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.aresix.housingassistant2.R;

/** 家居模式 **/
public class ShelterFragment extends Fragment {

    private static final String TAG = "Ares";
    private ShelterViewModel mViewModel;

    public static ShelterFragment newInstance() {
        return new ShelterFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(ShelterViewModel.class);
        View view = inflater.inflate(R.layout.fragment_shelter, container, false);

        try{
            ClickItems(view);
        }catch (Exception e){
            Log.d(TAG, "onCreateView: 点击事件出问题啦");
        }


        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ShelterViewModel.class);
        // TODO: Use the ViewModel
    }

    private void ClickItems(View view) {

        ImageView ivAir = view.findViewById(R.id.DevAir);
        ivAir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "已切换至空调模式", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView ivTv = view.findViewById(R.id.DevTV);
        ivTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "已切换至电视模式", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView ivPlayer = view.findViewById(R.id.DevPlayer);
        ivPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "已切换至音响模式", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView ivCur = view.findViewById(R.id.DevCurtain);
        ivCur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "已切换至窗帘模式", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView ivIll = view.findViewById(R.id.DevIllumination);
        ivIll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "已切换至照明模式", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView ivAdd = view.findViewById(R.id.DevAdd);
        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "新功能正在筹备中，敬请期待！", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
