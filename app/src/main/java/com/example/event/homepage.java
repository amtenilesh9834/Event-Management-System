package com.example.event;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class homepage extends AppCompatActivity {

    TextView t1,t2,t3;


    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(com.example.event.homepage.this, com.example.event.homepage.class));
        finish();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);


        t1 = findViewById(R.id.admin);
        t2 = findViewById(R.id.employe);
        t3 = findViewById(R.id.customer);


//
//        t1.setOnClickListener((View.OnClickListener) this);
//        t2.setOnClickListener((View.OnClickListener) this);
//        t3.setOnClickListener((View.OnClickListener) this);


        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.event.homepage.this, Register.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.event.homepage.this, empregister.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.event.homepage.this, custregister.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }

//    public  void onClick(View view){
//        Intent i;
//
//        switch (view.getId()){
//
//            case R.id.admin:
//
//            case R.id.customer:
//                i = new Intent(this,addevent.class);
//                startActivity(i);
//                break;
//
//            case R.id.employe:
//                i = new Intent(this,bookevent.class);
//                startActivity(i);
//                break;
//
//        }
//    }
}