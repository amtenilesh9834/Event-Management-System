package com.example.event;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class confirmation extends AppCompatActivity {

    Button btndone;

    private static final String apiurl="http://192.168.0.100/Eventmanagement/invoice_json.php";
    EditText et;
    ListView lv;
    ArrayList<String>holder=new ArrayList<>();


    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(com.example.event.confirmation.this, com.example.event.invoice.class));
        finish();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        btndone= findViewById(R.id.btndone);

        btndone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.event.confirmation.this, com.example.event.payment.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
//                finish();
            }
        });

        fetchdata();
    }







    public void fetchdata()
    {

        lv=(ListView)findViewById(R.id.lv);

        class dbManager extends AsyncTask<String,Void,String>
        {


            protected void onPostExecute(String data)
            {
                try{

                    JSONArray ja = new JSONArray(data);
                    JSONObject jo =null;
                    holder.clear();
                    for(int i=0;i<ja.length();i++)
                    {
                        jo=ja.getJSONObject(i);
                        String name1=jo.getString("id");
                        String name2=jo.getString("ename");
                        String name3=jo.getString("eprice");
                        String name4=jo.getString("photo");
                        String name5=jo.getString("cater");
                        String name6=jo.getString("decor");
                        String name7=jo.getString("gst");
                        String name8=jo.getString("total");

                        holder.add(name1);
                        holder.add(name2);
                        holder.add(name3);
                        holder.add(name4);
                        holder.add(name5);
                        holder.add(name6);
                        holder.add(name7);
                        holder.add(name8);
                    }

                    ArrayAdapter<String> at =new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,holder);
                    lv.setAdapter(at);
                }catch (Exception ex)
                {
                    Toast.makeText(getApplicationContext(),data, Toast.LENGTH_SHORT).show();
                }

            }


            @Override
            protected String doInBackground(String... strings)
            {
                try{
                    URL url=new URL(strings[0]);
                    HttpURLConnection conn=(HttpURLConnection)url.openConnection();
                    BufferedReader br= new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    StringBuffer data = new StringBuffer();
                    String line;

                    while((line=br.readLine())!=null)
                    {
                        data.append(line+"\n");
                    }
                    br.close();

                    return data.toString();
                } catch (Exception ex)
                {
                    return ex.getMessage();
                }
            }
        }
        dbManager obj= new dbManager();
        obj.execute(apiurl);
    }

}
