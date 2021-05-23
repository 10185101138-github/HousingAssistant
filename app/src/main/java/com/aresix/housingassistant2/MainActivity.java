package com.aresix.housingassistant2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.aresix.housingassistant2.utils.RequestQueueSingleton;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private final static String prefName = "MyInfo";

    private volatile Map<String, String> weather = null;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestQueue = RequestQueueSingleton.getInstance(this).getRequestQueue();

        requestWeather();
    }

    public boolean checkInfo(String mUserName, String mUserPassword) {
        Context context = getApplicationContext();
        assert context != null;
        if ("".equals(mUserName)) {
            Toast.makeText(context, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        if ("".equals(mUserPassword)) {
            Toast.makeText(context, "密码不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public String getUserName() {
        SharedPreferences userInfo = getSharedPreferences(prefName, MODE_PRIVATE);
        return userInfo.getString("username", "");
    }

    public String getUserPassword() {
        SharedPreferences userInfo = getSharedPreferences(prefName, MODE_PRIVATE);
        return userInfo.getString("password", "");
    }

    public Integer getUserHead() {
        SharedPreferences userInfo = getSharedPreferences(prefName, MODE_PRIVATE);
        return userInfo.getInt("head", 0);
    }

    @SuppressLint("CommitPrefEdits")
    public void saveInfo(String mUserName, String mUserPassword) {
        SharedPreferences userInfo = getSharedPreferences(prefName, MODE_PRIVATE);
        SharedPreferences.Editor editor = userInfo.edit();
        editor.putString("username", mUserName);
        editor.putString("password", mUserPassword);
        editor.commit();
        Context context = getApplicationContext();
        assert context != null;
        Toast.makeText(context, "修改成功", Toast.LENGTH_LONG).show();
    }

    @SuppressLint("CommitPrefEdits")
    public void saveInfo(Integer mode) {
        SharedPreferences userInfo = getSharedPreferences(prefName, MODE_PRIVATE);
        SharedPreferences.Editor editor = userInfo.edit();
        editor.putInt("mode", mode);
        editor.commit();
    }

    @SuppressLint("CommitPrefEdits")
    public void saveHead(Integer head) {
        SharedPreferences userInfo = getSharedPreferences(prefName, MODE_PRIVATE);
        SharedPreferences.Editor editor = userInfo.edit();
        editor.putInt("head", head);
        editor.commit();
    }

    public void requestWeather() {
        String url = "https://restapi.amap.com/v3/ip?key=f831d99aa8eb23ded9af607cbf2b7a86";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    String adcode = response.optString("adcode", "310000");
                    if (adcode.charAt(0) == '[') {
                        JSONArray array = response.optJSONArray("adcode");
                        assert array != null;
                        adcode = array.optString(0, "310000");
                    }
                    requestWeatherCallback(adcode);
                },
                error -> {
                    Context context = getApplicationContext();
                    Toast.makeText(context, "发生错误", Toast.LENGTH_SHORT).show();
                });
        requestQueue.add(request);
    }

    private void requestWeatherCallback(String adcode) {
        String url = "https://restapi.amap.com/v3/weather/weatherInfo?key=f831d99aa8eb23ded9af607cbf2b7a86&city=" + adcode + "&extensions=base";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    weather = new HashMap<>();
                    JSONObject jsonObject = response.optJSONArray("lives").optJSONObject(0);
                    assert jsonObject != null;
                    Log.e("j", jsonObject.toString());
                    weather.put("weather", jsonObject.optString("weather", ""));
                    weather.put("temperature", jsonObject.optString("temperature", ""));
                    weather.put("winddirection", jsonObject.optString("winddirection", ""));
                    weather.put("humidity", jsonObject.optString("humidity", ""));
                },
                error -> {
                    Context context = getApplicationContext();
                    Log.e("error", error.getMessage());
                    Toast.makeText(context, "发生错误", Toast.LENGTH_SHORT).show();
                });
        requestQueue.add(request);
    }

    public Map<String, String> getWeather() {
        return weather;
    }
}
