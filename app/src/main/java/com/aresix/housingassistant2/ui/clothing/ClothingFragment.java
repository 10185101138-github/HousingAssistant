package com.aresix.housingassistant2.ui.clothing;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.aresix.housingassistant2.AuditMainActivity;
import com.aresix.housingassistant2.MainActivity;
import com.aresix.housingassistant2.R;

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

    private ImageView mModel;
    private ImageView mWeather;

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

        MainActivity activity = (MainActivity) getActivity();
        assert activity != null;
        Map<String, String> weather = activity.getWeather();

        if (weather == null) {
            Toast.makeText(activity, "数据加载中, 请重新进入该页面", Toast.LENGTH_SHORT).show();
            return view;
        }

        mModel = (ImageView) view.findViewById(R.id.model);
        mWeather = (ImageView) view.findViewById(R.id.weather);

        Log.w("weather", weather.toString());
        mTemperature.setText(weather.get("temperature"));
        Random random = new Random();
        int maxTemperature = Integer.parseInt(weather.get("temperature")) + random.nextInt(5);
        int minTemperature = Integer.parseInt(weather.get("temperature")) - random.nextInt(5);
        mTodayWeather.setText(maxTemperature + "℃ / " + minTemperature + "℃");
        mBodyTemperature.setText("体感: " + weather.get("temperature") + "℃");
        mWind.setText("风向: " + weather.get("winddirection"));
        mHumidity.setText("湿度: " + weather.get("humidity") + "%");

        int temperature = Integer.parseInt(weather.get("temperature"));
        if (temperature < 15) {
            mModel.setImageResource(R.drawable.model0301);
        } else {
            mModel.setImageResource(R.drawable.model0302);
        }
        String w = weather.get("weather");
        if (w.contains("晴")) {
            mWeather.setImageResource(R.drawable.sunny);
        } else if (w.contains("雨")) {
            mWeather.setImageResource(R.drawable.rainy);
        } else {
            mWeather.setImageResource(R.drawable.windy);
        }

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ClothingViewModel.class);
        // TODO: Use the ViewModel
    }

}
