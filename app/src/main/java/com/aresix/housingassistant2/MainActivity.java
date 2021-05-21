package com.aresix.housingassistant2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    private final static String prefName = "MyInfo";

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
}
