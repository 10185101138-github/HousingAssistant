package com.aresix.housingassistant2.ui.setting;

import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.aresix.housingassistant2.AuditMainActivity;
import com.aresix.housingassistant2.ChildrenMainActivity;
import com.aresix.housingassistant2.MainActivity;
import com.aresix.housingassistant2.R;

import java.io.FileNotFoundException;

/** 设置 **/
public class SettingFragment extends Fragment {

    private SettingViewModel mSettingViewModel;

    private TextView mUserName;
    private TextView mUserPassword;

    /** 切换模式按钮 **/
    private Button mAdultButton;
    private Button mChildrenButton;

    private Button mConfirmButton;

    private ImageView mRoundImageView;

    public static SettingFragment newInstance() {
        return new SettingFragment();
    }

    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        MainActivity activity = (MainActivity) getActivity();
        assert activity != null;

        /** 设置用户名 **/
        mUserName = (TextView) view.findViewById(R.id.user_name);
        mUserName.setText(activity.getUserName());

        /** 设置密码 **/
        mUserPassword = (TextView) view.findViewById(R.id.password);
        mUserPassword.setText(activity.getUserPassword());

        mAdultButton = (Button) view.findViewById(R.id.setting_adult);
        mAdultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.saveInfo(0);
                Intent intent = new Intent(getActivity(), AuditMainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        mChildrenButton = (Button) view.findViewById(R.id.setting_children);
        mChildrenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.saveInfo(1);
                Intent intent = new Intent(getActivity(), ChildrenMainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        mConfirmButton = (Button) view.findViewById(R.id.setting_confirm);
        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!activity.checkInfo(
                        mUserName.getText().toString(), mUserPassword.getText().toString())) {
                    return;
                }
                activity.saveInfo(mUserName.getText().toString(), mUserPassword.getText().toString());
            }
        });

        mRoundImageView = (ImageView) view.findViewById(R.id.roundImageView);
        Integer head = activity.getUserHead();
        if (head == 0) {
            mRoundImageView.setImageResource(R.drawable.avatar2);
        } else if (head == 1) {
            mRoundImageView.setImageResource(R.drawable.avatar3);
        } else if (head == 2) {
            mRoundImageView.setImageResource(R.drawable.avatar4);
        } else if (head == 3) {
            mRoundImageView.setImageResource(R.drawable.avatar5);
        }
        mRoundImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String []items = { "内置头像 1", "内置头像 2", "内置头像 3", "内置头像 4" };
                final Integer[] choice = {0};
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
                builder.setTitle("头像");
                builder.setSingleChoiceItems(items, 0,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                choice[0] = i;
                            }
                        });
                builder.setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            @SuppressLint("ResourceType")
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (choice[0] == 0) {
                                    mRoundImageView.setImageResource(R.drawable.avatar2);
                                } else if (choice[0] == 1) {
                                    mRoundImageView.setImageResource(R.drawable.avatar3);
                                } else if (choice[0] == 2) {
                                    mRoundImageView.setImageResource(R.drawable.avatar4);
                                } else if (choice[0] == 3) {
                                    mRoundImageView.setImageResource(R.drawable.avatar5);
                                }
                                activity.saveHead(choice[0]);
                            }
                        });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.show();
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
