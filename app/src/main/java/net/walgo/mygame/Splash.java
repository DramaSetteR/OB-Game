package net.walgo.mygame;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends OBoard {




private ImageView img1;
    public void startFadeInAnimation() {
        img1= findViewById(R.id.starimg);
        Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
        img1.startAnimation(startAnimation);

    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startFadeInAnimation();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash.this, Menu.class));
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        }, 1500);

        img1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        startActivity(new Intent(Splash.this, Menu.class));
                        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                        break;
                    case MotionEvent.ACTION_UP:


                        break;

                    default:


                }
                return true;


            }
        });



    }
}
