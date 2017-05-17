package com.example.juan.sem5athome;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

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
        sm.registerListener(this,sensor,SensorManager.
                SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        String txt=event.values[0]+"";
        texto.setText(txt);
        float valor=event.values[0];

        if (valor==0){
            ll.setBackgroundColor(Color.CYAN);
        }else{
            ll.setBackgroundColor(Color.BLUE);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}