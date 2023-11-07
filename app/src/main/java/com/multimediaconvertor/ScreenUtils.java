package com.multimediaconvertor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.view.WindowManager;

public class ScreenUtils {
    public static void turnOffScreen(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        if (powerManager != null) {
            @SuppressLint("InvalidWakeLockTag") PowerManager.WakeLock wakeLock = powerManager.newWakeLock(
                    PowerManager.PROXIMITY_SCREEN_OFF_WAKE_LOCK |
                            PowerManager.ACQUIRE_CAUSES_WAKEUP,
                    "ProximityService"
            );
            wakeLock.acquire();
            wakeLock.release();
        }
    }
}
