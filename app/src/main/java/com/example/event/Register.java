package com.example.event;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Register extends AppCompatActivity  {


    private static final String TAG = null;
    TextInputEditText textInputEditTextFullname,textInputEditTextUsername,textInputEditTextPassword,textInputEditTextEmail;
    Button buttonSignup;
    TextView logintext;
    String fullname,username,password,email,callback;


    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(Register.this, Login.class));
        finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        textInputEditTextFullname =findViewById(R.id.fullname);
        textInputEditTextUsername =findViewById(R.id.username);
        textInputEditTextPassword =findViewById(R.id.password);
        textInputEditTextEmail =findViewById(R.id.email);
        logintext = findViewById(R.id.loginText);
        buttonSignup = findViewById(R.id.buttonSignUp);


//        ContentResolver cr = getContentResolver();
//        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
//                null, null, null, null);
//
//        if ((cur != null ? cur.getCount() : 0) > 0) {
//            while (cur != null && cur.moveToNext()) {
//                String id = cur.getString(
//                        cur.getColumnIndex(ContactsContract.Contacts._ID));
//                String name = cur.getString(cur.getColumnIndex(
//                        ContactsContract.Contacts.DISPLAY_NAME));
//
//                if (cur.getInt(cur.getColumnIndex(
//                        ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
//                    Cursor pCur = cr.query(
//                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
//                            null,
//                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
//                            new String[]{id}, null);
//                    while (pCur.moveToNext()) {
//                        String phoneNo = pCur.getString(pCur.getColumnIndex(
//                                ContactsContract.CommonDataKinds.Phone.NUMBER));
//                        Log.i(TAG, "Name: " + name);
//                        Log.i(TAG, "Phone Number: " + phoneNo);
//                    }
//                    pCur.close();
//                }
//            }
//        }
//        if(cur!=null){
//            cur.close();
//        }



//        textInputEditTextEmail.addTextChangedListener(new TextWatcher() {
//            String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
//
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            public void afterTextChanged(Editable s) {
//                emailValidator(textInputEditTextEmail);
//            }
//
//            private void emailValidator(TextInputEditText textInputEditTextEmail) {
//                // extract the entered data from the EditText
//                String emailToText = textInputEditTextEmail.getText().toString();
//
//                if (!emailToText.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailToText).matches()) {
//                    Toast.makeText(getApplicationContext(), "Email Verified !", Toast.LENGTH_LONG).show();
//                } else {
//                    Toast.makeText(getApplicationContext(), "Enter valid Email address !", Toast.LENGTH_LONG).show();
//                }
//
//            }
//        });


        // To Click Register Button Goto login Button

//        logintext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Register.this, Login.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
//                finish();
//
//            }
//        });



        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(Register.this);
                fullname = Objects.requireNonNull(textInputEditTextFullname.getText()).toString();
                username = textInputEditTextUsername.getText().toString().toLowerCase();
                email = textInputEditTextEmail.getText().toString().toLowerCase();
                password = textInputEditTextPassword.getText().toString();

                if (!fullname.isEmpty() && !username.isEmpty() && !email.isEmpty() && !password.isEmpty()) {

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.0.100/LoginRegister/signup.php", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equals("Sign Up Success")) {
                                Intent intent = new Intent(Register.this, Login.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();

                            }
                        }
                    }, new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(Register.this, error.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() {
                            HashMap<String, String> params = new HashMap<>();
                            params.put("fullname", fullname);
                            params.put("email", email);
                            params.put("username", username);
                            params.put("password", password);

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