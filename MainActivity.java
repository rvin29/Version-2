package com.example.erovoutika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imglogo;
    Animation top;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

/*
        imglogo = (ImageView)findViewById(R.id.img_logo);

        top = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.logoanimation);

        imglogo.setAnimation(top);
*/

    new Handler().postDelayed(new Runnable() {
         @Override
         public void run() {
             Intent intent = new Intent(MainActivity.this, Dashboard.class);
             startActivity(intent);
         }
     }, 2000);

    }


}