package friendlyitsolution.com.mysensormanager;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ListView lv;
    ArrayAdapter<String> adapter;
    List<String> sname;

    SensorManager man;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lv=findViewById(R.id.lv);
        sname=new ArrayList<>();
        adapter=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,sname);
        lv.setAdapter(adapter);


        man=(SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> allsen=man.getSensorList(Sensor.TYPE_ALL);


        for(int i=0;i<allsen.size();i++)
        {

            sname.add(allsen.get(i).getName());

        }
        adapter.notifyDataSetChanged();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);
            }
        });
    }

}
