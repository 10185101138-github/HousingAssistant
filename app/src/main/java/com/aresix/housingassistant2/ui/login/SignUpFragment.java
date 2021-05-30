package com.aresix.housingassistant2.ui.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aresix.housingassistant2.LoginActivity;
import com.aresix.housingassistant2.R;

/** 注册 **/
public class SignUpFragment extends Fragment {

    private TextView mUserName;
    private TextView mUserPassword;
    private TextView mUserConfirmPassword;

    private Button mSignIn;

    private ImageView mUserHead;

    @SuppressLint("ResourceType")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login_sign_up, container, false);

        mUserName = (TextView) view.findViewById(R.id.sign_up_user_name);

        mUserPassword = (TextView) view.findViewById(R.id.sign_up_user_password);

        mUserConfirmPassword = (TextView) view.findViewById(R.id.sign_up_confirm_password);

        mSignIn = (Button) view.findViewById(R.id.sign_up_signInButton);
        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity activity = (LoginActivity) getActivity();
                assert activity != null;
                if (!activity.checkSignUpInfo(
                        mUserName.getText().toString(),
                        mUserPassword.getText().toString(),
                        mUserConfirmPassword.getText().toString())) {
                    return;
                }
                activity.saveInfo(
                        mUserName.getText().toString(),
                        mUserPassword.getText().toString());
                activity.switchToSignIn();
            }
        });

        LoginActivity activity = (LoginActivity) getActivity();
        mUserHead = (ImageView) view.findViewById(R.id.roundImageView3);
        assert activity != null;
        Integer head = activity.getUserHead();
        if (head == 0) {
            mUserHead.setImageResource(R.drawable.avatar2);
        } else if (head == 1) {
            mUserHead.setImageResource(R.drawable.avatar3);
        } else if (head == 2) {
            mUserHead.setImageResource(R.drawable.avatar4);
        } else if (head == 3) {
            mUserHead.setImageResource(R.drawable.avatar5);
        }
        return view;
    }
}
