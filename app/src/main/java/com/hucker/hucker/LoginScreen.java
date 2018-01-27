package com.hucker.hucker;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import java.util.Arrays;




public class LoginScreen extends AppCompatActivity {

    TextView textView;
    Button login_withFB_button;

    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        hideStatusBar();

        login_withFB_button = (Button) findViewById(R.id.login_FB_button);

        FacebookSdk.sdkInitialize(this.getApplicationContext());
        initializeCotrols();
        loginWithFB();
    }

    private void hideStatusBar(){
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }


    private void initializeCotrols(){
        callbackManager = CallbackManager.Factory.create();
        login_withFB_button = findViewById(R.id.login_FB_button);
        login_withFB_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginManager.getInstance().logInWithReadPermissions(LoginScreen.this, Arrays.asList("public_profile"));
            }
        });

        textView = findViewById(R.id.textView2);
    }


    private void loginWithFB(){

        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                textView.setText("Login Success\n" + loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Toast.makeText(LoginScreen.this, "Login Cancel", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(FacebookException exception) {
                Toast.makeText(LoginScreen.this, exception.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
