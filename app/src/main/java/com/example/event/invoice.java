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

public class invoice extends AppCompatActivity {

    EditText iename,eprice,photo,cater,decor,gst,total;
    Button btninvoice;
    String siename,seprice,sphoto,scater,sdecor,sgst,stotal;


    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(com.example.event.invoice.this, com.example.event.bookevent.class));
        finish();

    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);


        iename = findViewById(R.id.iename);
        eprice = findViewById(R.id.price);
        photo = findViewById(R.id.photo);
        cater = findViewById(R.id.cater);
        decor = findViewById(R.id.decor);
        gst = findViewById(R.id.gst);
        total = findViewById(R.id.total);



        btninvoice = findViewById(R.id.btninvoice);

        btninvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(com.example.event.invoice.this);
//                carid = Integer.valueOf(Objects.requireNonNull(textInputEditTextCarid.getText()).toString());
//                carno = Integer.valueOf(textInputEditTextCarno.getText().toString().toLowerCase());
//                carmod = textInputEditTextCarmod.getText().toString();
//                carcap = Integer.valueOf(textInputEditTextCarcap.getText().toString());

                siename = iename.getText().toString();
                seprice = eprice.getText().toString();
                sphoto = photo.getText().toString();
                scater = cater.getText().toString();
                sdecor = decor.getText().toString();
                sgst = gst.getText().toString();
                stotal = total.getText().toString();

                if ( !siename.isEmpty() && !seprice.isEmpty() && !sphoto.isEmpty() && !scater.isEmpty() && !sdecor.isEmpty() && !sgst.isEmpty() && !stotal.isEmpty()) {

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.0.100/EventManagement/invoice.php", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equals("Invoice Created Success")) {
                                Intent intent = new Intent(com.example.event.invoice.this, confirmation.class);
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
                            Toast.makeText(com.example.event.invoice.this, error.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() {
                            HashMap<String, String> params = new HashMap<>();

                            params.put("siename", siename);
                            params.put("seprice", seprice);
                            params.put("sphoto", sphoto);
                            params.put("scater", scater);
                            params.put("sdecor", sdecor);
                            params.put("sgst", sgst);
                            params.put("stotal", stotal);

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