//package com.hucker.hucker;
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.content.pm.ActivityInfo;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//
///**
// * Created by aldor on 02.02.2018.
// */
//
//public class LoginScreen extends AppCompatActivity {
//    private EditText name;
//    private EditText password;
//    private Button login_button;
//    private Button sign_up_button;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.activity_login);
//
//        hideStatusBar();
//        initializeControls();
//    }
//
//    private void hideStatusBar(){
//        View decorView = getWindow().getDecorView();
//        // Hide the status bar.
//        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
//        decorView.setSystemUiVisibility(uiOptions);
//    }
//
//    private void initializeControls(){
//        name = findViewById(R.id.Name);
//        password = findViewById(R.id.Password);
//        login_button = findViewById(R.id.login_button);
//        sign_up_button = findViewById(R.id.sign_up_button);
//
//        login_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if((name.getText().toString().equals("123")) && (password.getText().toString().equals("123"))){
//                  //  name.setText("Logined");
//                    callMainActivityScreen();
//                } else {
//                    name.setText("Wrong name or pass");
//                }
//            }
//        });
//
//        sign_up_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                callSignUpScreen();
//            }
//        });
//    }
//
//    private void callMainActivityScreen(){
//        final Intent intent = new Intent(this, MainActivity.class);
//        Thread callMainActivity = new Thread(){
//            public void run(){
//                startActivity(intent);
//                finish();
//            }
//        };
//        callMainActivity.start();
//    }
//
//
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
//}
