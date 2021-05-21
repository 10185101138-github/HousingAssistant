package com.aresix.housingassistant2.ui.clothing;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.aresix.housingassistant2.R;
import com.aresix.housingassistant2.utils.Weather;

import java.util.Map;
import java.util.Random;

/** 穿衣模式（包括天气） **/
public class ClothingFragment extends Fragment {

    private ClothingViewModel mViewModel;

    private TextView mTemperature;
    private TextView mTodayWeather;
    private TextView mBodyTemperature;
    private TextView mWind;
    private TextView mHumidity;

    public static ClothingFragment newInstance() {
        return new ClothingFragment();
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clothing, container, false);
        mTemperature = view.findViewById(R.id.temperature);
        mTodayWeather = view.findViewById(R.id.todayWea);
        mBodyTemperature = view.findViewById(R.id.weatherInfo02);
        mWind = view.findViewById(R.id.weatherInfo03);
        mHumidity = view.findViewById(R.id.weatherInfo04);

        String adcode = Weather.getAdcodeInfo();
        // 查询天气
        Map<String, String> res = Weather.getWeatherInfo(adcode);
        mTemperature.setText(res.get("temperature"));
        Random random = new Random();
        int maxTemperature = Integer.parseInt(res.get("temperature")) + random.nextInt(5);
        int minTemperature = Integer.parseInt(res.get("temperature")) - random.nextInt(5);
        mTodayWeather.setText(maxTemperature + "℃ / " + minTemperature + "℃");
        mBodyTemperature.setText("体感: " + res.get("temperature") + "℃");
        mWind.setText("风向: " + res.get("winddirection"));
        mHumidity.setText("湿度: " + res.get("humidity") + "%");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ClothingViewModel.class);
        // TODO: Use the ViewModel
    }

}
