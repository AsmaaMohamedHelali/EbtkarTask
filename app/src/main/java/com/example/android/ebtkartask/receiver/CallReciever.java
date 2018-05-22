package com.example.android.ebtkartask.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.ebtkartask.R;
import com.example.android.ebtkartask.services.BackgroundService;

import java.util.zip.Inflater;

import static android.content.ContentValues.TAG;

/**
 * Created by asmaa on 21/05/18.
 */

public class CallReciever extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        if (state.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
//            if (Build.VERSION.SDK_INT >= 23) {
//                if (!Settings.canDrawOverlays(context)) {
//                    Intent intent1 = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
//                            Uri.parse("package:" + context.getPackageName()));
//                    context.startActivity(intent1);
//                }
//            } else {
//                context.startService(new Intent(context, BackgroundService.class));
//            }


        }
    }

    }
