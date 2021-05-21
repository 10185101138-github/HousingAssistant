package com.aresix.housingassistant2.utils;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import javax.net.ssl.HttpsURLConnection;

public class Weather {
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static String getAdcodeInfo() {
        AtomicReference<String> apiRes = new AtomicReference<>();
        Thread getLocation = new Thread(() -> {
            // 获取地址
            try {
                URL url = new URL("https://restapi.amap.com/v3/ip?key=f831d99aa8eb23ded9af607cbf2b7a86");
                HttpsURLConnection httpURLConnection = (HttpsURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(reader);

                StringBuffer buffer = new StringBuffer();
                String temp = null;

                while ((temp = bufferedReader.readLine()) != null) {
                    buffer.append(temp);
                }
                bufferedReader.close();
                reader.close();
                inputStream.close();
                temp = buffer.toString();
                apiRes.set(temp);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        getLocation.start();
        try {
            getLocation.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<>();
        map = gson.fromJson(apiRes.get(), map.getClass());
        List<String> list = (List<String>) map.get("adcode");
        return list.size() > 0 ? list.get(0) : "310000";
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static Map<String, String> getWeatherInfo(String adcode) {
        AtomicReference<Map<String, String>> apiRes = new AtomicReference<>();
        Thread getWeather = new Thread(() -> {
            try {
                URL url = new URL("https://restapi.amap.com/v3/weather/weatherInfo?key=f831d99aa8eb23ded9af607cbf2b7a86&city=" + adcode + "&extensions=base");
                HttpsURLConnection httpURLConnection = (HttpsURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(reader);

                StringBuffer buffer = new StringBuffer();
                String temp = null;

                while ((temp = bufferedReader.readLine()) != null) {
                    buffer.append(temp);
                }
                bufferedReader.close();
                reader.close();
                inputStream.close();

                Gson gson = new Gson();
                Map<String, Object> map = new HashMap<>();
                map = gson.fromJson(buffer.toString(), map.getClass());
                apiRes.set((Map<String, String>) (((List) (map.get("lives"))).get(0)));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        getWeather.start();
        try {
            getWeather.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return apiRes.get();
    }
}
