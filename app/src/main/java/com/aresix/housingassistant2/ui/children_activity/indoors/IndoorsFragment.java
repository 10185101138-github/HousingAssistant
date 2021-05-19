package com.aresix.housingassistant2.ui.children_activity.indoors;

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

public class IndoorsFragment extends Fragment {

    private CardView mIndoorsCardView1;
    private CardView mIndoorsCardView2;
    private CardView mIndoorsCardView3;
    private CardView mIndoorsCardView4;
    private CardView mIndoorsCardView5;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_children_activity_indoors, container, false);

        mIndoorsCardView1 = (CardView) view.findViewById(R.id.indoors_card_view1);
        mIndoorsCardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(getContext())
                        .setTitle(R.string.indoors_card1)
                        .setMessage(R.string.indoors_card1_content)
                        .setPositiveButton("确定", null)
                        .create();
                dialog.show();
            }
        });

        mIndoorsCardView2 = (CardView) view.findViewById(R.id.indoors_card_view2);
        mIndoorsCardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(getContext())
                        .setTitle(R.string.indoors_card2)
                        .setMessage(R.string.indoors_card2_content)
                        .setPositiveButton("确定", null)
                        .create();
                dialog.show();
            }
        });

        mIndoorsCardView3 = (CardView) view.findViewById(R.id.indoors_card_view3);
        mIndoorsCardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(getContext())
                        .setTitle(R.string.indoors_card3)
                        .setMessage(R.string.indoors_card3_content)
                        .setPositiveButton("确定", null)
                        .create();
                dialog.show();
            }
        });

        mIndoorsCardView4 = (CardView) view.findViewById(R.id.indoors_card_view4);
        mIndoorsCardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(getContext())
                        .setTitle(R.string.indoors_card4)
                        .setMessage(R.string.indoors_card4_content)
                        .setPositiveButton("确定", null)
                        .create();
                dialog.show();
            }
        });

        mIndoorsCardView5 = (CardView) view.findViewById(R.id.indoors_card_view5);
        mIndoorsCardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(getContext())
                        .setTitle(R.string.indoors_card5)
                        .setMessage(R.string.indoors_card5_content)
                        .setPositiveButton("确定", null)
                        .create();
                dialog.show();
            }
        });

        return view;
    }
}
