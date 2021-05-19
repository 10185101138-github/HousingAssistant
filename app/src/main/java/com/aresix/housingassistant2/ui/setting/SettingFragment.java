package com.aresix.housingassistant2.ui.setting;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.aresix.housingassistant2.ChildrenMainActivity;
import com.aresix.housingassistant2.MainActivity;
import com.aresix.housingassistant2.R;

/** 设置 **/
public class SettingFragment extends Fragment {

    private SettingViewModel mSettingViewModel;

    private TextView mUserName;
    private TextView mUserPassword;

    /** 切换模式按钮 **/
    private Button mAdultButton;
    private Button mChildrenButton;

    public static SettingFragment newInstance() {
        return new SettingFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        /** 设置用户名 **/
        mUserName = (TextView) view.findViewById(R.id.user_name);
        mUserName.setText(R.string.user_name);

        /** 设置密码 **/
        mUserPassword = (TextView) view.findViewById(R.id.password);
        mUserPassword.setText(R.string.password);

        mAdultButton = (Button) view.findViewById(R.id.setting_adult);
        mAdultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        mChildrenButton = (Button) view.findViewById(R.id.setting_children);
        mChildrenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ChildrenMainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mSettingViewModel = ViewModelProviders.of(this).get(SettingViewModel.class);
        // TODO: Use the ViewModel
    }

}
