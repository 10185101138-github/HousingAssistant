package com.aresix.housingassistant2.ui.children_activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.aresix.housingassistant2.R;
import com.aresix.housingassistant2.ui.children_activity.indoors.IndoorsActivity;
import com.aresix.housingassistant2.ui.children_activity.outdoors.OutdoorsActivity;
import com.aresix.housingassistant2.ui.setting.SettingActivity;
import com.aresix.housingassistant2.utils.Weather;

import java.util.Map;
import java.util.Random;

/** 儿童活动模式 **/
public class ChildrenActivityFragment extends Fragment {

    private ImageButton mSettingButton;

    private ImageButton mActivityOutdoors;
    private ImageButton mActivityIndoors;

    private TextView mTemperature;
    private TextView mTodayWeather;

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

        String adcode = Weather.getAdcodeInfo();
        Map<String, String> res = Weather.getWeatherInfo(adcode);
        mTemperature = view.findViewById(R.id.temperature);
        mTodayWeather = view.findViewById(R.id.todayWea);
        mTemperature.setText(res.get("temperature"));
        Random random = new Random();
        int maxTemperature = Integer.parseInt(res.get("temperature")) + random.nextInt(5);
        int minTemperature = Integer.parseInt(res.get("temperature")) - random.nextInt(5);
        mTodayWeather.setText(maxTemperature + "℃ / " + minTemperature + "℃");
        return view;
    }
}
