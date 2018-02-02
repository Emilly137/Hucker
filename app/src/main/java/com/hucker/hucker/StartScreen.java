package com.hucker.hucker;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class StartScreen extends AppCompatActivity {
    private TextView textEmail;
    private TextView textVersion;
    private TextView textTop;
    private TextView textMid;
    private TextView textBot;
    private ImageView imageLogo;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        hideStatusBar();
        startAnim();
        callNextScreen();
    }

    private void startAnim(){
        textEmail = findViewById(R.id.textEmail);
        textVersion = findViewById(R.id.textVersion);
        textTop = findViewById(R.id.textTop);
        textMid = findViewById(R.id.textMid);
        textBot = findViewById(R.id.textBot);
        imageLogo = findViewById(R.id.imageLogo);
        progressBar = findViewById(R.id.progressBar);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.first_screen_anim);

        textEmail.startAnimation(animation);
        textVersion.startAnimation(animation);
        textTop.startAnimation(animation);
        textMid.startAnimation(animation);
        textBot.startAnimation(animation);
        imageLogo.startAnimation(animation);
        progressBar.startAnimation(animation);
    }

    private void hideStatusBar(){
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    private void callNextScreen(){
        final Intent intent = new Intent(this, StartMenu.class);
        Thread callNextScreen = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                }catch (InterruptedException ie){
                    ie.printStackTrace();
                } finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        callNextScreen.start();
    }
}
