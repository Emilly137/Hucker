package com.hucker.hucker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class StartLoadingMenu extends AppCompatActivity {
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
        setContentView(R.layout.activity_start_loading_menu);

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

        final Intent intent = new Intent(this, LoginScreen.class);
        Thread callNextScreen = new Thread(){
            public void run(){
                try{
                    sleep(3500);
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
