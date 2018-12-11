package net.walgo.mygame;


import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class PopupWindow extends OBoard {
    private Button restart,menu,exitapp;
    public android.widget.PopupWindow popUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);
        restart=findViewById(R.id.restart);
        menu=findViewById(R.id.menu);
        exitapp=findViewById(R.id.exitapp);
        popUp = new android.widget.PopupWindow(this);

       // popUp.setBackgroundDrawable(new ColorDrawable(
              //  android.graphics.Color.TRANSPARENT));

        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=dm.widthPixels;
        int height=dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.2));

        WindowManager.LayoutParams params=getWindow().getAttributes();
        params.gravity=Gravity.CENTER;
        params.x=0;
        params.y=-10;

        getWindow().setAttributes(params);


        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("finish_activity");
                sendBroadcast(intent);
                finish();
                startActivity(new Intent(PopupWindow.this, OBoard.class));
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("finish_activity");
                sendBroadcast(intent);
                finish();
                startActivity(new Intent(PopupWindow.this, Menu.class));
             }
        });
        exitapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);
            }
        });
    }

}
