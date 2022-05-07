package com.example.event;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    TextInputEditText textInputEditTextusername,textInputEditTextpassword;
    Button buttonLogin;
    TextView signUpText;
    String username,password;

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(Login.this, Register.class));
        finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputEditTextusername = findViewById(R.id.username);
        textInputEditTextpassword = findViewById(R.id.password);
        signUpText =findViewById(R.id.signUpText);
        buttonLogin = findViewById(R.id.buttonLogin);


//        signUpText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Login.this, Register.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
////               finish();
//            }
//        });


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                RequestQueue queue = Volley.newRequestQueue(Login.this);

                username = textInputEditTextusername.getText().toString().toLowerCase();
                password = textInputEditTextpassword.getText().toString();
                if (!username.isEmpty() && !password.isEmpty()) {

                    StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.POST, "http://192.168.0.100/LoginRegister/login.php", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equals("Login Success")) {
                                Intent intent = new Intent(Login.this, admindashboard.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
//                                finish();



                                //  SessionManager sessionManager = new SessionManager(LoginPage.this,Registerpage.class);
                                //  sessionManager.saveSession(username);

                                // accountVerification(username);
                            } else if (response.equals("Username or Password wrong")) {

                                textInputEditTextusername.setError("Enter correct email!");
                                textInputEditTextpassword.setError("Enter correct password!");
                                buttonLogin.setEnabled(true);
                            } else {
                                buttonLogin.setEnabled(true);
                                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();

                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            ///   buttonLogin.setEnabled(true);
                            Toast.makeText(Login.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }) {
                        // @Override
                        // public Map<String, String> getHeaders() throws AuthFailureError {
                        //   HashMap<String, String> params = new HashMap<>();
                        //   params.put("Accept", "Application/json; charset=UTF-8");
                        //  return params;
                        //  }

                        @Override
                        protected Map<String, String> getParams() {
                            HashMap<String, String> params = new HashMap<>();
                            params.put("username", username);
                            params.put("password", password);
                            return params;
                        }
                    };

                    stringRequest.setRetryPolicy(new DefaultRetryPolicy(0, -1, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                    //VolleySingleton.getInstance().addRequestQueue(stringRequest);
                    queue.add(stringRequest);
                } else {
                    buttonLogin.setEnabled(true);
                    Toast.makeText(getApplicationContext(), "All fields are required.", Toast.LENGTH_SHORT).show();
                }


            }

        });

    }
}