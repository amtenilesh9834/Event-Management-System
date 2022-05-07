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

public class bookevent extends AppCompatActivity {

    Button btnbookevent;

    private static final String apiurl="http://192.168.0.104/EventManagement/addevent_json.php";
    EditText et;
    ListView lv;
    ArrayList<String> holder=new ArrayList<>();

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(com.example.event.bookevent.this, form.class));
        finish();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookevent);

        btnbookevent= findViewById(R.id.btneventbook);

        btnbookevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.event.bookevent.this, invoice.class);
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
                        String name1=jo.getString("capacity");
//                        String name2=jo.getString("car_mod");
//                        String name3=jo.getString("car_cap");
//                        String name4=jo.getString("d_name");
//                        String name5=jo.getString("d_mo_no");

                        holder.add(name1);
//                        holder.add(name2);
//                        holder.add(name3);
//                        holder.add(name4);
//                        holder.add(name5);
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