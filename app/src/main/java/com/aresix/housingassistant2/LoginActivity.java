package com.aresix.housingassistant2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.SurfaceControl;
import android.view.View;
import android.widget.Button;

import com.aresix.housingassistant2.ui.login.SignInFragment;
import com.aresix.housingassistant2.ui.login.SignUpFragment;

/** login界面 **/
public class LoginActivity extends AppCompatActivity {

    private SignInFragment mSignInFragment;
    private SignUpFragment mSignUpFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        beginWithSignIn();
    }

    /** 启动页面 **/
    private void beginWithSignIn() {

        mSignInFragment = new SignInFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction
                .add(R.id.login_fragment_container, mSignInFragment, null)
                .commit();
    }

    /** 切换至登录界面 **/
    public void switchToSignIn() {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (mSignInFragment == null) {
            mSignInFragment = new SignInFragment();
            transaction
                    .hide(mSignUpFragment)
                    .add(R.id.login_fragment_container, mSignInFragment, null)
                    .commit();
        } else {
            transaction
                    .hide(mSignUpFragment)
                    .show(mSignInFragment)
                    .commit();

        }
    }

    /** 切换至注册界面**/
    public void switchToSignUp() {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (mSignUpFragment == null) {
            mSignUpFragment = new SignUpFragment();
            transaction
                    .hide(mSignInFragment)
                    .add(R.id.login_fragment_container, mSignUpFragment, null)
                    .commit();
        } else {
            transaction
                    .hide(mSignInFragment)
                    .show(mSignUpFragment)
                    .commit();
        }
    }
}
