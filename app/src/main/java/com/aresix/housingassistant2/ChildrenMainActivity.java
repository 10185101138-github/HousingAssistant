package com.aresix.housingassistant2;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ChildrenMainActivity extends MainActivity {

    private final static String prefName = "MyInfo";

    private Integer age = 0;
    private Float height = 0f;
    private Float weight = 0f;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children_main);
        BottomNavigationView navView = findViewById(R.id.children_nav_view);
        
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.children_navigation_shelter,
                R.id.children_navigation_food,
                R.id.children_navigation_activity,
                R.id.children_navigation_record)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.children_nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }
}
