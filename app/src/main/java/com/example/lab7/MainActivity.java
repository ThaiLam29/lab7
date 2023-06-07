package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.thailam.lab7.R;

public class MainActivity extends AppCompatActivity {
    TextView txt_welcome;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_welcome=(TextView) findViewById(R.id.tv_welcome);
        logo=(ImageView) findViewById(R.id.logo);
        Animation animation= AnimationUtils.loadAnimation(this, R.anim.style1);
        txt_welcome.startAnimation(animation);
        logo.startAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(MainActivity.this, Login.class);
                startActivity(intent);
                finish();
            }
        },3000);



    }
}