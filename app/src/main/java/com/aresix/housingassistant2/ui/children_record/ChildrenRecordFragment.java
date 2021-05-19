package com.aresix.housingassistant2.ui.children_record;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.aresix.housingassistant2.R;
import com.aresix.housingassistant2.ui.setting.SettingActivity;

/** 儿童记录模式 **/
public class ChildrenRecordFragment extends Fragment {

    private ImageButton mSettingButton;

    private Button mHeightWeightReferenceTable;
    private Button mActivitySkillReferenceTable;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_children_record, container, false);

        /** 居家模式界面设置按钮 **/
        mSettingButton = (ImageButton) view.findViewById(R.id.children_record_setting);
        mSettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        mHeightWeightReferenceTable = (Button) view.findViewById(R.id.height_weight_ref);
        mHeightWeightReferenceTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog heightWeightReference = new AlertDialog.Builder(getContext())
                        .setTitle(R.string.children_record_text1)
                        .setMessage(R.string.children_record_height_weight_reference)
                        .setPositiveButton("确定", null)
                        .create();
                heightWeightReference.show();
            }
        });

        mActivitySkillReferenceTable = (Button) view.findViewById(R.id.activity_skill_ref);
        mActivitySkillReferenceTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog activitySkillReference = new AlertDialog.Builder(getContext())
                        .setTitle(R.string.children_record_text2)
                        .setMessage(R.string.children_record_activity_skill_reference)
                        .setPositiveButton("确定", null)
                        .create();
                activitySkillReference.show();
            }
        });

        return view;
    }
}
