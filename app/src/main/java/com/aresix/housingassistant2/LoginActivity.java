package com.aresix.housingassistant2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.SurfaceControl;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aresix.housingassistant2.ui.login.SignInFragment;
import com.aresix.housingassistant2.ui.login.SignUpFragment;

/** login界面 **/
public class LoginActivity extends AppCompatActivity {

    private final static String prefName = "MyInfo";

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

    public boolean checkSignUpInfo(String mUserName, String mUserPassword, String mUserConfirmPassword) {
        Context context = getApplicationContext();
        if (mUserName == null || "".equals(mUserName)) {
            Toast.makeText(context, "请输入用户名", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (mUserPassword == null || "".equals(mUserPassword) ||
                mUserConfirmPassword == null || "".equals(mUserConfirmPassword)) {
            Toast.makeText(context, "请输入密码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!mUserPassword.equals(mUserConfirmPassword)) {
            Toast.makeText(context, "两次输入的密码不一致", Toast.LENGTH_SHORT).show();
            return false;
        }
        Toast.makeText(context, "注册成功, 请登录", Toast.LENGTH_SHORT).show();
        return true;
    }

    @SuppressLint("CommitPrefEdits")
    public void saveInfo(String mUserName, String mUserPassword) {
        SharedPreferences userInfo = getSharedPreferences(prefName, MODE_PRIVATE);
        SharedPreferences.Editor editor = userInfo.edit();
        editor.putString("username", mUserName);
        editor.putString("password", mUserPassword);
        editor.commit();
    }

    public boolean checkSignInInfo(String mUserName, String mUserPassword) {
        Context context = getApplicationContext();
        assert context != null;
        SharedPreferences userInfo = getSharedPreferences(prefName, MODE_PRIVATE);
        String username = userInfo.getString("username", "");
        String password = userInfo.getString("password", "");
        if (username == null || "".equals(username)) {
            Toast.makeText(context, "请先注册", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!username.equals(mUserName)) {
            Toast.makeText(context, "用户名错误", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!password.equals(mUserPassword)) {
            Toast.makeText(context, "密码错误", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public Integer getMode() {
        SharedPreferences userInfo = getSharedPreferences(prefName, MODE_PRIVATE);
        return userInfo.getInt("mode", 0);
    }

    public Integer getUserHead() {
        SharedPreferences userInfo = getSharedPreferences(prefName, MODE_PRIVATE);
        return userInfo.getInt("head", 0);
    }
}
