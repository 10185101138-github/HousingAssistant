package com.aresix.housingassistant2.ui.children_activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.aresix.housingassistant2.MainActivity;
import com.aresix.housingassistant2.R;
import com.aresix.housingassistant2.ui.children_activity.indoors.IndoorsActivity;
import com.aresix.housingassistant2.ui.children_activity.outdoors.OutdoorsActivity;

import java.util.Map;
import java.util.Random;

/** 儿童活动模式 **/
public class ChildrenActivityFragment extends Fragment {

    private ImageButton mSettingButton;

    private ImageButton mActivityOutdoors;
    private ImageButton mActivityIndoors;

    private TextView mTemperature;
    private TextView mTodayWeather;
    private TextView mMessage;

    private ImageView mWeather;

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_children_activity, container, false);

        /** 活动模式界面设置按钮 **/
        mSettingButton = (ImageButton) view.findViewById(R.id.children_activity_setting);
        mSettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navigation = Navigation.findNavController(view);
                navigation.navigate(R.id.navigation_setting);
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

        mWeather = (ImageView) view.findViewById(R.id.children_weather);
        mMessage = (TextView) view.findViewById(R.id.textView);

        MainActivity activity = (MainActivity) getActivity();
        assert activity != null;
        Map<String, String> weather = activity.getWeather();

        if (weather == null) {
            Toast.makeText(activity, "数据加载中, 请重新进入该页面", Toast.LENGTH_SHORT).show();
            return view;
        }
        mTemperature = view.findViewById(R.id.temperature);
        mTodayWeather = view.findViewById(R.id.todayWea);
        mTemperature.setText(weather.get("temperature"));
        Random random = new Random();
        int maxTemperature = Integer.parseInt(weather.get("temperature")) + random.nextInt(5);
        int minTemperature = Integer.parseInt(weather.get("temperature")) - random.nextInt(5);
        mTodayWeather.setText(maxTemperature + "℃ / " + minTemperature + "℃");

        String w = weather.get("weather");
        if (w.contains("晴")) {
            mWeather.setImageResource(R.drawable.sunny);
            mMessage.setText("今天是个好天气，快出门运动吧！");
        } else {
            mMessage.setText("今天天气不太好，进行室内活动吧！");
            if (w.contains("雨")) {
                mWeather.setImageResource(R.drawable.rainy);
            } else {
                mWeather.setImageResource(R.drawable.windy);
            }
        }
        return view;
    }
}
