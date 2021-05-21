package com.aresix.housingassistant2.ui.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login_sign_up, container, false);

        mUserName = (TextView) view.findViewById(R.id.sign_up_user_name);
        mUserName.setText("");

        mUserPassword = (TextView) view.findViewById(R.id.sign_up_user_password);
        mUserPassword.setText("");

        mUserConfirmPassword = (TextView) view.findViewById(R.id.sign_up_confirm_password);
        mUserConfirmPassword.setText("");

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
        return view;
    }
}
