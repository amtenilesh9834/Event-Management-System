package com.example.event                   ;

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

public class Feddback extends AppCompatActivity {

    EditText  editText1,editText2,editText3,editText4;
    Button btnbf;

    String  feed1,feed2,feed3,feed4;


    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(Feddback.this, homepage.class));
        finish();

    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feddback);




        editText1 = findViewById(R.id.feed1);
        editText2 = findViewById(R.id.feed2);
//        editText3 = findViewById(R.id.feed3);
        editText4 = findViewById(R.id.feed4);




        btnbf = findViewById(R.id.buttonfb);

        btnbf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(Feddback.this);
//                carid = Integer.valueOf(Objects.requireNonNull(textInputEditTextCarid.getText()).toString());
//                carno = Integer.valueOf(textInputEditTextCarno.getText().toString().toLowerCase());
//                carmod = textInputEditTextCarmod.getText().toString();
//                carcap = Integer.valueOf(textInputEditTextCarcap.getText().toString());

                feed1 = editText1.getText().toString();
                feed2 = editText2.getText().toString();
//                feed3 = editText3.getText().toString();
                feed4 = editText4.getText().toString();


                if ( !feed1.isEmpty() && !feed2.isEmpty()  && !feed4.isEmpty() ) {

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.0.101/EventManagement/feedback.php", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equals("Event Feedback Added Success")) {
                                Intent intent = new Intent(Feddback.this, Dashboard.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
//                            finish();
                            } else {
                                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();

                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(Feddback.this, error.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() {
                            HashMap<String, String> params = new HashMap<>();

                            params.put("feed1", feed1);
                            params.put("feed2", feed2);
//                            params.put("feed3", feed3);
                            params.put("feed4", feed4);


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