package com.aresix.housingassistant2.ui.children_activity.indoors;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.aresix.housingassistant2.R;

public class IndoorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indoors);

        if (getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.indoors_fragment_container, IndoorsFragment.class, null)
                .commit();
    }
}
