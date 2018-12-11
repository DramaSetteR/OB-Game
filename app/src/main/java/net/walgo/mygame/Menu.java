package net.walgo.mygame;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

public class Menu extends OBoard {
    private ImageView darlingcross, obgame, farewell, darlingcrosssoon, obgamepresed, farewellpressed, spaceship1, spaceship2;
    private Switch switch1;
    private MediaPlayer mp;
    private AudioManager mAudioManager;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            return true;
        }

        return false;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        darlingcross = findViewById(R.id.darlingcross);
        darlingcrosssoon = findViewById(R.id.darlingcrosssoon);
        obgame = findViewById(R.id.obgame);
        obgamepresed = findViewById(R.id.obgamepressed);
        farewell = findViewById(R.id.farewell);
        farewellpressed = findViewById(R.id.farewellpressed);

        spaceship1 = findViewById(R.id.spaceship);
        spaceship2 = findViewById(R.id.spaceship2);

        switch1 = findViewById(R.id.switch1);
        mp=MediaPlayer.create(this, R.raw.biospherepoaalpina);


        darlingcross.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        darlingcrosssoon.setVisibility(View.VISIBLE);
                        spaceship();
                        break;
                    case MotionEvent.ACTION_UP:

                        float x, y;
                        x = spaceship1.getX();
                        y = spaceship1.getY();
                        spaceship2.setX(x);
                        spaceship2.setY(y);

                        darlingcrosssoon.setVisibility(View.INVISIBLE);
                    default:


                }
                return true;


            }
        });

        obgame.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        obgamepresed.setVisibility(View.VISIBLE);
                        spaceship();

                        break;
                    case MotionEvent.ACTION_UP:

                        float x, y;
                        x = spaceship1.getX();
                        y = spaceship1.getY();
                        spaceship2.setX(x);
                        spaceship2.setY(y);

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(Menu.this, OBoard.class));
                            }
                        }, 1000);

                        obgamepresed.setVisibility(View.INVISIBLE);
                        break;

                    default:


                }
                return true;


            }
        });

        farewell.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        farewellpressed.setVisibility(View.VISIBLE);
                        break;
                    case MotionEvent.ACTION_UP:
                        farewellpressed.setVisibility(View.VISIBLE);
                        moveTaskToBack(true);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(0);
                    default:


                }
                return true;


            }
        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mp.start();
                }
                else
                    mp.pause();

            }
        });


    }

    private void spaceship() {

        float x, y;
        x = spaceship1.getX();
        y = spaceship1.getY();
        spaceship2.animate().x(x).y(y).setDuration(900).start();
    }

}
