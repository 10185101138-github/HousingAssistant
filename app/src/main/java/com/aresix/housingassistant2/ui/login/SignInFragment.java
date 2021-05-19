package com.aresix.housingassistant2.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.aresix.housingassistant2.LoginActivity;
import com.aresix.housingassistant2.MainActivity;
import com.aresix.housingassistant2.R;

import java.security.Signer;

/** 登录 **/
public class SignInFragment extends Fragment {

    private TextView mUserName;
    private TextView mUserPassword;
    private Button mSignIn;
    private Button mSignUp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login_sign_in, container, false);

        mUserName = (TextView) view.findViewById(R.id.sign_in_user_name);
        mUserName.setText(R.string.user_name);

        mUserPassword = (TextView) view.findViewById(R.id.sign_in_user_password);
        mUserPassword.setText(R.string.password);

        /** 登录按钮 **/
        mSignIn = (Button) view.findViewById(R.id.sign_in_signInButton);
        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        /** 注册按钮 **/
        mSignUp = (Button) view.findViewById(R.id.sign_in_signUpButton);
        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity activity = (LoginActivity) getActivity();
                activity.switchToSignUp();
            }
        });

        return view;
    }
}
