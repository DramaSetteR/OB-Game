package net.walgo.mygame;


import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class OBoard extends AppCompatActivity {

    private ImageView b_circle1;
    private ImageView b_circle2;
    private ImageView b_circle3;
    private ImageView b_clone;

    private ImageView o_circle1;
    private ImageView o_circle2;
    private ImageView o_circle3;
    private ImageView o_clone;

    private ImageView loc1;
    private ImageView loc2;
    private ImageView loc3;
    private ImageView loc4;
    private ImageView loc5;
    private ImageView loc6;
    private ImageView loc7;
    private ImageView loc8;
    private ImageView loc9;

    private ImageView oturn, bturn;
    private float blueXCoordinate, blueYCoordinate;
    private float orangeXCoordinate, orangeYCoordinate;

    private float c1, c2, c3, c4, c5, c6, c8, c9, c7;
    private float orangeF1, orangeF2, orangeF3, blueF1, blueF2, blueF3;

    private TextView wintext;
    private MediaPlayer down, click;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oboard);
        final Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        click = MediaPlayer.create(this, R.raw.butclick);
        down = MediaPlayer.create(this, R.raw.butdown);

        b_circle1 = findViewById(R.id.b_circle1);
        b_circle2 = findViewById(R.id.b_circle2);
        b_circle3 = findViewById(R.id.b_circle3);
        o_circle1 = findViewById(R.id.o_circle1);
        o_circle2 = findViewById(R.id.o_circle2);
        o_circle3 = findViewById(R.id.o_circle3);
        loc1 = findViewById(R.id.loc1);
        loc2 = findViewById(R.id.loc2);
        loc3 = findViewById(R.id.loc3);
        loc4 = findViewById(R.id.loc4);
        loc5 = findViewById(R.id.loc5);
        loc6 = findViewById(R.id.loc6);
        loc7 = findViewById(R.id.loc7);
        loc8 = findViewById(R.id.loc8);
        loc9 = findViewById(R.id.loc9);
        wintext = findViewById(R.id.wintext);
        oturn = findViewById(R.id.oturn);
        bturn = findViewById(R.id.bturn);

        setparams();
        randomTurn();

        b_circle1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                click.start();
                o_clone = null;
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        gaqroba2();
                        Coordinates();
                        b_clone = findViewById(R.id.b_circle1);

                    case MotionEvent.ACTION_UP:
                        BlueState();
                        break;

                    default:

                }

                return true;

            }


        });


        b_circle2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                click.start();
                o_clone = null;
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        gaqroba2();
                        Coordinates();
                        b_clone = findViewById(R.id.b_circle2);

                    case MotionEvent.ACTION_UP:
                        BlueState();
                        break;

                    default:


                }
                return true;
            }
        });

        b_circle3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                click.start();
                o_clone = null;
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        gaqroba2();
                        Coordinates();
                        b_clone = findViewById(R.id.b_circle3);

                    case MotionEvent.ACTION_UP:
                        BlueState();
                        break;

                    default:


                }
                return true;
            }
        });

        o_circle1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                click.start();
                b_clone = null;
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:

                        gaqroba2();
                        Coordinates();
                        o_clone = findViewById(R.id.o_circle1);

                    case MotionEvent.ACTION_UP:
                        OrangeState();
                        break;

                    default:


                }
                return true;
            }
        });

        o_circle2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                click.start();
                b_clone = null;
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        gaqroba2();

                        Coordinates();
                        o_clone = findViewById(R.id.o_circle2);

                    case MotionEvent.ACTION_UP:
                        OrangeState();
                        break;

                    default:


                }
                return true;
            }
        });

        o_circle3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                click.start();
                b_clone = null;
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        gaqroba2();
                        Coordinates();
                        o_clone = findViewById(R.id.o_circle3);

                    case MotionEvent.ACTION_UP:
                        OrangeState();
                        break;

                    default:

                }
                return true;
            }
        });


        loc1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                down.start();
                gaqroba2();
                if (b_clone == b_circle1 || b_clone == b_circle2 || b_clone == b_circle3) {
                    blueXCoordinate = loc1.getX();
                    blueYCoordinate = loc1.getY();
                    switch (event.getActionMasked()) {
                        case MotionEvent.ACTION_DOWN:

                            try {
                                b_clone.animate().x(blueXCoordinate).y(blueYCoordinate).setDuration(300).start();
                            } catch (Exception e) {
                                wintext.setText(R.string.warning);
                            }
                            b_clone.setX(blueXCoordinate);
                            b_clone.setY(blueYCoordinate);
                            b_clone = null;

                            figuresXY();


                        case MotionEvent.ACTION_UP:

                            CheckBlue();
                            oturn.setVisibility(View.VISIBLE);
                            bturn.setVisibility(View.INVISIBLE);
                            break;
                        default:

                            break;

                    }
                } else if (o_clone == o_circle1 || o_clone == o_circle2 || o_clone == o_circle3) {
                    orangeXCoordinate = loc1.getX();
                    orangeYCoordinate = loc1.getY();
                    switch (event.getActionMasked()) {
                        case MotionEvent.ACTION_DOWN:
                            try {
                                o_clone.animate().x(orangeXCoordinate).y(orangeYCoordinate).setDuration(300).start();
                            } catch (Exception e) {
                                wintext.setText(R.string.warning);
                            }
                            o_clone.setX(orangeXCoordinate);
                            o_clone.setY(orangeYCoordinate);
                            o_clone = null;
                            figuresXY();

                        case MotionEvent.ACTION_UP:
                            CheckOrange();
                            oturn.setVisibility(View.INVISIBLE);
                            bturn.setVisibility(View.VISIBLE);
                            break;

                        default:

                            break;

                    }

                }
                return true;

            }
        });


        loc2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                down.start();
                gaqroba2();
                if (b_clone == b_circle1 || b_clone == b_circle2 || b_clone == b_circle3) {
                    blueXCoordinate = loc2.getX();
                    blueYCoordinate = loc2.getY();

                    switch (event.getActionMasked()) {
                        case MotionEvent.ACTION_DOWN:

                            try {
                                b_clone.animate().x(blueXCoordinate).y(blueYCoordinate).setDuration(300).start();
                            } catch (Exception e) {
                                wintext.setText(R.string.warning);
                            }
                            b_clone.setX(blueXCoordinate);
                            b_clone.setY(blueYCoordinate);
                            b_clone = null;

                            figuresXY();


                        case MotionEvent.ACTION_UP:
                            CheckBlue();
                            oturn.setVisibility(View.VISIBLE);
                            bturn.setVisibility(View.INVISIBLE);
                            break;
                        default:

                            break;

                    }
                } else if (o_clone == o_circle1 || o_clone == o_circle2 || o_clone == o_circle3) {
                    orangeXCoordinate = loc2.getX();
                    orangeYCoordinate = loc2.getY();
                    switch (event.getActionMasked()) {
                        case MotionEvent.ACTION_DOWN:
                            try {
                                o_clone.animate().x(orangeXCoordinate).y(orangeYCoordinate).setDuration(300).start();
                            } catch (Exception e) {
                                wintext.setText(R.string.warning);
                            }
                            o_clone.setX(orangeXCoordinate);
                            o_clone.setY(orangeYCoordinate);
                            o_clone = null;
                            figuresXY();

                        case MotionEvent.ACTION_UP:
                            CheckOrange();
                            oturn.setVisibility(View.INVISIBLE);
                            bturn.setVisibility(View.VISIBLE);
                            break;

                        default:

                            break;

                    }
                }

                return true;
            }
        });

        loc3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                down.start();
                gaqroba2();
                if (b_clone == b_circle1 || b_clone == b_circle2 || b_clone == b_circle3) {
                    blueXCoordinate = loc3.getX();
                    blueYCoordinate = loc3.getY();
                    switch (event.getActionMasked()) {
                        case MotionEvent.ACTION_DOWN:

                            try {
                                b_clone.animate().x(blueXCoordinate).y(blueYCoordinate).setDuration(300).start();
                            } catch (Exception e) {
                                wintext.setText(R.string.warning);
                            }
                            b_clone.setX(blueXCoordinate);
                            b_clone.setY(blueYCoordinate);
                            b_clone = null;

                            figuresXY();

                        case MotionEvent.ACTION_UP:
                            CheckBlue();
                            oturn.setVisibility(View.VISIBLE);
                            bturn.setVisibility(View.INVISIBLE);
                            break;
                        default:

                            break;

                    }
                } else if (o_clone == o_circle1 || o_clone == o_circle2 || o_clone == o_circle3) {
                    orangeXCoordinate = loc3.getX();
                    orangeYCoordinate = loc3.getY();
                    switch (event.getActionMasked()) {
                        case MotionEvent.ACTION_DOWN:
                            try {
                                o_clone.animate().x(orangeXCoordinate).y(orangeYCoordinate).setDuration(300).start();
                            } catch (Exception e) {
                                wintext.setText(R.string.warning);
                            }
                            o_clone.setX(orangeXCoordinate);
                            o_clone.setY(orangeYCoordinate);
                            o_clone = null;
                            figuresXY();

                        case MotionEvent.ACTION_UP:
                            CheckOrange();
                            oturn.setVisibility(View.INVISIBLE);
                            bturn.setVisibility(View.VISIBLE);
                            break;

                        default:

                            break;

                    }
                }
                return true;
            }
        });

        loc4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                down.start();
                gaqroba2();
                if (b_clone == b_circle1 || b_clone == b_circle2 || b_clone == b_circle3) {
                    blueXCoordinate = loc4.getX();
                    blueYCoordinate = loc4.getY();
                    switch (event.getActionMasked()) {
                        case MotionEvent.ACTION_DOWN:

                            try {
                                b_clone.animate().x(blueXCoordinate).y(blueYCoordinate).setDuration(300).start();
                            } catch (Exception e) {
                                wintext.setText(R.string.warning);
                            }
                            b_clone.setX(blueXCoordinate);
                            b_clone.setY(blueYCoordinate);
                            b_clone = null;

                            figuresXY();


                        case MotionEvent.ACTION_UP:
                            CheckBlue();
                            oturn.setVisibility(View.VISIBLE);
                            bturn.setVisibility(View.INVISIBLE);
                            break;
                        default:

                            break;

                    }
                } else if (o_clone == o_circle1 || o_clone == o_circle2 || o_clone == o_circle3) {
                    orangeXCoordinate = loc4.getX();
                    orangeYCoordinate = loc4.getY();
                    switch (event.getActionMasked()) {
                        case MotionEvent.ACTION_DOWN:
                            try {
                                o_clone.animate().x(orangeXCoordinate).y(orangeYCoordinate).setDuration(300).start();
                            } catch (Exception e) {
                                wintext.setText(R.string.warning);
                            }
                            o_clone.setX(orangeXCoordinate);
                            o_clone.setY(orangeYCoordinate);
                            o_clone = null;
                            figuresXY();

                        case MotionEvent.ACTION_UP:
                            CheckOrange();
                            oturn.setVisibility(View.INVISIBLE);
                            bturn.setVisibility(View.VISIBLE);
                            break;

                        default:

                            break;

                    }
                }

                return true;


            }

        });


        loc5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                down.start();
                gaqroba2();
                if (b_clone == b_circle1 || b_clone == b_circle2 || b_clone == b_circle3) {
                    blueXCoordinate = loc5.getX();
                    blueYCoordinate = loc5.getY();
                    switch (event.getActionMasked()) {
                        case MotionEvent.ACTION_DOWN:

                            try {
                                b_clone.animate().x(blueXCoordinate).y(blueYCoordinate).setDuration(300).start();
                            } catch (Exception e) {
                                wintext.setText(R.string.warning);
                            }
                            b_clone.setX(blueXCoordinate);
                            b_clone.setY(blueYCoordinate);
                            b_clone = null;
                            figuresXY();

                        case MotionEvent.ACTION_UP:
                            CheckBlue();
                            oturn.setVisibility(View.VISIBLE);
                            bturn.setVisibility(View.INVISIBLE);
                            break;
                        default:

                            break;

                    }
                } else if (o_clone == o_circle1 || o_clone == o_circle2 || o_clone == o_circle3) {
                    orangeXCoordinate = loc5.getX();
                    orangeYCoordinate = loc5.getY();
                    switch (event.getActionMasked()) {
                        case MotionEvent.ACTION_DOWN:
                            try {
                                o_clone.animate().x(orangeXCoordinate).y(orangeYCoordinate).setDuration(300).start();
                            } catch (Exception e) {
                                wintext.setText(R.string.warning);
                            }
                            o_clone.setX(orangeXCoordinate);
                            o_clone.setY(orangeYCoordinate);
                            o_clone = null;
                            figuresXY();

                        case MotionEvent.ACTION_UP:
                            CheckOrange();
                            oturn.setVisibility(View.INVISIBLE);
                            bturn.setVisibility(View.VISIBLE);
                            break;

                        default:

                            break;

                    }
                }


                return true;
            }
        });


        loc6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                down.start();
                gaqroba2();
                if (b_clone == b_circle1 || b_clone == b_circle2 || b_clone == b_circle3) {
                    blueXCoordinate = loc6.getX();
                    blueYCoordinate = loc6.getY();
                    switch (event.getActionMasked()) {
                        case MotionEvent.ACTION_DOWN:

                            try {
                                b_clone.animate().x(blueXCoordinate).y(blueYCoordinate).setDuration(300).start();
                            } catch (Exception e) {
                                wintext.setText(R.string.warning);
                            }
                            b_clone.setX(blueXCoordinate);
                            b_clone.setY(blueYCoordinate);
                            b_clone = null;

                            figuresXY();


                        case MotionEvent.ACTION_UP:
                            CheckBlue();
                            oturn.setVisibility(View.VISIBLE);
                            bturn.setVisibility(View.INVISIBLE);
                            break;
                        default:

                            break;

                    }
                } else if (o_clone == o_circle1 || o_clone == o_circle2 || o_clone == o_circle3) {
                    orangeXCoordinate = loc6.getX();
                    orangeYCoordinate = loc6.getY();
                    switch (event.getActionMasked()) {
                        case MotionEvent.ACTION_DOWN:
                            try {
                                o_clone.animate().x(orangeXCoordinate).y(orangeYCoordinate).setDuration(300).start();
                            } catch (Exception e) {
                                wintext.setText(R.string.warning);
                            }
                            o_clone.setX(orangeXCoordinate);
                            o_clone.setY(orangeYCoordinate);
                            o_clone = null;
                            figuresXY();

                        case MotionEvent.ACTION_UP:
                            CheckOrange();
                            oturn.setVisibility(View.INVISIBLE);
                            bturn.setVisibility(View.VISIBLE);
                            break;

                        default:

                            break;

                    }
                }

                return true;
            }
        });

        loc7.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                down.start();
                gaqroba2();
                if (b_clone == b_circle1 || b_clone == b_circle2 || b_clone == b_circle3) {
                    blueXCoordinate = loc7.getX();
                    blueYCoordinate = loc7.getY();
                    switch (event.getActionMasked()) {
                        case MotionEvent.ACTION_DOWN:

                            try {
                                b_clone.animate().x(blueXCoordinate).y(blueYCoordinate).setDuration(300).start();
                            } catch (Exception e) {
                                wintext.setText(R.string.warning);
                            }
                            b_clone.setX(blueXCoordinate);
                            b_clone.setY(blueYCoordinate);
                            b_clone = null;

                            figuresXY();

                        case MotionEvent.ACTION_UP:
                            CheckBlue();
                            oturn.setVisibility(View.VISIBLE);
                            bturn.setVisibility(View.INVISIBLE);
                            break;
                        default:

                            break;

                    }
                } else if (o_clone == o_circle1 || o_clone == o_circle2 || o_clone == o_circle3) {
                    orangeXCoordinate = loc7.getX();
                    orangeYCoordinate = loc7.getY();
                    switch (event.getActionMasked()) {
                        case MotionEvent.ACTION_DOWN:
                            try {
                                o_clone.animate().x(orangeXCoordinate).y(orangeYCoordinate).setDuration(300).start();
                            } catch (Exception e) {
                                wintext.setText(R.string.warning);
                            }
                            o_clone.setX(orangeXCoordinate);
                            o_clone.setY(orangeYCoordinate);
                            o_clone = null;
                            figuresXY();

                        case MotionEvent.ACTION_UP:
                            CheckOrange();
                            oturn.setVisibility(View.INVISIBLE);
                            bturn.setVisibility(View.VISIBLE);
                            break;

                        default:
                            break;
                    }
                }

                return true;
            }
        });

        loc8.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                down.start();
                gaqroba2();
                if (b_clone == b_circle1 || b_clone == b_circle2 || b_clone == b_circle3) {
                    blueXCoordinate = loc8.getX();
                    blueYCoordinate = loc8.getY();
                    switch (event.getActionMasked()) {
                        case MotionEvent.ACTION_DOWN:

                            try {
                                b_clone.animate().x(blueXCoordinate).y(blueYCoordinate).setDuration(300).start();
                            } catch (Exception e) {
                                wintext.setText(R.string.warning);
                            }
                            b_clone.setX(blueXCoordinate);
                            b_clone.setY(blueYCoordinate);
                            b_clone = null;

                            figuresXY();


                        case MotionEvent.ACTION_UP:
                            CheckBlue();
                            oturn.setVisibility(View.VISIBLE);
                            bturn.setVisibility(View.INVISIBLE);
                            break;
                        default:

                            break;

                    }
                } else if (o_clone == o_circle1 || o_clone == o_circle2 || o_clone == o_circle3) {
                    orangeXCoordinate = loc8.getX();
                    orangeYCoordinate = loc8.getY();
                    switch (event.getActionMasked()) {
                        case MotionEvent.ACTION_DOWN:
                            try {
                                o_clone.animate().x(orangeXCoordinate).y(orangeYCoordinate).setDuration(300).start();
                            } catch (Exception e) {
                                wintext.setText(R.string.warning);
                            }
                            o_clone.setX(orangeXCoordinate);
                            o_clone.setY(orangeYCoordinate);
                            o_clone = null;
                            figuresXY();

                        case MotionEvent.ACTION_UP:
                            CheckOrange();
                            oturn.setVisibility(View.INVISIBLE);
                            bturn.setVisibility(View.VISIBLE);
                            break;

                        default:

                            break;

                    }
                }

                return true;
            }
        });

        loc9.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                down.start();
                gaqroba2();
                if (b_clone == b_circle1 || b_clone == b_circle2 || b_clone == b_circle3) {
                    blueXCoordinate = loc9.getX();
                    blueYCoordinate = loc9.getY();
                    switch (event.getActionMasked()) {
                        case MotionEvent.ACTION_DOWN:

                            try {
                                b_clone.animate().x(blueXCoordinate).y(blueYCoordinate).setDuration(300).start();
                            } catch (Exception e) {
                                wintext.setText(R.string.warning);
                            }
                            b_clone.setX(blueXCoordinate);
                            b_clone.setY(blueYCoordinate);
                            b_clone = null;

                            figuresXY();


                        case MotionEvent.ACTION_UP:
                            CheckBlue();
                            oturn.setVisibility(View.VISIBLE);
                            bturn.setVisibility(View.INVISIBLE);
                            break;
                        default:

                            break;

                    }


                } else if (o_clone == o_circle1 || o_clone == o_circle2 || o_clone == o_circle3) {
                    orangeXCoordinate = loc9.getX();
                    orangeYCoordinate = loc9.getY();
                    switch (event.getActionMasked()) {
                        case MotionEvent.ACTION_DOWN:
                            try {
                                o_clone.animate().x(orangeXCoordinate).y(orangeYCoordinate).setDuration(300).start();
                            } catch (Exception e) {
                                wintext.setText(R.string.warning);
                            }
                            o_clone.setX(orangeXCoordinate);
                            o_clone.setY(orangeYCoordinate);
                            o_clone = null;
                            figuresXY();

                        case MotionEvent.ACTION_UP:
                            CheckOrange();
                            oturn.setVisibility(View.INVISIBLE);
                            bturn.setVisibility(View.VISIBLE);
                            break;

                        default:

                            break;

                    }
                }

                return true;
            }
        });


    }

    ////////////////////////VOIDS///////////////////////

    private void setparams() {

        ConstraintLayout.LayoutParams lp;
        lp = (ConstraintLayout.LayoutParams) loc1.getLayoutParams();
        b_circle1.setLayoutParams(lp);
        lp = (ConstraintLayout.LayoutParams) loc2.getLayoutParams();
        b_circle2.setLayoutParams(lp);
        lp = (ConstraintLayout.LayoutParams) loc3.getLayoutParams();
        b_circle3.setLayoutParams(lp);
        lp = (ConstraintLayout.LayoutParams) loc7.getLayoutParams();
        o_circle1.setLayoutParams(lp);
        lp = (ConstraintLayout.LayoutParams) loc8.getLayoutParams();
        o_circle2.setLayoutParams(lp);
        lp = (ConstraintLayout.LayoutParams) loc9.getLayoutParams();
        o_circle3.setLayoutParams(lp);


    }


    private void randomTurn() {
        int Random = (int) Math.round(Math.random());
        Math.round(Math.random());

        System.out.println(Random);
        if (Random == 1) {
            bturn.setVisibility(View.VISIBLE);
        } else {
            oturn.setVisibility(View.VISIBLE);
        }
    }


    private void Coordinates() {
        float c1x, c1y, c2x, c2y, c3x, c3y, c4x, c4y, c5x, c5y, c6x, c6y, c7x, c7y, c8x, c8y, c9x, c9y;
        c1x = loc1.getX();
        c1y = loc1.getY();
        c1 = (c1x + c1y);

        c2x = loc2.getX();
        c2y = loc2.getY();
        c2 = (c2x + c2y);

        c3x = loc3.getX();
        c3y = loc3.getY();
        c3 = (c3x + c3y);

        c4x = loc4.getX();
        c4y = loc4.getY();
        c4 = (c4x + c4y);

        c5x = loc5.getX();
        c5y = loc5.getY();
        c5 = (c5x + c5y);

        c6x = loc6.getX();
        c6y = loc6.getY();
        c6 = (c6x + c6y);

        c7x = loc7.getX();
        c7y = loc7.getY();
        c7 = (c7x + c7y);

        c8x = loc8.getX();
        c8y = loc8.getY();
        c8 = (c8x + c8y);

        c9x = loc9.getX();
        c9y = loc9.getY();
        c9 = (c9x + c9y);


    }


    private void figuresXY() {
        float b1FigureX, b1FigureY, b2FigureX, b2FigureY, b3FigureX, b3FigureY;
        float o1FigureX, o1FigureY, o2FigureX, o2FigureY, o3FigureX, o3FigureY;


        b1FigureX = b_circle1.getX();
        b1FigureY = b_circle1.getY();
        blueF1 = (b1FigureX + b1FigureY);

        b2FigureX = b_circle2.getX();
        b2FigureY = b_circle2.getY();
        blueF2 = (b2FigureX + b2FigureY);

        b3FigureX = b_circle3.getX();
        b3FigureY = b_circle3.getY();
        blueF3 = (b3FigureX + b3FigureY);

        o1FigureX = o_circle1.getX();
        o1FigureY = o_circle1.getY();
        orangeF1 = (o1FigureX + o1FigureY);


        o2FigureX = o_circle2.getX();
        o2FigureY = o_circle2.getY();
        orangeF2 = (o2FigureX + o2FigureY);


        o3FigureX = o_circle3.getX();
        o3FigureY = o_circle3.getY();
        orangeF3 = (o3FigureX + o3FigureY);
    }


    private void gaqroba2() {
        if (loc1.getVisibility() == View.VISIBLE) {
            loc1.setVisibility(View.INVISIBLE);
        }
        if (loc2.getVisibility() == View.VISIBLE) {
            loc2.setVisibility(View.INVISIBLE);
        }
        if (loc3.getVisibility() == View.VISIBLE) {
            loc3.setVisibility(View.INVISIBLE);
        }
        if (loc4.getVisibility() == View.VISIBLE) {
            loc4.setVisibility(View.INVISIBLE);
        }
        if (loc5.getVisibility() == View.VISIBLE) {
            loc5.setVisibility(View.INVISIBLE);
        }
        if (loc6.getVisibility() == View.VISIBLE) {
            loc6.setVisibility(View.INVISIBLE);
        }
        if (loc7.getVisibility() == View.VISIBLE) {
            loc7.setVisibility(View.INVISIBLE);
        }
        if (loc8.getVisibility() == View.VISIBLE) {
            loc8.setVisibility(View.INVISIBLE);
        }
        if (loc9.getVisibility() == View.VISIBLE) {
            loc9.setVisibility(View.INVISIBLE);
        }

    }

    //////////////////////Figure State///////////////////////
    private void BlueState() {

        float bX, bY;
        double cloneXY;

        bX = b_clone.getX();
        bY = b_clone.getY();
        cloneXY = (bX + bY);


        if (cloneXY == c1) {
            loc2.setVisibility(View.VISIBLE);
            loc4.setVisibility(View.VISIBLE);
            loc5.setVisibility(View.VISIBLE);
        } else if (cloneXY == c2) {
            loc1.setVisibility(View.VISIBLE);
            loc3.setVisibility(View.VISIBLE);
            loc5.setVisibility(View.VISIBLE);
        } else if (cloneXY == c3) {
            loc2.setVisibility(View.VISIBLE);
            loc5.setVisibility(View.VISIBLE);
            loc6.setVisibility(View.VISIBLE);
        } else if (cloneXY == c4) {
            loc1.setVisibility(View.VISIBLE);
            loc5.setVisibility(View.VISIBLE);
            loc7.setVisibility(View.VISIBLE);
        } else if (cloneXY == c5) {
            loc1.setVisibility(View.VISIBLE);
            loc2.setVisibility(View.VISIBLE);
            loc3.setVisibility(View.VISIBLE);
            loc4.setVisibility(View.VISIBLE);
            loc5.setVisibility(View.VISIBLE);
            loc6.setVisibility(View.VISIBLE);
            loc7.setVisibility(View.VISIBLE);
            loc8.setVisibility(View.VISIBLE);
            loc9.setVisibility(View.VISIBLE);
        } else if (cloneXY == c6) {
            loc5.setVisibility(View.VISIBLE);
            loc3.setVisibility(View.VISIBLE);
            loc9.setVisibility(View.VISIBLE);

        } else if (cloneXY == c7) {
            loc4.setVisibility(View.VISIBLE);
            loc5.setVisibility(View.VISIBLE);
            loc8.setVisibility(View.VISIBLE);
        } else if (cloneXY == c8) {
            loc7.setVisibility(View.VISIBLE);
            loc5.setVisibility(View.VISIBLE);
            loc9.setVisibility(View.VISIBLE);
        } else if (cloneXY == c9) {
            loc6.setVisibility(View.VISIBLE);
            loc5.setVisibility(View.VISIBLE);
            loc8.setVisibility(View.VISIBLE);
        }
    }

    private void OrangeState() {
        double cloneXY;
        float oX, oY;
        oX = o_clone.getX();
        oY = o_clone.getY();
        cloneXY = (oX + oY);


        if (cloneXY == c1) {
            loc2.setVisibility(View.VISIBLE);
            loc4.setVisibility(View.VISIBLE);
            loc5.setVisibility(View.VISIBLE);
        } else if (cloneXY == c2) {
            loc1.setVisibility(View.VISIBLE);
            loc3.setVisibility(View.VISIBLE);
            loc5.setVisibility(View.VISIBLE);
        } else if (cloneXY == c3) {
            loc2.setVisibility(View.VISIBLE);
            loc5.setVisibility(View.VISIBLE);
            loc6.setVisibility(View.VISIBLE);
        } else if (cloneXY == c4) {
            loc1.setVisibility(View.VISIBLE);
            loc5.setVisibility(View.VISIBLE);
            loc7.setVisibility(View.VISIBLE);
        } else if (cloneXY == c5) {
            loc1.setVisibility(View.VISIBLE);
            loc2.setVisibility(View.VISIBLE);
            loc3.setVisibility(View.VISIBLE);
            loc4.setVisibility(View.VISIBLE);
            loc5.setVisibility(View.VISIBLE);
            loc6.setVisibility(View.VISIBLE);
            loc7.setVisibility(View.VISIBLE);
            loc8.setVisibility(View.VISIBLE);
            loc9.setVisibility(View.VISIBLE);
        } else if (cloneXY == c6) {
            loc5.setVisibility(View.VISIBLE);
            loc3.setVisibility(View.VISIBLE);
            loc9.setVisibility(View.VISIBLE);
        } else if (cloneXY == c7) {
            loc5.setVisibility(View.VISIBLE);
            loc8.setVisibility(View.VISIBLE);
            loc4.setVisibility(View.VISIBLE);
        } else if (cloneXY == c8) {
            loc7.setVisibility(View.VISIBLE);
            loc5.setVisibility(View.VISIBLE);
            loc9.setVisibility(View.VISIBLE);
        } else if (cloneXY == c9) {
            loc6.setVisibility(View.VISIBLE);
            loc5.setVisibility(View.VISIBLE);
            loc8.setVisibility(View.VISIBLE);
        }

    }


//////////////////////Figure State///////////////////////


    private void CheckBlue() {


        if (c4 == blueF1 && c5 == blueF2 && c6 == blueF3 ||
                c4 == blueF2 && c5 == blueF3 && c6 == blueF1 ||
                c4 == blueF3 && c5 == blueF1 && c6 == blueF2 ||
                c4 == blueF1 && c5 == blueF3 && c6 == blueF2 ||
                c4 == blueF2 && c5 == blueF1 && c6 == blueF3 ||
                c4 == blueF3 && c5 == blueF2 && c6 == blueF1
                ) {

            wintext.setText("Blue Wins");
        } else if (c1 == blueF1 && c4 == blueF2 && c7 == blueF3 ||
                c1 == blueF2 && c4 == blueF3 && c7 == blueF1 ||
                c1 == blueF3 && c4 == blueF1 && c7 == blueF2 ||
                c1 == blueF1 && c4 == blueF3 && c7 == blueF2 ||
                c1 == blueF2 && c4 == blueF1 && c7 == blueF3 ||
                c1 == blueF3 && c4 == blueF2 && c7 == blueF1) {
            wintext.setText("Blue Wins");
        } else if (c3 == blueF1 && c6 == blueF2 && c9 == blueF3 ||
                c3 == blueF2 && c6 == blueF3 && c9 == blueF1 ||
                c3 == blueF3 && c6 == blueF1 && c9 == blueF2 ||
                c3 == blueF1 && c6 == blueF3 && c9 == blueF2 ||
                c3 == blueF2 && c6 == blueF1 && c9 == blueF3 ||
                c3 == blueF3 && c6 == blueF2 && c9 == blueF1) {
            wintext.setText("Blue Wins");

        } else if (c3 == blueF1 && c5 == blueF2 && c7 == blueF3 ||
                c3 == blueF2 && c5 == blueF3 && c7 == blueF1 ||
                c3 == blueF3 && c5 == blueF1 && c7 == blueF2 ||
                c3 == blueF1 && c5 == blueF3 && c7 == blueF2 ||
                c3 == blueF2 && c5 == blueF1 && c7 == blueF3 ||
                c3 == blueF3 && c5 == blueF2 && c7 == blueF1) {
            wintext.setText("Blue Wins");
        } else if (c1 == blueF1 && c5 == blueF2 && c9 == blueF3 ||
                c1 == blueF2 && c5 == blueF3 && c9 == blueF1 ||
                c1 == blueF3 && c5 == blueF1 && c9 == blueF2 ||
                c1 == blueF1 && c5 == blueF3 && c9 == blueF2 ||
                c1 == blueF2 && c5 == blueF1 && c9 == blueF3 ||
                c1 == blueF3 && c5 == blueF2 && c9 == blueF1) {
            wintext.setText("Blue Wins");
        } else if (c7 == blueF1 && c8 == blueF2 && c9 == blueF3 ||
                c7 == blueF2 && c8 == blueF3 && c9 == blueF1 ||
                c7 == blueF3 && c8 == blueF1 && c9 == blueF2 ||
                c7 == blueF1 && c8 == blueF3 && c9 == blueF2 ||
                c7 == blueF2 && c8 == blueF1 && c9 == blueF3 ||
                c7 == blueF3 && c8 == blueF2 && c9 == blueF1) {
            wintext.setText("Blue Wins");
        } else if (c2 == blueF1 && c5 == blueF2 && c8 == blueF3 ||
                c2 == blueF2 && c5 == blueF3 && c8 == blueF1 ||
                c2 == blueF3 && c5 == blueF1 && c8 == blueF2 ||
                c2 == blueF1 && c5 == blueF3 && c8 == blueF2 ||
                c2 == blueF2 && c5 == blueF1 && c8 == blueF3 ||
                c2 == blueF3 && c5 == blueF2 && c8 == blueF1) {
            wintext.setText("Blue Wins");
        } else
            wintext.setText("");


    }


    private void CheckOrange() {

        if (c4 == orangeF1 && c5 == orangeF2 && c6 == orangeF3 ||
                c4 == orangeF2 && c5 == orangeF3 && c6 == orangeF1 ||
                c4 == orangeF3 && c5 == orangeF1 && c6 == orangeF2 ||
                c4 == orangeF1 && c5 == orangeF3 && c6 == orangeF2 ||
                c4 == orangeF2 && c5 == orangeF1 && c6 == orangeF3 ||
                c4 == orangeF3 && c5 == orangeF2 && c6 == orangeF1

                ) {
            wintext.setText("Orange Wins");
        } else if (c1 == orangeF1 && c4 == orangeF2 && c7 == orangeF3 ||
                c1 == orangeF2 && c4 == orangeF3 && c7 == orangeF1 ||
                c1 == orangeF3 && c4 == orangeF1 && c7 == orangeF2 ||
                c1 == orangeF1 && c4 == orangeF3 && c7 == orangeF2 ||
                c1 == orangeF2 && c4 == orangeF1 && c7 == orangeF3 ||
                c1 == orangeF3 && c4 == orangeF2 && c7 == orangeF1) {
            wintext.setText("Orange Wins");
        } else if (c3 == orangeF1 && c6 == orangeF2 && c9 == orangeF3 ||
                c3 == orangeF2 && c6 == orangeF3 && c9 == orangeF1 ||
                c3 == orangeF3 && c6 == orangeF1 && c9 == orangeF2 ||
                c3 == orangeF1 && c6 == orangeF3 && c9 == orangeF2 ||
                c3 == orangeF2 && c6 == orangeF1 && c9 == orangeF3 ||
                c3 == orangeF3 && c6 == orangeF2 && c9 == orangeF1) {
            wintext.setText("Orange Wins");

        } else if (c3 == orangeF1 && c5 == orangeF2 && c7 == orangeF3 ||
                c3 == orangeF2 && c5 == orangeF3 && c7 == orangeF1 ||
                c3 == orangeF3 && c5 == orangeF1 && c7 == orangeF2 ||
                c3 == orangeF1 && c5 == orangeF3 && c7 == orangeF2 ||
                c3 == orangeF2 && c5 == orangeF1 && c7 == orangeF3 ||
                c3 == orangeF3 && c5 == orangeF2 && c7 == orangeF1) {
            wintext.setText("Orange Wins");
        } else if (c1 == orangeF1 && c5 == orangeF2 && c9 == orangeF3 ||
                c1 == orangeF2 && c5 == orangeF3 && c9 == orangeF1 ||
                c1 == orangeF3 && c5 == orangeF1 && c9 == orangeF2 ||
                c1 == orangeF1 && c5 == orangeF3 && c9 == orangeF2 ||
                c1 == orangeF2 && c5 == orangeF1 && c9 == orangeF3 ||
                c1 == orangeF3 && c5 == orangeF2 && c9 == orangeF1) {
            wintext.setText("Orange Wins");
        } else if (c1 == orangeF1 && c2 == orangeF2 && c3 == orangeF3 ||
                c1 == orangeF2 && c2 == orangeF3 && c3 == orangeF1 ||
                c1 == orangeF3 && c2 == orangeF1 && c3 == orangeF2 ||
                c1 == orangeF1 && c2 == orangeF3 && c3 == orangeF2 ||
                c1 == orangeF2 && c2 == orangeF1 && c3 == orangeF3 ||
                c1 == orangeF3 && c2 == orangeF2 && c3 == orangeF1) {
            wintext.setText("Orange Wins");
        } else if (c2 == orangeF1 && c5 == orangeF2 && c8 == orangeF3 ||
                c2 == orangeF2 && c5 == orangeF3 && c8 == orangeF1 ||
                c2 == orangeF3 && c5 == orangeF1 && c8 == orangeF2 ||
                c2 == orangeF1 && c5 == orangeF3 && c8 == orangeF2 ||
                c2 == orangeF2 && c5 == orangeF1 && c8 == orangeF3 ||
                c2 == orangeF3 && c5 == orangeF2 && c8 == orangeF1) {
            wintext.setText("Orange Wins");
        } else
            wintext.setText("");

    }

}