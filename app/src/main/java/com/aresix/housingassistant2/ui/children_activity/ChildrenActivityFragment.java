package com.aresix.housingassistant2.ui.children_activity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aresix.housingassistant2.R;
import com.aresix.housingassistant2.ui.children_activity.indoors.IndoorsActivity;
import com.aresix.housingassistant2.ui.children_activity.outdoors.OutdoorsActivity;
import com.aresix.housingassistant2.ui.setting.SettingActivity;

/** 儿童活动模式 **/
public class ChildrenActivityFragment extends Fragment {

    private ImageButton mSettingButton;

    private ImageButton mActivityOutdoors;
    private ImageButton mActivityIndoors;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_children_activity, container, false);

        /** 活动模式界面设置按钮 **/
        mSettingButton = (ImageButton) view.findViewById(R.id.children_activity_setting);
        mSettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        /** 活动模式室外活动按钮 **/
        mActivityOutdoors = (ImageButton) view.findViewById(R.id.children_activity_outdoors);
        mActivityOutdoors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OutdoorsActivity.class);
                startActivity(intent);
            }
        });

        /** 活动模式室内活动按钮 **/
        mActivityIndoors = (ImageButton) view.findViewById(R.id.children_activity_indoors);
        mActivityIndoors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), IndoorsActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
