package com.example.airquality_app;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView location_textView, altitude_textView, temperature_textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign the locally declared text-views to the ones in the XML design
        location_textView = (TextView)findViewById(R.id.location_xml_textView);
        altitude_textView = (TextView)findViewById(R.id.altitude_xml_textVIew);
        temperature_textView = (TextView)findViewById(R.id.temperature_xml_textView);

    }

}