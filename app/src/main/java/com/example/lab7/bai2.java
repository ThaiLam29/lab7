package com.example.lab7;

import static com.google.android.material.animation.AnimationUtils.lerp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.thailam.lab7.R;

public class bai2 extends AppCompatActivity {
    TextView txt_fast, txt_medium, txt_slow, txt_off;
    ImageView tmg_quat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);

        txt_fast= (TextView) findViewById(R.id.txt_fast);
        txt_medium=(TextView) findViewById(R.id.txt_medium);
        txt_slow=(TextView) findViewById(R.id.txt_slow);
        txt_off=(TextView) findViewById(R.id.txt_off);
        tmg_quat=(ImageView) findViewById(R.id.canhquat);

        txt_fast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFan(200);
            }
        });
        txt_medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFan(1000);
            }
        });
        txt_slow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFan(1500);
            }
        });
        txt_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopFan();
            }
        });



    }
    private void startFan(long time){
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                tmg_quat.animate()
                        .rotationBy(360)
                        .withEndAction(this)
                        .setDuration(time)
                        .setInterpolator(new LinearInterpolator())
                        .start();
            }
        };
        tmg_quat.animate()
                .rotationBy(360)
                .withEndAction(runnable)
                .setDuration(time)
                .setInterpolator(new LinearInterpolator())
                .start();;
    }
    private void stopFan(){
        tmg_quat.animate().cancel();
    }

}