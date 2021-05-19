package com.aresix.housingassistant2.ui.children_activity.outdoors;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.aresix.housingassistant2.R;

/** 户外运动activity **/
public class OutdoorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outdoors);

        /** 消除activity顶部状态框 **/
        if (getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.outdoors_fragment_container, OutdoorsFragment.class, null)
                .commit();
    }
}
