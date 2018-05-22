package com.example.android.ebtkartask.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.IBinder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.ebtkartask.R;


/**
 * Created by asmaa on 22/05/18.
 */

public class BackgroundService extends Service {

    public Context context = this;
    public Handler handler = null;
    public static Runnable runnable = null;
    private WindowManager wm;
    private LinearLayout ly1;
    private TextView tv1, tv2;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
                final WindowManager.LayoutParams params1 = new WindowManager.LayoutParams(
                        WindowManager.LayoutParams.WRAP_CONTENT,
                        WindowManager.LayoutParams.WRAP_CONTENT,
                        WindowManager.LayoutParams.TYPE_SYSTEM_ERROR,
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                                | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
                                | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                        PixelFormat.TRANSLUCENT);

                params1.height = 280;
                params1.width = WindowManager.LayoutParams.MATCH_PARENT;
                params1.gravity = Gravity.CENTER;
                params1.format = PixelFormat.TRANSLUCENT;

                ly1 = new LinearLayout(context.getApplicationContext());
                ly1.setOrientation(LinearLayout.HORIZONTAL);
                ly1.setBackgroundColor(Color.WHITE);
                View hiddenInfo = LayoutInflater.from(context).inflate(R.layout.call_screen_overlay, ly1,
                        false);
                tv1 = (TextView) hiddenInfo.findViewById(R.id.number);
                tv1.setText("01151666492");
                tv2 = (TextView) hiddenInfo.findViewById(R.id.name);
                tv2.setText("Incoming...");
                tv2.setText("Incoming...");
                ly1.addView(hiddenInfo);
                wm.addView(ly1, params1);
            }
        }, 3000);
    }

    @Override
    public void onDestroy() {
        /* IF YOU WANT THIS SERVICE KILLED WITH THE APP THEN UNCOMMENT THE FOLLOWING LINE */
        handler.removeCallbacks(runnable);
        Toast.makeText(this, "Service stopped", Toast.LENGTH_LONG).show();
    }


}