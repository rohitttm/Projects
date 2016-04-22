package com.example.rohit.roomer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;


public class adDetails extends ActionBarActivity {
    TextView textName,textPostedBy,textDescription;
    ImageView imageView;
    String titlead,fnad,dad;
    Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_details);

        final int position=getIntent().getExtras().getInt("position");
        String suni=getIntent().getExtras().getString("suni");

        textName=(TextView) findViewById(R.id.name);
        textPostedBy=(TextView) findViewById(R.id.postedBy);
        textDescription=(TextView)findViewById(R.id.description);


        ParseQuery<ParseObject> query = ParseQuery.getQuery("Ad");

        query.whereEqualTo("University", suni);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> parseObjects, ParseException e) {
                if (e == null) {


                        ParseObject a = parseObjects.get(position);

                        titlead = (String) a.get("Title");
                        fnad = (String) a.get("FullName");
                        dad = (String) a.get("Description");

                    textName.setText(titlead);
                    textPostedBy.setText("Posted By: "+fnad);
                    textDescription.setText("Description: "+dad);


                    ParseFile fileObject = (ParseFile) a.get("imageUpload");
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
                else
                {
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ad_details, menu);
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
