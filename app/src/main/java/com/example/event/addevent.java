package com.example.event;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class addevent extends AppCompatActivity {

    Button btnadd;

    EditText editTexttype ,editTextcapacity,editTextaddress,editTextlocation,editTextdate,editTexttime;
    String etype,capacity,address,location,date,time;


    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(com.example.event.addevent.this, Dashboard.class));
        finish();

    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addevent);


        editTexttype = findViewById(R.id.type);
        editTextcapacity = findViewById(R.id.capacity);
        editTextaddress = findViewById(R.id.address);
        editTextlocation = findViewById(R.id.location);
        editTextdate = findViewById(R.id.date);
        editTexttime = findViewById(R.id.time);


        btnadd = findViewById(R.id.btnadd);

//        btnaddevent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                // Instantiate the RequestQueue.
//                RequestQueue queue = Volley.newRequestQueue(addevent.this);
////                carid = Integer.valueOf(Objects.requireNonNull(textInputEditTextCarid.getText()).toString());
////                carno = Integer.valueOf(textInputEditTextCarno.getText().toString().toLowerCase());
////                carmod = textInputEditTextCarmod.getText().toString();
////                carcap = Integer.valueOf(textInputEditTextCarcap.getText().toString());
//
////                etype = editTexttype.getText().toString();
////                capacity = editTextcapacity.getText().toString();
////                address = editTextaddress.getText().toString();
////                location = editTextlocation.getText().toString();
////                date = editTextdate.getText().toString();
////                time = editTexttime.getText().toString();
//
//                etype = editTexttype.getText().toString();
//                capacity = editTextcapacity.getText().toString();
//                address = editTextaddress.getText().toString();
//                location = editTextlocation.getText().toString();
//                date = editTextdate.getText().toString();
//                time = editTexttime.getText().toString();
//
//                if ( !etype.isEmpty() && !capacity.isEmpty() && !address.isEmpty() && !location.isEmpty() && !date.isEmpty() && !time.isEmpty()) {
//
//                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.0.104/LoginRegister/addevent.php", new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(String response) {
//                            if (response.equals("Car Added Success")) {
//                                Intent intent = new Intent(addevent.this, Register.class);
//                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                                startActivity(intent);
////                            finish();
//                            } else {
//                                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
//
//                            }
//                        }
//                    }, new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            Toast.makeText(addevent.this, error.getMessage(), Toast.LENGTH_LONG).show();
//                        }
//                    }) {
//                        @Override
//                        protected Map<String, String> getParams() {
//                            HashMap<String, String> params = new HashMap<>();
//
//                            params.put("etype", etype);
//                            params.put("capacity", capacity);
//                            params.put("address", address);
//                            params.put("location", location);
//                            params.put("date", date);
//                            params.put("time", time);
//                            return params;
//                        }
//                    };
//                    stringRequest.setRetryPolicy(new DefaultRetryPolicy(0, -1, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//                    //VolleySingleton.getInstance().addRequestQueue(stringRequest);
//                    // Add the request to the RequestQueue.
//                    queue.add(stringRequest);
//                } else {
//                    Toast.makeText(getApplicationContext(), "All fields are required.", Toast.LENGTH_LONG).show();
//                }
//
//
//            }
//
//
//        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(com.example.event.addevent.this);
//                carid = Integer.valueOf(Objects.requireNonNull(textInputEditTextCarid.getText()).toString());
//                carno = Integer.valueOf(textInputEditTextCarno.getText().toString().toLowerCase());
//                carmod = textInputEditTextCarmod.getText().toString();
//                carcap = Integer.valueOf(textInputEditTextCarcap.getText().toString());

                etype = editTexttype.getText().toString();
                capacity = editTextcapacity.getText().toString();
                address = editTextaddress.getText().toString();
                location = editTextlocation.getText().toString();
                date = editTextdate.getText().toString();
                time = editTexttime.getText().toString();

                if ( !etype.isEmpty() && !capacity.isEmpty() && !address.isEmpty() && !location.isEmpty() && !date.isEmpty() && !time.isEmpty()) {

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.0.100/EventManagement/addevent.php", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equals("Event Added Success")) {
                                Intent intent = new Intent(com.example.event.addevent.this, Dashboard.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            finish();
                            } else {
                                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();

                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(com.example.event.addevent.this, error.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() {
                            HashMap<String, String> params = new HashMap<>();

                            params.put("etype", etype);
                            params.put("capacity", capacity);
                            params.put("address", address);
                            params.put("location", location);
                            params.put("date", date);
                            params.put("time", time);

                            return params;
                        }
                    };
                    stringRequest.setRetryPolicy(new DefaultRetryPolicy(0, -1, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                    //VolleySingleton.getInstance().addRequestQueue(stringRequest);
                    // Add the request to the RequestQueue.
                    queue.add(stringRequest);
                } else {
                    Toast.makeText(getApplicationContext(), "All fields are required.", Toast.LENGTH_LONG).show();
                }


            }


        });
    }

}