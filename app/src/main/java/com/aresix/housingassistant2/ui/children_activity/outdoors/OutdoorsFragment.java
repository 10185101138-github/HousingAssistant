package com.aresix.housingassistant2.ui.children_activity.outdoors;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.aresix.housingassistant2.R;

public class OutdoorsFragment extends Fragment {

    private CardView mOutdoorsCardView1;
    private CardView mOutdoorsCardView2;
    private CardView mOutdoorsCardView3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_children_activity_outdoors, container, false);

        mOutdoorsCardView1 = (CardView) view.findViewById(R.id.outdoors_card_view1);
        mOutdoorsCardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(getContext())
                        .setTitle(R.string.outdoors_card1)
                        .setMessage(R.string.outdoors_card1_content)
                        .setPositiveButton("确定", null)
                        .create();
                dialog.show();
            }
        });

        mOutdoorsCardView2 = (CardView) view.findViewById(R.id.outdoors_card_view2);
        mOutdoorsCardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(getContext())
                        .setTitle(R.string.outdoors_card2)
                        .setMessage(R.string.outdoors_card2_content)
                        .setPositiveButton("确定", null)
                        .create();
                dialog.show();
            }
        });

        mOutdoorsCardView3 = (CardView) view.findViewById(R.id.outdoors_card_view3);
        mOutdoorsCardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(getContext())
                        .setTitle(R.string.outdoors_card3)
                        .setMessage(R.string.outdoors_card3_content)
                        .setPositiveButton("确定", null)
                        .create();
                dialog.show();
            }
        });

        return view;
    }
}
