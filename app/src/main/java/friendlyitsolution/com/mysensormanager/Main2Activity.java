package friendlyitsolution.com.mysensormanager;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class Main2Activity extends AppCompatActivity implements SensorEventListener {

    TextView valx,valy,valz,prdata;

    SensorManager man;
    RelativeLayout rel;


    Random ra;

    float ox=0,oy=0,oz=0;
    int changed=4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rel=findViewById(R.id.rel);
        valx=findViewById(R.id.valx);
        valy=findViewById(R.id.valy);
        valz=findViewById(R.id.valz);
        prdata=findViewById(R.id.prdata);
        ra=new Random();


        man=(SensorManager)getSystemService(SENSOR_SERVICE);


    }

    @Override
    protected void onResume() {
        super.onResume();

    man.registerListener(this,man.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
    man.registerListener(this ,man.getDefaultSensor(Sensor.TYPE_PROXIMITY),SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause() {
        super.onPause();

        man.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {


        Sensor s=sensorEvent.sensor;

        if(s.getType()==Sensor.TYPE_ACCELEROMETER)
        {

            float[] data=sensorEvent.values;

            float x=data[0];
            float y=data[1];
            float z=data[2];



            valx.setText("X  : "+x);
            valy.setText("Y  : "+y);
            valz.setText("Z  : "+z);


            if(x>ox+changed ||y>oy+changed||z>oz+changed || x<ox-changed ||y<oy-changed||z<oz-changed)
            {
                rel.setBackgroundColor(Color.rgb(ra.nextInt(255),ra.nextInt(255),ra.nextInt(255)));

                ox=x;
                oy=y;
                oz=z;




            }





        }
        else
        {
            float[] data=sensorEvent.values;




        }



    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
