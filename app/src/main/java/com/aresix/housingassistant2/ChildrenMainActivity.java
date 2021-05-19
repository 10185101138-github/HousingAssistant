package com.aresix.housingassistant2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ChildrenMainActivity extends AppCompatActivity {

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
