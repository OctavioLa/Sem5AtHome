package com.example.juan.sem5athome;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    TextView texto;
    LinearLayout ll;
    SensorManager sm;
    Sensor sensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto=(TextView)findViewById(R.id.txtTexto);
        ll=(LinearLayout)findViewById(R.id.llSensores);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        sensor=sm.getDefaultSensor(sensor.TYPE_PROXIMITY);
        sm.registerListener(this,sensor,sm.SENSOR_DELAY_NORMAL);


    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
