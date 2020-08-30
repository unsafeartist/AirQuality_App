package com.example.airquality_app;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView location_textView, altitude_textView, temperature_textView;
    private RequestQueue weatherQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign the locally declared text-views to the ones in the XML design
        location_textView = (TextView)findViewById(R.id.location_xml_textView_TITLE);
        altitude_textView = (TextView)findViewById(R.id.altitude_xml_textVIew);
        temperature_textView = (TextView)findViewById(R.id.temperature_xml_textView_TITLE);

        weatherQueue = Volley.newRequestQueue(this);
        
        weather();
    }

    private void weather(){
        String url = "http://api.openweathermap.org/data/2.5/weather?lat=37.5934&lon=122.0439&appid=df97f772c7421491887e922381e80e70";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //This will be called when Json request for weather is SUCCESSFUL
                        try {
                            JSONObject main_object = response.getJSONObject("main");
                            JSONArray array = response.getJSONArray("weather");
                            JSONObject object = array.getJSONObject(0);
                            String temperatureString = String.valueOf(main_object.getDouble("temp"));
                            String description = object.getString("description");
                            String city = response.getString("name");

                            location_textView.setText(city);
                            //altitude_textView
                            temperature_textView.setText(temperatureString);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //This will be called when the Json request FAILS
            }
        });

        weatherQueue.add(request);
    }

}