package net.walgo.mygame;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class Splash extends OBoard {



    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView image = findViewById(R.id.starimg);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(Splash.this, OBoard.class));
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        }, 2000);

        image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:

                        break;
                    case MotionEvent.ACTION_UP:

                        startActivity(new Intent(Splash.this, OBoard.class));
                        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                        break;

                    default:


                }
                return true;


            }
        });

    }
}
