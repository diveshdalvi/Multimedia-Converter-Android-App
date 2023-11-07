package com.multimediaconvertor;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
public class ProximityService extends Service implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor proximitySensor;
    @Override
    public void onCreate() {
        super.onCreate();
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if (proximitySensor != null) {
            sensorManager.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL); } }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (sensorManager != null) {
            sensorManager.unregisterListener(this); }}
    @Override
    public void onSensorChanged(SensorEvent event) {
        float distance = event.values[0];
        if (distance < proximitySensor.getMaximumRange()) {
            // An object is detected near the proximity sensor, turn off the screen
            ScreenUtils.turnOffScreen(this);}}
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
    @Override
    public IBinder onBind(Intent intent) {
        return null;}}
