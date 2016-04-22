package com.example.rohit.roomer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;


public class detailFriends extends ActionBarActivity {

    TextView textName,textEmail,textUniversity,textCity,textAge,textPhone;
    ImageView imageView;
    String city,university,age,phoneNumber,fullName,email;
    Bitmap bmp;
    String email2,phoneNumber2,pn,em;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_friends);

        String fullName1=getIntent().getExtras().getString("friendName");



        ParseQuery<ParseUser> query=ParseUser.getQuery();
        query.whereEqualTo("FullName",fullName1);
        //query.whereEqualTo("City",scity);
        query.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> parseUsers, com.parse.ParseException e) {

                if (e == null) {


                    ParseUser u = parseUsers.get(0);

                    city = u.getString("City");
                    fullName = u.getString("FullName");
                    university = u.getString("University");
                    email = u.getString("email");
                    phoneNumber = u.getString("Phone");
                    age = u.getString("Age");

                    textName = (TextView) findViewById(R.id.textFullName);
                    textEmail = (TextView) findViewById(R.id.textEmail);
                    textUniversity = (TextView) findViewById(R.id.textUniversity);
                    textCity = (TextView) findViewById(R.id.textCity);
                    textPhone = (TextView) findViewById(R.id.textPhoneNumber);
                    textAge = (TextView) findViewById(R.id.textAge);
                    imageView = (ImageView) findViewById(R.id.imageView);

                    textName.setText(fullName);
                    textEmail.setText("E-mail: " + email);
                    em = email;
                    textCity.setText("City: " + city);
                    textUniversity.setText("University: " + university);
                    textAge.setText("Age: " + age);
                    textPhone.setText("Phone Number: " + phoneNumber);
                    phoneNumber2 = phoneNumber;


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
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail_friends, menu);
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

