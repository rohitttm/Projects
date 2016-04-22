package com.example.rohit.roomer;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;


public class details extends Activity {
    TextView textView,textAddress,textOpen,textRating,textPhoneNumber,textWebsite;
    String temp,phoneNumber,website;
    String geo="geo:";
    String place_id;
    ImageView img,img1,img2,img3,img4,img5;
    Bitmap bitmap;
    ProgressDialog pDialog;
    String p[]=new String[5];
    String week[]=new String[7];
    String width[]=new String[5];
    String picReference;


    String website2,phoneNumber2,pn,url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String name=getIntent().getExtras().getString("name");
        String address="Address: "+getIntent().getExtras().getString("address");
        String open="Open Now: "+getIntent().getExtras().getString("open");
        String rating="Rating: "+getIntent().getExtras().getString("rating");
        String lati = getIntent().getExtras().getString("latitude");
        String longi = getIntent().getExtras().getString("longitude");
        picReference=getIntent().getExtras().getString("picReference");
        place_id = getIntent().getExtras().getString("place_id");
        geo = geo + lati + "," + longi;

        textView = (TextView) findViewById(R.id.name);
        textAddress = (TextView) findViewById(R.id.textAddress);
        textOpen = (TextView) findViewById(R.id.open);
        textRating = (TextView) findViewById(R.id.rating);
        textPhoneNumber=(TextView) findViewById(R.id.phoneNumber);
        textWebsite=(TextView) findViewById(R.id.website);



        textView.setText(name);
        textAddress.setText(address);
        textOpen.setText(open);
        textRating.setText(rating);

        //load_img = (Button)findViewById(R.id.load);
        img = (ImageView) findViewById(R.id.img);
        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);
        img4 = (ImageView) findViewById(R.id.img4);
        img5 = (ImageView) findViewById(R.id.img5);

        new googleplaces().execute();
    }

    private class googleplaces extends AsyncTask<View, Void, String> {

        @Override
        protected String doInBackground(View... urls) {

            //String replaceText = search.replace(' ', '+');
            // temp = makeCall("https://maps.googleapis.com/maps/api/place/textsearch/json?query=rental+homes+in+"+replaceText+"&key=AIzaSyDMX69her6nrZ_FrnK52ows1dVf5hF6Cpc");
            temp=makeCall("https://maps.googleapis.com/maps/api/place/details/json?placeid="+place_id+"&key=AIzaSyDMX69her6nrZ_FrnK52ows1dVf5hF6Cpc");
            return "";
        }

        @Override
        protected void onPreExecute() {
            // we can start a progress bar here
        }

        @Override
        protected void onPostExecute(String result) {
            if (temp == null) {
                // we have an error to the call
                // we can also stop the progress bar
            } else {


                parseGoogleParse(temp);


            }
        }
    }
    private class LoadImage extends AsyncTask<String, String, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(details.this);
            pDialog.setMessage("Loading Image ....");
            pDialog.show();
        }
        protected Bitmap doInBackground(String... args) {
            try {
                bitmap = BitmapFactory.decodeStream((InputStream) new URL(args[0]).getContent());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }
        protected void onPostExecute(Bitmap image) {
            if(image != null){

                img.setImageBitmap(image);

                pDialog.dismiss();
            }else{
                pDialog.dismiss();
                Toast.makeText(details.this, "Image Does Not exist or Network Error", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private class LoadImage1 extends AsyncTask<String, String, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            /*pDialog = new ProgressDialog(details.this);
            pDialog.setMessage("Loading Image ....");
            pDialog.show();*/
        }
        protected Bitmap doInBackground(String... args) {
            try {
                bitmap = BitmapFactory.decodeStream((InputStream) new URL(args[0]).getContent());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }
        protected void onPostExecute(Bitmap image) {
            if(image != null){

                img1.setImageBitmap(image);

                pDialog.dismiss();
            }else{
                pDialog.dismiss();
                Toast.makeText(details.this, "Image Does Not exist or Network Error", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private class LoadImage2 extends AsyncTask<String, String, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            /*pDialog = new ProgressDialog(details.this);
            pDialog.setMessage("Loading Image ....");
            pDialog.show();*/
        }
        protected Bitmap doInBackground(String... args) {
            try {
                bitmap = BitmapFactory.decodeStream((InputStream) new URL(args[0]).getContent());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }
        protected void onPostExecute(Bitmap image) {
            if(image != null){

                img2.setImageBitmap(image);

                pDialog.dismiss();
            }else{
                pDialog.dismiss();
                Toast.makeText(details.this, "Image Does Not exist or Network Error", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private class LoadImage3 extends AsyncTask<String, String, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            /*pDialog = new ProgressDialog(details.this);
            pDialog.setMessage("Loading Image ....");
            pDialog.show();*/
        }
        protected Bitmap doInBackground(String... args) {
            try {
                bitmap = BitmapFactory.decodeStream((InputStream) new URL(args[0]).getContent());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }
        protected void onPostExecute(Bitmap image) {
            if(image != null){

                img3.setImageBitmap(image);

                pDialog.dismiss();
            }else{
                pDialog.dismiss();
                Toast.makeText(details.this, "Image Does Not exist or Network Error", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private class LoadImage4 extends AsyncTask<String, String, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            /*pDialog = new ProgressDialog(details.this);
            pDialog.setMessage("Loading Image ....");
            pDialog.show();*/
        }
        protected Bitmap doInBackground(String... args) {
            try {
                bitmap = BitmapFactory.decodeStream((InputStream) new URL(args[0]).getContent());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }
        protected void onPostExecute(Bitmap image) {
            if(image != null){

                img4.setImageBitmap(image);

                pDialog.dismiss();
            }else{
                pDialog.dismiss();
                Toast.makeText(details.this, "Image Does Not exist or Network Error", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private class LoadImage5 extends AsyncTask<String, String, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            /*pDialog = new ProgressDialog(details.this);
            pDialog.setMessage("Loading Image ....");
            pDialog.show();*/
        }
        protected Bitmap doInBackground(String... args) {
            try {
                bitmap = BitmapFactory.decodeStream((InputStream) new URL(args[0]).getContent());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }
        protected void onPostExecute(Bitmap image) {
            if(image != null){

                img5.setImageBitmap(image);

                pDialog.dismiss();
            }else{
                pDialog.dismiss();
                Toast.makeText(details.this, "Image Does Not exist or Network Error", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void process(View view)
    {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(geo));
        startActivity(intent);
    }

    public void process1(View view)
    {
        url = website2;
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void process2(View view) {
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


    public static String makeCall(String url) {

        // string buffers the url
        StringBuffer buffer_string = new StringBuffer(url);
        String replyString = "";

        // instanciate an HttpClient
        HttpClient httpclient = new DefaultHttpClient();
        // instanciate an HttpGet
        HttpGet httpget = new HttpGet(buffer_string.toString());

        try {
            // get the responce of the httpclient execution of the url
            HttpResponse response = httpclient.execute(httpget);
            InputStream is = response.getEntity().getContent();

            // buffer input stream the result
            BufferedInputStream bis = new BufferedInputStream(is);
            ByteArrayBuffer baf = new ByteArrayBuffer(20);
            int current = 0;
            while ((current = bis.read()) != -1) {
                baf.append((byte) current);
            }
            // the result as a string is ready for parsing
            replyString = new String(baf.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(replyString);

        // trim the whitespaces
        return replyString.trim();
    }

    public void parseGoogleParse(final String response) {


        try {

            // make an jsonObject in order to parse the response
            JSONObject jsonObject = new JSONObject(response);

            // make an jsonObject in order to parse the response
            if (jsonObject.has("result")) {

                JSONObject json1 = jsonObject.getJSONObject("result");
                phoneNumber = "Phone Number: "+json1.getString("formatted_phone_number");
                phoneNumber2=json1.getString("formatted_phone_number");
                website="Website: "+json1.getString("website");
                website2=json1.getString("website");
                textPhoneNumber.setText(phoneNumber);
                //textWebsite.setText(website);
                textPhoneNumber.setText(phoneNumber);
                //textWebsite.setText(website);

                if (json1.has("weekday_text")) {
                    JSONArray typesArray = json1.getJSONArray("weekday_text");

                    for (int j = 0; j < typesArray.length(); j++) {
                        week[j]= (String) typesArray.get(j);
                    }
                }
                textWebsite.setText(website);



                if(json1.has("photos")){

                    JSONArray jsonArray = json1.getJSONArray("photos");
                    for (int i = 0; i < jsonArray.length(); i++){
                        p[i]=jsonArray.getJSONObject(i).optString("photo_reference");
                        width[i]=jsonArray.getJSONObject(i).optString("width");
                    }

                    LoadImage l = new LoadImage();
                    l.execute("https://maps.googleapis.com/maps/api/place/photo?maxwidth="+width[0]+"+&photoreference="+p[0]+"&key=AIzaSyDMX69her6nrZ_FrnK52ows1dVf5hF6Cpc");

                    LoadImage1 l1 = new LoadImage1();
                    l1.execute("https://maps.googleapis.com/maps/api/place/photo?maxwidth="+width[1]+"&photoreference="+p[1]+"&key=AIzaSyDMX69her6nrZ_FrnK52ows1dVf5hF6Cpc");

                    LoadImage2 l2 = new LoadImage2();
                    l2.execute("https://maps.googleapis.com/maps/api/place/photo?maxwidth="+width[2]+"&photoreference="+p[2]+"&key=AIzaSyDMX69her6nrZ_FrnK52ows1dVf5hF6Cpc");

                    LoadImage3 l3 = new LoadImage3();
                    l3.execute("https://maps.googleapis.com/maps/api/place/photo?maxwidth="+width[3]+"&photoreference="+p[3]+"&key=AIzaSyDMX69her6nrZ_FrnK52ows1dVf5hF6Cpc");

                    LoadImage4 l4 = new LoadImage4();
                    l4.execute("https://maps.googleapis.com/maps/api/place/photo?maxwidth="+width[4]+"&photoreference="+p[4]+"&key=AIzaSyDMX69her6nrZ_FrnK52ows1dVf5hF6Cpc");

                    LoadImage5 l5 = new LoadImage5();
                    l5.execute("https://maps.googleapis.com/maps/api/place/photo?maxwidth="+width[4]+"&photoreference="+picReference+"&key=AIzaSyDMX69her6nrZ_FrnK52ows1dVf5hF6Cpc");


                }

            }


        } catch (Exception e) {
            e.printStackTrace();

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
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
