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

public class form extends AppCompatActivity {

    Button add;

    EditText editTextfname ,editTextdate,editTextvenue,editTextevent,editTexteventtype,editTextphoto,editTextdecor,editTextcater;
    String fname,edate,venue,ename,etype,photo,decor,cater;


    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(com.example.event.form.this, Dashboard.class));
        finish();

    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);


        editTextfname = findViewById(R.id.fname);
        editTextdate = findViewById(R.id.date);
        editTextvenue = findViewById(R.id.venue);
        editTextevent = findViewById(R.id.ename);
        editTexteventtype = findViewById(R.id.etype);
        editTextphoto = findViewById(R.id.photog);
        editTextdecor = findViewById(R.id.decor);
        editTextcater = findViewById(R.id.cater);


        add = findViewById(R.id.add);

//

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(com.example.event.form.this);
//                carid = Integer.valueOf(Objects.requireNonNull(textInputEditTextCarid.getText()).toString());
//                carno = Integer.valueOf(textInputEditTextCarno.getText().toString().toLowerCase());
//                carmod = textInputEditTextCarmod.getText().toString();
//                carcap = Integer.valueOf(textInputEditTextCarcap.getText().toString());

                fname = editTextfname.getText().toString();
                edate = editTextdate.getText().toString();
                venue = editTextvenue.getText().toString();
                ename = editTextvenue.getText().toString();
                etype = editTexteventtype.getText().toString();
                photo = editTextphoto.getText().toString();
                decor = editTextdecor.getText().toString();
                cater = editTextcater.getText().toString();
                if ( !fname.isEmpty() && !edate.isEmpty() && !venue.isEmpty() && !ename.isEmpty() && !etype.isEmpty() && !photo.isEmpty() && !decor.isEmpty() && !cater.isEmpty()) {

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.0.100/EventManagement/form.php", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equals("Event Added Success")) {
                                Intent intent = new Intent(com.example.event.form.this, invoice.class);
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
                            Toast.makeText(com.example.event.form.this, error.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() {
                            HashMap<String, String> params = new HashMap<>();

                            params.put("fname", fname);
                            params.put("edate", edate);
                            params.put("venue", venue);
                            params.put("ename", ename);
                            params.put("etype", etype);
                            params.put("photo", photo);
                            params.put("decor", decor);
                            params.put("cater", cater);

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