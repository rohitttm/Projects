package com.example.rohit.roomer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.Parse;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;


public class searchActivity extends ActionBarActivity {


    private ListView listView;
    Bitmap bmp;
    String suni,scity,city,university,email,phoneNumber,age,fullName,city1,university1,email1,fullName1,age1,phoneNumber1;
    customAdapter adapter;
    byte[] dataa1;
    private List<User> user = null;
    byte[] data1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Parse.initialize(this, "3K0f8MYuKdLCTuxSSwxGYSUo4iS8NPBR7BHVoJP7", "FaCIcG3mgNWTDN1OHsRP0sGDWz0svslZrfcK3m2g");
        final ParseUser currentUser= ParseUser.getCurrentUser();
        if (currentUser == null) {
            loadLoginView();
        }
        else {
            scity= getIntent().getExtras().getString("City");
            suni= getIntent().getExtras().getString("University");
            //final ArrayAdapter<String> listAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
            listView=(ListView)findViewById(R.id.listView);
            //listView.setAdapter(listAdapter);

            user = new ArrayList<User>();

            ParseQuery<ParseUser> query=ParseUser.getQuery();
            query.whereEqualTo("University",suni);
            //query.whereEqualTo("City",scity);
            query.findInBackground(new FindCallback<ParseUser>() {
                @Override
                public void done(List<ParseUser> parseUsers, com.parse.ParseException e) {
                    if (e == null) {
                        //Log.d("score", "Retrieved " + parseUsers.size() + " scores");
                        for (int i = 0; i < parseUsers.size(); i++)
                        {
                            ParseUser u = parseUsers.get(i);

                            /*String fullName = u.getString("FullName");
                            String city=u.getString("City");
                            listAdapter.add(fullName+"\nCity: "+city);*/


                            //ParseFile image = (ParseFile) u.get("imageUpload");
                            //User first = new User();
                            /*first.setFullName((String) u.get("FullName"));
                            first.setCity((String) u.get("City"));
                            first.setUniversity((String) u.get("University"));
                            first.setImage(image.getUrl());*/
                            city=u.getString("City");
                            fullName=u.getString("FullName");
                            university=u.getString("University");
                            age=u.getString("Age");
                            email=u.getString("email");
                            phoneNumber=u.getString("Phone");
                            user.add(new User(fullName,city,university));


                          /* ParseFile fileObject = (ParseFile) u.get("imageUpload");
                            fileObject.getDataInBackground(new GetDataCallback() {

                                public void done(byte[] data, com.parse.ParseException e) {

                                    if (e == null) {

                                        //data1=data;
                                        //bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
                                        //user.add(new User(fullName,city,university,data));
                                    } else {
                                        Log.d("test", "There was a problem downloading the data.");
                                    }
                                    //user.add(new User(fullName,city,university,data1));
                                }
                                //user.add(new User(fullName,city,university,data1));
                            });
                             //user.add(new User(fullName,city,university,data1));
                            //listView.setAdapter(adapter);
*/
                        }
                        //listView.setAdapter(new customAdapter(searchActivity.this,R.layout.custom_row,user));
                    }
                    else {
                        Log.d("score", "Error: " + e.getMessage());
                    }
                    listView.setAdapter(new customAdapter(searchActivity.this,R.layout.custom_row,user));
                }
            });
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                //int position=position;

                /*university1=user.get(position).getUniversity();
                city1=user.get(position).getCity();
                fullName1=user.get(position).getFullName();
                email1=user.get(position).getEmail();
                phoneNumber1=user.get(position).getPhoneNumber();
                age1=user.get(position).getAge();*/
                //dataa1=user.get(position).getDataa();
                //user = new ArrayList<User>();
/*
               *//* ParseQuery<ParseUser> query=ParseUser.getQuery();
                query.whereEqualTo("University",suni);
                //query.whereEqualTo("City",scity);
                query.findInBackground(new FindCallback<ParseUser>() {
                    @Override
                    public void done(List<ParseUser> parseUsers, com.parse.ParseException e) {

                        if (e == null) {


                            ParseUser u = parseUsers.get(position);

                           *//**//* city1=u.getString("City");
                            fullName1=u.getString("FullName");
                            university1=u.getString("University");
                            email1=u.getEmail();*//**//*



                            ParseFile fileObject = (ParseFile) u.get("imageUpload");
                            fileObject.getDataInBackground(new GetDataCallback() {

                                public void done(byte[] data, com.parse.ParseException e) {

                                    if (e == null) {
                                       // bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
                                        data1=data;


                                    } else {
                                        Log.d("test", "There was a problem downloading the data.");
                                    }
                                }
                            });
*//*
                            //user.add(new User(fullName,city,university,bmp));
                            //listView.setAdapter(adapter);



                            //listView.setAdapter(new customAdapter(searchActivity.this,R.layout.custom_row, user));
                        }
                        else {
                            Log.d("score", "Error: " + e.getMessage());
                        }
                    }
                });*/
                Intent intent1=new Intent(searchActivity.this,detailUsers.class);
                /*intent1.putExtra("city",city1);
                intent1.putExtra("fullName",fullName1);
                intent1.putExtra("university",university1);
                intent1.putExtra("email",email1);
                intent1.putExtra("Phone",phoneNumber1);
                intent1.putExtra("Age",age1);
                intent1.putExtra("dataa1",dataa1);*/
                intent1.putExtra("suni",suni);
                intent1.putExtra("position",position);





                startActivity(intent1);
            }
        });


    }




    private void loadLoginView() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
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













//package com.example.rohit.roomer;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.ActionBarActivity;
//import android.util.Log;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//
//import com.parse.FindCallback;
//import com.parse.Parse;
//import com.parse.ParseQuery;
//import com.parse.ParseUser;
//
//import java.util.List;
//
//
//public class searchActivity extends ActionBarActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_search);
//
//        String scity= getIntent().getExtras().getString("City");
//        String suni= getIntent().getExtras().getString("University");
//
//        Parse.initialize(this, "3K0f8MYuKdLCTuxSSwxGYSUo4iS8NPBR7BHVoJP7", "FaCIcG3mgNWTDN1OHsRP0sGDWz0svslZrfcK3m2g");
//        final ParseUser currentUser= ParseUser.getCurrentUser();
//        if (currentUser == null) {
//            loadLoginView();
//        }
//        else {
//            final ArrayAdapter<String> listAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
//            final ListView playerlv=(ListView)findViewById(R.id.listView);
//            playerlv.setAdapter(listAdapter);
//
//            ParseQuery<ParseUser> query=ParseUser.getQuery();
//            query.whereEqualTo("University", suni.toString());
//            query.findInBackground(new FindCallback<ParseUser>() {
//
//
//                @Override
//                public void done(List<ParseUser> parseUsers, com.parse.ParseException e) {
//
//                    if (e == null) {
//                        Log.d("score", "Retrieved " + parseUsers.size() + " scores");
//                        for (int i = 0; i < parseUsers.size(); i++)
//                        { ParseUser u = parseUsers.get(i);
//                            //String name = u.getString("username");
//
//                            String fullName = u.getString("FullName"); listAdapter.add(fullName);
//
////listAdapter.add(email);
//                        } }
//                    else { Log.d("score", "Error: " + e.getMessage()); }
//                }
//            });
//        }
//
//    }
//
//
//    private void loadLoginView() {
//        Intent intent = new Intent(this, LoginActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        startActivity(intent);
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_search, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//}
