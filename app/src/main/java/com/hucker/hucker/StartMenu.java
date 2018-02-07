
package com.hucker.hucker;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import java.util.Collections;

public class StartMenu extends AppCompatActivity {
    ConstraintLayout StartMenuScreen;
    Button login_withFB_button;
    Button loginButton;
    Button sign_upButton;
    EditText login;
    EditText password;

    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start_menu);
        FacebookSdk.sdkInitialize(this.getApplicationContext());

        hideStatusBar();
        initializeControls();
        loginWithFB();
    }

    private void hideStatusBar(){
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initializeControls() {
        StartMenuScreen = findViewById(R.id.StartMenuScreen);
        callbackManager = CallbackManager.Factory.create();
        login_withFB_button = findViewById(R.id.login_FB_button);
        loginButton = findViewById(R.id.login_button);
        sign_upButton = findViewById(R.id.forgot_password_Button);

        login_withFB_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginManager.getInstance().logInWithReadPermissions(StartMenu.this, Collections.singletonList("public_profile"));
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callMainScreen();
            }
        });

//
//        sign_upButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //callSignUpScreen();
//            }
//        });


        StartMenuScreen.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        hideStatusBar();
                        break;
                }
                return true;
            }
        });

    }

///////////////////////////////////////////LOGIN FACEBOOK///////////////////////////////////////////////////////////////////////////////////////////

    private void loginWithFB(){

        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

            }

            @Override
            public void onCancel() {
                Toast.makeText(StartMenu.this, "Login Cancel", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(FacebookException exception) {
                Toast.makeText(StartMenu.this, exception.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        ///
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }


///// /////////////////////////////////////////////////CALL OPERATION////////////////////////////////////////////////////////////////////////////////
    private void callMainScreen(){
        final Intent intent = new Intent(this, MainActivity.class);
        Thread callMainScreen = new Thread(){
            public void run(){
                startActivity(intent);
                finish();
            }
        };
        callMainScreen.start();
    }

//    private void callSignUpScreen(){
//        final Intent intent = new Intent(this, SignUpScreen.class);
//        Thread callSignUpScreen = new Thread(){
//            public void run(){
//                startActivity(intent);
//                finish();
//            }
//        };
//        callSignUpScreen.start();
//    }

}