package com.example.event;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class empdashboard extends AppCompatActivity implements View.OnClickListener {

    private CardView card3,card4,card5,card6;



    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(com.example.event.empdashboard.this, homepage.class));
        finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empdashboard);




        card3 =(CardView) findViewById(R.id.c3);
        card4=(CardView) findViewById(R.id.c4);
        card5 =(CardView) findViewById(R.id.c5);
        card6 =(CardView) findViewById(R.id.c6);




        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);


    }


    public  void onClick(View view){
        Intent i;

        switch (view.getId()){

            case R.id.c3:
                i = new Intent(this,employee.class);
                startActivity(i);
                break;

            case R.id.c4:
                i = new Intent(this,Feddback.class);
                startActivity(i);
                break;



            case R.id.c5:
                i = new Intent(this,contact.class);
                startActivity(i);
                break;

            case R.id.c6:
                i = new Intent(this,Login.class);
                startActivity(i);
                break;

        }

    }
}