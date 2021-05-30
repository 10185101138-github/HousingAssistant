package com.aresix.housingassistant2.ui.children_record;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.aresix.housingassistant2.ChildrenMainActivity;
import com.aresix.housingassistant2.R;

import java.util.zip.DeflaterOutputStream;

/** 儿童记录模式 **/
public class ChildrenRecordFragment extends Fragment {

    private final static String prefName = "MyInfo";

    private ImageButton mSettingButton;

    private Button mHeightWeightReferenceTable;
    private Button mActivitySkillReferenceTable;

    private TextView mAge;
    private TextView mHeight;
    private TextView mWeight;
    private TextView mHealth;

    private Integer age = 3;
    private Float height = 100f;
    private Float weight = 40f;

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_children_record, container, false);

        /** 居家模式界面设置按钮 **/
        mSettingButton = (ImageButton) view.findViewById(R.id.children_record_setting);
        mSettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navigation = Navigation.findNavController(view);
                navigation.navigate(R.id.navigation_setting);
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

        getInfo();

        mAge = (TextView) view.findViewById(R.id.textAge);
        mAge.setText(age + " 岁");
        mAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChildrenMainActivity activity = (ChildrenMainActivity) getActivity();
                assert activity != null;

                String[] items = { "3 岁", "4 岁", "5 岁", "6 岁" };
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
                builder.setTitle("年龄");
                builder.setSingleChoiceItems(items, 0,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                age = i + 3;
                            }
                        });
                builder.setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (age == 0) {
                                    age = 3;
                                }
                                updateInfo();
                                saveInfo();
                            }
                        });
                builder.show();
            }
        });

        mHeight = (TextView) view.findViewById(R.id.textHeight);
        mHeight.setText(height.toString());
        mHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChildrenMainActivity activity = (ChildrenMainActivity) getActivity();
                assert activity != null;

                EditText editText = new EditText(activity);
                editText.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
                editText.setHint("请输入厘米数");
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
                builder.setTitle("身高").setView(editText);
                builder.setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                try {
                                    height = Float.parseFloat(editText.getText().toString());
                                } catch (NumberFormatException e) {
                                    Toast.makeText(activity, "请输入数字", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                                updateInfo();
                                saveInfo();
                            }
                        });
                builder.setNegativeButton("取消",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                builder.show();
            }
        });

        mWeight = (TextView) view.findViewById(R.id.textWeight);
        mWeight.setText(weight.toString());
        mWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChildrenMainActivity activity = (ChildrenMainActivity) getActivity();
                assert activity != null;
                EditText editText = new EditText(activity);
                editText.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
                editText.setHint("请输入公斤数");
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
                builder.setTitle("体重").setView(editText);
                builder.setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                try {
                                    weight = Float.parseFloat(editText.getText().toString());
                                } catch (NumberFormatException e) {
                                    Toast.makeText(activity, "请输入数字", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                                updateInfo();
                                saveInfo();
                            }
                        });
                builder.setNegativeButton("取消",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                builder.show();
            }
        });

        mHealth = (TextView) view.findViewById(R.id.textHealth);
        return view;
    }

    @SuppressLint("SetTextI18n")
    private void updateInfo() {
        mAge.setText(age + " 岁");
        mHeight.setText(height.toString());
        mWeight.setText(weight.toString());
        if (age == 3) {
            judgeHealth(94.9f, 111.7f, 12.7f, 21.2f);
        } else if (age == 4) {
            judgeHealth(100.7f, 119.2f, 14.1f, 24.2f);
        } else {
            judgeHealth(106.1f, 125.8f, 15.9f, 27.1f);
        }
    }

    private void getInfo() {
        ChildrenMainActivity activity = (ChildrenMainActivity) getActivity();
        assert activity != null;
        SharedPreferences userInfo = activity.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        age = userInfo.getInt("age", 3);
        height = userInfo.getFloat("height", 100);
        weight = userInfo.getFloat("weight", 40);
    }


    @SuppressLint("CommitPrefEdits")
    public void saveInfo() {
        ChildrenMainActivity activity = (ChildrenMainActivity) getActivity();
        assert activity != null;
        SharedPreferences userInfo = activity.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = userInfo.edit();
        editor.putInt("age", age);
        editor.putFloat("height", height);
        editor.putFloat("weight", weight);
        editor.commit();
    }

    @SuppressLint("SetTextI18n")
    private void judgeHealth(Float minHeight, Float maxHeight, Float minWeight, Float maxWeight) {
        if (height < minHeight) {
            if (weight < minWeight) {
                mHealth.setText("营养不良");
            } else if (weight > maxWeight) {
                mHealth.setText("超重幼儿");
            } else {
                mHealth.setText("身高不足");
            }
        } else if (height > maxHeight) {
            if (weight < minWeight) {
                mHealth.setText("超高幼儿");
            } else if (weight > maxWeight) {
                mHealth.setText("营养过剩");
            } else {
                mHealth.setText("身高过高");
            }
        } else {
            if (weight < minWeight) {
                mHealth.setText("体重不足");
            } else if (weight > maxWeight) {
                mHealth.setText("超重幼儿");
            } else {
                mHealth.setText("健康");
            }
        }
    }
}
