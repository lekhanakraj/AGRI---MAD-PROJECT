package com.example.agri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.SplashScreen;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class introductory extends AppCompatActivity {
    private static int SPLASH_SCREEN = 5000 ;
       TextView textView ;
       LottieAnimationView lottieAnimationView;
       Animation topAnim , bottomAnim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        textView=findViewById(R.id.textView2);
        lottieAnimationView=findViewById(R.id.lottie);


        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animaton);
        bottomAnim=AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        lottieAnimationView.setAnimation(topAnim);
        textView.setAnimation(bottomAnim);
        textView.animate().translationX(-1700).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationX(1700).setDuration(1000).setStartDelay(4000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(introductory.this,dashboard.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }
}