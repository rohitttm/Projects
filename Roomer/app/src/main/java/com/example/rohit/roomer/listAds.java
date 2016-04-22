package com.example.rohit.roomer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;


public class listAds extends ActionBarActivity {


    String titlead,fnad,dad;
    // Declare Variables
    private ListView listview;
    String suni,scity;
    listViewAdapter adapter;
    private List<Ad> ads = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ads);
        listview=(ListView) findViewById(R.id.listviewAds);

        ads=new ArrayList<>();

        scity= getIntent().getExtras().getString("City");
        suni= getIntent().getExtras().getString("University");
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Ad");

        query.whereEqualTo("University", suni);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> parseObjects, ParseException e) {
                if (e == null) {
                    for (int i = 0; i < parseObjects.size(); i++) {

                        ParseObject a = parseObjects.get(i);

                        titlead = (String) a.get("Title");
                        fnad = (String) a.get("FullName");
                        dad = (String) a.get("Description");

                        ads.add(new Ad(titlead, fnad, dad));
                    }
                } else {

                }




                listview.setAdapter(new listViewAdapter(listAds.this, R.layout.rowadlist, ads));

            }

        });

       /* ParseQuery query=new ParseQuery("Ad");
        //ParseQuery<ParseObject> query = ParseQuery.getQuery("Ad");
        query.whereEqualTo("University", suni);
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> queryList, ParseException e) {
                if (e == null) {
                    for (int i = 0; i < queryList.size(); i++) {


                        for (ParseObject a : queryList) {
                           // ParseObject a = queryList.get(i);

                        titlead = a.getString("Title");
                        fnad = a.getString("FullName");
                        dad = a.getString("Description");

                        Ad aa= new Ad(titlead,fnad,dad);
                        ads.add(aa);

                        //ads.add(new Ad(titlead,fnad,dad));
                        }

                        *//*ParseObject a = queryList.get(i);

                        titlead = a.getString("Title");
                        fnad = a.getString("FullName");
                        dad = a.getString("Description");

                        ads.add(new Ad(titlead,fnad,dad));*//*
                    }
                } else {
                    //Log.d("score", "Error: " + e.getMessage());
                }
                listview.setAdapter(new listViewAdapter(listAds.this,R.layout.rowadlist,ads));

            }
        });
*/


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(listAds.this,adDetails.class);
                intent.putExtra("position",position);
                intent.putExtra("suni",suni);
                startActivity(intent);

            }
        });

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_ads, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}