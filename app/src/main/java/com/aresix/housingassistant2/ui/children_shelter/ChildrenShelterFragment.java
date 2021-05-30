package com.aresix.housingassistant2.ui.children_shelter;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.aresix.housingassistant2.MainActivity;
import com.aresix.housingassistant2.R;
import com.aresix.housingassistant2.ui.setting.SettingActivity;

/** 儿童家居模式 **/
public class ChildrenShelterFragment extends Fragment {

    private ImageButton mSettingButton;

    private ImageButton mSpeakerButton;
    private ImageButton mLightingButton;
    private ImageButton mCurtainutton;
    private ImageButton mAddNewDevicesButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_children_shelter, container, false);

        /** 居家模式界面设置按钮 **/
        mSettingButton = (ImageButton) view.findViewById(R.id.children_shelter_setting);
        mSettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navigation = Navigation.findNavController(view);
                navigation.navigate(R.id.navigation_setting);
            }
        });

        /** 居家模式界面音响按钮 **/
        mSpeakerButton = (ImageButton) view.findViewById(R.id.children_shelter_button1);
        mSpeakerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog notion = new AlertDialog.Builder(getContext())
                        .setTitle("音响")
                        .setMessage("已打开音响")
                        .setPositiveButton("确定", null)
                        .create();
                notion.show();
            }
        });

        /** 居家模式界面灯光按钮 **/
        mLightingButton = (ImageButton) view.findViewById(R.id.children_shelter_button2);
        mLightingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog notion = new AlertDialog.Builder(getContext())
                        .setTitle("灯光")
                        .setMessage("已打开关闭")
                        .setPositiveButton("确定", null)
                        .create();
                notion.show();
            }
        });

        /** 居家模式界面窗帘按钮 **/
        mCurtainutton = (ImageButton) view.findViewById(R.id.children_shelter_button3);
        mCurtainutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog notion = new AlertDialog.Builder(getContext())
                        .setTitle("窗帘")
                        .setMessage("已打开窗帘")
                        .setPositiveButton("确定", null)
                        .create();
                notion.show();
            }
        });

        /** 居家模式界面添加设备按钮 **/
        mAddNewDevicesButton = (ImageButton) view.findViewById(R.id.children_shelter_button4);
        mAddNewDevicesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog notion = new AlertDialog.Builder(getContext())
                        .setTitle("添加设备")
                        .setMessage("新功能开发中...")
                        .setPositiveButton("确定", null)
                        .create();
                notion.show();
            }
        });
        return view;
    }
}
