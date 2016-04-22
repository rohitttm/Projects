package com.example.rohit.roomer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import org.json.JSONArray;

import java.util.List;


public class detailUsers extends ActionBarActivity {
    TextView textName,textEmail,textUniversity,textCity,textAge,textPhone;
    ImageView imageView;
    String city,university,age,phoneNumber,fullName,email;
    Bitmap bmp;
    String email2,phoneNumber2,pn,em;
    final ParseUser currentUser = ParseUser.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_users);
        Parse.initialize(this, "3K0f8MYuKdLCTuxSSwxGYSUo4iS8NPBR7BHVoJP7", "FaCIcG3mgNWTDN1OHsRP0sGDWz0svslZrfcK3m2g");

/*
        String fullName1="Name: "+getIntent().getExtras().getString("fullName");
        String email1="E-mail: "+getIntent().getExtras().getString("email");
        String city1="City: "+getIntent().getExtras().getString("city");
        String university1="University: "+getIntent().getExtras().getString("university");
        String age1="Age: "+getIntent().getExtras().getString("Age");
        String phone="Phone: "+getIntent().getExtras().getString("Phone");
        byte[] data=getIntent().getExtras().getByteArray("dataa1");

        textName=(TextView) findViewById(R.id.textFullName);
        textEmail=(TextView) findViewById(R.id.textEmail);
        textUniversity=(TextView) findViewById(R.id.textUniversity);
        textCity=(TextView) findViewById(R.id.textCity);
        textPhone=(TextView)findViewById(R.id.textPhone);
        textAge=(TextView)findViewById(R.id.textAge);
        imageView=(ImageView) findViewById(R.id.imageView);

        textName.setText(fullName1);
        textEmail.setText(email1);
        textCity.setText(city1);
        textUniversity.setText(university1);
        textAge.setText(age1);
        textPhone.setText(phone);

        Bitmap bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
        imageView.setImageBitmap(bmp);*/

        final int position= getIntent().getExtras().getInt("position");
        String suni=getIntent().getExtras().getString("suni");

        ParseQuery<ParseUser> query=ParseUser.getQuery();
        query.whereEqualTo("University",suni);
        //query.whereEqualTo("City",scity);
        query.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> parseUsers, com.parse.ParseException e) {

                if (e == null) {


                    ParseUser u = parseUsers.get(position);

                    city=u.getString("City");
                    fullName=u.getString("FullName");
                    university=u.getString("University");
                    email=u.getString("email");
                    phoneNumber=u.getString("Phone");
                    age=u.getString("Age");

                    textName=(TextView) findViewById(R.id.textFullName);
                    textEmail=(TextView) findViewById(R.id.textEmail);
                    textUniversity=(TextView) findViewById(R.id.textUniversity);
                    textCity=(TextView) findViewById(R.id.textCity);
                    textPhone=(TextView)findViewById(R.id.textPhoneNumber);
                    textAge=(TextView)findViewById(R.id.textAge);
                    imageView=(ImageView) findViewById(R.id.imageView);

                    textName.setText(fullName);
                    textEmail.setText("E-mail: "+email);
                    em=email;
                    textCity.setText("City: "+city);
                    textUniversity.setText("University: "+university);
                    textAge.setText("Age: "+age);
                    textPhone.setText("Phone Number: "+phoneNumber);
                    phoneNumber2=phoneNumber;



                    Button Fav=(Button) findViewById(R.id.button4);
                    Fav.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            JSONArray myArray=currentUser.getJSONArray("Friends");
//                                    JSONArray arr = new JSONArray(yourJSONresponse);
                            myArray.put(fullName);




                            currentUser.put("Friends",myArray);
                            currentUser.saveInBackground(new SaveCallback() {
                                @Override
                                public void done(ParseException e) {
                                    if (e == null) {
                                        // Success!
                                        Intent intent = new Intent(detailUsers.this, MainActivity2Activity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent);
                                    } else {
                                    }

                                }
                            });

                        }
                    });







                    ParseFile fileObject = (ParseFile) u.get("imageUpload");
                    fileObject.getDataInBackground(new GetDataCallback() {

                        public void done(byte[] data, com.parse.ParseException e) {

                            if (e == null) {
                                bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
                                imageView=(ImageView) findViewById(R.id.imageView);
                                imageView.setImageBitmap(bmp);

                            } else {
                                Log.d("test", "There was a problem downloading the data.");
                            }
                        }
                    });

                }
                else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail_users, menu);
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


    public void processPhone(View view){
        String newnumber="";
        pn = phoneNumber2;
        for (int a = 0; a < pn.length(); a++)
        {
            if(pn.charAt(a)=='('||pn.charAt(a)==')'||pn.charAt(a)==' '||pn.charAt(a)=='-'||pn.charAt(a)=='(')
            {}
            else
            {
                newnumber+=pn.charAt(a);
            }
        }
        newnumber="tel:" + newnumber.trim() ;
//        Toast.makeText(getApplicationContext(),newnumber,Toast.LENGTH_SHORT).show();
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse(newnumber));
        startActivity(i);
    }

    public void processEmail(View view){


        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto",em, null));
//        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "EXTRA_SUBJECT");
        startActivity(Intent.createChooser(emailIntent, "Send email..."));

    }
}
